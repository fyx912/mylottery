package com.yys.lottery.task.scheduled;

import com.yys.lottery.task.service.LotteryHFService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 高频菜品定时任务
 */
@Component
public class LotteryHFTask {
    private Logger logger = LoggerFactory.getLogger(LotteryHFTask.class);
    private int countSum = 0;

    @Autowired
    private LotteryHFService hfService;

    @Scheduled(fixedRate = 60000)//1分钟运行一次
    public void lotteryHFTask(){
        logger.info("高频彩票1分钟运行一次...第[{}]次....runTime[{}]",countSum++,new Date());
        hfService.saveLotteryData();
    }
}
