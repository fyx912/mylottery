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
    private Logger logger = LoggerFactory.getLogger(LotteryHFService.class);

    @Autowired
    private LotteryHFMapper sscMapper;


    /**
     * 获取最大planNo，当编号为null 则设置默认为1
     * @param lotteryType
     * @return
     */
    public Integer getMaxPlanNo(String lotteryType){
        Integer planNo = sscMapper.getMaxPlanNo(lotteryType);
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
            LotteryHF lotteryHF = sscMapper.findOneObject(lotteryType,lotteryNo);
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
      return sscMapper.findAll(lotteryType,page,pageSize);
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
        return  sscMapper.findHistoryLotteryNoAndResultData(lotteryType,page,pageSize);
    }
}
