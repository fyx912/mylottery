package com.yys.lottery.api.service;

import com.yys.lottery.api.miles.mapper.MilesMapper;
import com.yys.lottery.core.domain.LotteryHF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 私有数据
 */
@Service
public class LotteryMilesService {
    @Autowired
    public MilesMapper trendMapper;

    public List<LotteryHF> getTrendData(String lotteryType, int page, int pageSize){
        switch (lotteryType){
            case "ffssc" : lotteryType = "t_ffTimeLottery_result";break;//分分时时彩
            case "lfssc": lotteryType = "t_ef_time_lottery_result";break;//二分时时彩
            case "ffpk10" : lotteryType = "t_ffTimeLottery_result";break;//分分PK10
            case "lfpk10": lotteryType = "t_ef_pk_lottery_result";break;//二分pk10
            case "lfk3" : lotteryType = "t_ffTimeLottery_result";break;//二分快3
            case "ffk3": lotteryType = "t_ffTimeLottery_result";break;//分分快3
            default:lotteryType = "t_ffTimeLottery_result";
        }
        return trendMapper.findMilesLotterTrendData(lotteryType,page,handlePageSize(pageSize));
    }

    public int handlePageSize(int pageSize){
        if (0>pageSize||pageSize>100){
            pageSize = 30;
        }
        return pageSize;
    }
}
