package com.ipubu.boot.skills.enjoymore.smarthome;

import static com.ipubu.boot.skills.enjoymore.constant.DeviceConsts.SMARTHOME_LIGHT;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.REQ_ACTION;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.REQ_INPUT;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.REQ_PARAM;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.DB_ACTION;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.DB_FUNCTION;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.DB_PARAM;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.DEVICE_NO_FIND;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.FUNCTION_NO;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.PARAM_NO_FIND;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.PARAM_OUT_RANGE;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.RESPONSE_TEXT;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.USER_NO_DEVICE;
import static com.ipubu.boot.skills.enjoymore.constant.RspConsts.USER_NO_FIND;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipubu.boot.skills.base.constant.RtnCodeConsts;
import com.ipubu.boot.skills.base.exception.SmartHomeException;
import com.ipubu.boot.skills.base.util.ParamChecker;
import com.ipubu.boot.skills.enjoymore.constant.CommandConsts;
import com.ipubu.boot.skills.enjoymore.constant.RspConsts;
import com.ipubu.boot.skills.enjoymore.domain.AccountLinked;
import com.ipubu.boot.skills.enjoymore.domain.CustomDeviceScene;
import com.ipubu.boot.skills.enjoymore.dto.ControlDTO;
/**
 * @ClassName SmartHomeLight
 * @Description
 * @Author jzy
 */
public class SmartHomeLight extends AbstractSmartHome implements SmartHome {

	@Override
	public JSONObject control(JSONObject intent, String userId) throws SmartHomeException {
		final String input = intent.getString(REQ_INPUT);
		final String actionName = intent.getString(REQ_ACTION);
		final String command = intent.getString(REQ_PARAM);

		final String actionValue = CommandConsts.getLIGHTValue(actionName);
		final String paramValue = CommandConsts.getLIGHTValue(command);

		AccountLinked accountLinked = morefunService.getAccountLinked(userId);

		if (accountLinked == null) {
			LOGGER.warn(USER_NO_FIND, userId);
			return responseMsg(RspConsts.getUserId(userId));
		}
		// 获得的指令参数
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("获取的指令参数值...", paramValue);
		}

		// 参数为空返回 "指令未找到"
		if (paramValue.isEmpty()) {
			return responseMsg(PARAM_NO_FIND);
		}

		// 查询用户是否绑定该设备
		List<CustomDeviceScene> accountDevice = morefunService.getAccountDevice(userId, SMARTHOME_LIGHT);
		if (ParamChecker.isEmpty(accountDevice)) {
			LOGGER.warn(USER_NO_DEVICE, userId, SMARTHOME_LIGHT);
			return responseMsg(SMARTHOME_LIGHT + DEVICE_NO_FIND);
		}

		// 查询设备的参数信息
		JSONObject deviceScene = morefunService.getDeviceScene(SMARTHOME_LIGHT);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("SmartHomeLight req deviceScene:{}", deviceScene);
		}

		JSONArray action = deviceScene.getJSONArray(DB_ACTION);

		ControlDTO controlDTO = new ControlDTO();

		for (int i = 0; i < action.size(); i++) {
			String function = action.getJSONObject(i).getString(DB_FUNCTION);
			if (actionValue.equals(function)) {
				JSONArray param = action.getJSONObject(i).getJSONArray(DB_PARAM);
				if (param.contains(paramValue)) {
					controlDTO.setParam(paramValue);
					controlDTO.setAction(actionValue);
					controlDTO.setObject(SMARTHOME_LIGHT);
					controlDTO.setOrignVolume(input);
					controlDTO.setThirdAccount(accountLinked.getUsername());
				}
			} else {
				return responseMsg(FUNCTION_NO);
			}
		}

}
