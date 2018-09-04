package com.ipubu.boot.skills.base.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName RtnCodeConsts
 * @Description		返回码异常
 * @Author jzy
 */
public class RtnCodeConsts {

    protected RtnCodeConsts() {
        throw new IllegalStateException(
                this.getClass().getName() + " is Utility class ,can't construction.");
    }

    protected static final Map<String, String> CODES = new ConcurrentHashMap<>();

    /**
     * 根据代码获取代码的解释信息
     * 
     * @param code
     * @return
     */
    public static String getCodeMsg(final String code) {
        return CODES.getOrDefault(code, "未找到此代码（" + code + "）的解释信息.");
    }
}
