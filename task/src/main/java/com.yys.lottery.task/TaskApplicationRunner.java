package com.yys.lottery.task;

import com.yys.lottery.task.common.DateTimeFormat;
import com.yys.lottery.task.service.LotteryHFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Order(value = 1)
public class TaskApplicationRunner implements ApplicationRunner {
    @Autowired
    private LotteryHFService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("高频彩票初始化运行......runTime[{}]",DateTimeFormat.forMatDate(new Date()));
        String[] type = new String[]{"HF_CQSSC","HF_FFSSC","HF_BJPK10","HF_FFPK10",
                "HF_LF28","HF_BJ28","HF_BJK3","HF_LFK3","HF_FFK3"};
        for (int i = 0; i < type.length; i++) {
            service.saveBatchAllLotteryData(type[i]);
            Thread.sleep(30 * 1000);
        }
        log.info("初始化完成....");
    }
}
