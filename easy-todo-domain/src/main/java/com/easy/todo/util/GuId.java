package com.easy.todo.util;
/**
 *      Copyright (C) 2008 10gen Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */


import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 全局对象唯一标示符
 * A globally unique identifier for objects.
 * <p>Consists of 12 bytes, divided as follows:
 * <blockquote><pre>
 * <table border="1">
 * <tr><td>0</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td>
 *     <td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>
 * <tr><td colspan="4">time</td><td colspan="3">machine</td>
 *     <td colspan="2">pid</td><td colspan="3">inc</td></tr>
 * </table>
 * </pre></blockquote>
 *
 */
public class GuId implements java.io.Serializable {

    /**
     * 序列化uid
     */
    private static final long serialVersionUID = -4415279469780082174L;

    /**
     * 日志对象
     */
    static final Logger LOGGER = Logger.getLogger("com.easy.todo.util");

    /**
     * 机器id
     */
    final int _machine;


    /**
     * 测试主方法
     * @param args  输入参数
     */
    public static  void main(final String args[]){
        System.out.println(GuId.get());  //0a6d
    }

    /**
     * 默认构造函数
     */
    public GuId(){
        _machine = _genmachine;
    }

    /** 获取一个新的对象id
     * Gets a new object id.
     * @return the new id
     */
    public static GuId get(){
        return new GuId();
    }

    /**
     * 生成srting方法
     * @return
     */
    public  String toString(){
        byte[] b = toByteArray();
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i< 4; i++){
            int x = b[i] & 0xFF;
            if(i % 2 == 0){   //减少位数，最后仅保留4位
                continue;
            }
            //以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式
            String s = Integer.toHexString(x);
            if (s.length() == 1)
                buf.append("0");
            buf.append(s);
        }

        return buf.toString();
    }

    public byte[] toByteArray(){
        byte[] b = new byte[4];
        ByteBuffer bb = ByteBuffer.wrap(b); //将 byte 数组包装到缓冲区中，新的缓冲区将由给定的 byte 数组支持；也就是说，缓冲区修改将导致数组修改，反之亦然
        // by default BB is big endian like we need
        bb.putInt(_genmachine);
        return b;
    }


    private static final int _genmachine;
    static {

        try {
            // 根据机器的网络信息创建两个字节的机器标识
            // build a 2-byte machine piece based on NICs info
            int machinePiece;
            {
                try {
                    StringBuilder sb = new StringBuilder();
                    Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
                    while (e.hasMoreElements()){
                        NetworkInterface ni = e.nextElement();
                        sb.append(ni.toString());
                    }

                    //网络接口信息例如  name:utun0 (utun0)name:vnic1 (vnic1)name:vnic0 (vnic0)name:en1 (en1)name:lo0 (lo0) 总共有五个网卡接口
                    //int共32位，左移16位，右边补零，最高位为符号位，正负可能变化，java存负数使用的补码例。
                    // 位移后是负数的反向计算的时候是先减1再位移，再换算成十进制
                    // 例如如 782745866 <<16 = -1056309248
                    // 0010 1110 1010 0111 1100 0001 0000 1010<<16=1100 0001 0000 1010 0000 0000 0000 0000
                    //再反向转换成十进制为0011 1110 1111 0110 0000 0000 0000 0000

                    machinePiece = sb.toString().hashCode() << 16;
                } catch (Throwable e) {
                    // exception sometimes happens with IBM JVM, use random
                    LOGGER.log(Level.WARNING, e.getMessage(), e);
                    machinePiece = (new Random().nextInt()) << 16;
                }
                LOGGER.fine("machine piece post: " + Integer.toHexString( machinePiece ) );
            }

            // 添加 2字节的进程标示，他由jvm和类加载器共同决定
            //由于静态变量由类加载器决定，所以可能引发冲突
            // add a 2 byte process piece. It must represent not only the JVM but the class loader.
            // Since static var belong to class loader there could be collisions otherwise
            final int processPiece;
            {
                int processId = new Random().nextInt();
                try {
                    //获取进程标识的hashcode，例如2096@Macintosh.local的hashcode
                    processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
                }
                catch (Throwable t){
                }

                ClassLoader loader = GuId.class.getClassLoader();
                //不论ClassLoader有没有复写hashCode方法，都调用原始的hashCode方法。防止不同的loader重写hashcode方法，造成不同的loader的hashcode相同
                int loaderId = loader != null ? System.identityHashCode(loader) : 0;

                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toHexString(processId)); //显示一个byte型的单字节十六进制(两位十六进制表示)的编码
                sb.append(Integer.toHexString(loaderId));  //10进制10位改变为16进制等于八位
                //
                //572284967  &  65535  = 24615
                processPiece = sb.toString().hashCode() & 0xFFFF;   //16位16进制的数取hashcode，再与0xFFFF与操作
                LOGGER.fine( "process piece: " + Integer.toHexString( processPiece ) );
            }
            //  -1056284633 =   -1056309248 | 24615
            _genmachine = machinePiece | processPiece;
        }
        catch ( Exception e ){
            throw new RuntimeException( e );
        }

    }
}

