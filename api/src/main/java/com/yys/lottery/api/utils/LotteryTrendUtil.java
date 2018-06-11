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
     * 出现总次数
     * @return
     */
    public static Integer countOmitValue(List<Integer> list){
        Integer count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (i==list.get(i)){
                count ++;
            }
        }
        return  count;
    }

    /**
     * 最大遗漏值
     */
    public static Integer maxOmitValue(List<Integer> list){
        return  Collections.max(list);
    }

    /**
     *平均遗漏值
     */
    public static Integer averageOmitValue(List<Integer> list){
        Integer sum=0;
        if (list.size()>0){
            int total = 0;
//            boolean falg = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)<list.get(i-1)){
                    total += list.get(i-1);
//                    falg = true;
                }
            }
//            if (falg==true){
//                total += list.get(list.size()-1);
//            }
            sum = (int) Math.sqrt(total);
            System.out.println("total = "+total+",avg = "+sum);
//            sum = total/list.size();
        }
        return sum;
    }

}
