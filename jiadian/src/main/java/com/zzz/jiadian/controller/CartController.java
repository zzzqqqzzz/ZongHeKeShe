package com.zzz.jiadian.controller;


import com.zzz.jiadian.annotations.UserLoginToken;
import com.zzz.jiadian.config.TokenUtil;
import com.zzz.jiadian.dao.UserDao;
import com.zzz.jiadian.entity.Cart;
import com.zzz.jiadian.entity.CartResult;
import com.zzz.jiadian.entity.Picture;
import com.zzz.jiadian.entity.User;
import com.zzz.jiadian.entity.jsonData.CartData;
import com.zzz.jiadian.service.CartResultService;
import com.zzz.jiadian.service.CartService;
import com.zzz.jiadian.service.GoodsInfService;
import com.zzz.jiadian.service.PictureService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService ;
    @Autowired
    PictureService pictureService;
    @Autowired
    GoodsInfService goodsInfService;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    UserDao userDao;
    @Autowired
    CartResultService cartResultService;


    @UserLoginToken
    @PostMapping("/getCartTable")
    public Map selectCartTable(){
        Map<String,Object> resultMap = new HashMap<>();
        String username = TokenUtil.getUserNameByToken(httpServletRequest.getHeader("token"));

        User user = userDao.getUserByName(username);
        ArrayList<CartResult> carts = cartResultService.selectByUid(user.getUid());

        resultMap.put("success",true);
        resultMap.put("cart",carts);

        return resultMap;
    }

    @UserLoginToken
    @PostMapping("/deleteCart")
    public Map deleteCart(@RequestBody CartData cartData){
        Map<String,Object> resultMap = new HashMap<>();

        if(cartService.deleteCartById(cartData.getId())!=0){
            resultMap.put("success",true);
            resultMap.put("msg","删除成功");
        }
        else {
            resultMap.put("success",false);
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    @UserLoginToken
    @PostMapping("/deleteCarts")
    public Map deleteCarts(@RequestBody CartData cartData){
        Map<String,Object> resultMap = new HashMap<>();
        Integer[] ids = cartData.getIds();
        int[] id = new int[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i] = ids[i].intValue();
        }
        if(cartService.deleteCartByIds(id)!=0){
            resultMap.put("success",true);
            resultMap.put("msg","删除成功");
        }
        else {
            resultMap.put("success",false);
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

}
