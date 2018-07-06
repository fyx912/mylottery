package com.yys.lottery.core.common;

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
    HF_XJSSC("新疆时时彩","xjssc"),
    HF_TJSSC("天津时时彩","tjssc"),
    HF_LFSSC("二分时时彩","lfssc"),
    HF_BJPK10("北京PK拾","bjpk10"),
    HF_FFPK10("分分PK拾","ffpk10"),
    HF_LFPK10("二分PK拾","lfpk10"),
    HF_LK28("幸运28","lk28"),
    HF_BJ28("北京28","bj28"),
    HF_BJK3("北京快3","bjk3"),
    HF_FFK3("分分快3","ffk3"),
    HF_LFK3("二分快3","lfk3");


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
            if (enums.getDescr().equalsIgnoreCase(descr)){
                return enums;
            }
        }
        return null;
    }

    public static  LotteryTypeEnums  getByDescr(String name){
        LotteryTypeEnums[] array = LotteryTypeEnums.values();
        for (LotteryTypeEnums enums :array){
            if (enums.getName().equalsIgnoreCase(name)){
                return enums;
            }
        }
        return null;
    }

    public static boolean exists(String name){
        LotteryTypeEnums[] array = LotteryTypeEnums.values();
        name = name.toUpperCase();
        for (LotteryTypeEnums enums :array){
            if (enums.getName().endsWith(name)){
                return true;
            }
        }
        return false;
    }
}
