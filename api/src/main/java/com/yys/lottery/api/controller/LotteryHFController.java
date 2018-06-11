package com.yys.lottery.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.api.common.CodeJson;
import com.yys.lottery.api.domain.LotteryTrend;
import com.yys.lottery.api.service.LotteryHFApiService;
import com.yys.lottery.core.common.LotteryTypeEnums;
import com.yys.lottery.core.domain.LotteryHF;
import com.yys.lottery.core.services.LotteryHFService;
import com.yys.lottery.core.services.LotteryListService;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@Api(value = "LotteryHFController",description = "高频彩票相关操作")
@RestController
@RequestMapping("HF/")
public class LotteryHFController {
    private Logger logger = LoggerFactory.getLogger(LotteryHFController.class);

    @Autowired
    private LotteryHFApiService apiService;
    @Autowired
    private LotteryHFService hfService;
    @Autowired
    private LotteryListService typeService;

    @ApiOperation(value = "获取趋势图",notes = "获取高频率趋势图")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",dataType = "String",name = "type",value = "彩票类型",required = true),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "index",defaultValue = "0",value = "彩票位数",required = true),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "page",defaultValue = "1",value = "首页"),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "pageSize",defaultValue = "30",value = "页面大小")
    })
    @Cacheable(value = "lottery.hf.trend")
    @RequestMapping(value = "trend",method = {RequestMethod.GET},produces = "application/json;charset=UTF-8 ")
    public String trendView(@RequestParam String type, @RequestParam(defaultValue = "0") int index,
                            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "30") int pageSize){
        if (StringUtils.isEmpty(type)){
            type = LotteryTypeEnums.HF_CQSSC.getName();
        }
        if (page>0){
            page = pageSize *(page-1);
        }
        LotteryTrend trend = apiService.lotteryBaseTrend(type,index,page,pageSize);
        JSONObject json = CodeJson.successJsonObject(trend);
        json.put("type",type);
        json.put("index",index);
        return  json.toString();
    }

    @ApiOperation(value = "彩票数据集",notes = "获取高频彩票数据集")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",dataType = "String",name = "type",value = "彩票类型",required = true),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "page",defaultValue = "1",value = "首页"),
            @ApiImplicitParam(paramType = "query",dataType = "int",name = "pageSize",defaultValue = "30",value = "页面大小")
    })
    @Cacheable(value = "lottery.hf.list")
    @RequestMapping(value = "list/{type}",method = {RequestMethod.GET},produces = "application/json;charset=UTF-8 ")
    public String getLotteryData(@PathVariable String type, @RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "30") int pageSize){
        boolean flag =typeService.typeExists(type);
        String result;
        if (flag){
            page = pageSize *(page-1);
            List<LotteryHF> hfList = hfService.findAll(type,page,pageSize);
            result =  CodeJson.success(hfList);
        }else {
            logger.info("请求的类型不存在！");
            result = CodeJson.error(1,"请求的类型不存在!");
        }
        return result;
    }
}
