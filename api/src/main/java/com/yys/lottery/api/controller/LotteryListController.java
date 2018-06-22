package com.yys.lottery.api.controller;

import com.yys.lottery.api.common.CodeJson;
import com.yys.lottery.core.domain.LotteryList;
import com.yys.lottery.core.services.LotteryListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@Api(description = "彩票种类")
@RestController
@RequestMapping("lottery")
public class LotteryListController {

    @Autowired
    private LotteryListService listService;

    @ApiOperation(value = "彩票种类",notes = "支持相关的彩种")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")
    })
    @Cacheable(value = "lottery.type")
    @RequestMapping(value = "type",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getLotteryType(){
       List<LotteryList> lotteryLists =  listService.getAll();
       return  CodeJson.success(lotteryLists);
    }
}
