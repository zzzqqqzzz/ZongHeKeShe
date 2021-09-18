package com.zzz.jiadian.dao;

import com.zzz.jiadian.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface GoodsDao {
    ArrayList<Goods> selectAllGoods();
}
