package com.yys.lottery.task;

import com.yys.lottery.task.common.DateTimeFormat;
import com.yys.lottery.task.service.LotteryHFTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
@Order(value = 1)
public class TaskApplicationRunner implements ApplicationRunner {
    @Autowired
    private LotteryHFTaskService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("高频彩票初始化运行......runTime[{}]",DateTimeFormat.forMatDate(new Date()));
        String[] type = new String[]{
                "HF_CQSSC","HF_FFSSC","HF_XJSSC","HF_LFSSC","HF_TJSSC",
                "HF_BJPK10","HF_FFPK10","HF_LFPK10",
                "HF_LF28","HF_BJ28",
                "HF_AHD11","HF_GDD11","HF_JXD11","HF_SDD11","HF_SHD11","HF_FJD11",
                "HF_BJK3","HF_AHK3","HF_GXK3","HF_JSK3","HF_BJK3","HF_JLK3","HF_LFK3","HF_FFK3",
                "HF_GDKL10F","HF_CQKL10F","HF_SHSSL","HF_LFKLPK","HF_XYFT","HF_XYSM","HF_JSMS"
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < type.length; i++) {
            String index = type[i];
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("初始化数据...[{}]",index);
                    service.saveBatchAllLotteryData(index);
                    try {
                        new Thread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        log.info("初始化完成....end,耗时[{}]",(System.currentTimeMillis()-startTime));
        pool.shutdown();
    }
}
