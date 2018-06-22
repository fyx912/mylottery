package com.yys.lottery.api.utils;

import com.yys.lottery.core.common.LotteryTypeEnums;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ding
 * @Date 2018-06-12
 * @desccibe 彩票视图开奖结果计算类
 */
public class LotteryTrendUtil {

    /**
     * @describe 最大连续值
     * @Param sumList 每一次的开奖结果
     * @Param list 需要计算的遗漏值集合列
     * @return Integer sum 计算的结果
     */
    public static Integer maxContinuousValue(List<Integer> sumList,List<Integer> list){
        Integer sum=0;
        if (list.size()>0&&sumList.size()>0){
            for (int i = 0; i <sumList.size() ; i++) {
                if (sum==0&&sumList.get(i)!=i){
                    sum =1;
                    break;
                }
            }
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i)==list.get(i+1)){
                    if (sumList.get(i)==sumList.get(i+1)){
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * @describe 出现总次数
     * @param sumList 开奖的结果集合
     * @param index 开奖结果的索引
     * @return
     */
    public static Integer countOmitValue(List<Integer> sumList,int index){
        Integer count = 0;
        if (sumList!=null){
            for (int i = 0; i < sumList.size(); i++) {
                if (sumList.get(i)==index){
                    count ++;
                }
            }
        }
        return  count;
    }

    /**
     * @describe 最大遗漏值
     * @param list 遗漏值的集合
     */
    public static Integer maxOmitValue(List<Integer> list){
        return  Collections.max(list);
    }

    /**
     * @describe 平均遗漏值:lastValue判断最后一位是否开奖结果
     * @param lastValue 最后的开奖结果
     * @param list  遗漏值的集合列
     */
    public static Integer averageOmitValue(Integer lastValue,List<Integer> list){
        Integer sum=0;
        if (list.size()>0){
            int total = 0;
            boolean falg = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)<list.get(i-1)){
                    total += list.get(i-1);
                       falg = true;
                }
            }
            if (falg==true){
                if (lastValue!=null){
                    total += list.get(list.size()-1);
                }
            }
            sum = (int) Math.sqrt(total);
        }
        return sum;
    }

    /**
     * @describe 不同彩票的遗漏值列不同
     * @return
     */
    public static int lotteryOmitSize(String lotteryType){
        int size = 0;
       if (lotteryType.equalsIgnoreCase(LotteryTypeEnums.HF_CQSSC.getName())||
               lotteryType.equalsIgnoreCase(LotteryTypeEnums.HF_FFSSC.getName())){
            size = 9;
       } else if (lotteryType.equalsIgnoreCase(LotteryTypeEnums.HF_BJPK10.getName())||
                lotteryType.equalsIgnoreCase(LotteryTypeEnums.HF_FFPK10.getName())){
            size = 10;
       }else{
            size = 9;
        }
       return size;
    }

    /**
     * @describe 视图开始列
     * @param type 彩票的类型
     * @return
     */
    public static int lotteryStartRank(String type){
        int startRank = 0;
        if (type.equalsIgnoreCase(LotteryTypeEnums.HF_BJPK10.getName())||
                type.equalsIgnoreCase(LotteryTypeEnums.HF_FFPK10.getName())){
            startRank = 1;
        }
        return startRank;
    }

    /**
     * @describe 波色,(主要分为红,蓝,绿,无)
     * @remark
     * 绿波：1，4，7，10，16，19，22，25;
     * 蓝波：2，5，8，11，17，20，23，26;
     * 红波：3，6，9，12，15，18，21，24;
     * 0,13,14,27不属于任何波色
     * @param sum 计算的值
     * @return
     */
    public static String waveColor(int sum){
        String waveColor = null;
        Integer[] noArray = new Integer[]{0,13,14,27};
        Integer[]  greenArray = new Integer[]{1,4,7,10,16,19,22,25};
        Integer[] blueArray = new Integer[]{2,5,8,11,17,20,23,26};
        Integer[] redArray = new Integer[]{3,6,9,12,15,18,21,24};

        if (ArrayUtils.contains(noArray,sum)){
            waveColor = "无";
        }else if(ArrayUtils.contains(greenArray,sum)){
            waveColor = "绿";
        }else if(ArrayUtils.contains(blueArray,sum)){
            waveColor = "蓝";
        }else if(ArrayUtils.contains(redArray,sum)){
            waveColor = "红";
        }
        return  waveColor;
    }

    /**
     * @describe 计算大小单双
     * @remark  大：14～27；小：0～13；单：奇数；双：偶数；
     * @param sum
     * @return
     */
    public static String  bigMinSingleDouble(int sum){
        String param = null;
        if (0<sum&&sum<=13){
            param = "小";
        }else {
            param = "大";
        }
        if (sum%2==0){
            param += "双";
        }else {
            param += "单";
        }
        return  param;
    }


}
