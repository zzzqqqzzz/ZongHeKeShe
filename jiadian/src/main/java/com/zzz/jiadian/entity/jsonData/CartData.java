package com.zzz.jiadian.entity.jsonData;

import com.zzz.jiadian.entity.Cart;

public class CartData {
    private Cart cart;
    private Integer[] ids;
    private Integer id;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
