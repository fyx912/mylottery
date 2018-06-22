package com.yys.lottery.core.domain;

public class LotteryHF {
    private Integer id;
    private Integer planNo;
    private String lotteryType;
    private String lotteryName;
    private String lotteryNo;
    private String resultNum;
    private String sum;
    private String bullfight;
    private String officialOpenTime;
    private String nextOfficialOpenTime;
    private String stopOrderTime;

    private String type;
    private Integer[] result;
    private String waveColor; //波色
    private String remark;

    public LotteryHF() {
    }


    public LotteryHF(Integer id, Integer planNo, String lotteryType, String lotteryName, String lotteryNo, String resultNum, String sum, String bullfight, String officialOpenTime, String nextOfficialOpenTime, String stopOrderTime, Integer[] result) {
        this.id = id;
        this.planNo = planNo;
        this.lotteryType = lotteryType;
        this.lotteryName = lotteryName;
        this.lotteryNo = lotteryNo;
        this.resultNum = resultNum;
        this.sum = sum;
        this.bullfight = bullfight;
        this.officialOpenTime = officialOpenTime;
        this.nextOfficialOpenTime = nextOfficialOpenTime;
        this.stopOrderTime = stopOrderTime;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLotteryNo() {
        return lotteryNo;
    }

    public void setLotteryNo(String lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

    public String getResultNum() {
        return resultNum;
    }

    public void setResultNum(String resultNum) {
        this.resultNum = resultNum;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getBullfight() {
        return bullfight;
    }

    public void setBullfight(String bullfight) {
        this.bullfight = bullfight;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getOfficialOpenTime() {
        return officialOpenTime;
    }

    public void setOfficialOpenTime(String officialOpenTime) {
        this.officialOpenTime = officialOpenTime;
    }

    public String getNextOfficialOpenTime() {
        return nextOfficialOpenTime;
    }

    public void setNextOfficialOpenTime(String nextOfficialOpenTime) {
        this.nextOfficialOpenTime = nextOfficialOpenTime;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getStopOrderTime() {
        return stopOrderTime;
    }

    public void setStopOrderTime(String stopOrderTime) {
        this.stopOrderTime = stopOrderTime;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public Integer[] getResult() {
        return result;
    }

    public void setResult(Integer[] result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWaveColor() {
        return waveColor;
    }

    public void setWaveColor(String waveColor) {
        this.waveColor = waveColor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
