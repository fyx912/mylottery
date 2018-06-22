package com.yys.lottery.core.dao.mapper;

import com.yys.lottery.core.domain.LotteryHF;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LotteryHFTrendMapper {

    @Select("select lotteryNo,resultNum FROM t_lottery_hf_${lotteryType} order by lotteryNo desc limit ${page},${pageSize}")
    List<LotteryHF> findTrendData(@Param("lotteryType") String lotteryType, @Param("page") int page, @Param("pageSize") int pageSize);

    @Select("select lotteryNo,resultNum,officialOpenTime,sum FROM t_lottery_hf_${lotteryType} order by lotteryNo desc limit ${page},${pageSize}")
    List<LotteryHF> findPCTrendData(@Param("lotteryType") String lotteryType, @Param("page") int page, @Param("pageSize") int pageSize);

}
