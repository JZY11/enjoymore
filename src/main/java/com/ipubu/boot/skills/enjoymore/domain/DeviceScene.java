package com.ipubu.boot.skills.enjoymore.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.DB_MF_DEVICE_SCENE;

/**
 * @ClassName DeviceScene
 * @Description 设备场景库
 * @Author jzy
 */
@Document(collection = DB_MF_DEVICE_SCENE)
public class DeviceScene implements Serializable {

    private static final long serialVersionUID = 5442742757047684687L;

    @Field("_id")
    private String id;

    /** 产品名称 */
    private String productName;
    /** 产品类型 */
    private String productType;
    /** 功能指令 */
    private List<Operator> action;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Operator> getAction() {
        return action;
    }

    public void setAction(List<Operator> action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "DeviceScene [productName=" + productName + ", productType=" + productType
                + ", action=" + action + "]";
    }


}
