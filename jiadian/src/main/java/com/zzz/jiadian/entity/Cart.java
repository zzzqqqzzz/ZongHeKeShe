package com.zzz.jiadian.entity;

public class Cart {
    private int cratId;
    private int cid;
    private GoodsInf goodsInf;
    private int num;
    private double price;

    public int getCratId() {
        return cratId;
    }

    public void setCratId(int cratId) {
        this.cratId = cratId;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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
