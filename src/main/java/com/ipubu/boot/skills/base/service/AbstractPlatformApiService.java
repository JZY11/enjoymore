package com.ipubu.boot.skills.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.exception.SmartHomeException;
import com.ipubu.boot.skills.enjoymore.dto.ControlDTO;

/**
 * @ClassName AbstractPlatformApiService
 * @Description		平台API服务
 * @Author jzy
 */
public abstract class AbstractPlatformApiService {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 执行命令
     * 
     * @param morefunDTO
     * @return
     */
    protected abstract JSONObject doCommand(ControlDTO controlDTO) throws SmartHomeException;

    /**
     * 控制操作
     * 
     * @param morefunDTO
     * @return
     */
    public JSONObject execControl(ControlDTO controlDTO) throws SmartHomeException {

        // 进行控制
        return doCommand(controlDTO);

    }

}
