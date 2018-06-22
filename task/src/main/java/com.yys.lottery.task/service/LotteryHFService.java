package com.yys.lottery.task.service;

import com.alibaba.fastjson.JSONObject;
import com.yys.lottery.task.common.LotteryTypeEnums;
import com.yys.lottery.task.data.LotteryHFData;
import com.yys.lottery.task.domain.LotteryHF;
import com.yys.lottery.task.mapper.LotteryHFMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LotteryHFService {
    private Logger logger = LoggerFactory.getLogger(LotteryHFService.class);

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
     * @param lotteryType  (彩种)
     * @param lotteryNo 期号
     * @return
     */
    public boolean existsLotteryNo(String lotteryType ,String lotteryNo){
        boolean flag = false;
        if (StringUtils.isNotEmpty(lotteryType)&&StringUtils.isNotEmpty(lotteryNo)){
            LotteryHF lotteryHF = sscMapper.findOneObject(lotteryType,lotteryNo);
            if (lotteryHF!=null){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 保存所有高频彩票开奖数据
     */
    public void saveLotteryData(){
        List<LotteryHF> lotteryData = new LotteryHFData().getLotteryHFLastDate();
        if (lotteryData!=null){
            for (int i = 0; i < lotteryData.size(); i++) {
                LotteryHF lotteryHF =  lotteryData.get(i);
                if (!existsLotteryNo(lotteryHF.getLotteryType(),lotteryHF.getLotteryNo())){
                    String lotteryType = lotteryHF.getLotteryType();
                    lotteryHF.setPlanNo(this.getMaxPlanNo(lotteryType)+1);
                    Integer idValue =  sscMapper.InsertObject(lotteryType,lotteryHF);
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

    /**
     * 批量插入高频彩票数据
     * @param lotteryType 彩票类型
     */
    public void  saveBatchAllLotteryData(String lotteryType){
        if (lotteryType==null){
            lotteryType ="cqssc";
        }
        List<LotteryHF> result = null;
        List<LotteryHF> lotteryData = new LotteryHFData().getLotteryData(lotteryType);
        if (lotteryData!=null){
            LotteryTypeEnums typeEnum = LotteryTypeEnums.getByName(lotteryType);
            String type = typeEnum.getName();
            logger.info("开始批量获取[{}]数据....",type);
            List<String> lotteryNoList = sscMapper.getLotteryNoByDate(type);
            if (lotteryNoList != null){
                Collections.sort(lotteryNoList);
                for (int i = 0; i <lotteryNoList.size(); i++) {
                    for (int j = 0; j <lotteryData.size() ; j++) {
                        if (lotteryNoList.get(i).equals(lotteryData.get(j).getLotteryNo())){
                            lotteryData.remove(j);
                            break;
                        }
                    }
                }
            }
            logger.info("去重后数据大小:[{}]",lotteryData==null?0:lotteryData.size());
            if (lotteryData!=null&&lotteryData.size()>0){
                logger.info(" 初始化获取去重的数据:type[{}] size[{}],json[{}]",type,lotteryData.size(),JSONObject.toJSON(lotteryData));
                Integer planNo = this.getMaxPlanNo(type);
                planNo++;
                result = new ArrayList<>();
                LotteryHF ssc = null;
                for (int i = 0; i < lotteryData.size(); i++) {
                    ssc = new LotteryHF();
                    ssc = lotteryData.get(i);
                    ssc.setPlanNo(planNo);
                    result.add(ssc);
                    planNo++;
                }
                sscMapper.InsertBatchObject(type,result);
            }

            logger.info("批量获取[{}]数据....end",type);
        }
    }

}
