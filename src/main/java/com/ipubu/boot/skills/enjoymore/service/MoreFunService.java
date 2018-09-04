package com.ipubu.boot.skills.enjoymore.service;

import com.alibaba.fastjson.JSONObject;
import com.inpubu.boot.skills.enjoymore.util.ObjectId;
import com.ipubu.boot.skills.base.service.AbstractPlatformService;
import com.ipubu.boot.skills.enjoymore.domain.*;
import com.ipubu.boot.skills.enjoymore.es.entity.ESCustomName;
import com.mongodb.client.result.DeleteResult;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_USERID;
/**
 * @ClassName MoreFunService
 * @Description	  
 * @Author jzy
 */
@Service
public class MoreFunService extends AbstractPlatformService {

    @Autowired
    private ElasticsearchService elasticsearchService;
    /**
     * 获取账户关联信息
     * 
     * @param userId
     * @return
     */
    public AccountInfo getAccountInfo(String userId) {

        // 查询用户下的设备信息
        Query query = new Query();

        // 条件
        Criteria criteria1 = Criteria.where(P_USERID).is(userId);
        query.addCriteria(criteria1);

        return mongoTemplate.findOne(query, AccountInfo.class);
    }

    /**
     * 获取账户关联信息
     * 
     * @param userId
     * @return
     */
    public AccountLinked getAccountLinked(String userId) {

        Query query = new Query();
        // 条件
        Criteria criteria1 = Criteria.where("userId").is(userId);
        query.addCriteria(criteria1);

        return mongoTemplate.findOne(query, AccountLinked.class);
    }

}
