package com.ipubu.boot.skills.enjoymore.es.entity;

import java.io.Serializable;
/**
 * @ClassName ESCustomName
 * @Description	
 * @Author jzy
 */
public class ESCustomName implements Serializable{

    private static final long serialVersionUID = -9125376548739072823L;

    /**Lenovo id*/
    private String userId;
    /**对应的类型*/
    private String category;
    /**原始名称*/
    private String originalName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
}
