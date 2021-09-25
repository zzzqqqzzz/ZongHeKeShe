package com.zzz.jiadian.service.impl;

import com.zzz.jiadian.dao.GoodsInfDao;
import com.zzz.jiadian.entity.GoodsInf;
import com.zzz.jiadian.service.GoodsInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsInfServiceImpl implements GoodsInfService {
    @Autowired
    GoodsInfDao goodsInfDao;
    @Override
    public GoodsInf getGoodsInfByGid(int gid) {
        return goodsInfDao.getGoodsInfByGid(gid);
    }
}
