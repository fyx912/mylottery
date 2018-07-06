package com.yys.lottery.task.mapper;

import com.yys.lottery.task.domain.LotteryHF;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface LotteryHFMapper {

    @Select("SELECT MAX(planNo) FROM t_lottery_hf_${lotteryType}")
    Integer getMaxPlanNo(@Param("lotteryType") String lotteryType);

    @Insert("insert into t_lottery_hf_${lotteryType} (planNo,lotteryNo,resultNum,officialOpenTime,nextOfficialOpenTime,stopOrderTime,sum) " +
            "values(#{lottery.planNo},#{lottery.lotteryNo},#{lottery.resultNum},#{lottery.officialOpenTime},#{lottery.nextOfficialOpenTime},#{lottery.stopOrderTime},#{lottery.sum})")
    @Options(useGeneratedKeys = true,keyProperty = "lottery.id",keyColumn = "id")
    Integer InsertObject(@Param("lotteryType") String lotteryType,@Param("lottery")LotteryHF lottery);


    @Insert({
            "<script>" +
                    "insert into t_lottery_hf_${lotteryType} (planNo,lotteryNo,resultNum,officialOpenTime,nextOfficialOpenTime,stopOrderTime,sum) values " +
                    "<foreach item='list' index='key' collection='list' separator=','>" +
                    "(#{list.planNo},#{list.lotteryNo},#{list.resultNum},#{list.officialOpenTime},#{list.nextOfficialOpenTime},#{list.stopOrderTime},#{list.sum})" +
                    " </foreach>"+
                    "</script>"
    })
    void InsertBatchObject(@Param("lotteryType") String lotteryType,@Param("list")List<LotteryHF> list);

    /**
     * 获取当前日期所有的期号
     * @param lotteryType 高频彩票的种类动态表,如:cqssc,ffssc等等
     * @return
     */
    @Select("select lotteryNo FROM t_lottery_hf_${lotteryType} " +
            "where officialOpenTime between date_format(date_sub(now(),INTERVAL 1 DAY),\"%Y-%m-%d\") " +
            "and date_format(DATE_ADD(now(),INTERVAL 1 DAY),\"%Y-%m-%d\") order by lotteryNo ")
    List<String> getLotteryNoByDate(@Param("lotteryType") String lotteryType);

    @Select("select * FROM t_lottery_hf_${lotteryType} where lotteryNo='${lotteryNo}'")
    LotteryHF findOneObject(@Param("lotteryType") String lotteryType, @Param("lotteryNo") String lotteryNo);

}
