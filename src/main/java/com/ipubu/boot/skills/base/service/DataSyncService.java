package com.ipubu.boot.skills.base.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName DataSyncService
 * @Description	  数据同步更新
 * @Author jzy
 */
public interface DataSyncService {

    /**
     * 处理消息
     * 
     * @param json
     */
    void process(JSONObject json);

}
