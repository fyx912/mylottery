package com.yys.lottery.api.service;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.api.domain.LotteryTrend;
import com.yys.lottery.api.utils.LotteryTrendUtil;
import com.yys.lottery.core.common.LotteryTypeEnums;
import com.yys.lottery.core.domain.LotteryHF;
import com.yys.lottery.core.services.LotteryHFTrendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryHFApiService {
    @Autowired
    private LotteryHFTrendService trendService;

    /**
     * 计算遗漏数据
     * @param lotteryType
     * @param index
     * @param page
     * @param pageSize
     * @return
     */
    public List<LotteryHF> lotteryTrendData(String lotteryType,int index,int page,int pageSize){
      List<LotteryHF>  hfList = trendService.getTrendData(lotteryType,page,pageSize);
      List<LotteryHF>  trendList = trendDataDispose(lotteryType,index,hfList);
      return trendList;
    }

    public LotteryTrend  lotteryBaseTrend(String lotteryType,int index,int page,int pageSize){
        List<LotteryHF> hfList = lotteryTrendData(lotteryType,index,page,pageSize);
        List<Integer> maxList = new ArrayList<>();
        List<Integer> avgList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        List<Integer> maxContinuousList = new ArrayList<>();
        LotteryTrend trend = new LotteryTrend();
        int resultSize = 10;
        for (int j = 0; j < resultSize; j++) {
            Integer[] resultArray = new Integer[resultSize];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <  hfList.size(); i++) {
                Integer[] result = hfList.get(i).getResult();
                list.add(result[j]);
            }
            System.out.println(JSONObject.toJSON(list));
            Integer omitValue = LotteryTrendUtil.maxOmitValue(list);
            maxList.add(omitValue);
            Integer avgValue = LotteryTrendUtil.averageOmitValue(list);
            avgList.add(avgValue);
            Integer countValue = LotteryTrendUtil.averageOmitValue(list);
            countList.add(countValue);
            Integer  maxContinuousValue = LotteryTrendUtil.averageOmitValue(list);
            maxContinuousList.add(maxContinuousValue);
        }
        trend.setLotteryHF(hfList);
        trend.setMaxOmit(maxList);
        trend.setAvgOmit(avgList);
        trend.setCountOmit(countList);
        trend.setMaxContinuous(maxContinuousList);
        return trend;
    }

    /**
     * 处理之后的数据
     * @param lotteryType
     * @param index
     * @param hfList
     * @return
     */
    public List<LotteryHF>  trendDataDispose(String lotteryType,int index,List<LotteryHF>  hfList){
        if (hfList!=null){
            LotteryHF hfLottery = null;
            List<LotteryHF> resultList = new ArrayList<>();
            for (int i = 0; i <hfList.size() ; i++) {
                hfLottery = new LotteryHF();
                hfLottery.setLotteryNo(hfList.get(i).getLotteryNo());
//                String subStringNum = subStringNum(lotteryType,index,hfList.get(i).getResultNum());
//                hfLottery.setResultNum(subStringNum);
                String num = hfList.get(i).getResultNum();
                hfLottery.setResultNum(num);
                String[] result = num.split(",");
                int resultSize = 10;
                Integer indexData = Integer.valueOf(result[index]);
                hfLottery.setSum(indexData.toString());
                if(i==0){
                    hfLottery.setResult(initOmitData(indexData,resultSize));
                }else {
                    Integer[] resultValues = resultList.get(i-1).getResult();
                    Integer[] data = new Integer[resultSize];
                    for (int j = 0; j < resultValues.length; j++) {
                        if (j==indexData){
                            data[j] = indexData;
                        }else {
                            if (j == resultValues[j]){
                                data[j] = 1;
                            }else {
                                data[j] = resultValues[j]+1;
                            }
                        }
                    }
                    hfLottery.setResult(data);
                }
                resultList.add(hfLottery);
            }
            return  resultList;
        }
        return null;
    }

    /**
     * 初始化遗漏值数据
     * @param data
     * @return
     */
    public Integer[] initOmitData(int data,int index){
        Integer[] sum= new Integer[index];
        for (int i = 0; i <index ; i++) {
            if (i == data){
                sum[i] = data;
            }else {
                sum[i] = 1;
            }
        }
        return sum;
    }


    public String subStringNum(String lotteryType,int index,String resultNum){
        if (StringUtils.isNotEmpty(resultNum)){
            index -= 1;
            int first = 2;
            int end = 2;
            if (lotteryType.equals(LotteryTypeEnums.HF_BJPK10.getName())||
                    lotteryType.equals(LotteryTypeEnums.HF_FFPK10.getName())){
                first=3;
                first = first*index ;
                end = first + 2;
            }else {
                first *= index;
                end = end * index + 1;
            }
            if (first<end&&end<=resultNum.length()){
                System.out.println("index= "+index+" 取字符串的first="+first+"\t end="+end);
                return  resultNum.substring(first,end);
            }
        }
        return null;
    }
}
