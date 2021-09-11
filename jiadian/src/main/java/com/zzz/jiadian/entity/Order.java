package com.zzz.jiadian.entity;

public class Order {
    private int oid;
    private int toId;
    private GoodsInf goodsInf;
    private int num;
    private double price;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public GoodsInf getGoodsInf() {
        return goodsInf;
    }

    public void setGoodsInf(GoodsInf goodsInf) {
        this.goodsInf = goodsInf;
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
}
