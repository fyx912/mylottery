package com.yys.lottery.task.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.task.common.DateTimeFormat;
import com.yys.lottery.task.common.HttpClientUtils;
import com.yys.lottery.task.common.LotteryTypeEnums;
import com.yys.lottery.task.domain.LotteryHF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 获取重庆时时彩数据
 */
@Component
public class LotteryCQSSCData {
    private Logger logger = LoggerFactory.getLogger(LotteryCQSSCData.class);

    @Value("${lottery.HF_url}")
    private String hf_url="https://1233caipiao.com/api/v1";

    /**
     * 获取当天100条数据
     * @return
     */
    public List<LotteryHF> getCQSSCData(){
        String url = hf_url;
        String cqsscResultsUrl = url+"/result/service/mobile/results/hist/HF_CQSSC?limit=50";
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

    /**
     * 获取重庆时时彩最新的数据
     * @return
     */
    public LotteryHF getObject(){
        String url = hf_url;
        String lastResultsUrl = hf_url+"/result/service/mobile/results/lastOpen";
        String result =  HttpClientUtils.getMethod(lastResultsUrl);
        logger.info("最新的重庆时时彩接口:[{}],data:[{}]",lastResultsUrl,result);
        JSONArray jsonArray =  JSONArray.parseArray(result);
        LotteryHF lottery = new LotteryHF();
        if (jsonArray!=null){
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("gameNameInChinese").equals(LotteryTypeEnums.HF_CQSSC.getDescr())) {
                    lottery.setLotteryNo(jsonObject.getString("uniqueIssueNumber"));
                    lottery.setResultNum(jsonObject.getString("openCode"));
                    lottery.setOfficialOpenTime(DateTimeFormat.forMatDate(jsonObject.getDate("officialOpenTime")));
                    lottery.setNextOfficialOpenTime(DateTimeFormat.forMatDate(jsonObject.getDate("nextOfficialOpenTime")));
                    lottery.setStopOrderTime(DateTimeFormat.forMatDate(jsonObject.getDate("nextStopOrderTime")));
                    logger.info("获取最新的重庆时时彩数据:[{}]",JSONObject.toJSON(lottery));
                    break;
                }
            }
            return lottery;
        }
        return null;
    }
}
