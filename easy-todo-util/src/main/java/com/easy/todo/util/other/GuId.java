package com.easy.todo.util.other; /**
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



import java.net.*;
import java.nio.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.logging.*;

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
 * @dochub CreateGuIds
 */
public class GuId implements Comparable<GuId> , java.io.Serializable {

    private static final long serialVersionUID = -4415279469780082174L;

    static final Logger LOGGER = Logger.getLogger( "com.easy.todo.util" );

    public static  void main(String args[]){
        System.out.println("机器标志为"+Integer.toHexString( _genmachine )); //此表示和进程有关，每次不同

        System.out.println(GuId.get());
    }


    public static String getMachineID(){
           return Integer.toHexString( _genmachine );
    }

    /** 获取一个新的对象id
     * Gets a new object id.
     * @return the new id
     */
    public static GuId get(){
        return new GuId();
    }

    /** Checks if a string could be an <code>CreateGuId</code>.
     * @return whether the string could be an object id
     */
    public static boolean isValid( String s ){
        if ( s == null )
            return false;

        final int len = s.length();
        if ( len != 24 )
            return false;

        for ( int i=0; i<len; i++ ){
            char c = s.charAt( i );
            if ( c >= '0' && c <= '9' )
                continue;
            if ( c >= 'a' && c <= 'f' )
                continue;
            if ( c >= 'A' && c <= 'F' )
                continue;

            return false;
        }

        return true;
    }

    /** Turn an object into an <code>CreateGuId</code>, if possible.
     * Strings will be converted into <code>CreateGuId</code>s, if possible, and <code>CreateGuId</code>s will
     * be cast and returned.  Passing in <code>null</code> returns <code>null</code>.
     * @param o the object to convert
     * @return an <code>CreateGuId</code> if it can be massaged, null otherwise
     */
    public static GuId massageToCreateGuId( Object o ){
        if ( o == null )
            return null;

        if ( o instanceof GuId)
            return (GuId)o;

        if ( o instanceof String ){
            String s = o.toString();
            if ( isValid( s ) )
                return new GuId( s );
        }

        return null;
    }

    public GuId(Date time){
        this(time, _genmachine, _nextInc.getAndIncrement());//原子操作加1
    }

    public GuId(Date time, int inc){
        this( time , _genmachine , inc );
    }

    public GuId(Date time, int machine, int inc){
        _time = (int)(time.getTime() / 1000); //获取时间戳
        _machine = machine;
        _inc = inc;
        _new = false;
    }

    /** Creates a new instance from a string.
     * @param s the string to convert
     * @throws IllegalArgumentException if the string is not a valid id
     */
    public GuId(String s){
        this( s , false );
    }

    public GuId(String s, boolean babble){

        if ( ! isValid( s ) )
            throw new IllegalArgumentException( "invalid CreateGuId [" + s + "]" );

        if ( babble )
            s = babbleToMongod( s );

        byte b[] = new byte[12];
        for ( int i=0; i<b.length; i++ ){
            b[i] = (byte)Integer.parseInt( s.substring( i*2 , i*2 + 2) , 16 );
        }
        //将 byte 数组包装到缓冲区中，新的缓冲区将由给定的 byte 数组支持；也就是说，缓冲区修改将导致数组修改，反之亦然
        ByteBuffer bb = ByteBuffer.wrap( b );
        _time = bb.getInt();
        _machine = bb.getInt();
        _inc = bb.getInt();
        _new = false;
    }

    public GuId(byte[] b){
        if ( b.length != 12 )
            throw new IllegalArgumentException( "need 12 bytes" );
        ByteBuffer bb = ByteBuffer.wrap( b );
        _time = bb.getInt();
        _machine = bb.getInt();
        _inc = bb.getInt();
        _new = false;
    }

    /**
     * Creates an CreateGuId
     * @param time time in seconds
     * @param machine machine ID
     * @param inc incremental value
     */
    public GuId(int time, int machine, int inc){
        _time = time;
        _machine = machine;
        _inc = inc;
        _new = false;
    }

    /** Create a new object id.
     */
    public GuId(){
        _time = (int) (System.currentTimeMillis() / 1000);
        _machine = _genmachine;
        _inc = _nextInc.getAndIncrement();
        _new = true;
    }

    public int hashCode(){
        int x = _time;
        x += ( _machine * 111 );
        x += ( _inc * 17 );
        return x;
    }

    public boolean equals( Object o ){

        if ( this == o )
            return true;

        GuId other = massageToCreateGuId( o );
        if ( other == null )
            return false;

        return
            _time == other._time &&
            _machine == other._machine &&
            _inc == other._inc;
    }

