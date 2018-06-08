package com.yys.lottery.api.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTrendUtil {

    /**
     * 最大连续值
     */
    public static Integer maxContinuousValue(List<Integer> list){
        Integer sum=1;
        if (list.size()>0){
            Integer continousValue=1;
            List<Integer> sumList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i)+1==list.get(i+1)){
                    continousValue ++;
                }
                sumList.add(continousValue);
            }
            if (sumList.size()>0){
                sum = Collections.max(sumList);
            }
        }else {
            sum =0;
        }
        return sum;
    }


    /**
     * 最大遗漏值
     */
    public static Integer maxOmitValue(List<Integer> list){
        Integer sum=0;
        if (list.size()>0){
            List<Integer> sumList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                sumList.add(list.get(i+1)-list.get(i));
            }
            if(sumList.size()>0)
                sum = Collections.max(sumList);
        }
        return sum;
    }


    /**
     *平均遗漏值
     */
    public static Integer averageOmitValue(List<Integer> list){
        Integer sum=0;
        if (list.size()>0){
            int total = 0;
            List<Integer> sumList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                total += list.get(i+1)-list.get(i);

            }
            sum = total/list.size();
        }
        return sum;
    }

}
