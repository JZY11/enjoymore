package com.ipubu.boot.skills.enjoymore.service;

import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.HOST;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.inpubu.boot.skills.enjoymore.util.CryptUtil;
import com.inpubu.boot.skills.enjoymore.util.HttpUtil;
import com.ipubu.boot.skills.base.exception.SmartHomeException;
import com.ipubu.boot.skills.base.service.AbstractPlatformApiService;
import com.ipubu.boot.skills.enjoymore.constant.GlobalConsts;
import com.ipubu.boot.skills.enjoymore.dto.ControlDTO;

/**
 * @ClassName ElasticsearchService
 * @Description	  处理IOT请求服务
 * @Author jzy
 */
@Component
public class MoreFunApiService extends AbstractPlatformApiService {

    @Override
    protected JSONObject doCommand(ControlDTO control) throws SmartHomeException {
        String res = "";

        try {

            // 设置公共请求参数

            // 最大65535的随机整数
            int randomNum = new Random().nextInt(65535);
            // 系统时间毫秒数
            long time = System.currentTimeMillis();

            control.setTime(String.valueOf(time));

            control.setRandom(String.valueOf(randomNum));

            control.setSeq(control.getTime() + control.getRandom());

            control.setType("7");

            control.setTimePoint(control.getSeq());

            JSONObject json = new JSONObject();

            json.put("seq", control.getSeq());
            json.put("type", control.getType());

            JSONObject data = new JSONObject();
            data.put("orignVolum", control.getOrignVolume());
            data.put("thirdAccount", control.getThirdAccount());
            data.put("param", control.getParam());
            data.put("action", control.getAction());
            data.put("timePoint", control.getTimePoint());
            data.put("object", control.getObject());

            json.put("data", data);

            Map<String, String> header = new HashMap<>();

            header.put("appid", GlobalConsts.APPID);

            String sign = "appkey=" + GlobalConsts.APPKEY + "&random=" + control.getRandom()
                    + "&time=" + control.getTime();
            sign = CryptUtil.getSHA256StrJava(sign);
            header.put("sign", sign);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("post content:sign= {},reqbody={}", sign, json);
            }
            // 请求地址
            final String reqPath = HOST + "/iot/third/service?random=" + control.getRandom()
                    + "&time=" + control.getTime();
            // 请求
            res = HttpUtil.doPost(reqPath, header, json.toString());

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Control result is {}", res);
            }

        } catch (Exception e) {
            LOGGER.error("doQuery exception {}", e);
        }
        return JSONObject.parseObject(res);
    }

}
