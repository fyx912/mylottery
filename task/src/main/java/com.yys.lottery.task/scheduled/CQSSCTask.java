package com.yys.lottery.task.scheduled;

import com.yys.lottery.task.common.LotteryTypeEnums;
import com.yys.lottery.task.service.LotteryHF_SSCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class CQSSCTask {
    private Logger logger = LoggerFactory.getLogger(CQSSCTask.class);
    private int countSum = 0;

    @Autowired
    private LotteryHF_SSCService service;

//    @Scheduled(fixedRate = 5000)        //fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
    @Scheduled(cron = "0 0 3 1/1 * ? ")//每天3点运行一次
    public void saveBatchLotteryTask() {
        logger.info("重庆时时彩一天运行一次.....运行时间[{}].",new Date());
        service.saveBatchLotteryData();
    }

    @Scheduled(fixedRate = 5*60*1000)        //fixedRate = 5000表示当前方法开始执行5分钟后，Spring scheduling会再次调用该方法
    public void executeSaveObjectTask() {
        logger.info("重庆时时彩5分钟运行一次.....第[{}]次.",countSum++);
        service.saveLotteryData(LotteryTypeEnums.HF_CQSSC.getName());
    }

}
