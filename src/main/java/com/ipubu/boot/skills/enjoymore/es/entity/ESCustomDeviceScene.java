package com.ipubu.boot.skills.enjoymore.es.entity;

import java.io.Serializable;

public class ESCustomDeviceScene implements Serializable{
    private static final long serialVersionUID = -9125376545909382823L;

    /** 修改前设备名 */
    private String beforeModifyDeviceName;
    /** 修改后场景名称 */
    private String afterModifyDeviceName;


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
}
