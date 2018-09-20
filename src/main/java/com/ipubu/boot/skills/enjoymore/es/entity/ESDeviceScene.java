package com.ipubu.boot.skills.enjoymore.es.entity;

import java.io.Serializable;
/**
 * @ClassName ESDeviceScene
 * @Description	
 * @Author jzy
 */
public class ESDeviceScene implements Serializable {
    private static final long serialVersionUID = -9126356745909382823L;

    /** 产品名称 */
    private String productName;
    /** 产品类型 */
    private String productType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
