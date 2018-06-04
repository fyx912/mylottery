package com.yys.lottery.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test {

    @RequestMapping("/")
    public String index(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","success");
        jsonObject.put("data",null);
        return jsonObject.toString();
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
