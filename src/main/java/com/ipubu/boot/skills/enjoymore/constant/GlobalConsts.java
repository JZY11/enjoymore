package com.ipubu.boot.skills.enjoymore.constant;

/**
 * @ClassName GlobalConsts
 * @Description	 全部是一些定义的常量
 * @Author jzy
 */
public final class GlobalConsts {

    private GlobalConsts() {
        throw new IllegalStateException("this is Utility class ,can't construction.");
    }

    public static final String APPID = "00fd"; // 接入魔方的唯一标识

    public static final String APPKEY = "b93dcb50000003c0"; // 加密算法私钥

    public static final String CRYPT_KEY = "AES/CBC/PKCS5Padding"; // 加密算法

    public static final String HOST = "http://172.208.252.135:4205";

    public static final String CHAR_ENCODING = "UTF-8";


}
