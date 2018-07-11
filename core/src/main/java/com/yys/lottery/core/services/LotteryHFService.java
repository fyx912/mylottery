package com.yys.lottery.core.services;


import com.yys.lottery.core.dao.mapper.LotteryHFMapper;
import com.yys.lottery.core.domain.LotteryHF;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryHFService {

    @Autowired
    private LotteryHFMapper lotteryHFMapper;

    /**
     * 获取最大planNo，当编号为null 则设置默认为1
     * @param lotteryType
     * @return
     */
    public Integer getMaxPlanNo(String lotteryType){
        Integer planNo = lotteryHFMapper.getMaxPlanNo(lotteryType);
        if (planNo!=null){
            return planNo;
        }
        return 0;
    }

    /**
     * 判断彩票期号是否存在
     * @param lotteryType  (彩种，期号)
     * @return
     */
    public boolean existsLotteryNo(String lotteryType ,String lotteryNo){
        boolean flag = false;
        if (StringUtils.isNotEmpty(lotteryType)&&StringUtils.isNotEmpty(lotteryNo)){
            LotteryHF lotteryHF = lotteryHFMapper.findOneObject(lotteryType,lotteryNo);
            if (lotteryHF!=null){
                flag = true;
            }
        }
        return flag;
    }

    public List<LotteryHF>  findAll(String lotteryType,int page,int pageSize){
        if (0>pageSize&&pageSize>100){
            pageSize = 30;
        }
      return lotteryHFMapper.findAll(lotteryType,page,pageSize);
    }

    /**
     * 查询开奖彩票开奖结果和期号
     * @param lotteryType
     * @param page
     * @param pageSize
     * @return
     */
    public List<LotteryHF> findHistoryLotteryNoAndResultData(String lotteryType,int page,int pageSize){
        if (0>pageSize&&pageSize>100){
            pageSize = 30;
        }
        return  lotteryHFMapper.findHistoryLotteryNoAndResultData(lotteryType,page,pageSize);
    }

    /**
     * @describe 获取最新的数据
     * @param lotteryType 彩票类型
     * @return
     */
    public LotteryHF findLatestData(String lotteryType){
       return lotteryHFMapper.findLatestData(lotteryType);
    }

    /**
     * @describe 根据日期查找开奖信息
     * @param lotteryType 彩票类型
     * @param date  查询日期，格式"yyyy-MM-dd"
     * @return
     */
    public List<LotteryHF> findLotteryByDate(String lotteryType,String date){
        return lotteryHFMapper.findLotteryByDate(lotteryType,date);
    }

    /**
     * @describe 获取开奖结果的
     * @return
     */
    public Integer resultNumLength(String lotteryType){
        String result = lotteryHFMapper.findResultNum(lotteryType);
        if (result!=null&&result.length()>2){
            return result.split(",").length;
        }else {
            return 0;
        }
    }

    /**
     * @describe 历史开奖结果
     * @return
     */
    public List<LotteryHF> historyOpenResult(String type,Integer page,Integer pageSize){
        List<LotteryHF> hfList = lotteryHFMapper.findHistoryOpenResult(type,page,pageSize);
        return  hfList;
    }
}
