package com.ipubu.boot.skills.enjoymore.domain;

import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.DB_MF_ACCOUNT_SCENE;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName AccountScene
 * @Description  账户场景
 * @Author jzy
 */
@Document(collection = DB_MF_ACCOUNT_SCENE)
public class AccountScene implements Serializable {

    private static final long serialVersionUID = -9125376545070672823L;

    @Field("_id")
    private String id;
    /** LenovoId */
    private String userId;
    /** 账户 */
    private String thirdAccount;
    /** 场景名称 */
    private String sceneName;
    /** 修改后场景名称 */
    private String afterModifysceneName;
    /** 操作类型 1 新增 2 修改 3 删除 */
    private String operType;

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

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }


    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getAfterModifysceneName() {
        return afterModifysceneName;
    }

    public void setAfterModifysceneName(String afterModifysceneName) {
        this.afterModifysceneName = afterModifysceneName;
    }

    @Override
    public String toString() {
        return "AccountScene{" + "id='" + id + '\'' + ", userId='" + userId + '\''
                + ", thirdAccount='" + thirdAccount + '\'' + ", sceneName='" + sceneName + '\''
                + ", afterModifysceneName='" + afterModifysceneName + '\'' + ", operType='"
                + operType + '\'' + '}';
    }
}
