package com.yys.test;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.api.ApiMain;
import com.yys.lottery.api.miles.mapper.MilesMapper;
import com.yys.lottery.api.service.LotteryMilesService;
import com.yys.lottery.core.domain.LotteryHF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiMain.class)
public class MilesLottery {
    @Autowired
    LotteryMilesService milesMapper;

    @Test
    public void test(){
      List<LotteryHF> lotteryHFList = milesMapper.getTrendData("",1,10);
      System.out.println(JSONObject.toJSON(lotteryHFList));
    }
}
