package com.ipubu.boot.skills.enjoymore.domain;

import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.DB_MF_ACCOUNT_INFO;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @ClassName AccountInfo
 * @Description
 * @Author jzy
 */

@Document(collection = DB_MF_ACCOUNT_INFO)
public class AccountInfo implements Serializable {

    private static final long serialVersionUID = -9125376545070672823L;

    private String _id;
    private String userId;
    private String platform;
    private List<String> scenes;// 场景列表
    private List<String> devices;// 设备列表



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<String> getScenes() {
        return scenes;
    }

    public void setScenes(List<String> scenes) {
        this.scenes = scenes;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }
}
