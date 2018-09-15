package com.ipubu.boot.skills.enjoymore.smarthome;

import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.exception.SmartHomeException;
import com.ipubu.boot.skills.enjoymore.dto.ControlDTO;

/**
 * @ClassName SmartHomeDevice
 * @Description
 * @Author jzy
 */
public class SmartHomeDevice extends AbstractSmartHome implements SmartHome {

    @Override
    public JSONObject control(JSONObject request, String userId) throws SmartHomeException {

        String expectMsg = RESP_TEXT;
        
        ControlDTO controlDTO = new ControlDTO();

        int randomNum = new Random().nextInt(65535);
        long time = System.currentTimeMillis();

        controlDTO.setTime(String.valueOf(time));

        controlDTO.setRandom(String.valueOf(randomNum));

        controlDTO.setSeq(controlDTO.getTime() + controlDTO.getRandom());

        controlDTO.setType("7");

        controlDTO.setOrignVolume("打开灯");

        controlDTO.setParam("开");

        controlDTO.setThirdAccount("18911776459");

        controlDTO.setAction("开关");

        controlDTO.setTimePoint(controlDTO.getSeq());

        controlDTO.setObject("灯");

        JSONObject rtnJson = morefunApiService.execControl(controlDTO);

        expectMsg = processResponse(rtnJson, expectMsg);
        JSONObject response = new JSONObject();
        response.put(RESP_TEXT, expectMsg);
        return response;
    }

}
