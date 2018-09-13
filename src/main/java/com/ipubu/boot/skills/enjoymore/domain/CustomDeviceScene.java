package com.ipubu.boot.skills.enjoymore.domain;

import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.DB_MF_CUSTOM_DEVICE_SCENE;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName CustomDeviceScene
 * @Description 用户自定义设备场景库
 * @Author jzy
 */
@Document(collection = DB_MF_CUSTOM_DEVICE_SCENE)
public class CustomDeviceScene implements Serializable {

    private static final long serialVersionUID = 5442742757047684687L;

    @Field("_id")
    private String id;
    /** LenovoId */
    private String userId;
    /** 账户 */
    private String thirdAccount;
    /** 修改前设备名 */
    private String beforeModifyDeviceName;
    /** 修改后场景名称 */
    private String afterModifyDeviceName;
    /** 设备类型名称 */
    private String deviceTypeName;
    /** 功能指令 */
    private List<Operator> action;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(String thirdAccount) {
        this.thirdAccount = thirdAccount;
    }

    public String getBeforeModifyDeviceName() {
        return beforeModifyDeviceName;
    }

    public void setBeforeModifyDeviceName(String beforeModifyDeviceName) {
        this.beforeModifyDeviceName = beforeModifyDeviceName;
    }

    public String getAfterModifyDeviceName() {
        return afterModifyDeviceName;
    }

    public void setAfterModifyDeviceName(String afterModifyDeviceName) {
        this.afterModifyDeviceName = afterModifyDeviceName;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public List<Operator> getAction() {
        return action;
    }

    public void setAction(List<Operator> action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "CustomDeviceScene [id=" + id + ", userId=" + userId + ", thirdAccount="
                + thirdAccount + ", beforeModifyDeviceName=" + beforeModifyDeviceName
                + ", afterModifyDeviceName=" + afterModifyDeviceName + ", deviceTypeName="
                + deviceTypeName + ", action=" + action + "]";
    }

}
