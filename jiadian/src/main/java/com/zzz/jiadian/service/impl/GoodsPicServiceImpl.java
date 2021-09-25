package com.zzz.jiadian.service.impl;

import com.zzz.jiadian.dao.GoodsPicDao;
import com.zzz.jiadian.entity.GoodsPic;
import com.zzz.jiadian.service.GoodsPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodsPicServiceImpl implements GoodsPicService {
    @Autowired
    GoodsPicDao goodsPicDao;
    @Override
    public ArrayList<GoodsPic> selectAll() {
        return goodsPicDao.selectAll();
    }
}
