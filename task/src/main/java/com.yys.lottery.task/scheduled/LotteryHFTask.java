package com.yys.lottery.task.scheduled;

import com.yys.lottery.task.common.DateTimeFormat;
import com.yys.lottery.task.service.LotteryHFTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 高频彩票定时任务
 */
@Component
public class LotteryHFTask {
    private Logger logger = LoggerFactory.getLogger(LotteryHFTask.class);
    private int countSum = 0;

    @Autowired
    private LotteryHFTaskService hfService;

    @Scheduled(fixedRate = 60000)//1分钟运行一次
    public void lotteryHFTask(){
        logger.info("高频彩票1分钟运行一次...第[{}]次....runTime[{}]",countSum,DateTimeFormat.forMatDate(new Date()));
        hfService.saveLotteryData();
    }

//    @Scheduled(cron = "0 0 4 1/1 * ? ")//每天4点运行一次
    @Scheduled(cron = "0 0 1/2 * * ? ")//每天2h运行一次
//    @Scheduled(fixedRate = 60000)//1分钟运行一次
    public void saveBatchLotteryTask() throws InterruptedException {
        logger.info("一天运行一次.....运行时间[{}].",new Date());
        String[] type = new String[]{"HF_CQSSC","HF_FFSSC","HF_XJSSC","HF_LFSSC","HF_BJPK10","HF_FFPK10","HF_LFPK10",
                "HF_LF28","HF_BJ28","HF_BJK3","HF_LFK3","HF_FFK3","HF_TJSSC"};
        for (int i = 0; i < type.length; i++) {
            hfService.saveBatchAllLotteryData(type[i]);
            Thread.sleep(60000);
        }
    }
}
