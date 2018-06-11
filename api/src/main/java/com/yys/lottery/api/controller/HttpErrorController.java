package com.yys.lottery.api.controller;

import com.yys.lottery.api.common.CodeJson;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HttpErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

//    @RequestMapping(value = ERROR_PATH)
//    @ResponseBody
//    @ResponseStatus
//    public String handlerError(){
//        return  CodeJson.error(1,"请求的路径不存在!");
//    }
//
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
