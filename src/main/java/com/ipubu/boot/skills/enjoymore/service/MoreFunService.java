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

    /**
     * 获取userId
     * 
     * @param thirdAccount
     * @return
     */
    public String getUserId(String thirdAccount) {

        Query query = new Query();
        // 条件
        Criteria criteria1 = Criteria.where("username").is(thirdAccount);
        query.addCriteria(criteria1);

        AccountLinked aLinked = mongoTemplate.findOne(query, AccountLinked.class);

        if (Objects.nonNull(aLinked)) {
            return aLinked.getUserId();
        }

        return "";

    }

    /**
     * 根据userId和场景名称获取AccountScene
     *
     * @param userId
     * @return
     */
    public AccountScene getAccountScene(String userId,String sceneName) {

        Query query = new Query();
        // 条件
        Criteria criteria = new Criteria();
        criteria.and("userId").is(userId);
        criteria.and("sceneName").is(sceneName);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, AccountScene.class);

    }


    /**
     * 根据userId和修改前设备名获取对象
     *
     * @param userId
     * @return
     */
    public CustomDeviceScene getCustomDeviceScene(String userId,String beforeModifyDeviceName) {

        Query query = new Query();
        // 条件
        Criteria criteria = new Criteria();
        criteria.and("userId").is(userId);
        criteria.and("beforeModifyDeviceName").is(beforeModifyDeviceName);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, CustomDeviceScene.class);

    }
    /**
     * 更新账户基本信息
     * 
     * @param accountInfo
     */
    public void saveAccountInfo(AccountInfo accountInfo) {
        mongoTemplate.save(accountInfo);
    }

    /**
     * 更新账户关联信息
     * 
     * @param accountLinked
     */
    public void saveAccountLinked(AccountLinked accountLinked) {
        mongoTemplate.save(accountLinked);
    }

    /**
     * 删除用户关联信息
     * 
     * @param userId
     */
    public long removeAccountLinked(String userId) {
        // 查询用户下的设备信息
        Query query = new Query();
        // 条件
        Criteria criteria1 = Criteria.where(P_USERID).is(userId);
        query.addCriteria(criteria1);

        DeleteResult delResult = mongoTemplate.remove(query, AccountLinked.class);

        return delResult.getDeletedCount();
    }

    /**
     * 删除用户基本信息
     * 
     * @param userId
     */
    public long removeAccountInfo(String userId) {
        // 查询用户下的设备信息
        Query query = new Query();
        // 条件
        Criteria criteria1 = Criteria.where(P_USERID).is(userId);
        query.addCriteria(criteria1);

        DeleteResult delResult = mongoTemplate.remove(query, AccountInfo.class);

        return delResult.getDeletedCount();
    }

    /**
     * 保存账户设备
     * 
     * @param userId
     */
    public long removeAccountDevice(String userId) {
        // 查询用户下的设备信息
        Query query = new Query();

        // 条件
        Criteria criteria1 = Criteria.where(P_USERID).is(userId);
        query.addCriteria(criteria1);

        DeleteResult delResult = mongoTemplate.remove(query, DeviceScene.class);

        return delResult.getDeletedCount();
    }

    public List<CustomDeviceScene> getAccountDevice(String userId, String deviceType) {
        return null;
    }

    public JSONObject getDeviceScene(String deviceType) {
        return null;
    }

    /***
     * 保存AccountScene
     * @param accountScene
     * @param isUpdate
     */
    public void saveAccountScene(AccountScene accountScene, ESCustomName esCustomName, boolean isUpdate){
        try {
            if(Objects.nonNull(accountScene)){
                if(isUpdate){
                    String userId = this.getUserId(accountScene.getThirdAccount());
                    AccountScene accountScene1 = this.getAccountScene(userId,accountScene.getSceneName());
                    if(Objects.nonNull(accountScene1)){
                       accountScene.setId(accountScene1.getId());
                    }
                }else {
                    accountScene.setId(new ObjectId().toHexString());
                }
                if(StringUtils.isNotEmpty(accountScene.getId())){
                    mongoTemplate.save(accountScene);
                    elasticsearchService.saveESCustomName(esCustomName,isUpdate,accountScene.getId());
                }
            }
        } catch (Exception e) {
            LOGGER.error("AccountScene 保存到出现错误:{}", e);
        }

    }

    /***
     * 删除AccountScene
     * @param accountScene
     */
    @Transactional
    public void deleteAccountScene(AccountScene accountScene,ESCustomName esCustomName){
        try {
            AccountScene accountScene1 = null;
            if (Objects.nonNull(accountScene)) {
                String userId = this.getUserId(accountScene.getThirdAccount());
                accountScene1 = this.getAccountScene(userId,accountScene.getSceneName());
                if(Objects.nonNull(accountScene1)){
                    Query query = new Query();
                    Criteria criteria = new Criteria();
                    criteria.and("sceneName").is(accountScene1.getSceneName());
                    criteria.and("userId").is(accountScene1.getUserId());
                    query.addCriteria(criteria);
                    mongoTemplate.remove(query,AccountScene.class);
                    elasticsearchService.deleteCustomName(esCustomName,accountScene1.getId());
                }
            }

        } catch (Exception e) {
            LOGGER.error("AccountScene 从mongodb里面删除错误:{}", e);
        }
    }
}
