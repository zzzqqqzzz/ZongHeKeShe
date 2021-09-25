package com.zzz.jiadian.service;

import com.zzz.jiadian.entity.Cart;

import java.util.ArrayList;

public interface CartService {

    int inertCart(Cart cart);

    Cart selectByUidAndGoodsInfId(int uid,int goodsInfId);

    ArrayList<Cart> selectByUid(int uid);

    int deleteCartById(int id);

    int deleteCartByIds(int[] id);
}
