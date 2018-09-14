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
