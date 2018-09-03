package com.ipubu.boot.skills.enjoymore.service;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.service.AbstractElasticsearchService;
import com.ipubu.boot.skills.enjoymore.es.entity.ESCustomName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

import static com.ipubu.boot.skills.enjoymore.constant.ESIndexAndTypeConsts.*;
/**
 * @ClassName ElasticsearchService
 * @Description	
 * @Author jzy
 */
@Component
public class ElasticsearchService extends AbstractElasticsearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchService.class);

    public void saveESCustomName(ESCustomName esCustomName, boolean isUpdate, String id) {
        try {
            Map<String, Object> esMap = null;
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(esCustomName);
            if (isUpdate) {
                boolean indexIsExist = this.isIndexExist(ES_MOREFUN_INDEX);
                if (indexIsExist) {
                    esMap = this.searchDataById(ES_MOREFUN_INDEX, ES_MOREFUN_TYPE_ACCOUNTSCENE, id, null);
                }
                if (Objects.nonNull(esMap)) {
                    this.updateDataById(jsonObject, ES_MOREFUN_INDEX, ES_MOREFUN_TYPE_ACCOUNTSCENE, id);
                }
            } else {
                this.addData(jsonObject, ES_MOREFUN_INDEX, ES_MOREFUN_TYPE_ACCOUNTSCENE, id);
            }
        } catch (Exception e) {
            LOGGER.error("ESCustomName数据添加到elasticsearch时出现异常:{}", e);
        }

    }

    public void deleteCustomName(ESCustomName esCustomName, String id) {
        try {
            if (Objects.nonNull(esCustomName)) {
                LOGGER.info("数据已经存入mongodb:{}", esCustomName);
                boolean indexIsExist = this.isIndexExist(ES_MOREFUN_INDEX);
                if (indexIsExist) {
                    this.deleteDataById(ES_MOREFUN_INDEX, ES_MOREFUN_TYPE_ACCOUNTSCENE, id);
                }
            }
        } catch (Exception e) {
            LOGGER.error("ESCustomName从elasticsearch删除诗句时出现异常:{}", e);
        }

    }
}
