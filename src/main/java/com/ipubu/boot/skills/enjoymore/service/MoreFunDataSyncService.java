package com.ipubu.boot.skills.enjoymore.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.inpubu.boot.skills.enjoymore.util.ObjectId;
import com.ipubu.boot.skills.base.service.AbstractPlatformService;
import com.ipubu.boot.skills.base.service.DataSyncService;
import com.ipubu.boot.skills.enjoymore.domain.AccountScene;
import com.ipubu.boot.skills.enjoymore.domain.CustomDeviceScene;
import com.ipubu.boot.skills.enjoymore.domain.DeviceScene;
import com.ipubu.boot.skills.enjoymore.es.entity.ESCustomName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.ipubu.boot.skills.base.util.ParamChecker.isInvalidPara;
import static com.ipubu.boot.skills.enjoymore.constant.ESIndexAndTypeConsts.ES_MOREFUN_COTEGORY_DEVICE;
import static com.ipubu.boot.skills.enjoymore.constant.ESIndexAndTypeConsts.ES_MOREFUN_COTEGORY_SCENE;
import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.*;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_TYPE;
import static com.ipubu.boot.skills.enjoymore.constant.SmartHomeConsts.*;
/**
 * @ClassName MoreFunDataSyncService
 * @Description	
 * @Author jzy
 */

@Component
public class MoreFunDataSyncService extends AbstractPlatformService implements DataSyncService {

    @Autowired
    private MoreFunService moreFunService;

    @Override
    public void process(JSONObject jsonObj) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Request datasync input {}", jsonObj);
        }

        try {
            final String type = jsonObj.getString(P_TYPE);

            if (isInvalidPara(type)) {
                LOGGER.error("Required parameter type is null");
                return;
            }
            JSONObject jsonData = jsonObj.getJSONObject("data");
            LOGGER.info("the content of morefun data:{}", jsonData);
            if (Objects.nonNull(jsonData)) {
                switch (type) {
                    case TYPE_ACCOUNTSCENE:
                        operateAccountScene(jsonData);
                        break;
                    case TYPE_CUSTOMDEVICESCENE:
                        operateCustomDeviceScene(jsonData);
                        break;
                    case TYPE_DEVICESCENE:
                        passDeviceScene(jsonData);
                        break;
                    default:
                        LOGGER.error("未知的操作类型：{}", type);
                        break;
                }

            }

        } catch (Exception e) {
            LOGGER.error("Request applicationId now exception :{}", e);
        }
    }

    private void passDeviceScene(JSONObject obj) {
        String list = obj.getString("list");

        if (isInvalidPara(list)) {
            LOGGER.error("the data of list is null");
            return;
        }
        JSONArray jsonList = JSONArray.parseArray(list);
        if (Objects.nonNull(jsonList)) {
            for (int i = 0; i < jsonList.size(); i++) {
                DeviceScene deviceScene = new Gson().fromJson(jsonList.get(i).toString(), DeviceScene.class);
                LOGGER.info("识别到的是DeviceScene数据:{}", deviceScene);
                if (Objects.nonNull(deviceScene)) {
                    deviceScene.setId(new ObjectId().toHexString());
                    mongoTemplate.save(deviceScene);
                    LOGGER.info("数据存入mongodb:{}", deviceScene);
                }
            }
        }

    }

    private void operateCustomDeviceScene(JSONObject obj) {
        String userId;
        ESCustomName esCustomName = new ESCustomName();
        CustomDeviceScene instance = new Gson().fromJson(obj.toJSONString(), CustomDeviceScene.class);
        if (Objects.nonNull(instance)) {
            LOGGER.info("识别到的是CustomDeviceScene数据:{}", instance);
            instance.setId(new ObjectId().toHexString());
            userId = moreFunService.getUserId(instance.getThirdAccount());
            esCustomName.setCategory(ES_MOREFUN_COTEGORY_DEVICE);
            esCustomName.setOriginalName(instance.getBeforeModifyDeviceName());
            esCustomName.setAfterModifyName(instance.getAfterModifyDeviceName());
            esCustomName.setUserId(userId);
            final String operType = obj.getString("operType");
            switch (operType) {
                case OPERATE_ADD:
                    moreFunService.saveCustomDeviceScene(instance, esCustomName,false);
                    break;
                case OPERATE_EDIT:
                    moreFunService.saveCustomDeviceScene(instance, esCustomName,true);
                    break;
                case OPERATE_DEL:
                    moreFunService.deleteCustomDeviceScene(instance,esCustomName);
                    break;
                default:
                    LOGGER.error("operType 未知的操作类型：{}", operType);
                    break;
            }
        }
    }

    private void operateAccountScene(JSONObject obj) {
        AccountScene instance = new Gson().fromJson(obj.toJSONString(), AccountScene.class);
        if (Objects.nonNull(instance)) {
            ESCustomName esCustomName = new ESCustomName();
            LOGGER.info("识别到的是AccountScene数据:{}", instance);
            String userId = moreFunService.getUserId(instance.getThirdAccount());
            instance.setUserId(userId);
            esCustomName.setCategory(ES_MOREFUN_COTEGORY_SCENE);
            esCustomName.setOriginalName(instance.getSceneName());
            esCustomName.setAfterModifyName(instance.getAfterModifysceneName());
            esCustomName.setUserId(userId);
            String operType = instance.getOperType();
            switch (operType) {
                case OPERATE_ADD:
                    moreFunService.saveAccountScene(instance,esCustomName,false);
                    break;
                case OPERATE_EDIT:
                    moreFunService.saveAccountScene(instance,esCustomName,true);
                    break;
                case OPERATE_DEL:
                    moreFunService.deleteAccountScene(instance,esCustomName);
                    break;
                default:
                    LOGGER.error("operType 未知的操作类型：{}", operType);
                    break;
            }
        }


    }

}
