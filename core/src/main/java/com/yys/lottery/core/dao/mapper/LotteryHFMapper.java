package com.yys.lottery.core.dao.mapper;

import com.yys.lottery.core.domain.LotteryHF;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LotteryHFMapper {

    @Select("SELECT MAX(planNo) FROM t_lottery_hf_${lotteryType}")
    Integer getMaxPlanNo(@Param("lotteryType") String lotteryType);

    @Insert("insert into t_lottery_hf_${lotteryType} (planNo,lotteryNo,resultNum,officialOpenTime,nextOfficialOpenTime,stopOrderTime) " +
            "values(#{lottery.planNo},#{lottery.lotteryNo},#{lottery.resultNum},#{lottery.officialOpenTime},#{lottery.nextOfficialOpenTime},#{lottery.stopOrderTime})")
    @Options(useGeneratedKeys = true,keyProperty = "lottery.id",keyColumn = "id")
    Integer InsertObject(@Param("lotteryType") String lotteryType, @Param("lottery") LotteryHF lottery);


    @Insert({
            "<script>" +
                    "insert into t_lottery_hf_${lotteryType} (planNo,lotteryNo,resultNum,officialOpenTime,nextOfficialOpenTime,stopOrderTime) values " +
                    "<foreach item='list' index='key' collection='list' separator=','>" +
                    "(#{list.planNo},#{list.lotteryNo},#{list.resultNum},#{list.officialOpenTime},#{list.nextOfficialOpenTime},#{list.stopOrderTime})" +
                    " </foreach>"+
                    "</script>"
    })
    void InsertBatchOObject(@Param("lotteryType") String lotteryType, @Param("list") List<LotteryHF> list);

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

    @Select("select * FROM t_lottery_hf_${lotteryType}  order by lotteryNo desc limit ${page},${pageSize}")
    List<LotteryHF> findAll(@Param("lotteryType") String lotteryType,@Param("page") int page,@Param("pageSize") int pageSize);

    @Select("select lotteryNo,resultNum,sum FROM t_lottery_hf_${lotteryType} order by lotteryNo desc limit ${page},${pageSize}")
    List<LotteryHF> findHistoryLotteryNoAndResultData(@Param("lotteryType") String lotteryType,@Param("page") int page,@Param("pageSize") int pageSize);


    @Select("select * FROM t_lottery_hf_${lotteryType}  where officialOpenTime like '${date}%'")
    List<LotteryHF> findLotteryByDate(@Param("lotteryType") String lotteryType,@Param("date") String date);


    @Select("select * from t_lottery_hf_${lotteryType} order by lotteryNo desc limit 1")
    LotteryHF findLatestData(@Param("lotteryType") String lotteryType);

}
