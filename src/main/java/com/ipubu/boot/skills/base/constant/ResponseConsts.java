package com.ipubu.boot.skills.base.constant;

/**
 * @ClassName ResponseConsts
 * @Description
 * @Author jzy
 */
public class ResponseConsts {

    protected ResponseConsts() {
        throw new IllegalStateException(
                this.getClass().getName() + " is Utility class ,can't construction.");
    }

    public static final String RESPONSE_ERROR = "未知错误，请稍后再试";

    public static final String RESP_NO_SKILL = "这个技能在学习中";

    public static final String RESP_NOT_IMPLEMENT = "该功能待开发哦";

    public static final String RESP_TEXT = "respText";

    public static final String TYPE = "PlainText";

    public static final String STATUS = "status";

    public static final String MSG = "msg";

}
