package com.yys.lottery.core.dao.mapper;

import com.yys.lottery.core.domain.LotteryList;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface LotteryListMapper {

    @Results(id = "lotteryListMap",value = {
            @Result(column = "id",property = "id",javaType = Integer.class),
            @Result(column = "lottery_id",property = "lotteryId",javaType = String.class),
            @Result(column = "lottery_type_id",property = "lotteryTypeId",javaType = Integer.class),
            @Result(column = "lottery_name",property = "lotteryName",javaType = String.class),
            @Result(column = "lottery_group",property = "lotteryGroup",javaType = String.class),
            @Result(column = "datetime",property = "dateTime",javaType = Timestamp.class),
            @Result(column = "remarks",property = "remarks",javaType = String.class)
    })
    @Select("select * from t_lottery_list")
    List<LotteryList> getAll();

    @Select("select * from t_lottery_list where lottery_type_id=3")
    List<LotteryList>

    getLotteryHFAll();

    @Select("select lottery_id from t_lottery_list where lottery_id=${lotteryType}")
    String findType(@Param("lotteryType")String lotteryType);
}
