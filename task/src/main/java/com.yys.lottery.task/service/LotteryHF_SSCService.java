package com.yys.lottery.task.service;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.task.data.LotteryCQSSCData;
import com.yys.lottery.task.domain.LotteryHF;
import com.yys.lottery.task.domain.LotteryHF_SSC;
import com.yys.lottery.task.mapper.LotteryHFMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LotteryHF_SSCService {
    private Logger logger = LoggerFactory.getLogger(LotteryHF_SSCService.class);

    @Autowired
    private LotteryHFMapper sscMapper;

    /**
     * 获取最大planNo，当编号为null 则设置默认为1
     * @param lotteryType
     * @return
     */
    public Integer getMaxPlanNo(String lotteryType){
        Integer planNo = sscMapper.getMaxPlanNo(lotteryType);
        if (planNo!=null){
            return planNo;
        }
        return 0;
    }

    /**
     * 判断彩票期号是否存在
     * @param lotteryType  彩种
     * @param lotteryNo    期号
     * @return
     */
    public boolean existsLotteryNo(String lotteryType,String lotteryNo){
        LotteryHF lottery = sscMapper.findOneObject(lotteryType,lotteryNo);
        if (lottery!=null){
            return true;
        }
        return false;
    }

    /**
     * 批量插入重庆时时彩数据
     */
    public void  saveBatchLotteryData(){
        String lotteryType ="cqssc";
        List<LotteryHF> result = null;
        List<LotteryHF> cqsscData = new LotteryCQSSCData().getCQSSCData();
        if (cqsscData!=null){
            List<String> list = sscMapper.getLotteryNoByDate(lotteryType);
            if (list !=null){
                Collections.sort(list);
                for (int i = 0; i <list.size(); i++) {
                    for (int j = 0; j <cqsscData.size() ; j++) {
                        if (list.get(i).equals(cqsscData.get(j).getLotteryNo())){
                            cqsscData.remove(j);
                            break;
                        }
                    }
                }
            }
            logger.info(" 获取重庆时时彩去除已经存在之后的数据: size[{}],json[{}]",cqsscData.size(),JSONObject.toJSON(cqsscData));
            if (cqsscData!=null&&cqsscData.size()>0){
                Integer planNo = this.getMaxPlanNo(lotteryType);
                planNo++;
                result = new ArrayList<>();
                LotteryHF ssc = null;
                for (int i = 0; i < cqsscData.size(); i++) {
                    ssc = new LotteryHF();
                    ssc = cqsscData.get(i);
                    ssc.setPlanNo(planNo);
                    result.add(ssc);
                    planNo++;
                }
                sscMapper.InsertBatchObject(lotteryType,result);
            }
        }
    }

    /**
     * 保存开奖数据
     */
    public void saveLotteryData(String lotteryType){
        LotteryHF  lotteryData = new LotteryCQSSCData().getObject();
        if (lotteryData!=null){
            if (!existsLotteryNo(lotteryType,lotteryData.getLotteryNo())){
                lotteryData.setPlanNo(this.getMaxPlanNo(lotteryType)+1);
               Integer idValue =  sscMapper.InsertObject(lotteryType,lotteryData);
               if (idValue!=null){
                   logger.info("Data Save Success!Data:[{}]",JSONObject.toJSON(lotteryData));
               }else {
                   logger.error("Can't Save Data Failed! Because :[],Data[{}]",idValue,JSONObject.toJSON(lotteryData));
                   logger.info("Can't Save Data Failed! Because :[],Data[{}]",JSONObject.toJSON(lotteryData));
               }
            }else {
                logger.info("Data already has:[{}]",JSONObject.toJSON(lotteryData));
            }
        }
    }

}
