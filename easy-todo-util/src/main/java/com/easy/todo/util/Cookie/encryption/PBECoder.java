package com.easy.todo.util.cookie.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.util.Random;
/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-14
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */


/** */

/**
 * PBE安全编码组件
 */
public class PBECoder {
/** */
    /**
     * 支持以下任意一种算法
     * <p/>
     * <pre>
     * PBEWithMD5AndDES
     * PBEWithMD5AndTripleDES
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     * </pre>
     */
    public static final String ALGORITHM = "PBEWITHMD5andDES";

    /**
     * 使用随机盐
     *
     * @return
     * @throws Exception
     */
    public static byte[] initSalt() throws Exception {
        byte[] salt = new byte[8];
        Random random = new Random();
        random.nextBytes(salt);
        return salt;
    }

    /**
     *  8-byte 使用固定的盐
      */
    private static byte[] salt = {
            (byte) 0xC3, (byte) 0x9B, (byte) 0xA8, (byte) 0x82,
            (byte) 0x11, (byte) 0x38, (byte) 0xE2, (byte) 0x03
    };

    /**
     * 转换密钥<br>
     *
     * @param password
     * @return
     * @throws Exception
     */
    private static Key toKey(String password) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(keySpec);
    }
/** */
    /**
     * 加密
     *
     * @param str      数据
     * @param password 密码
     * @return
     * @throws Exception
     */

    public static String encrypt(String str, String password)
            throws Exception {
        Key key = toKey(password);
        byte[] data = str.getBytes("UTF8");
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 19);
        Cipher ecipher = Cipher.getInstance(ALGORITHM);
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        byte[] rs = ecipher.doFinal(data);
        return new sun.misc.BASE64Encoder().encode(rs);
    }
/** */
    /**
     * 解密
     *
     * @param str      数据
     * @param password 密码
     * @return
     * @throws Exception
     */
    public static String decrypt(String str, String password)
            throws Exception {
        byte[] data = new sun.misc.BASE64Decoder().decodeBuffer(str);
//        byte[] data = dec.getBytes("UTF8");

        Key key = toKey(password);
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 19);
        Cipher dcipher = Cipher.getInstance(ALGORITHM);
        dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        byte[] rs = dcipher.doFinal(data);
        return new String(rs, "UTF8");
    }


    /**
     * 测试方法
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String inputStr = "SID_5215c904c2e6edd8f77a4fb6_13776707500001";
        String pwd = "11111";
        System.err.println("密码: " + pwd);
//           byte[] salt = PBECoder.initSalt();
        BASE64Decoder dec=new BASE64Decoder();
        BASE64Encoder enc=new BASE64Encoder();
        String input = enc.encode(inputStr.getBytes("Utf8"));
        String temp = "MaCgFzEZ3IHh24KgzFKHosab3R1Yz1A%2BDLdww501igEVcUpWV9aOpJkSqysph9Cr";

        String data = PBECoder.encrypt(inputStr, pwd);
        System.err.println("加密后: " + data);
        String output = PBECoder.decrypt(data, pwd);
        System.err.println("解密后: " + output);

    }
}