    public String toStringBabble(){
        return babbleToMongod( toStringMongod() );
    }

    public String toStringMongod(){
        byte b[] = toByteArray();

        StringBuilder buf = new StringBuilder(24);

        for ( int i=0; i<b.length; i++ ){
            int x = b[i] & 0xFF;
            //以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式
            String s = Integer.toHexString( x );
            if ( s.length() == 1 )
                buf.append( "0" );
            buf.append( s );
        }

        return buf.toString();
    }

    public byte[] toByteArray(){
        byte b[] = new byte[12];
        ByteBuffer bb = ByteBuffer.wrap( b );
        // by default BB is big endian like we need
        bb.putInt( _time );
        bb.putInt( _machine );
        bb.putInt( _inc );
        return b;
    }

    static String _pos( String s , int p ){
        return s.substring( p * 2 , ( p * 2 ) + 2 );
    }

    public static String babbleToMongod( String b ){
        if ( ! isValid( b ) )
            throw new IllegalArgumentException( "invalid object id: " + b );

        StringBuilder buf = new StringBuilder( 24 );
        for ( int i=7; i>=0; i-- )
            buf.append( _pos( b , i ) );
        for ( int i=11; i>=8; i-- )
            buf.append( _pos( b , i ) );

        return buf.toString();
    }

    public String toString(){
        return toStringMongod();
    }

    int _compareUnsigned( int i , int j ){
        long li = 0xFFFFFFFFL;
        li = i & li;
        long lj = 0xFFFFFFFFL;
        lj = j & lj;
        long diff = li - lj;
        if (diff < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (diff > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) diff;
    }

    public int compareTo( GuId id ){
        if ( id == null )
            return -1;

        int x = _compareUnsigned( _time , id._time );
        if ( x != 0 )
            return x;

        x = _compareUnsigned( _machine , id._machine );
        if ( x != 0 )
            return x;

        return _compareUnsigned( _inc , id._inc );
    }

    public int getMachine(){
        return _machine;
    }

    /**
     * 获取id的时间，单位为毫秒 Gets the time of this ID, in milliseconds
     */
    public long getTime(){
        return _time * 1000L;
    }

    /**
     * 获取id的时间，单位为秒 Gets the time of this ID, in seconds
     */
    public int getTimeSecond(){
        return _time;
    }

    public int getInc(){
        return _inc;
    }

    public int _time(){
        return _time;
    }
    public int _machine(){
        return _machine;
    }
    public int _inc(){
        return _inc;
    }

    public boolean isNew(){
        return _new;
    }

    public void notNew(){
        _new = false;
    }

    /**
     * 获取生成的机器id，此id根据机器网络接口信息，进程和类加载器共同来生成
     * Gets the generated machine ID, identifying the machine / process / class loader
     */
    public static int getGenMachineId() {
        return _genmachine;
    }

    /**
     * 获取自增数字的值
     * Gets the current value of the auto increment
     */
    public static int getCurrentInc() {
        return _nextInc.get();
    }

    final int _time;
    final int _machine;
    final int _inc;

    boolean _new;

    public static int _flip( int x ){
        int z = 0;
        z |= ( ( x << 24 ) & 0xFF000000 );  //向左位移24位，然后与0xFF000000做按位与运算
        z |= ( ( x << 8 )  & 0x00FF0000 );
        z |= ( ( x >> 8 )  & 0x0000FF00 );
        z |= ( ( x >> 24 ) & 0x000000FF );
        return z;
    }

    private static AtomicInteger _nextInc = new AtomicInteger( (new java.util.Random()).nextInt() );

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
                    while ( e.hasMoreElements() ){
                        NetworkInterface ni = e.nextElement();
                        sb.append( ni.toString() );
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
                LOGGER.fine( "machine piece post: " + Integer.toHexString( machinePiece ) );
            }

            // 添加 2字节的进程标示，他由jvm和类加载器共同决定
            //由于静态变量由类加载器决定，所以可能引发冲突
            // add a 2 byte process piece. It must represent not only the JVM but the class loader.
            // Since static var belong to class loader there could be collisions otherwise
            final int processPiece;
            {
                int processId = new java.util.Random().nextInt();
                try {
                    //获取进程标识的hashcode，例如2096@Macintosh.local的hashcode
                    processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
                }
                catch ( Throwable t ){
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
            LOGGER.fine( "machine : " + Integer.toHexString( _genmachine ) );
        }
        catch ( Exception e ){
            throw new RuntimeException( e );
        }

    }
}
