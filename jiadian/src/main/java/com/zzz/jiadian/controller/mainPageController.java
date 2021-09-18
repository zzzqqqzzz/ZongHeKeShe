package com.zzz.jiadian.controller;

import com.zzz.jiadian.annotations.PassToken;
import com.zzz.jiadian.entity.Goods;
import com.zzz.jiadian.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class mainPageController {
    @Autowired
    GoodsServiceImpl goodsService;

    @PassToken
    @GetMapping("/getGoods")
    public Map getGoods(){
        Map<String,Object> resultMap = new HashMap<>(1);
        ArrayList<Goods> goodsList = goodsService.selectAllGoods();
        resultMap.put("goods",goodsList);
        return resultMap;
    }
}
