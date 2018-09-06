package com.ipubu.boot.skills.base.service;

import static com.ipubu.boot.skills.base.util.ParamChecker.isValidPara;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_ATTRIBUTE;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_USERID;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_USERNAME;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_VALUE;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.enjoymore.domain.AccountLinked;
/**
 * @ClassName AbstractPlatformService
 * @Description	
 * @Author jzy
 */

@Component
public abstract class AbstractPlatformService {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 转换参数内容
     * 
     * @param payload
     * @return
     */
    public AccountLinked parseAccountLinked(String payload) {

        JSONArray jsonList = JSONArray.parseArray(payload);

        String userId = "";
        String username = "";
        String pword = "";

        for (int i = 0; i < jsonList.size(); i++) {

            JSONObject obj = jsonList.getJSONObject(i);

            String attribute = obj.getString(P_ATTRIBUTE);
            String value = obj.getString(P_VALUE);

            switch (attribute) {
                case P_USERID:
                    userId = value;
                    break;
                case P_USERNAME:
                    username = value;
                    break;
                default:
                    break;
            }
        }

        return new AccountLinked(userId, username, pword);
    }
}
