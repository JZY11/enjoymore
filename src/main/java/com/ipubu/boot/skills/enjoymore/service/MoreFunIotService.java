package com.ipubu.boot.skills.enjoymore.service;

import static com.ipubu.boot.skills.base.util.ParamChecker.isInvalidPara;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.ACTION_ACCOUNT_LINKED;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_ACTION;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_PAYLOAD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.service.AbstractPlatformService;
import com.ipubu.boot.skills.base.service.DataSyncService;
import com.ipubu.boot.skills.enjoymore.domain.AccountInfo;
import com.ipubu.boot.skills.enjoymore.domain.AccountLinked;

/**
 * @ClassName MoreFunIotService
 * @Description		处理iot下发的命令
 * @Author jzy
 */
@Component
public class MoreFunIotService extends AbstractPlatformService implements DataSyncService {

    @Autowired
    private MoreFunService morefunService;

    @Override
    public void process(JSONObject json) {

        try {
            final String action = json.getString(P_ACTION);

            if (isInvalidPara(action)) {
                LOGGER.error("Required parameter platform is null");
                return;
            }

            if (ACTION_ACCOUNT_LINKED.equalsIgnoreCase(action)) {
                accountLinked(json);
            } else {
                LOGGER.error("未知的操作类型：{}", action);
            }

        } catch (Exception e) {
            LOGGER.error("process IOT message:{}", e);
        }
    }

    /**
     * 账户关联
     * 
     * @param paramMap
     * @throws Exception
     */
    protected void accountLinked(JSONObject json) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("接收数据(accountLinked)账户关联消息,json:{}", json);
        }

        final String payload = json.getString(P_PAYLOAD);

        // 解析账户关联信息
        AccountLinked aLinked = parseAccountLinked(payload);

        final String userId = aLinked.getUserId();


        AccountLinked orginalALinked = morefunService.getAccountLinked(userId);
        // 判断用户是否已经绑定过
        if (orginalALinked != null) {
            // 先删除再增加
            long res = morefunService.removeAccountLinked(userId);
            LOGGER.info("账户({})绑定请求，用户已绑定，先删除用户绑定信息再增加.res:{}", userId, res);
        }
        // 保存账户关联信息
        morefunService.saveAccountLinked(aLinked);

        AccountInfo aInfo = morefunService.getAccountInfo(userId);

        // 判断用户是否已经绑定过
        if (aInfo != null) {
            // 先删除再增加
            long res = morefunService.removeAccountInfo(userId);
            LOGGER.info("账户({})绑定请求，用户已绑定，先删除用户绑定信息再增加.res:{}", userId, res);
        } else {//
            aInfo = new AccountInfo();
        }

        aInfo.setUserId(userId);

        // 保存账户基本信息
        morefunService.saveAccountInfo(aInfo);

        LOGGER.info("账户:{} 关联完毕。", userId);
    }



}
