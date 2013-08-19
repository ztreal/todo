package com.easy.todo.util.cookie.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
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

    // 8-byte 使用固定的盐
    private static byte[] salt = {
            (byte) 0xC3, (byte) 0x9B, (byte) 0xA8, (byte) 0x82,
            (byte) 0x11, (byte) 0x38, (byte) 0xE2, (byte) 0x03
    };
/** */
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
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        return secretKey;
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
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        byte[] rs = cipher.doFinal(data);
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
        byte[] data = str.getBytes("UTF8");
        Key key = toKey(password);
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        byte[] rs = cipher.doFinal(data);
        return new sun.misc.BASE64Encoder().encode(rs);
    }


    /**
     * 测试方法
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String inputStr = "abc";
        String pwd = "efg";
        System.err.println("密码: " + pwd);
//           byte[] salt = PBECoder.initSalt();
        String data = PBECoder.encrypt(inputStr, pwd);
        System.err.println("加密后: " + data);
        String output = PBECoder.decrypt(inputStr, pwd);
        System.err.println("解密后: " + output);

    }
}
