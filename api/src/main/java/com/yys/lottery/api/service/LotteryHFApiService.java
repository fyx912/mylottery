package com.yys.lottery.api.service;

import com.yys.lottery.api.domain.LotteryTrend;
import com.yys.lottery.api.utils.LotteryTrendUtil;
import com.yys.lottery.core.common.LotteryTypeEnums;
import com.yys.lottery.core.domain.LotteryHF;
import com.yys.lottery.core.domain.LotteryList;
import com.yys.lottery.core.services.LotteryHFService;
import com.yys.lottery.core.services.LotteryHFTrendService;
import com.yys.lottery.core.services.LotteryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LotteryHFApiService {
    @Autowired
    private LotteryHFTrendService trendService;
    @Autowired
    private LotteryHFService hfService;
    @Autowired
    private LotteryListService lotteryListService;
    @Autowired
    private LotteryMilesService lotteryMilesService;

    /**
     * 计算遗漏数据
     * @param lotteryType
     * @param index
     * @param page
     * @param pageSize
     * @return
     */
    public List<LotteryHF> lotteryTrendData(String lotteryType,int index,int page,int pageSize){
        List<LotteryHF>  hfList ;
        String[] milesLotteryType = {"ffssc","lfssc","lfpk10","ffpk10"};
        if (Arrays.asList(milesLotteryType).contains(lotteryType)){
            hfList = lotteryMilesService.getTrendData(lotteryType,page,pageSize);
        }else {
            hfList = trendService.getTrendData(lotteryType,page,pageSize);
        }
        List<LotteryHF>  trendList = trendDataDispose(index,hfList);//计算处理之后的数据
        return trendList;
    }

    /**
     * @describe 高频彩票基本走势图
     * @param lotteryType 高频彩票的类型
     * @param index 基本视图索引列
     * @param page 页面
     * @param pageSize 页面大小
     * @return
     */
//    @Cacheable(value = "LotteryHFApiService.lotteryBaseTrend",key = "#lotteryType")
    public LotteryTrend  lotteryBaseTrend(String lotteryType,int index,int page,int pageSize){
        List<LotteryHF> hfList = lotteryTrendData(lotteryType,index,page,pageSize);//计算遗漏数据
        List<Integer> maxList = new ArrayList<>();
        List<Integer> avgList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        List<Integer> maxContinuousList = new ArrayList<>();
        LotteryTrend trend = new LotteryTrend();
        int resultSize = 10;
        if (lotteryType.equals(LotteryTypeEnums.HF_FFK3.getName())||
                lotteryType.equals(LotteryTypeEnums.HF_BJK3.getName())||
                lotteryType.equals(LotteryTypeEnums.HF_LFK3.getName())){
            resultSize = 3;
        }
        for (int j = 0; j < resultSize; j++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> sumList = new ArrayList<>();
            for (int i = 0; i <  hfList.size(); i++) {
                Integer[] result = hfList.get(i).getResult();
                LotteryHF lotteryHF = hfList.get(i);
                lotteryHF.setResult(result);
                list.add(result[j]);
                sumList.add(Integer.valueOf(lotteryHF.getSum()));
            }
            Integer countValue = LotteryTrendUtil.countOmitValue(sumList,j);
            countList.add(countValue);
            Integer resultValue = Integer.valueOf(hfList.get(j).getSum());
            Integer avgValue = LotteryTrendUtil.averageOmitValue(resultValue,list);
            avgList.add(avgValue);
            Integer maxOmitValue = LotteryTrendUtil.maxOmitValue(list);
            maxList.add(maxOmitValue);
            Integer  maxContinuousValue = LotteryTrendUtil.maxContinuousValue(sumList,list);
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
    public List<LotteryHF>  trendDataDispose(int index,List<LotteryHF>  hfList){
        if (hfList!=null){
            LotteryHF hfLottery = null;
            List<LotteryHF> resultList = new ArrayList<>();
            for (int i = 0; i <hfList.size() ; i++) {
                hfLottery = new LotteryHF();
                hfLottery.setLotteryNo(hfList.get(i).getLotteryNo());
//                String subStringNum = subStringNum(lotteryType,index,hfList.get(i).getResultNum());
//                hfLottery.setResultNum(subStringNum);
                String num =null;
                if (hfList.get(i).getResultNum()!=null){
                     num = hfList.get(i).getResultNum();
                }else {
                    String[] resultNumArray =  hfList.get(i).getResultNum().split(",");
                    int resultSum = 0;
                    for (int j = 0; j < resultNumArray.length; j++) {
                        resultSum += Integer.valueOf(resultNumArray[i]);
                    }
                    num = String.valueOf(resultSum);
                }
                hfLottery.setResultNum(num);
                String[] result = num.split(",");
                int resultSize = 10;
                Integer indexData = Integer.valueOf(result[index]);
                hfLottery.setSum(indexData.toString());
                if(i==0){
                    hfLottery.setResult(initOmitData(indexData,resultSize));
                }else {
                    Integer[] resultValues = resultList.get(i-1).getResult();
                    Integer lastValue = Integer.valueOf(resultList.get(i-1).getSum());
                    Integer[] data = new Integer[resultSize];
                    for (int j = 0; j < resultValues.length; j++) {
                        if (j==indexData){
                            data[j] = indexData;
                        }else {
                            if (j == indexData){
                                data[j] = indexData;
                            }else {
                                if (j==lastValue&&lastValue == resultValues[j]){
                                    data[j] = 1;
                                }else {
                                    data[j] = resultValues[j]+1;
                                }
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
    @Cacheable(value = "lottery.trend.initOmit",key = "#data")
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

    /**
     * @describe 获取最新的数据
     * @return
     */
    public List<LotteryHF>  findLatestData(){
        List<LotteryHF> hfList = new ArrayList<>();
        List<LotteryList> lotteryLists = lotteryListService.findLotteryHFAll();
        if (lotteryLists!=null){
            for (LotteryList lotteryList: lotteryLists) {
                String lotteryType = lotteryList.getLotteryId();
                LotteryHF lotteryHF = hfService.findLatestData(lotteryType);
                lotteryHF.setType(lotteryType);
                hfList.add(lotteryHF);
            }
        }
        return hfList;
    }

    /**
     * @describe pc蛋蛋基本视图
     * @return
     */
    public List<LotteryHF> pcBaseTrendData(String lotteryType,int page,int pageSize){
        List<LotteryHF> lotteryHFList = null;
        List<LotteryHF> hfList =  trendService.getPCBaseTrendData(lotteryType,page,pageSize);
        if (hfList!=null){
            LotteryHF lotteryHF = null;
            lotteryHFList = new ArrayList<>();
            for (int i = 0; i < hfList.size(); i++) {
                lotteryHF = new LotteryHF();
                lotteryHF.setLotteryNo(hfList.get(i).getLotteryNo());
                String[] num = hfList.get(i).getResultNum().split(",");
                String result = "";
                Integer numTotal=0;
                for (int j = 0; j < num.length; j++) {
                    result += num[j] +" + ";
                    numTotal += Integer.valueOf(num[j]);
                }
                result = result.substring(0,result.lastIndexOf("+"))+"= "+numTotal;
                lotteryHF.setResultNum(result);
                lotteryHF.setOfficialOpenTime(hfList.get(i).getOfficialOpenTime());
                String sum = hfList.get(i).getSum();
                if (sum==null){
                    sum = numTotal.toString();
                }
                lotteryHF.setSum(sum);
                lotteryHF.setRemark(LotteryTrendUtil.bigMinSingleDouble(Integer.valueOf(sum)));
                lotteryHF.setWaveColor(LotteryTrendUtil.waveColor(Integer.valueOf(sum)));

                lotteryHFList.add(lotteryHF);
            }
        }
        return  lotteryHFList;
    }

}
