package com.yys.lottery.task.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.task.common.DateTimeFormat;
import com.yys.lottery.task.common.HttpClientUtils;
import com.yys.lottery.task.common.LotteryTypeEnums;
import com.yys.lottery.task.domain.LotteryHF;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 高频彩票数据
 */
public class LotteryHFData {
    private Logger logger = LoggerFactory.getLogger(LotteryHFData.class);

    @Value("${lottery.HF_url}")
    private String hf_url="https://1233caipiao.com/api/v1";

    /**
     * 获取高频彩票最新的数据
     * @return
     */
    public List<LotteryHF> getLotteryHFLastDate(){
        String url = hf_url;
        String lastResultsUrl = url+"/result/service/mobile/results/lastOpen";
        String result =  HttpClientUtils.getMethod(lastResultsUrl);
        logger.info("最新的彩接口:[{}],data:[{}]",lastResultsUrl,result);
        JSONArray jsonArray =  JSONArray.parseArray(result);
        LotteryHF lottery = null ;
        List<LotteryHF> list;
        if (jsonArray!=null){
            list = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                lottery =  new LotteryHF();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String lotteryName = jsonObject.getString("gameNameInChinese");
                if (lotteryName.equals(LotteryTypeEnums.HF_CQSSC.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_FFSSC.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_BJ28.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_LK28.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_FFPK10.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_BJPK10.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_BJK3.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_FFK3.getDescr())||
                        lotteryName.equals(LotteryTypeEnums.HF_LFK3.getDescr())
                        ){
                    String lotteryType = null;
                    if (lotteryName.equals(LotteryTypeEnums.HF_CQSSC.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_CQSSC.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_FFSSC.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_FFSSC.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_BJ28.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_BJ28.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_LK28.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_LK28.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_FFPK10.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_FFPK10.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_BJPK10.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_BJPK10.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_BJK3.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_BJK3.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_FFK3.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_FFK3.getName();
                    }
                    if (lotteryName.equals(LotteryTypeEnums.HF_LFK3.getDescr())){
                        lotteryType = LotteryTypeEnums.HF_LFK3.getName();
                    }

                    String resultNum = jsonObject.getString("openCode");
                    if (StringUtils.isEmpty(resultNum)){
                        logger.info("{}的开奖结果为{}",lotteryType,resultNum);
                        continue;
                    }
                    String[] num = resultNum.split(",");
                    Integer sum =0;
                    for (int j = 0; j <num.length ; j++) {
                        sum += Integer.valueOf(num[j]);
                    }
                    lottery.setSum(sum.toString());
                    lottery.setResultNum(resultNum);
                    lottery.setLotteryType(lotteryType);
                    lottery.setLotteryName(lotteryName);
                    lottery.setLotteryNo(jsonObject.getString("uniqueIssueNumber"));
                    lottery.setOfficialOpenTime(DateTimeFormat.forMatDate(jsonObject.getDate("officialOpenTime")));
                    lottery.setNextOfficialOpenTime(DateTimeFormat.forMatDate(jsonObject.getDate("nextOfficialOpenTime")));
                    lottery.setStopOrderTime(DateTimeFormat.forMatDate(jsonObject.getDate("nextStopOrderTime")));
                    list.add(lottery);
                    logger.info("获取最新的[{}]数据:[{}]",lottery.getLotteryName(),JSONObject.toJSON(list));
                }
            }
            return  list;
        }
        return null;
    }

    /**
     * 获取当天100条数据
     * @param type  彩票类型
     * @return
     */
    public List<LotteryHF> getLotteryData(String type){
        String url = hf_url;
        String cqsscResultsUrl = url+"/result/service/mobile/results/hist/"+type+"?limit=100";
        String result =  HttpClientUtils.getMethod(cqsscResultsUrl);
        logger.info("获取cqssc 100 条数据:URL[{}],Data[{}]",cqsscResultsUrl,result);
        JSONArray jsonArray =  JSONArray.parseArray(result);
        List<LotteryHF> resultList = null;
        LotteryHF lotteryHF_ssc =null;
        if (jsonArray!=null){
            resultList = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                lotteryHF_ssc = new LotteryHF();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                lotteryHF_ssc.setResultNum(jsonObject.getString("openCode"));
                lotteryHF_ssc.setOfficialOpenTime(DateTimeFormat.forMatDate(jsonObject.getDate("officialOpenTime")));
                lotteryHF_ssc.setNextOfficialOpenTime(DateTimeFormat.forMatDate(jsonObject.getDate("nextStopOrderTime")));
                lotteryHF_ssc.setStopOrderTime(DateTimeFormat.forMatDate(jsonObject.getDate("stopOrderTime")));
                lotteryHF_ssc.setLotteryNo(jsonObject.getString("uniqueIssueNumber"));
                resultList.add(lotteryHF_ssc);
            }
            Collections.sort(resultList, new Comparator<LotteryHF>() {
                @Override
                public int compare(LotteryHF o1, LotteryHF o2) {
                    return new BigDecimal(o1.getLotteryNo()).compareTo(new BigDecimal(o2.getLotteryNo()));
                }
            });
        }
        return resultList;
    }
}
