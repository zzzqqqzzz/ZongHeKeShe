package com.zzz.jiadian.service.impl;

import com.zzz.jiadian.dao.CartResultDao;
import com.zzz.jiadian.entity.CartResult;
import com.zzz.jiadian.service.CartResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartResultServiceImpl implements CartResultService {
    @Autowired
    CartResultDao cartResultDao;

    @Override
    public ArrayList<CartResult> selectByUid(int uid) {
        return cartResultDao.selectByUid(uid);
    }
}
