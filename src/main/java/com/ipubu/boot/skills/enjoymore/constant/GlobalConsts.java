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

    public static final String TOPIC_SMARTHOME_DATASYNC = "cui.morefun.datasync";
   
    public static final String DB_MF_ACCOUNT_LINKED = "mf_account_linked";
    
    public static final String DB_MF_ACCOUNT_INFO = "mf_account_info";

    public static final String DB_MF_CUSTOM_DEVICE_SCENE = "mf_custom_device_scene";
   
    public static final String DB_MF_DEVICE_SCENE = "mf_device_scene";
    
    public static final String DB_MF_ACCOUNT_SCENE = "mf_account_scene";

    public static final String OPERATE_ADD = "1";
    public static final String OPERATE_EDIT = "2";
    public static final String OPERATE_DEL = "3";



}
