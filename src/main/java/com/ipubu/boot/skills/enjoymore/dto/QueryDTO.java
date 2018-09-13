package com.ipubu.boot.skills.enjoymore.dto;

import static com.ipubu.boot.skills.base.util.ParamChecker.isInvalidPara;
import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.APPID;
import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.APPKEY;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_APPID;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_TIME;
import static com.ipubu.boot.skills.enjoymore.constant.ReqConsts.P_USER_NAME;
//import static com.lenovo.cui.skills.morefun.constant.ReqConsts.P_PWORD;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ipubu.boot.skills.base.exception.SmartHomeException;

/**
 * @ClassName QueryDTO
 * @Description
 * @Author jzy
 */
public class QueryDTO {

    private String uri = ""; // 请求地址
    private Map<String, String> paramsMap = new HashMap<>(); // 参数集合
    private String appId = APPID; // 必须要有
    private String appKey = APPKEY; // 必须要有
    private String sn; // 必须要有
    private String userId; // 用户ID
    private String userName; // 用户名
    private String password; // 密码
    private String deviceId; // 设备唯一标识
    private String uid; // 设备唯一标识


    public QueryDTO build() throws SmartHomeException {

        if (isInvalidPara(userName) || isInvalidPara(password)) {
            throw new SmartHomeException("param userName is null or password is null. userName="
                    + userName + ",password =" + password);
        }

        try {
            paramsMap.put(P_APPID, APPID); // 【一定要有】
            paramsMap.put(P_TIME, String.valueOf(System.currentTimeMillis())); // 【一定要有】
            String randomsn = UUID.randomUUID().toString().replaceAll("-", "");
            paramsMap.put("sn", randomsn); // 【一定要有】

            paramsMap.put(P_USER_NAME, getUserName()); // 【一定要有】
//            paramsMap.put(P_PWORD, getPassword()); // 【一定要有】

        } catch (Exception e) {
            throw new SmartHomeException("build query params exception ," + e.getMessage());
        }

        return this;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
