package com.yys.lottery.core.domain;

import java.sql.Timestamp;

public class LotteryList {
    private Integer id;
    private String lotteryId;
    private Integer lotteryTypeId;
    private String lotteryName;
    private String lotteryGroup;
    private Timestamp dateTime;
    private String remarks;

    public LotteryList() {
    }

    public LotteryList(Integer id, String lotteryId, Integer lotteryTypeId, String lotteryName, String lotteryGroup, Timestamp dateTime, String remarks) {
        this.id = id;
        this.lotteryId = lotteryId;
        this.lotteryTypeId = lotteryTypeId;
        this.lotteryName = lotteryName;
        this.lotteryGroup = lotteryGroup;
        this.dateTime = dateTime;
        this.remarks = remarks;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(String lotteryId) {
        this.lotteryId = lotteryId;
    }

    public Integer getLotteryTypeId() {
        return lotteryTypeId;
    }

    public void setLotteryTypeId(Integer lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public String getLotteryGroup() {
        return lotteryGroup;
    }

    public void setLotteryGroup(String lotteryGroup) {
        this.lotteryGroup = lotteryGroup;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
