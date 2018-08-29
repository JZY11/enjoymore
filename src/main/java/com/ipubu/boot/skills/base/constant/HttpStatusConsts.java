package com.ipubu.boot.skills.base.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName HttpStatusConsts
 * @Description
 * @Author jzy
 */
public final class HttpStatusConsts {

    private static final Map<String, String> CODES = new ConcurrentHashMap<>();

    private HttpStatusConsts() {
        throw new IllegalStateException(
                this.getClass().getName() + " is Utility class ,can't construction.");
    }

    static {
        CODES.put("200", "OK,GET或者PUT请求成功");
        CODES.put("201", "Created,POST请求成功");
        CODES.put("204", "No content,DELETE请求成功");
        CODES.put("400", "Bad request,GET, PUT或者POST请求由于内容不符合标准而失败");
        CODES.put("401", "Unauthorized,身份验证未通过");
        CODES.put("403", "Forbidden,不允许的请求");
        CODES.put("404", "Not found,请求的URL没有资源或者参数错误");
        CODES.put("405", "Method not allowed,指定的URL不允许此种请求类型");
        CODES.put("409", "Conflict,POST失败,试图插入重复数据");
        CODES.put("500", "Internal server error,服务器或数据库故障");
    }

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
