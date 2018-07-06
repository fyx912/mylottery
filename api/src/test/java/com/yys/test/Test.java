package com.yys.test;


import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.api.ApiMain;
import com.yys.lottery.api.domain.LotteryTrend;
import com.yys.lottery.api.service.LotteryHFApiService;
import com.yys.lottery.api.utils.LotteryTrendUtil;
import com.yys.lottery.core.common.LotteryTypeEnums;
import com.yys.lottery.core.domain.LotteryHF;
import com.yys.lottery.core.domain.LotteryList;
import com.yys.lottery.core.services.LotteryHFService;
import com.yys.lottery.core.services.LotteryHFTrendService;
import com.yys.lottery.core.services.LotteryListService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiMain.class)
public class Test {

    @Autowired
    private LotteryListService lotteryListService;

    @Autowired
    private LotteryHFService hfService;

    @Autowired
    private LotteryHFTrendService trendService;

    @Autowired
    private LotteryHFApiService hfApiService;

    @org.junit.Test
    public void getLotteryList(){
       List<LotteryList> lists =  lotteryListService.getAll();
       System.out.println("lottery list :" + JSONObject.toJSON(lists));
    }

    @org.junit.Test
    public void getLotteryHFAll(){
       List<LotteryHF>  hfList= hfService.findAll("bjpk10",0,10);
        System.out.println("lottery list :" + JSONObject.toJSON(hfList));
    }

    @org.junit.Test
    public void findHistoryLotteryNoAndResultData(){
        String lotteryType = "cqssc";
        List<LotteryHF>  hfList= hfService.findHistoryLotteryNoAndResultData(lotteryType,0,30);
        System.out.println("lottery hf :" + JSONObject.toJSON(hfList));
    }

    @org.junit.Test
    public void getTrend(){
        String lotteryType = "cqssc";
        List<LotteryHF>  hfList = trendService.getTrendData(lotteryType,0,30);
        System.out.println("lottery trend :" + JSONObject.toJSON(hfList));
    }

    @org.junit.Test
    public void getAPiTrendData(){
        String lotteryType = "cqssc";
        List<LotteryHF>  hfList = hfApiService.lotteryTrendData(lotteryType,0,0,30);
        System.out.println("lottery trend :" + JSONObject.toJSON(hfList));
        List<Integer> maxList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            Integer[] resultArray = new Integer[10];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <  hfList.size(); i++) {
                Integer[] result = hfList.get(i).getResult();
//                resultArray[j] = result;
                list.add(result[j]);
            }
            System.out.println(JSONObject.toJSON(list));
            Integer omitValue = LotteryTrendUtil.maxOmitValue(list);
            maxList.add(omitValue);
        }
        System.out.println("max =="+JSONObject.toJSON(maxList));
//        System.out.println("result = "+ JSONObject.toJSON(maxList));
    }

    @org.junit.Test
    public void lotteryTrendView(){
        String lotteryType = "cqssc";
        LotteryTrend trend = hfApiService.lotteryBaseTrend(lotteryType,0,0,10);
        System.out.println(JSONObject.toJSON(trend));
       List<LotteryHF> hfList = trend.getLotteryHF();
        for (LotteryHF hf:hfList) {
            System.out.println(JSONObject.toJSON(hf.getResult()));
        }
    }

    public static Integer maxOmitValue(List<Integer> list){
        Integer sum=0;
        if (list.size()>0){
            List<Integer> sumList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                sumList.add(list.get(i+1)-list.get(i));
            }
            System.out.println(JSONObject.toJSON(sumList));
            if(sumList.size()>0)
                sum = Collections.max(sumList);
        }
        return sum;
    }


    public int[] getInitOmitData(int data){
        int[] sum= new int[10];
        for (int i = 0; i <10 ; i++) {
            if (i == data){
                sum[i] = data;
            }else {
                sum[i] = 1;
            }
        }
        return sum;
    }

    public static  void main (String[] args){
        String type = "cqssc";
        System.out.println(LotteryTypeEnums.getByDescr(type));
        System.out.println(LotteryTypeEnums.getByDescr(type).getName());
        System.out.println(LotteryTypeEnums.getByDescr(type).getDescr());
        String resultNum = "1,9,2,7,8";
        String result = resultNum.substring(0,1);
        System.out.println(result);
        System.out.println(resultNum.substring(2,3)+"\t"+resultNum.substring(8,9));

       System.out.println(Math.sqrt(25));
       System.out.println(Math.round(4.47213595499958));

       System.out.println("wave color :"+LotteryTrendUtil.waveColor(21));
        System.out.println("wave color :"+LotteryTrendUtil.bigMinSingleDouble(21));
    }

}
