package com.ipubu.boot.skills.enjoymore.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName FKeyConsts
 * @Description	 
 * @Author jzy
 */
public class FKeyConsts {

	private FKeyConsts() {

	}

	public static final Map<String, String> FAN = new ConcurrentHashMap<>();

	static {

		FAN.put("打开", "power");
		FAN.put("关闭", "power");
		FAN.put("左右摆风", "swing");
		FAN.put("+", "fan_speed");
		FAN.put("-", "fan_speed");
	}

	public static final Map<String, String> TV = new ConcurrentHashMap<>();

	static {

		TV.put("打开", "power");
		TV.put("关闭", "power");
		TV.put("左右摆风", "swing");
		TV.put("频道-", "channel_up");
		TV.put("频道+", "channel_down");
		TV.put("返回", "back");
		TV.put("主页", "homepage");
		TV.put("音量+", "volume_up");
		TV.put("音量-", "volume_down");
		TV.put("打开音量", "mute");
		TV.put("关闭音量", "mute");
		TV.put("菜单", "menu");
		TV.put("方向上", "navigate_up");
		TV.put("方向下", "navigate_down");
		TV.put("方向左", "navigate_left");
		TV.put("方向右", "navigate_right");
		TV.put("确认", "ok");
		TV.put("退出", "exit");
		TV.put("tv", "tv");
		TV.put("av", "av");
		TV.put("待机待机", "sleep");
		TV.put("待机睡眠", "sleep");
		TV.put("点播", "sleep");
		TV.put("翻页-", "previous");
		TV.put("翻页+", "next");
		TV.put("播放快退", "rewind");
		TV.put("播放快进", "fast_forward");
		TV.put("播放播放", "play");
		TV.put("播放暂停", "pause");
		TV.put("屏显", "display");
		TV.put("信息", "display");
	}

	public static final Map<String, String> SOCKET = new ConcurrentHashMap<>();

	static {

		SOCKET.put("打开", "on");
		SOCKET.put("关闭", "off");
	}

	public static final Map<String, String> AIR = new ConcurrentHashMap<>();

	static {
		// 开关
		AIR.put("打开", "0");
		AIR.put("关闭", "1");
		// 模式
		AIR.put("除湿", "4");
		AIR.put("送风", "3");
		AIR.put("自动", "2");
		AIR.put("制热", "1");
		AIR.put("制冷", "0");
		// 温度
		AIR.put("+", "1");
		AIR.put("-", "-1");
		// 风量
		AIR.put("风量自动", "0");
		AIR.put("风量低", "1");
		AIR.put("风量中", "2");
		AIR.put("风量高", "3");
		// 风向

		// 按键Id
		AIR.put("电源", "1");
		AIR.put("模式", "2");
		AIR.put("温度-", "3");
		AIR.put("温度+", "4");
		AIR.put("风量", "5");
		AIR.put("扫风", "6");
		AIR.put("固定风", "7");
	}

}
