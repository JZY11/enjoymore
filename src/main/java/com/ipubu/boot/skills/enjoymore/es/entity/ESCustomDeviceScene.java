package com.ipubu.boot.skills.enjoymore.es.entity;

import java.io.Serializable;

public class ESCustomDeviceScene implements Serializable{
    private static final long serialVersionUID = -9125376545909382823L;

    /** 修改前设备名 */
    private String beforeModifyDeviceName;
    /** 修改后场景名称 */
    private String afterModifyDeviceName;
    /** 设备类型名称 */
    private String deviceTypeName;


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
}
