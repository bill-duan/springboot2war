package com.dxh.common.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;

public class SecurityDemo {

    private final static Provider p = new BouncyCastleProvider();
    private static String pswkey="999"; //加密的密码，即密钥
    private final static IvParameterSpec iv = new IvParameterSpec("1234567890abcdef".getBytes());

    private static Key getAESKey() throws NoSuchAlgorithmException{
        //对该DES情况下加密，密钥需要为56位难以人工由string为根据设定，因此这里：
        //借助密钥生成器，由new SecureRandom(pswkey.getBytes())，以pswkey为种子值生成密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256, new SecureRandom(pswkey.getBytes()));
        return keyGenerator.generateKey();
    }

    private static byte[] encodeKey(Key key, String val) throws Exception {
        //加密，DES/ECB/pkcs5padding为：算法/模式/填充 的参数
        //参数new BouncyCastleProvider()也可修改为"BC"，要求前面要有Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/pkcs7padding",p);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        return cipher.doFinal(val.getBytes());
    }

    private static String decodeKey(Key key, byte[] out) throws Exception  {
        Cipher cipher2 = Cipher.getInstance("AES/CBC/pkcs7padding",p);
        cipher2.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] in = cipher2.doFinal(out);
        return new String(in);
    }

    //psw：加密的文本
    public static void test (Key key, String psw) throws Exception{
        Long t1 = System.currentTimeMillis();
        byte[] out = encodeKey(key, psw);
        System.out.println(out);//字节数组，没有编码
        Long t2 = System.currentTimeMillis();

        //解密
        String s = decodeKey(key, out);
        System.out.println(s);
        Long t3 = System.currentTimeMillis();

        System.out.println("t2 - t1 = " + (t2 - t1));
        System.out.println("t3 - t2 = " + (t3 - t2));
    }

    public static void main(String[] args) {
        try {
            Key key = getAESKey();
            test(key, "mysql");
            test(key, "kop09876hua");
            test(key, "ploakaa9999");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
