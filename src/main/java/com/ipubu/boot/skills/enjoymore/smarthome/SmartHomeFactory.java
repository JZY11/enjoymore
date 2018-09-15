package com.ipubu.boot.skills.enjoymore.smarthome;

import static com.ipubu.boot.skills.base.constant.ResponseConsts.RESPONSE_ERROR;
import static com.ipubu.boot.skills.base.constant.ResponseConsts.RESP_TEXT;
import static com.ipubu.boot.skills.enjoymore.constant.DeviceConsts.SMARTHOME_DEVICE;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lenovo.cui.skiprotocol.SKIResponser;

/**
 * @ClassName SmartHomeFactory
 * @Description	工厂
 * @Author jzy
 */
public class SmartHomeFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmartHomeFactory.class);

    private static final Map<Integer, SmartHome> SMARTHOME_MAP = new ConcurrentHashMap<>();

    private static final SmartHomeFactory smartHomeFactory = new SmartHomeFactory();

    private SmartHomeFactory() {
        init();
    }

    public static SmartHomeFactory me() {
        return smartHomeFactory;
    }

    private void init() {

        LOGGER.info("init...");

        SMARTHOME_MAP.put(SMARTHOME_DEVICE, new SmartHomeDevice());

        LOGGER.info("init finish...");
    }

    /**
     * 处理请求
     * 
     * @param request
     * @return
     * @throws IOException
     */
    public JSONObject process(JSONObject request) throws IOException {

        String type = "PlainText";
        String shouldEndSession = "true";
        String text = RESPONSE_ERROR;

        try {
            JSONObject intent = request.getJSONArray("intent").getJSONObject(0);

            String userId = request.getString("userid");

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("process===> userId:{}", userId);
            }

            SmartHome smartHome = SMARTHOME_MAP.get(SMARTHOME_DEVICE);

            JSONObject obj = smartHome.control(intent, userId);

        } catch (Exception e) {
            LOGGER.error("SmartHome process exception :", e);
        }

        return SKIResponser.getResponseJSON(type, null, null, null, shouldEndSession, text);
    }

}
