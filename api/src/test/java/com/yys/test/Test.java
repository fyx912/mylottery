package com.yys.test;


import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.api.LotteryApiMain;
import com.yys.lottery.api.service.LotteryHFApiService;
import com.yys.lottery.api.utils.LotteryTrendUtil;
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
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LotteryApiMain.class)
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
    public void getLotterList(){
       List<LotteryList> lists =  lotteryListService.getAll();
       System.out.println("lottery list :" + JSONObject.toJSON(lists));
    }

    @org.junit.Test
    public void getLotteryHFAll(){
       List<LotteryHF>  hfList= hfService.findAll("bjpk10");
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
        System.out.println(JSONObject.toJSON(maxList));
//        System.out.println("result = "+ JSONObject.toJSON(maxList));
    }

    public Integer maxOmitValue(List list){
        LotteryTrendUtil.maxOmitValue(list);
        return   LotteryTrendUtil.maxOmitValue(list);
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
        String resultNum = "1,9,2,7,8";
        String result = resultNum.substring(0,1);
        System.out.println(result);
        System.out.println(resultNum.substring(2,3)+"\t"+resultNum.substring(8,9));

        String pk = "02,03,06,09,01,07,08,05,04,10";
        System.out.println(pk.substring(0,2)+"\t"+pk.substring(3,5));
        String[] pks = pk.split(",");
        System.out.println(JSONObject.toJSON(pks));
        int[]  values = new Test().getInitOmitData(5);
        System.out.println(JSONObject.toJSON(values));

        Integer[] res = {1,1,1,1,1,1,1,1,1,9};
        Integer[] data = {5,8,4,9,3};
        int sum = 5;
        List<Integer[]> list = new ArrayList<>();
        list.add(res);
        Integer[] resultValues = null;
        for (int i = 0; i <5 ; i++) {
            resultValues =  new Integer[10];
            Integer[] value = list.get(i);
            for (int j = 0; j <10 ; j++) {
                if (j==data[i]){
                    resultValues[j]=data[i];
                }else {
                    int k = 0;
                    if (j>0){
                        k = j-1;
                    }
                    if (value[k]==j){
                        resultValues[j] = 1;
                    }else {
                        resultValues[j] = value[j]++;
                    }
                }
            }
           list.add(resultValues);
        }

        System.out.println(JSONObject.toJSON(list));
    }

}
