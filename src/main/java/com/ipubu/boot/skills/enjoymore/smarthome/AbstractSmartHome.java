package com.ipubu.boot.skills.enjoymore.smarthome;


import static com.ipubu.boot.skills.base.constant.ResponseConsts.RESPONSE_ERROR;
import static com.ipubu.boot.skills.base.constant.RtnCodeConsts.getCodeMsg;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.RESULTCODE;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.framework.BeanContainer;
import com.ipubu.boot.skills.enjoymore.service.MoreFunApiService;
import com.ipubu.boot.skills.enjoymore.service.MoreFunService;

/**
 * @ClassName AbstractSmartHome
 * @Description
 * @Author jzy
 */
@Component
public abstract class AbstractSmartHome {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected static final String RESP_TEXT = RESPONSE_ERROR;
    protected static final String RESP_NO_SKILL =
            com.ipubu.boot.skills.base.constant.ResponseConsts.RESP_NO_SKILL;


    @Autowired
    protected static MoreFunApiService morefunApiService;

    @Autowired
    protected static MoreFunService morefunService;

    static {

        if (morefunService == null) {
            morefunService = BeanContainer.getBean(MoreFunService.class);
        }

        if (morefunApiService == null) {
            morefunApiService = BeanContainer.getBean(MoreFunApiService.class);
        }
    }

    /**
     * 处理返回信息
     * 
     * @param rtnObj
     */
    protected String processResponse(JSONObject rtnObj, final String expectMsg) {

        String text = expectMsg;
        final String rtnCode = rtnObj.getString(RESULTCODE);

        if (!SUCCESS.equalsIgnoreCase(rtnCode)) {
            text = getCodeMsg(rtnCode);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("invoke remote interface return msg:{}", text);
            }
        }
        return text;
    }

    /**
     * 返回消息
     * 
     * @param msg
     * @return
     */
    protected JSONObject responseMsg(String msg) {
        JSONObject response = new JSONObject();
        response.put(RESP_TEXT, msg);
        return response;
    }


}
