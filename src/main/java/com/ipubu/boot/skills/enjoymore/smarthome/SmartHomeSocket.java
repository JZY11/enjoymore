package com.ipubu.boot.skills.enjoymore.smarthome;

import static com.ipubu.boot.skills.enjoymore.constant.DeviceConsts.SMARTHOME_SOCKET;
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
 * @ClassName SmartHomeSocket
 * @Description
 * @Author jzy
 */
public class SmartHomeSocket extends AbstractSmartHome implements SmartHome {

	@Override
	public JSONObject control(JSONObject intent, String userId) throws SmartHomeException {
		final String input = intent.getString(REQ_INPUT);
		final String actionName = intent.getString(REQ_ACTION);
		final String command = intent.getString(REQ_PARAM);

		final String actionValue = CommandConsts.getSOCKETValue(actionName);
		final String paramValue = CommandConsts.getSOCKETValue(command);

		AccountLinked accountLinked = morefunService.getAccountLinked(userId);

		if (accountLinked == null) {
			LOGGER.warn(USER_NO_FIND, userId);
			return responseMsg(RspConsts.getUserId(userId));
		}

		// 获得的指令参数
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("SmartHomeLight req paramValue:{}", paramValue);
		}

		// 参数为空返回 "指令未找到"
		if (paramValue.isEmpty()) {
			return responseMsg(PARAM_NO_FIND);
		}

		// 查询用户是否绑定该设备
		List<CustomDeviceScene> accountDevice = morefunService.getAccountDevice(userId, SMARTHOME_SOCKET);
		if (ParamChecker.isEmpty(accountDevice)) {
			LOGGER.warn(USER_NO_DEVICE, userId, SMARTHOME_SOCKET);
			return responseMsg(SMARTHOME_SOCKET + DEVICE_NO_FIND);
		}

		// 查询设备的参数信息
		JSONObject deviceScene = morefunService.getDeviceScene(SMARTHOME_SOCKET);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("SmartHomeLight req deviceScene:{}", deviceScene);
		}

}
