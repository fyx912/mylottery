package com.yys.lottery.task.common;

public enum LotteryTypeEnums {
    SSQ("双色球", "ssq"),
    // <br>
    DLT("超级大乐透", "dlt"),
    // <br>
    QLC("七乐彩", "qlc"),
    // <br>
    FCSD("福彩3D", "fcsd"),
    // <br>
    QXC("七星彩", "qxc"),
    // <br>
    PLS("排列三", "pls"),
    // <br>
    PLW("排列五", "plw"),

    /**
     * 高频彩票类型
     */
    HF_CQSSC("重庆时时彩","cqssc"),
    HF_FFSSC("分分时时彩","ffssc"),
    HF_BJPK10("北京PK拾","bjpk10"),
    HF_FFPK10("分分PK拾","ffpk10"),
    HF_LK28("幸运28","lk28"),
    HF_BJ28("北京28","bj28"),
    HF_BJK3("北京快3","bjk3"),
    HF_FFK3("分分快3","ffk3"),
    HF_LFK3("二分快3","lfk3"),

    //抓取数据的字段和本地字段对应
    CQSSC("HF_CQSSC","cqssc"),
    FFSSC("HF_FFSSC","ffssc"),
    BJPK10("HF_BJPK10","bjpk10"),
    FFPK10("HF_FFPK10","ffpk10"),
    LK28("HF_LF28","lk28"),
    BJ28("HF_BJ28","bj28"),
    BJK3("HF_BJK3","bjk3"),
    FFK3("HF_FFK3","ffk3"),
    LFK3("HF_LFK3","lfk3");

    private String descr;
    private String name;

    LotteryTypeEnums(String descr, String name) {
        this.descr = descr;
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static  LotteryTypeEnums  getByName(String descr){
        LotteryTypeEnums[] array = LotteryTypeEnums.values();
        for (LotteryTypeEnums enums :array){
            if (enums.getDescr()==descr){
                return enums;
            }
        }
        return null;
    }
}
