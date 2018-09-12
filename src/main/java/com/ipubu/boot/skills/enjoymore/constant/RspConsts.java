package com.ipubu.boot.skills.enjoymore.constant;

/**
 * 响应参数常量
 * 
 * @author Charles Duan
 * @date 2018-06-13
 * @version v1.0.0
 */
public final class RspConsts {

    protected RspConsts() {
        throw new IllegalStateException(
                this.getClass().getName() + " is Utility class ,can't construction.");
    }

    public static final String RESPONSE_TEXT = "respText";
    public static final String PARAM_OUT_RANGE = "指令超出可操作范围！";
    public static final String FUNCTION_NO = "设备没有该功能！";
    public static final String PARAM_NO_FIND = "指令未找到！";
    public static final String DEVICE_NO_FIND = "未找到，请检查是否绑定.";
    public static final String USER_NO_DEVICE = "账户({})未找到({})，请检查账户是否绑定.";
    public static final String USER_NO_FIND = "账户({})在关联库中未找到，请检查账户是否绑定.";

    public static String getUserId(String userId) {
        return "账户(" + userId + ")未找到，请检查账户是否绑定.";
    }

    // morefun response data
    /**
     * 功能名称
     */
    public static final String DB_FUNCTION = "function";
    /**
     * 参数值
     */
    public static final String DB_PARAM = "param";
    /**
     * 功能名称对应的参数范围
     */
    public static final String DB_ACTION = "action";

    /** 返回状态 */
    public static final String RESULTCODE = "resultCode";
    /** 返回说明 */
    public static final String RESULTMSG = "resultMsg";
    /** 返回数据 */
    public static final String DATA = "data";
    /** 成功 */
    public static final String SUCCESS = "000000";
    /** 失败 */
    public static final String FAIL = "999999";

}
