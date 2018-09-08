package com.ipubu.boot.skills.enjoymore.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @ClassName DeviceConsts
 * @Description	
 * @Author jzy
 */
public final class DeviceConsts {

	private DeviceConsts() {
		throw new IllegalStateException("it is wrong ,can't construction.");
	}

	private static final Map<String, Integer> DEVICE_TYPE_NAME = new ConcurrentHashMap<>();

	private static final Map<Integer, String> DEVICE_TYPE_KEY = new ConcurrentHashMap<>();

	static {

		DEVICE_TYPE_NAME.put("机顶盒", 32);
		DEVICE_TYPE_NAME.put("插座", 29);
		DEVICE_TYPE_NAME.put("空调", 5);
		DEVICE_TYPE_NAME.put("风扇", 58);
		DEVICE_TYPE_NAME.put("电视", 6);
		DEVICE_TYPE_NAME.put("电视盒子", 59);

		DEVICE_TYPE_KEY.put(32, "机顶盒");
		DEVICE_TYPE_KEY.put(29, "插座");
		DEVICE_TYPE_KEY.put(5, "空调");
		DEVICE_TYPE_KEY.put(58, "风扇");
		DEVICE_TYPE_KEY.put(6, "电视");
		DEVICE_TYPE_KEY.put(59, "电视盒子");
	}

	public static int getDeviceType(String deviceName) {
		return DEVICE_TYPE_NAME.get(deviceName);
	}

	public static String getDeviceName(int deviceType) {
		return DEVICE_TYPE_KEY.get(deviceType);
	}

	public static boolean containsDeviceType(int deviceType) {
		return DEVICE_TYPE_KEY.containsKey(deviceType);
	}

	/** 电视 */
	public static final int SMARTHOME_DEVICE = 1;

	/** 灯 */
	public static final String SMARTHOME_LIGHT = "灯";
	/** 窗帘 */
	public static final String SMARTHOME_CURTAIN = "窗帘";
	/** 插座 */
	public static final String SMARTHOME_SOCKET = "插座";
	/** 机顶盒 */
	public static final int SMARTHOME_STB = 32;
	/** 空调 */
	public static final int SMARTHOME_AC = 5;
	/** 风扇 */
	public static final int SMARTHOME_FAN = 58;
	/** 电视盒子 */
	public static final int SMARTHOME_TVBOX = 59;

}
