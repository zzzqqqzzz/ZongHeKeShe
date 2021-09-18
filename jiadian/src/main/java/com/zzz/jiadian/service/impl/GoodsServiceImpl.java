package com.zzz.jiadian.service.impl;

import com.zzz.jiadian.dao.GoodsDao;
import com.zzz.jiadian.entity.Goods;
import com.zzz.jiadian.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao dao;


    @Override
    public ArrayList<Goods> selectAllGoods() {
        return dao.selectAllGoods();
    }
}
