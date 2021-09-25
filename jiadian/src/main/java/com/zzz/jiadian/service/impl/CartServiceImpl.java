package com.zzz.jiadian.service.impl;

import com.zzz.jiadian.dao.CartDao;
import com.zzz.jiadian.entity.Cart;
import com.zzz.jiadian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao dao;

    @Override
    public int inertCart(Cart cart) {
        return dao.insertCart(cart);
    }

    @Override
    public Cart selectByUidAndGoodsInfId(int uid, int goodsInfId) {
        return dao.selectByUidAndGoodsInfId(uid,goodsInfId);
    }

    @Override
    public ArrayList<Cart> selectByUid(int uid) {
        return dao.selectByUid(uid);
    }

    @Override
    public int deleteCartById(int id) {
        return dao.deleteCartById(id);
    }

    @Override
    public int deleteCartByIds(int[] id) {
        return dao.deleteCartByIds(id);
    }
}
