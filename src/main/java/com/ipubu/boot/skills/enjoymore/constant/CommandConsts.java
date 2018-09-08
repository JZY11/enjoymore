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

}
