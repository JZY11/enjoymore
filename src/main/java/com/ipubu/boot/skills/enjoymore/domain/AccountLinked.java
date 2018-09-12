package com.ipubu.boot.skills.enjoymore.domain;

import static com.ipubu.boot.skills.enjoymore.constant.GlobalConsts.DB_MF_ACCOUNT_LINKED;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName AccountLinked
 * @Description  账户关联信息表
 * @Author jzy
 */
@Document(collection = DB_MF_ACCOUNT_LINKED)
public class AccountLinked implements Serializable {

    private static final long serialVersionUID = 5182921720734708073L;
    @Field("_id")
    private String id;
    private String userId;
    private String username;
    private String password;

    public AccountLinked(String userId, String username, String password) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountLinked [id=" + id + ", userId=" + userId + ", username=" + username
                + ", password=" + password + "]";
    }

}
