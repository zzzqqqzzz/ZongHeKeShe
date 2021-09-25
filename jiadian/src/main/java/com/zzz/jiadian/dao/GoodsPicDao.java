package com.zzz.jiadian.dao;


import com.zzz.jiadian.entity.GoodsPic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface GoodsPicDao {
    ArrayList<GoodsPic> selectAll();
}
