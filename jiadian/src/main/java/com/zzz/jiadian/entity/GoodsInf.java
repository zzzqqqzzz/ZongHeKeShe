package com.zzz.jiadian.entity;

import java.util.Date;

public class GoodsInf {
    private int goodsInfId;
    private String name;
    private double price;
    private String color;
    private int inventory;
    private int limit;
    private String originAddress;
    private String supplier;
    private Date date;

    public int getGoodsInfId() {
        return goodsInfId;
    }

    public void setGoodsInfId(int goodsInfId) {
        this.goodsInfId = goodsInfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
}
