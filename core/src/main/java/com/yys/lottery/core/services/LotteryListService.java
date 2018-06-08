package com.yys.lottery.core.services;

import com.yys.lottery.core.dao.mapper.LotteryListMapper;
import com.yys.lottery.core.domain.LotteryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryListService {

    @Autowired
    private LotteryListMapper listMapper;

    public List<LotteryList> getAll(){
        System.out.println(" core service....");
        return  listMapper.getAll();
    }
}
