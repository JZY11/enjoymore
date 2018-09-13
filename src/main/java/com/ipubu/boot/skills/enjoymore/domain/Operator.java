package com.ipubu.boot.skills.enjoymore.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Operator
 * @Description 操作指令
 * @Author jzy
 */
public class Operator implements Serializable {

    private static final long serialVersionUID = 131620963306816102L;

    private List<String> param;
    private String function;

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Operator [param=" + param + ", function=" + function + "]";
    }

}
