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

import java.util.ArrayList;
import java.util.List;

/**
 * 高频彩票数据
 */
public class LotteryHFData {
    private Logger logger = LoggerFactory.getLogger(LotteryHFData.class);
    /**
     * 获取重庆时时彩最新的数据
     * @return
     */
    public List<LotteryHF> getLotteryHFAllDate(){
        String lastResultsUrl = "https://1233caipiao.com/api/v1/result/service/mobile/results/lastOpen";
        String result =  HttpClientUtils.getMethod(lastResultsUrl);
        logger.info("最新的重庆时时彩接口:[{}],data:[{}]",lastResultsUrl,result);
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
                        lotteryName.equals(LotteryTypeEnums.HF_BJPK10.getDescr())
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
                    lottery.setLotteryType(lotteryType);
                    lottery.setLotteryName(lotteryName);
                    lottery.setLotteryNo(jsonObject.getString("uniqueIssueNumber"));
                    String resultNum = jsonObject.getString("openCode");
                    if (StringUtils.isEmpty(resultNum)){
                        continue;
                    }
                    lottery.setResultNum(resultNum);
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
}
