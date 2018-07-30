package com.yys.lottery.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.api.common.CodeJson;
import com.yys.lottery.api.domain.LotteryTrend;
import com.yys.lottery.api.service.LotteryHFApiService;
import com.yys.lottery.core.services.LotteryHFService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "LotteryMilesController",description = "高频彩票相关操作")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success — 请求已完成"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器不能完成请求")
})
@RestController
@RequestMapping("miles/")
public class LotteryMilesController {
    @Autowired
    private LotteryHFService hfService;
    @Autowired
    private LotteryHFApiService apiService;

    @ApiOperation(value = "获取趋势图",notes = "获取高频率趋势图")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "String",name = "type",value = "彩票类型",required = true),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "index",defaultValue = "0",value = "彩票位数",required = true),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "page",defaultValue = "1",value = "首页"),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "pageSize",defaultValue = "30",value = "页面大小")
    })
    @RequestMapping(value = "trend",method = {RequestMethod.GET},produces = "application/json;charset=UTF-8 ")
    public String trendView(@RequestParam(defaultValue = "ffssc") String type, @RequestParam(defaultValue = "0") int index,
                            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "30") int pageSize){
        if (page>0){
            page = pageSize *(page-1);
        } String result=null;
            Integer length = hfService.resultNumLength(type);
            if (index<=length-1){
                LotteryTrend trend = apiService.lotteryBaseTrend(type,index,page,pageSize);
                JSONObject json = CodeJson.successJsonObject(trend);
                json.put("type",type);
                json.put("index",index);
                json.put("count",trend.getLotteryHF().size());
                result = json.toString();
            }else {
                result = CodeJson.error(1,"请求的参数超出范围!");
            }
        return result;
    }
}
