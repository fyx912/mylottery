package com.yys.lottery.task.mapper;

import com.yys.lottery.task.domain.LotteryList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
