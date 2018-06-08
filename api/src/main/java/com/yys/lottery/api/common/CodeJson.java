package com.yys.lottery.api.common;

import com.alibaba.fastjson.JSONObject;

public class CodeJson {

    public static JSONObject success(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","success!");
        return jsonObject;
    }


    public static String success(Object data){
        JSONObject jsonObject = success();
        jsonObject.put("data",data);
        return jsonObject.toString();
    }

    public static JSONObject successJsonObject(Object data){
        JSONObject jsonObject = success();
        jsonObject.put("data",data);
        return jsonObject;
    }

    public static String error(int errorCode,String filed){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",errorCode);
        jsonObject.put("msg",filed);
        return  jsonObject.toString();
    }
}
