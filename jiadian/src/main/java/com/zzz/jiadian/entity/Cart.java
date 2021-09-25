package com.zzz.jiadian.entity;

public class Cart {
    private int cartId;
    private int uid;
    private int goodsInfId;
    private int num;
    //单价
    private double price;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGoodsInfId() {
        return goodsInfId;
    }

    public void setGoodsInfId(int goodsInfId) {
        this.goodsInfId = goodsInfId;
    }

}
