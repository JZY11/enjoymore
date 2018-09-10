package com.ipubu.boot.skills.enjoymore.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName LanguageCodeConsts
 * @Description	 语言代码常量
 * @Author jzy
 */
public final class LanguageCodeConsts {

    /**
     * key:countryCode,value:lanCode
     */
    private static final Map<String, String> LANGUAGE_CODE = new ConcurrentHashMap<>();

    private LanguageCodeConsts() {
        throw new IllegalStateException("this is Utility class ,can't construction.");
    }

    static {
        LANGUAGE_CODE.put("CN", "zh");
        LANGUAGE_CODE.put("EN", "en");
        LANGUAGE_CODE.put("HK", "zh");
        LANGUAGE_CODE.put("DE", "de");
        LANGUAGE_CODE.put("JP", "jp");
    }

    /**
     * 获取国家语言代码
     * 
     * @param lan
     * @return
     */
    public static String lanCode(String lan) {
        return LANGUAGE_CODE.getOrDefault(lan, "CN");
    }
}
