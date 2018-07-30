package com.yys.lottery.api.miles.mapper;

import com.yys.lottery.core.domain.LotteryHF;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MilesMapper {

    @Select("select issueNum as lotteryNo,openCodeAll as resultNum,openTime as officialOpenTime  " +
            "FROM ${lotteryType} where openCodeAll is not null order by issueNum desc limit ${page},${pageSize}")
    List<LotteryHF> findMilesLotterTrendData(@Param("lotteryType") String lotteryType, @Param("page") int page, @Param("pageSize") int pageSize);

}
