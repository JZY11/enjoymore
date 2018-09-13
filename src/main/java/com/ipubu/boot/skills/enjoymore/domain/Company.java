package com.ipubu.boot.skills.enjoymore.domain;

import java.io.Serializable;

/**
 * @ClassName Company
 * @Description 
 * @Author jzy
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 2614981869760563110L;

    private String spType;
    private String spId;
    private String areaId;
    private String brandId;
    private String countroycode;

    public String getSpType() {
        return spType;
    }

    public void setSpType(String spType) {
        this.spType = spType;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCountroycode() {
        return countroycode;
    }

    public void setCountroycode(String countroycode) {
        this.countroycode = countroycode;
    }

}
