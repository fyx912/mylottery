package com.yys.lottery.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.core.common.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @RequestMapping(value = "pay",method = RequestMethod.POST)
    public String pay(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount",10.1);
        jsonObject.put("merchantcode",102);
        jsonObject.put("notifyurl","http://localhost:80/receive");
        jsonObject.put("orderid","20180122181701");
        jsonObject.put("sign","523AB4F116A74B6D815E72A2647CBC60");
        jsonObject.put("type","ALIPAY");
        String reslut = HttpClientUtils.postMethod("http://api.huiyin-pay.com/orderpay/pay",jsonObject.toString());
        System.out.println(reslut);
       return reslut;
    }
}
