package com.hyperflex.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author chuntaojun
 */
public class BillSteps implements Serializable {

    private String oldAccessToken;
    private String newAccessToken;
    private String preStep;
    private String nowStep;
    private String aftStep;
    private List<String> billStepLists;
    private Integer after;

    public BillSteps() {
    }

    public BillSteps(String oldAccessToken, String newAccessToken) {
        this.oldAccessToken = oldAccessToken;
        this.newAccessToken = newAccessToken;
    }

    public String getOldAccessToken() {
        return oldAccessToken;
    }

    public void setOldAccessToken(String oldAccessToken) {
        this.oldAccessToken = oldAccessToken;
    }

    public String getNewAccessToken() {
        return newAccessToken;
    }

    public void setNewAccessToken(String newAccessToken) {
        this.newAccessToken = newAccessToken;
    }

    public String getPreStep() {
        return preStep;
    }

    public void setPreStep(String preStep) {
        this.preStep = preStep;
    }

    public String getNowStep() {
        return nowStep;
    }

    public void setNowStep(String nowStep) {
        this.nowStep = nowStep;
    }

    public String getAftStep() {
        return aftStep;
    }

    public void setAftStep(String aftStep) {
        this.aftStep = aftStep;
    }

    public List<String> getBillStepLists() {
        return billStepLists;
    }

    public void setBillStepLists(List<String> billStepLists) {
        this.billStepLists = billStepLists;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    @Override
    public String toString() {
        return "BillSteps{" +
                "oldAccessToken='" + oldAccessToken + '\'' +
                ", newAccessToken='" + newAccessToken + '\'' +
                ", preStep='" + preStep + '\'' +
                ", nowStep='" + nowStep + '\'' +
                ", aftStep='" + aftStep + '\'' +
                ", billStepLists=" + billStepLists +
                '}';
    }
}
