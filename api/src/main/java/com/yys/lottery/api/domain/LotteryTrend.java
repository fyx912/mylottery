package com.yys.lottery.api.domain;

import com.yys.lottery.core.domain.LotteryHF;
import lombok.Data;

import java.util.List;

@Data
public class LotteryTrend {
    private List<LotteryHF> lotteryHF;
    private List<Integer> maxOmit;//最大遗漏值
    private List<Integer> avgOmit;//平均遗漏值
    private List<Integer> countOmit;//出现总次数
    private List<Integer> maxContinuous;//最大连出值

}
