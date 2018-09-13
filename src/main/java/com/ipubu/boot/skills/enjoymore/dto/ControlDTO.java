package com.ipubu.boot.skills.enjoymore.dto;

/**
 * @ClassName ControlDTO
 * @Description
 * @Author jzy
 */
public class ControlDTO {

    private String time;// 系统毫秒时间
    private String random;// 随机数
    private String seq;// time+random
    private String type;//
    private String orignVolume;// （原始语音）
    private String cycle;
    private String action;
    private String object;
    private String timePoint;
    private String overTime;
    private String roomName;
    private String param;
    private String thirdAccount;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrignVolume() {
        return orignVolume;
    }

    public void setOrignVolume(String orignVolume) {
        this.orignVolume = orignVolume;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(String thirdAccount) {
        this.thirdAccount = thirdAccount;
    }

    @Override
    public String toString() {
        return "ControlDTO [orignVolume=" + orignVolume + ", cycle=" + cycle + ", action=" + action
                + ", object=" + object + ", timePoint=" + timePoint + ", overTime=" + overTime
                + ", roomName=" + roomName + ", param=" + param + ", thirdAccount=" + thirdAccount
                + "]";
    }
}
