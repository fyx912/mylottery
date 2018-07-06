package com.yys.lottery.core.services;

import com.yys.lottery.core.dao.mapper.LotteryListMapper;
import com.yys.lottery.core.domain.LotteryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryListService {

    @Autowired
    private LotteryListMapper listMapper;

    @Cacheable("lottery.type.list")
    public List<LotteryList> getAll(){
        return  listMapper.getAll();
    }

    @Cacheable("lottery.type.list.hf")
    public List<LotteryList>  findLotteryHFAll(){
        return  listMapper.getLotteryHFAll();
    }


    @Cacheable("lottery.type.exists")
    public boolean typeExists(String lotteryType){
        List<LotteryList> list = this.getAll();
        for (LotteryList lotteryList:list){
            if (lotteryList.getLotteryId().equalsIgnoreCase(lotteryType)){
                return true;
            }
        }
        return false;
    }

}
