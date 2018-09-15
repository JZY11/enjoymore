package com.ipubu.boot.skills.enjoymore.smarthome;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.exception.SmartHomeException;

/**
 * @ClassName SmartHome
 * @Description
 * @Author jzy
 */
public interface SmartHome {

    JSONObject control(JSONObject intent, final String userId) throws SmartHomeException;
}
