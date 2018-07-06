package com.yys.lottery.api.common;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

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

    public static String success(Map map){
        JSONObject jsonObject = success();
        jsonObject.putAll(map);
        return jsonObject.toString();
    }

    public static JSONObject successJsonObject(Object data){
        JSONObject jsonObject = success();
        jsonObject.put("data",data);
        return jsonObject;
    }

    public static String  filed(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        jsonObject.put("msg","filed!");
        return  jsonObject.toString();
    }

    public static String  filed(int code,String filed){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg","Filed! because:"+filed);
        return  jsonObject.toString();
    }

    public static String error(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        jsonObject.put("msg","filed!");
        return  jsonObject.toString();
    }

    public static String error(int errorCode,String filed){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",errorCode);
        jsonObject.put("msg","Filed! because:"+filed);
        return  jsonObject.toString();
    }
}
