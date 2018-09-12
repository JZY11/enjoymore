package com.ipubu.boot.skills.enjoymore.constant;

import java.util.HashSet;
import java.util.Set;
/**
 * @ClassName SmartHomeConsts
 * @Description
 * @Author jzy
 */
public class SmartHomeConsts {

    private SmartHomeConsts() {
        throw new IllegalStateException("this is Utility class ,can't construction.");
    }

    public static final String TYPE_CUSTOMDEVICESCENE = "5";
    public static final String TYPE_DEVICESCENE = "6";
    public static final String TYPE_VOICE_CONTROL = "7";
    public static final String TYPE_ACCOUNTSCENE = "9";

    private static final Set<String> PROTOCOL_PARAMS_PAYLOAD = new HashSet<>();

    static {
        PROTOCOL_PARAMS_PAYLOAD.add("attribute");
        PROTOCOL_PARAMS_PAYLOAD.add("value");
        PROTOCOL_PARAMS_PAYLOAD.add("userId");
    }

    public static boolean checkParam(String param) {
        return PROTOCOL_PARAMS_PAYLOAD.contains(param);
    }

    public static Set<String> payloadParam() {
        return PROTOCOL_PARAMS_PAYLOAD;
    }
}
