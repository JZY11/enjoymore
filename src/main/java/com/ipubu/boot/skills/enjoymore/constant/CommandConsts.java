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

	/**
	 * 净水器参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getWATERPURIFIERValue(final String code) {
		return WATERPURIFIER.getOrDefault(code, ERROR);
	}

	/**
	 * 场景面板
	 */
	private static final Map<String, String> SCENEPANEL = new ConcurrentHashMap<>();

	static {

		SCENEPANEL.put("", "开");
		SCENEPANEL.put("", "关");
		SCENEPANEL.put("", "up");
		SCENEPANEL.put("", "down");

		// 指令名称
		SCENEPANEL.put("", "恢复默认");
		SCENEPANEL.put("", "场景控制");
		SCENEPANEL.put("", "场景设置");
	}

	/**
	 * 场景面板参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getSCENEPANELValue(final String code) {
		return SCENEPANEL.getOrDefault(code, ERROR);
	}

	/**
	 * 声光报警器
	 */
	private static final Map<String, String> AUD_AND_VIS_ALARM = new ConcurrentHashMap<>();

	static {

		AUD_AND_VIS_ALARM.put("", "开");
		AUD_AND_VIS_ALARM.put("", "正常");
		AUD_AND_VIS_ALARM.put("", "消除");

		// 指令名称
		AUD_AND_VIS_ALARM.put("", "开关");
		AUD_AND_VIS_ALARM.put("", "消除当前告警");
	}

	/**
	 * 声光报警器参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getAudAndVisAlarmValue(final String code) {
		return AUD_AND_VIS_ALARM.getOrDefault(code, ERROR);
	}

	/**
	 * 天翼网关
	 */
	private static final Map<String, String> PHYSICALGATEWAY = new ConcurrentHashMap<>();

	static {

		PHYSICALGATEWAY.put("", "开");
		PHYSICALGATEWAY.put("", "关");

		// 指令名称
		PHYSICALGATEWAY.put("", "设置当前LED 灯开启状态");
	}

	/**
	 * 天翼网关参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getPHYSICALGATEWAYValue(final String code) {
		return PHYSICALGATEWAY.getOrDefault(code, ERROR);
	}

	/**
	 * 智能路由器
	 */
	private static final Map<String, String> INTELLIGENTROUTER = new ConcurrentHashMap<>();

	static {

		INTELLIGENTROUTER.put("", "开");
		INTELLIGENTROUTER.put("", "关");

		// 指令名称
		INTELLIGENTROUTER.put("", "设置当前LED 灯开启状态");
	}

	/**
	 * 智能路由器参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELLIGENTROUTERValue(final String code) {
		return INTELLIGENTROUTER.getOrDefault(code, ERROR);
	}

	/**
	 * 扫地机器人
	 */
	private static final Map<String, String> FLOOR_MOPPING_ROBOT = new ConcurrentHashMap<>();

	static {

		FLOOR_MOPPING_ROBOT.put("", "工作中");
		FLOOR_MOPPING_ROBOT.put("", "待机");
		FLOOR_MOPPING_ROBOT.put("", "完成工作");
		FLOOR_MOPPING_ROBOT.put("", "回充中");
		FLOOR_MOPPING_ROBOT.put("", "充电中");
		FLOOR_MOPPING_ROBOT.put("", "充电完成");
		FLOOR_MOPPING_ROBOT.put("", "故障");
		FLOOR_MOPPING_ROBOT.put("", "电量不足");
		FLOOR_MOPPING_ROBOT.put("", "关");
		FLOOR_MOPPING_ROBOT.put("", "开");
		FLOOR_MOPPING_ROBOT.put("", "停");

		// 指令名称
		FLOOR_MOPPING_ROBOT.put("", "状态");
		FLOOR_MOPPING_ROBOT.put("", "开关");
	}

	/**
	 * 扫地机器人参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getFloorMoppingRobotValue(final String code) {
		return FLOOR_MOPPING_ROBOT.getOrDefault(code, ERROR);
	}

	/**
	 * 控制主机
	 */
	private static final Map<String, String> CONTROLHOST = new ConcurrentHashMap<>();

	static {

		CONTROLHOST.put("", "up");
		CONTROLHOST.put("", "down");
		CONTROLHOST.put("", "关");
		CONTROLHOST.put("", "开");

		// 指令名称
		CONTROLHOST.put("", "密钥");
		CONTROLHOST.put("", "动态加密方式");
		CONTROLHOST.put("", "开关");
		CONTROLHOST.put("", "红外码");
	}

	/**
	 * 控制主机参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getCONTROLHOSTValue(final String code) {
		return CONTROLHOST.getOrDefault(code, ERROR);
	}

	/**
	 * 摄像头
	 */
	private static final Map<String, String> CAMERA = new ConcurrentHashMap<>();

	static {

		CAMERA.put("", "up");
		CAMERA.put("", "down");
		CAMERA.put("", "关");
		CAMERA.put("", "开");

		// 指令名称
		CAMERA.put("", "移动侦测");
		CAMERA.put("", "纵向旋转角度");
		CAMERA.put("", "数据存储");
		CAMERA.put("", "录制视频开关");
		CAMERA.put("", "开关");
		CAMERA.put("", "横向旋转角度");
		CAMERA.put("", "缩放");
		CAMERA.put("", "报警");
	}

	/**
	 * 摄像头参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getCAMERAValue(final String code) {
		return CAMERA.getOrDefault(code, ERROR);
	}

	/**
	 * 智能开关
	 */
	private static final Map<String, String> INTELSWITCH = new ConcurrentHashMap<>();

	static {

		INTELSWITCH.put("", "关");
		INTELSWITCH.put("", "开");

		// 指令名称
		INTELSWITCH.put("", "开关1");
		INTELSWITCH.put("", "三路开关");
		INTELSWITCH.put("", "开关2");
		INTELSWITCH.put("", "开关5");
		INTELSWITCH.put("", "开关6");
		INTELSWITCH.put("", "开关3");
		INTELSWITCH.put("", "开关4");
	}

	/**
	 * 智能开关参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELSWITCHValue(final String code) {
		return INTELSWITCH.getOrDefault(code, ERROR);
	}

	/**
	 * 智能投影仪
	 */
	private static final Map<String, String> INTELPROJECTOR = new ConcurrentHashMap<>();

	static {

		INTELPROJECTOR.put("", "关");
		INTELPROJECTOR.put("", "开");
		INTELPROJECTOR.put("", "up");
		INTELPROJECTOR.put("", "down");
		INTELPROJECTOR.put("", "上");
		INTELPROJECTOR.put("", "下");
		INTELPROJECTOR.put("", "左");
		INTELPROJECTOR.put("", "右");
		INTELPROJECTOR.put("", "确定");
		INTELPROJECTOR.put("", "音量增");
		INTELPROJECTOR.put("", "音量减");
		INTELPROJECTOR.put("", "菜单");
		INTELPROJECTOR.put("", "首页");
		INTELPROJECTOR.put("", "返回");

		// 指令名称
		INTELPROJECTOR.put("", "操作");
		INTELPROJECTOR.put("", "片单");
		INTELPROJECTOR.put("", "开关");
	}

	/**
	 * 智能投影仪参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELPROJECTORValue(final String code) {
		return INTELPROJECTOR.getOrDefault(code, ERROR);
	}

	/**
	 * 智能插座（单口）
	 */
	private static final Map<String, String> SMARTSOCKET = new ConcurrentHashMap<>();

	static {

		SMARTSOCKET.put("", "关");
		SMARTSOCKET.put("", "开");

		// 指令名称
		SMARTSOCKET.put("", "开关");
	}

	/**
	 * 智能插座（单口）参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getSMARTSOCKETValue(final String code) {
		return SMARTSOCKET.getOrDefault(code, ERROR);
	}

	/**
	 * 智能插座（多口）
	 */
	private static final Map<String, String> SMARTSOCKETS = new ConcurrentHashMap<>();

	static {

		SMARTSOCKETS.put("", "关");
		SMARTSOCKETS.put("", "开");

		// 指令名称
		SMARTSOCKETS.put("", "USB开关2");
		SMARTSOCKETS.put("", "开关2");
		SMARTSOCKETS.put("", "USB开关3");
		SMARTSOCKETS.put("", "USB开关");
		SMARTSOCKETS.put("", "开关");
		SMARTSOCKETS.put("", "开关3");
		SMARTSOCKETS.put("", "开关4");
	}

	/**
	 * 智能插座（多口）参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getSMARTSOCKETSValue(final String code) {
		return SMARTSOCKETS.getOrDefault(code, ERROR);
	}

	/**
	 * 智能灯具
	 */
	private static final Map<String, String> INTELLIGHTS = new ConcurrentHashMap<>();

	static {

		INTELLIGHTS.put("", "关");
		INTELLIGHTS.put("", "开");
		INTELLIGHTS.put("", "up");
		INTELLIGHTS.put("", "down");
		INTELLIGHTS.put("", "挂机");

		// 指令名称
		INTELLIGHTS.put("", "亮度等级");
		INTELLIGHTS.put("", "绿色值");
		INTELLIGHTS.put("", "蓝色值");
		INTELLIGHTS.put("", "恢复默认");
		INTELLIGHTS.put("", "渐变延时");
		INTELLIGHTS.put("", "红色值");
		INTELLIGHTS.put("", "场景控制");
		INTELLIGHTS.put("", "开关");
		INTELLIGHTS.put("", "色温等级");
		INTELLIGHTS.put("", "场景设置");
	}

	/**
	 * 智能灯具参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELLIGHTSValue(final String code) {
		return INTELLIGHTS.getOrDefault(code, ERROR);
	}

	/**
	 * 智能窗帘
	 */
	private static final Map<String, String> INTELCURTAIN = new ConcurrentHashMap<>();

	static {

		INTELCURTAIN.put("", "关");
		INTELCURTAIN.put("", "开");
		INTELCURTAIN.put("", "up");
		INTELCURTAIN.put("", "down");
		INTELCURTAIN.put("", "停");

		// 指令名称
		INTELCURTAIN.put("", "开关2");
		INTELCURTAIN.put("", "程度");
		INTELCURTAIN.put("", "开关");
	}

	/**
	 * 智能窗帘参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELCURTAINValue(final String code) {
		return INTELCURTAIN.getOrDefault(code, ERROR);
	}

	/**
	 * 智能车载后视镜
	 */
	private static final Map<String, String> INTELVEHICLEREARVIEW = new ConcurrentHashMap<>();

	static {

		INTELVEHICLEREARVIEW.put("", "关");
		INTELVEHICLEREARVIEW.put("", "开");

		// 指令名称
		INTELVEHICLEREARVIEW.put("", "开启声控");
		INTELVEHICLEREARVIEW.put("", "开启音乐");
		INTELVEHICLEREARVIEW.put("", "开启导航");
	}

	/**
	 * 智能车载后视镜参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELVEHICLEREARVIEWValue(final String code) {
		return INTELVEHICLEREARVIEW.getOrDefault(code, ERROR);
	}

	/**
	 * 智能门锁
	 */
	private static final Map<String, String> INTELDOORLOCK = new ConcurrentHashMap<>();

	static {
		// [{"param":["不请求","请求"],"function":"app开锁随机数请求"},
		// {"param":["门开","门锁"],"function":"门锁状态"},
		// {"param":["up","down"],"function":"app开锁发送开锁密码"}]

		INTELDOORLOCK.put("", "不请求");
		INTELDOORLOCK.put("", "请求");
		INTELDOORLOCK.put("", "门开");
		INTELDOORLOCK.put("", "门锁");
		INTELDOORLOCK.put("", "up");
		INTELDOORLOCK.put("", "down");

		// 指令名称
		INTELDOORLOCK.put("", "app开锁随机数请求");
		INTELDOORLOCK.put("", "门锁状态");
		INTELDOORLOCK.put("", "app开锁发送开锁密码");
	}

	/**
	 * 智能门锁参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELDOORLOCKValue(final String code) {
		return INTELDOORLOCK.getOrDefault(code, ERROR);
	}

	/**
	 * 智能遥控器
	 */
	private static final Map<String, String> INTELREMOTE = new ConcurrentHashMap<>();

	static {

		INTELREMOTE.put("", "关");
		INTELREMOTE.put("", "开");
		INTELREMOTE.put("", "up");
		INTELREMOTE.put("", "down");

		// 指令名称
		INTELREMOTE.put("", "开关");
		INTELREMOTE.put("", "密钥");
		INTELREMOTE.put("", "动态加密方式");
		INTELREMOTE.put("", "红外码");
	}

	/**
	 * 智能遥控器参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELREMOTEVIEWValue(final String code) {
		return INTELREMOTE.getOrDefault(code, ERROR);
	}

	/**
	 * 空气净化器
	 */
	private static final Map<String, String> AIRCLEANER = new ConcurrentHashMap<>();

	static {

		AIRCLEANER.put("", "手动");
		AIRCLEANER.put("", "自动");
		AIRCLEANER.put("", "睡眠");
		AIRCLEANER.put("", "关");
		AIRCLEANER.put("", "开");
		AIRCLEANER.put("", "up");
		AIRCLEANER.put("", "down");
		AIRCLEANER.put("", "低速");
		AIRCLEANER.put("", "中速");
		AIRCLEANER.put("", "高速");

		// 指令名称
		AIRCLEANER.put("", "睡眠");
		AIRCLEANER.put("", "杀菌");
		AIRCLEANER.put("", "定时1");
		AIRCLEANER.put("", "风速");
		AIRCLEANER.put("", "无级1");
		AIRCLEANER.put("", "开关");
		AIRCLEANER.put("", "设置温度");
	}

	/**
	 * 空气净化器参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getAIRCLEANERValue(final String code) {
		return AIRCLEANER.getOrDefault(code, ERROR);
	}

	/**
	 * 红外感应器
	 */
	private static final Map<String, String> INFRAREDSENSOR = new ConcurrentHashMap<>();

	static {
		INFRAREDSENSOR.put("", "正常");
		INFRAREDSENSOR.put("", "消除");

		// 指令名称
		INFRAREDSENSOR.put("", "消除当前告警");
	}

	/**
	 * 红外感应器参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINFRAREDSENSORValue(final String code) {
		return INFRAREDSENSOR.getOrDefault(code, ERROR);
	}

	/**
	 * 门、窗磁
	 */
	private static final Map<String, String> DOORWINDOWMAGNETIC = new ConcurrentHashMap<>();

	static {
		DOORWINDOWMAGNETIC.put("", "正常");
		DOORWINDOWMAGNETIC.put("", "消除");
		DOORWINDOWMAGNETIC.put("", "开");
		DOORWINDOWMAGNETIC.put("", "关");

		// 指令名称
		DOORWINDOWMAGNETIC.put("", "探测器状态");
	}

	/**
	 * 门、窗磁参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getDOORWINDOWMAGNETICValue(final String code) {
		return DOORWINDOWMAGNETIC.getOrDefault(code, ERROR);
	}

	/**
	 * 智能音响
	 */
	private static final Map<String, String> INTELSOUND = new ConcurrentHashMap<>();

	static {

		INTELSOUND.put("", "不变");
		INTELSOUND.put("", "上一首");
		INTELSOUND.put("", "下一首");
		INTELSOUND.put("", "红色");
		INTELSOUND.put("", "绿色");
		INTELSOUND.put("", "蓝色");
		INTELSOUND.put("", "关闭");
		INTELSOUND.put("", "打开");
		INTELSOUND.put("", "关");
		INTELSOUND.put("", "开");
		INTELSOUND.put("", "up");
		INTELSOUND.put("", "down");

		// 指令名称
		INTELSOUND.put("", "音乐切换开关");
		INTELSOUND.put("", "呼吸灯颜色");
		INTELSOUND.put("", "音量增大");
		INTELSOUND.put("", "呼吸灯开关");
		INTELSOUND.put("", "开关");
		INTELSOUND.put("", "音乐播放");
		INTELSOUND.put("", "音量减小");
		INTELSOUND.put("", "小夜灯开关");
		INTELSOUND.put("", "音量大小(百分比)");
		INTELSOUND.put("", "识音开关");
		INTELSOUND.put("", "静音开关");
	}

	/**
	 * 智能音响参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELSOUNDValue(final String code) {
		return INTELSOUND.getOrDefault(code, ERROR);
	}

	/**
	 * 智能空调
	 */
	private static final Map<String, String> INTELAIR = new ConcurrentHashMap<>();

	static {

		INTELAIR.put("", "关");
		INTELAIR.put("", "开");
		INTELAIR.put("", "up");
		INTELAIR.put("", "down");
		INTELAIR.put("", "自动");
		INTELAIR.put("", "风向1");
		INTELAIR.put("", "风向2");
		INTELAIR.put("", "风向3");
		INTELAIR.put("", "低风");
		INTELAIR.put("", "中风");
		INTELAIR.put("", "高风");
		INTELAIR.put("", "制冷");
		INTELAIR.put("", "除湿");
		INTELAIR.put("", "送风");
		INTELAIR.put("", "制热");
		INTELAIR.put("", "开关");
		INTELAIR.put("", "模式");
		INTELAIR.put("", "温度");
		INTELAIR.put("", "风速");
		INTELAIR.put("", "风向");
		INTELAIR.put("", "其它");

		// 指令名称
		INTELAIR.put("", "温度");
		INTELAIR.put("", "风向");
		INTELAIR.put("", "风速");
		INTELAIR.put("", "模式");
		INTELAIR.put("", "开关");
		INTELAIR.put("", "按键");
	}

	/**
	 * 智能空调参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getINTELAIRValue(final String code) {
		return INTELAIR.getOrDefault(code, ERROR);
	}

	/**
	 * 智能电饭煲
	 */
	private static final Map<String, String> SMART_RICE_COOKER = new ConcurrentHashMap<>();

	static {

		SMART_RICE_COOKER.put("", "up");
		SMART_RICE_COOKER.put("", "down");
		SMART_RICE_COOKER.put("", "启动");
		SMART_RICE_COOKER.put("", "取消");
		SMART_RICE_COOKER.put("", "暂停");
		SMART_RICE_COOKER.put("", "高温");
		SMART_RICE_COOKER.put("", "低温");
		SMART_RICE_COOKER.put("", "无预约");
		SMART_RICE_COOKER.put("", "预约");
		SMART_RICE_COOKER.put("", "普通米");
		SMART_RICE_COOKER.put("", "糯米");
		SMART_RICE_COOKER.put("", "丝苗米");
		SMART_RICE_COOKER.put("", "珍珠米");
		SMART_RICE_COOKER.put("", "玄米");
		SMART_RICE_COOKER.put("", "东北米");
		SMART_RICE_COOKER.put("", "香米");
		SMART_RICE_COOKER.put("", "糙米");
		SMART_RICE_COOKER.put("", "糙米发芽");
		SMART_RICE_COOKER.put("", "长粒米");
		SMART_RICE_COOKER.put("", "短粒米");
		SMART_RICE_COOKER.put("", "标准");
		SMART_RICE_COOKER.put("", "偏软");
		SMART_RICE_COOKER.put("", "偏硬");
		SMART_RICE_COOKER.put("", "锅巴");
		SMART_RICE_COOKER.put("", "蒸");
		SMART_RICE_COOKER.put("", "煮");
		SMART_RICE_COOKER.put("", "焖");
		SMART_RICE_COOKER.put("", "炖");
		SMART_RICE_COOKER.put("", "待机");
		SMART_RICE_COOKER.put("", "保温");

		// 指令名称
		SMART_RICE_COOKER.put("", "焖饭时间");
		SMART_RICE_COOKER.put("", "操作");
		SMART_RICE_COOKER.put("", "温度模式");
		SMART_RICE_COOKER.put("", "菜单");
		SMART_RICE_COOKER.put("", "浸泡时间");
		SMART_RICE_COOKER.put("", "浸泡温度");
		SMART_RICE_COOKER.put("", "预约");
		SMART_RICE_COOKER.put("", "吸水时间");
		SMART_RICE_COOKER.put("", "制作时间");
		SMART_RICE_COOKER.put("", "保温时间");
		SMART_RICE_COOKER.put("", "米种");
		SMART_RICE_COOKER.put("", "口感");
		SMART_RICE_COOKER.put("", "模式选择");
	}

	/**
	 * 智能电饭煲参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getSmartRiceCookerValue(final String code) {
		return INTELLIGHTS.getOrDefault(code, ERROR);
	}

	/**
	 * 多路灯具
	 */
	private static final Map<String, String> DL_LIGHTS = new ConcurrentHashMap<>();

	static {

		DL_LIGHTS.put("", "up");
		DL_LIGHTS.put("", "down");
		DL_LIGHTS.put("", "开");
		DL_LIGHTS.put("", "关");
		DL_LIGHTS.put("", "挂机");

		// 指令名称
		DL_LIGHTS.put("", "红色值3");
		DL_LIGHTS.put("", "红色值2");
		DL_LIGHTS.put("", "红色值1");
		DL_LIGHTS.put("", "红色值4");
		DL_LIGHTS.put("", "开关3");
		DL_LIGHTS.put("", "开关4");
		DL_LIGHTS.put("", "亮度等级1");
		DL_LIGHTS.put("", "亮度等级3");
		DL_LIGHTS.put("", "亮度等级2");
		DL_LIGHTS.put("", "亮度等级4");
		DL_LIGHTS.put("", "渐变延时1");
		DL_LIGHTS.put("", "渐变延时2");
		DL_LIGHTS.put("", "渐变延时3");
		DL_LIGHTS.put("", "绿色值3");
		DL_LIGHTS.put("", "渐变延时4");
		DL_LIGHTS.put("", "绿色值4");
		DL_LIGHTS.put("", "绿色值1");
		DL_LIGHTS.put("", "绿色值2");
		DL_LIGHTS.put("", "开关1");
		DL_LIGHTS.put("", "开关2");
		DL_LIGHTS.put("", "蓝色值1");
		DL_LIGHTS.put("", "蓝色值2");
		DL_LIGHTS.put("", "蓝色值3");
		DL_LIGHTS.put("", "蓝色值4");
		DL_LIGHTS.put("", "色温等级4");
		DL_LIGHTS.put("", "色温等级3");
		DL_LIGHTS.put("", "色温等级2");
		DL_LIGHTS.put("", "色温等级1");
	}

	/**
	 * 多路灯具参数指令
	 * 
	 * @param code
	 * @return
	 */
	public static String getDLlightsValue(final String code) {
		return DL_LIGHTS.getOrDefault(code, ERROR);
	}

}
