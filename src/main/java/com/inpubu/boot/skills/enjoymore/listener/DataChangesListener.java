package com.inpubu.boot.skills.enjoymore.listener;

import static com.ipubu.boot.skills.base.util.ParamChecker.isInvalidPara;
import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.APPKEY;
import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.CHAR_ENCODING;
import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.TOPIC_SMARTHOME_DATASYNC;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.inpubu.boot.skills.enjoymore.util.CryptUtil;
import com.ipubu.boot.skills.enjoymore.service.MoreFunDataSyncService;
import com.ipubu.boot.skills.enjoymore.service.MoreFunIotService;

/**
 * @ClassName DataChangesListener
 * @Description		数据变更操作
 * @Author jzy
 */
@Component
public class DataChangesListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataChangesListener.class);

    @Autowired
    private MoreFunDataSyncService morefunDataSyncService;
    @Autowired
    private MoreFunIotService moreFunIotService;

    private static final String KEY = "\"platform\": \"morefun\"";

    @KafkaListener(topics = TOPIC_SMARTHOME_DATASYNC)
    public void processMessage(String input) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("DataChangesListener received datasync request {}", input);
        }

        try {

            // 验证请求参数是否有效
            if (isInvalidPara(input)) {
                LOGGER.error("input is invalid! input:{}", input);
                return;
            }

            if (input.contains(KEY)) {
                LOGGER.info("IOT request message...");

                JSONObject json = JSONObject.parseObject(input);

                moreFunIotService.process(json);
            } else {
                LOGGER.info("morefun request message...");

                byte[] decrypt = CryptUtil.me().decrypt(Base64.decodeBase64(input), APPKEY);
                final String uncrpyt = new String(decrypt, CHAR_ENCODING);

                LOGGER.info("the morefun data was decrypted successfully... uncrypt===>{}",
                        uncrpyt);

                JSONObject json = JSONObject.parseObject(uncrpyt);

                morefunDataSyncService.process(json);
            }

        } catch (Exception e) {
            LOGGER.error("接收数据同步请求处理异常啦", e);
        }
    }
}
