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
            case "ahk3": lotteryType="t_lottery_nearly_three_ah";break;//安徽快三
            case "bjk3": lotteryType="t_lottery_nearly_three_bj";break;//北京快三
            case "jlk3": lotteryType="t_lottery_nearly_three_jl";break;//吉林快三
            case "gxk3": lotteryType="t_lottery_nearly_three_gx";break;//广西快三
            case "hbk3": lotteryType="t_lottery_nearly_three_hb";break;//湖北快三
            case "cqkl10f": lotteryType="t_lottery_happy_ten_cq";break;//重庆快乐10分
            case "gdkl10f": lotteryType="t_lottery_happy_ten_gd";break;//广东快乐10分
            case "hnkl10f": lotteryType="t_lottery_happy_ten_hn";break;//湖南快乐10分
            case "tjkl10f": lotteryType="t_lottery_happy_ten_tj";break;//天津快乐10分
            case "ynkl10f": lotteryType="t_lottery_happy_ten_yn";break;//云南快乐10分
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
