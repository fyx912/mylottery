package com.yys.lottery.task.controller;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.task.common.CommonURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private CommonURL commonURL;


    @RequestMapping("/test")
    public String test(){
        return commonURL.getHf_url();
    }

    @RequestMapping("/")
    public String index(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","success");
        jsonObject.put("data",null);
        return jsonObject.toString();
    }



}
