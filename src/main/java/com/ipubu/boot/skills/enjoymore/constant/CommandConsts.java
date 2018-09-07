package com.ipubu.boot.skills.enjoymore.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName CommandConsts
 * @Description		公共参数指定
 * @Author jzy
 */
public class CommandConsts {

	private CommandConsts() {

	}

	private static final String ERROR = "-10000";

	/**
	 * 灯
	 */
	private static final Map<String, String> LIGHT = new ConcurrentHashMap<>();

	static {

		LIGHT.put("", "开");
		LIGHT.put("", "关");
		LIGHT.put("", "挂机");
		LIGHT.put("", "up");
		LIGHT.put("", "down");

		// 指令名称
		LIGHT.put("", "亮度等级");
		LIGHT.put("", "绿色值");
		LIGHT.put("", "蓝色值");
		LIGHT.put("", "恢复默认");
		LIGHT.put("", "渐变延时");
		LIGHT.put("", "红色值");
		LIGHT.put("", "场景控制");
		LIGHT.put("", "开关");
		LIGHT.put("", "色温等级");
		LIGHT.put("", "场景设置");
	}

	/**
	 * 灯参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getLIGHTValue(final String code) {
		return LIGHT.getOrDefault(code, ERROR);
	}

	/**
	 * 窗帘
	 */
	private static final Map<String, String> CURTAIN = new ConcurrentHashMap<>();

	static {

		CURTAIN.put("", "开开");
		CURTAIN.put("", "关掉");
		CURTAIN.put("", "停止");
		CURTAIN.put("", "up");
		CURTAIN.put("", "down");

		// 指令名称
		CURTAIN.put("", "开关");
		CURTAIN.put("", "程度");
		CURTAIN.put("", "开关two");
	}

	/**
	 * 窗帘参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getCURTAINValue(final String code) {
		return CURTAIN.getOrDefault(code, ERROR);
	}

	/**
	 * 插座
	 */
	private static final Map<String, String> SOCKET = new ConcurrentHashMap<>();

	static {

		SOCKET.put("", "开");
		SOCKET.put("", "关");

		// 指令名称
		SOCKET.put("", "开关");
	}

	/**
	 * 插座参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getSOCKETValue(final String code) {
		return SOCKET.getOrDefault(code, ERROR);
	}

	/**
	 * 净水器
	 */
	private static final Map<String, String> WATERPURIFIER = new ConcurrentHashMap<>();

	static {

		WATERPURIFIER.put("", "开");
		WATERPURIFIER.put("", "关");

		// 指令名称
		WATERPURIFIER.put("", "开关");
		WATERPURIFIER.put("", "冲洗");
	}

}
