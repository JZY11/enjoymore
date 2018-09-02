package com.inpubu.boot.skills.enjoymore.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipubu.boot.skills.enjoymore.constant.GlobalConsts;

/**
 * @ClassName BootApplication
 * @Description		数据加解密工具类
 * @Author jzy
 */
public class CryptUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CryptUtil.class);

    private static final int SECURE_KEY_LENGTH = 16;

    private static CryptUtil instance = new CryptUtil();

    private CryptUtil() {}

    public static CryptUtil me() {
        return instance;
    }

    /**
     * 采用AES128解密
     * 
     */
    public byte[] decrypt(byte[] data, String secureKey) throws Exception {
        if (data == null || data.length == 0) {
            return data;
        }

        // 获得密匙数据
        byte[] rawKeyData = getAESKey(secureKey);
        // 从原始密匙数据创建一个KeySpec对象
        SecretKeySpec key = new SecretKeySpec(rawKeyData, "AES");
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(GlobalConsts.CRYPT_KEY);
        byte[] iv = new byte[SECURE_KEY_LENGTH];
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        try {
            return cipher.doFinal(data);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new Exception(e);
        }

    }

    public byte[] getAESKey(String key) throws UnsupportedEncodingException {
        byte[] keyBytes;
        keyBytes = key.getBytes("UTF-8");
        // Use the first 16 bytes (or even less if key is shorter)
        byte[] keyBytes128 = new byte[SECURE_KEY_LENGTH];
        System.arraycopy(keyBytes, 0, keyBytes128, 0, Math.min(keyBytes.length, SECURE_KEY_LENGTH));
        return keyBytes128;
    }


    /**
     * 采用AES128加密
     */
    public byte[] encrypt(byte[] data, String secureKey) throws Exception {
        if (data == null || data.length == 0) {
            return data;
        }

        // 获得密匙数据
        byte[] rawKeyData = getAESKey(secureKey);
        // 从原始密匙数据创建KeySpec对象
        SecretKeySpec key = new SecretKeySpec(rawKeyData, "AES");
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[SECURE_KEY_LENGTH];
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        // 正式执行加密操作

        return cipher.doFinal(data);
    }

    public static byte[] getHmacSHA256(String src, String key)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret = new SecretKeySpec(key.getBytes("UTF-8"), mac.getAlgorithm());
        mac.init(secret);
        return mac.doFinal(src.getBytes());
    }


    /**
     * 将byte转为16进制
     * 
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void demo() throws Exception {
        String key = "1234567890123456";
        String source = "{'name':'kevin'}";
        LOGGER.info("加密前的字串是：{}", source);
        byte[] encrypt = CryptUtil.me().encrypt(source.getBytes("utf-8"), key);
        String encryptStr = Base64.encodeBase64String(encrypt);
        LOGGER.info("加密后的字符串是：{}", encryptStr);
        byte[] decrypt = CryptUtil.me().decrypt(Base64.decodeBase64(encryptStr), key);
        final String uncrpyt = new String(decrypt, "UTF-8");
        LOGGER.info("解密后的字符串是：{}", uncrpyt);
    }

    public static void encrytStr(String source) throws Exception {

        byte[] encrypt = CryptUtil.me().encrypt(source.getBytes("utf-8"), GlobalConsts.APPKEY);
        String encryptStr = Base64.encodeBase64String(encrypt);
        LOGGER.info("加密后的字符串是：{}", encryptStr);
    }

    public static void main(String[] args) throws Exception {
        String source = "{\r\n" + "    \"seq\": \"1529998402232\",\r\n" + "    \"type\": \"9\",\r\n"
                + "    \"data\": {\r\n" + "        \"thirdAccount\": \"15332491032\",\r\n"
                + "        \"sceneName\": \"离家模式\",\r\n"
                + "        \"afterModifysceneName\": \"你的离家模式\",\r\n"
                + "        \"operType\": \"3\"\r\n" + "    }\r\n" + "}";

        String source2 = "{\r\n" + "    \"seq\": \"1529998402232\",\r\n"
                + "    \"type\": \"6\",\r\n" + "    \"data\": {\r\n"
                + "        \"thirdAccount\": \"15108316546\",\r\n"
                + "        \"beforeModifyDeviceName\": \"可调光灯具\",\r\n"
                + "        \"afterModifyDeviceName\": \"我家的灯\",\r\n"
                + "        \"deviceTypeName\": \"智能灯具\",\r\n" + "        \"action\": [\r\n"
                + "            {\r\n" + "                \"param\": [\r\n"
                + "                    \"关\",\r\n" + "                    \"开\"\r\n"
                + "                ],\r\n" + "                \"function\": \"开关\"\r\n"
                + "            },\r\n" + "            {\r\n" + "                \"param\": [\r\n"
                + "                    \"关\",\r\n" + "                    \"开\"\r\n"
                + "                ],\r\n" + "                \"function\": \"冲洗\"\r\n"
                + "            }\r\n" + "        ],\r\n" + "        \"operType\": \"2\"\r\n"
                + "    }\r\n" + "}\r\n" + "";

        encrytStr(source);
        //encrytStr(source2);
    }
}
