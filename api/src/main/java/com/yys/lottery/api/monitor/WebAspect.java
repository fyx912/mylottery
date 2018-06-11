package com.yys.lottery.api.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebAspect.class);

    //时间同步
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.yys.*.api.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 记录下请求内容
        logger.info("Start Record Time : "+startTime.get());
        logger.info("OS:\t"+System.getProperty("os.name"));
        logger.info("IP:\t"+request.getRemoteAddr()+"\t port:"+request.getServerPort());
        logger.info("URL:\t"+request.getRequestURI());
        logger.info("Request Language : "+request.getHeader("Accept-Language"));
        logger.info(String.format("Request Heads : Accept: %s,Accept-Language: %s,Origin: %s",request.getHeader("Accept"),
                request.getHeader("Accept-Language"),request.getHeader("Origin")));
        logger.info("Request Heads : Referer: {} ",request.getHeader("Referer"));
        logger.info(String.format("Request Heads : User-Agent: %s ",request.getHeader("User-Agent")));
        logger.info("HTTP_METHOD: "+request.getMethod());
        logger.info("Cookies: "+request.getCookies());
        logger.info("Class_Method: "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("Args: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "response",pointcut = "webLog()")
    public void doAfterReturning(Object response){
        // 处理完请求，返回内容
        logger.info("Response: "+response);
        logger.info("Spend Time : "+(System.currentTimeMillis()-startTime.get()));
    }
}


