package com.ipubu.boot.skills.enjoymore.constant;

import com.ipubu.boot.skills.base.constant.RtnCodeConsts;

/**
 * @ClassName ReturnCodeConsts
 * @Description		返回码常量
 * @Author jzy
 */
public final class ReturnCodeConsts extends RtnCodeConsts {

    static {
        CODES.put("000000", "成功");
        CODES.put("999999", "失败");
        CODES.put("100001", "数据格式错误");
        CODES.put("100003", "数据解密不通过");
        CODES.put("100004", "id无效");
        CODES.put("100010", "必填参数错误");
        CODES.put("100011", "下行地址不通");
        CODES.put("100012", "deviceMac参数无效");
    }

}
