package com.zzz.jiadian.controller;

import com.zzz.jiadian.annotations.UserLoginToken;
import com.zzz.jiadian.config.TokenUtil;
import com.zzz.jiadian.dao.UserDao;
import com.zzz.jiadian.entity.Cart;
import com.zzz.jiadian.entity.GoodsInf;
import com.zzz.jiadian.entity.Picture;
import com.zzz.jiadian.entity.User;
import com.zzz.jiadian.entity.jsonData.CartData;
import com.zzz.jiadian.service.PictureService;
import com.zzz.jiadian.service.impl.CartServiceImpl;
import com.zzz.jiadian.service.impl.GoodsInfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goodsInf")
public class GoodsInfController {
    @Autowired
    GoodsInfServiceImpl goodsInfService;
    @Autowired
    PictureService pictureService;
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    UserDao userDao;

    @GetMapping("/getDetailedMsg")
    public Map getDetailedMsg(int gid){
        Map<String,Object> resultMap = new HashMap<>(2);
        GoodsInf goodsInf = goodsInfService.getGoodsInfByGid(gid);
        ArrayList<Picture> pictures = pictureService.selectPictureByGid(gid);

        resultMap.put("goodsInf",goodsInf);
        resultMap.put("pictures",pictures);
        return resultMap;
    }

    @UserLoginToken
    @PostMapping("/addCart")
    public Map addCart(@RequestBody CartData cartData){
        Map<String,Object> resultMap = new HashMap<>();
        String username = TokenUtil.getUserNameByToken(httpServletRequest.getHeader("token"));

        User user = userDao.getUserByName(username);
        Cart cart = cartData.getCart();

        if(cartService.selectByUidAndGoodsInfId(user.getUid(),cart.getGoodsInfId())==null){
            cart.setUid(user.getUid());
            cartService.inertCart(cart);

            resultMap.put("success",true);
            resultMap.put("msg","成功加入购物车！");

            return resultMap;
        }else {
            resultMap.put("success",false);
            resultMap.put("msg","已经加入购物车，请勿重复加入");

            return resultMap;
        }
    }



}
