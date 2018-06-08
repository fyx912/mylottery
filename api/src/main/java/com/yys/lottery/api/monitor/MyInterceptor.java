package com.yys.lottery.api.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String path = request.getServletPath();
        String userName = (String) request.getSession().getAttribute("userName");
        logger.info(String.format("请求参数, url: %s, method: %s, uri: %s,userName: %s, params: %s", url, method, uri, userName,queryString));
//        if (uri.equals(path+"/")||uri.equals(path+"/login")||uri.equals(path+"/validateCode")||uri.endsWith(".js")||uri.endsWith(".css")
//                ||uri.endsWith(".jpg")){
//            flag = true;
//        }else {
//            if (userName!=null){
//                flag = true;
//            }else {
//                request.getRequestDispatcher(path+"/login").forward(request, response);
//            }
//        }
        return true;
    }
}
