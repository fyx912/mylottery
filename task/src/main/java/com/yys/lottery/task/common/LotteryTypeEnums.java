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
    MARK_SIX("香港六合彩","xglhc"),

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
    HF_LFK3("二分快3","lfk3"),
    HF_AHK3("安徽快3","ahk3"),
    HF_GXK3("广西快3","gxk3"),
    HF_JSK3("江苏快3","jsk3"),
    HF_JLK3("吉林快3","jlk3"),

    HF_SHD11("上海11选5","shd11"),
    HF_SDD11("山东11选5","sdd11"),
    HF_JXD11("江西11选5","jxd11"),
    HF_GDD11("广东11选5","gdd11"),
    HF_AHD11("安徽11选5","ahd11"),
    HF_FJD11("福建11选5","fjd11"),

    HF_GDKL10F("广东快乐十分","gdkl10f"),
    HF_CQKL10F("重庆快乐十分","ffk3"),
    HF_SHSSL("上海时时乐","shssl"),
    HF_LFKLPK("幸运扑克","lfklpk"),
    HF_XYFT("幸运飞艇","xyft"),
    HF_XYSM("幸运赛马","xysm"),
    HF_JSMS("极速六合彩","jslhc"),


    //抓取数据的字段和本地字段对应
    CQSSC("HF_CQSSC","cqssc"),
    FFSSC("HF_FFSSC","ffssc"),
    XJSSC("HF_XJSSC","xjssc"),
    TJSSC("HF_TJSSC","tjssc"),
    LFSSC("HF_LFSSC","lfssc"),
    BJPK10("HF_BJPK10","bjpk10"),
    FFPK10("HF_FFPK10","ffpk10"),
    LFPK10("HF_LFPK10","lfpk10"),
    LK28("HF_LF28","lk28"),
    BJ28("HF_BJ28","bj28"),
    BJK3("HF_BJK3","bjk3"),
    FFK3("HF_FFK3","ffk3"),
    LFK3("HF_LFK3","lfk3"),
    AHK3("HF_AHK3","ahk3"),
    GXK3("HF_GXK3","gxk3"),
    JSK3("HF_JSK3","jsk3"),
    JLK3("HF_JLK3","jlk3"),

    SHD11("HF_SHD11","shd11"),
    SDD11("HF_SDD11","sdd11"),
    JXD11("HF_JXD11","jxd11"),
    GDD11("HF_GDD11","gdd11"),
    AHD11("HF_AHD11","ahd11"),
    FJD11("HF_FJD11","fjd11"),

    GDKL10F("HF_GDKL10F","gdkl10f"),//广东快乐十分
    CQKL10F("HF_CQKL10F","cqkl10f"),//重庆快乐十分
    SHSSL("HF_SHSSL","shssl"),//上海时时乐
    LFKLPK("HF_LFKLPK","lfklpk"),//幸运扑克
    XYFT("HF_XYFT","xyft"),//幸运飞艇
    XYSM("HF_XYSM","xysm"),//幸运赛马
    JSMS("HF_JSMS","jslhc")//极速六合彩
    ;

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
