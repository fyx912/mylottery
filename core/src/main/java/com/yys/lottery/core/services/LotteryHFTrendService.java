package com.yys.lottery.core.services;

import com.yys.lottery.core.common.LotteryTypeEnums;
import com.yys.lottery.core.dao.mapper.LotteryHFTrendMapper;
import com.yys.lottery.core.domain.LotteryHF;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryHFTrendService {

    @Autowired
    public LotteryHFTrendMapper trendMapper;

    public List<LotteryHF> getTrendData(String lotteryType,int page,int pageSize){
        if (StringUtils.isEmpty(lotteryType)){
            lotteryType = LotteryTypeEnums.HF_CQSSC.getName();
        }
        if (pageSize!=30||pageSize!=50||pageSize!=100){
            pageSize = 30;
        }
        return trendMapper.findTrendData(lotteryType,page,pageSize);
    }
}
