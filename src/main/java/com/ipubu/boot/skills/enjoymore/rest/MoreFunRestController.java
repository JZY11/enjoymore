package com.ipubu.boot.skills.enjoymore.rest;

import static com.ipubu.boot.skills.base.constant.ResponseConsts.RESPONSE_ERROR;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.enjoymore.smarthome.SmartHomeFactory;
import com.lenovo.cui.skiprotocol.SKIResponser;
/**
 * @ClassName MoreFunRestController
 * @Description
 * @Author jzy
 */
@RequestMapping("/normal")
@RestController
public class MoreFunRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoreFunRestController.class);

    /**
     * 
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/morefun/*", method = { POST })
    public JSONObject morefun(@RequestBody JSONObject request) throws IOException {

        try {
            JSONObject req =
                    request.getJSONObject("request").getJSONObject("intent").getJSONObject("slots");
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("req: {}", req);
            }
            // 请求响应
            return SmartHomeFactory.me().process(req);
        } catch (Exception e) {
            LOGGER.error("response exception : {}", e);
        }

        String type = "PlainText";
        String shouldEndSession = "true";
        String text = RESPONSE_ERROR;
        return SKIResponser.getResponseJSON(type, null, null, null, shouldEndSession, text);
    }


}
