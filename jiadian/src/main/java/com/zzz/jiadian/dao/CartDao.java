package com.zzz.jiadian.dao;


import com.zzz.jiadian.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface CartDao {

    int insertCart(Cart cart);
    Cart selectByUidAndGoodsInfId(@Param("uid") int uid,@Param("goodsInfId") int goodsInfId);
    ArrayList<Cart> selectByUid(int uid);
    int deleteCartById(int id);
    int deleteCartByIds(int[] id);

}
