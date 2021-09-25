package com.zzz.jiadian.dao;


import com.zzz.jiadian.entity.GoodsInf;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsInfDao {
    GoodsInf getGoodsInfByGid(int gid);
}
