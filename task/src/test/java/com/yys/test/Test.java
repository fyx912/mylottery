package com.yys.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.core.dao.mapper.LotteryListMapper;
import com.yys.lottery.task.common.CommonURL;
import com.yys.lottery.task.common.HttpClientUtils;
import com.yys.lottery.task.common.LotteryTypeEnums;
import com.yys.lottery.task.data.LotteryCQSSCData;
import com.yys.lottery.task.data.LotteryHFData;
import com.yys.lottery.core.domain.LotteryHF;
import com.yys.lottery.core.domain.LotteryList;
import com.yys.lottery.task.TaskMain;
import com.yys.lottery.task.mapper.LotteryTaskHFMapper;
import com.yys.lottery.task.service.LotteryHFTaskService;
import com.yys.lottery.task.service.LotteryHF_SSCService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaskMain.class)
public class Test {

    @Autowired
    private LotteryListMapper mapper;

    @Autowired
    private LotteryTaskHFMapper sscMapper;

    @Autowired
    private LotteryHF_SSCService sscService;

    @Autowired
    private LotteryHFTaskService hfService;

   @Autowired
   private CommonURL commonURL;

    @org.junit.Test
    public void getLotteryList(){
        List<LotteryList> list= mapper.getAll();
        System.out.println(JSONObject.toJSON(list));
        Integer planNo = sscService.getMaxPlanNo("cqssc");
        System.out.println("planNo:"+planNo);
    }

    @org.junit.Test
    public void insetSSC(){
        LotteryCQSSCData cqsscTask = new LotteryCQSSCData();
        List<LotteryHF> list = cqsscTask.getCQSSCData(commonURL.getHf_url());
//        sscMapper.InsertObject("cqssc",list.get(0));
        sscMapper.InsertBatchObject("cqssc",list);
    }


    @org.junit.Test
    public void getLotteryNo(){
//        List<String> list =   sscMapper.getLotteryNoByDate("cqssc");
//        System.out.println(JSONObject.toJSON(list));

//        sscService.saveBatchLotteryData();

//        sscService.saveLotteryData(LotteryTypeEnums.HF_CQSSC.getName());
        hfService.saveLotteryData();

    }
    @org.junit.Test
    public void  test(){
        LotteryHFData hfData = new LotteryHFData();
        System.out.println(commonURL.getHf_url());
        System.out.println(hfData.getLotteryHFLastDate(commonURL.getHf_url()));
    }




    public static void main(String[] args){
        String cqsscUrl = "https://1233caipiao.com/results?gameUniqueId=HF_CQSSC";
        String cqsscResultsUrl = "https://1233caipiao.com/api/v1/result/service/mobile/results/hist/HF_CQSSC?limit=100";
        String result =  HttpClientUtils.getMethod(cqsscResultsUrl);
//        Document doc = Jsoup.parse(result);
//
//        Element bodyElement = doc.body();
        JSONArray jsonArray =  JSONArray.parseArray(result);
        System.out.println(jsonArray);


        String lastOpenUrl = "https://1233caipiao.com/api/v1/result/service/mobile/results/lastOpen";
        String lastResult =  HttpClientUtils.getMethod(lastOpenUrl);
        JSONArray lastJsonArray =  JSONArray.parseArray(lastResult);
        System.out.println(lastJsonArray);
        for (int i = 0; i < lastJsonArray.size(); i++) {
//            JSONObject jsonObject = lastJsonArray.getJSONObject(i);
//            jsonObject.getString("gameUniqueId");
//            jsonObject.getString("openCode");
//            jsonObject.getString("gameNameInChinese");
//            jsonObject.getDate("officialOpenTime");
//            jsonObject.getDate("nextOfficialOpenTime");
//            jsonObject.getDate("nextStopOrderTime");
            System.out.println(lastJsonArray.getJSONObject(i));
        }
        System.out.println(LotteryTypeEnums.HF_CQSSC.getName()+"\t"+LotteryTypeEnums.HF_CQSSC.getDescr()+"\t"+
        LotteryTypeEnums.getByName("重庆时时彩"));
    }
}
