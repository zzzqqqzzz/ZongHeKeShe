package com.zzz.jiadian.dao;

import com.zzz.jiadian.entity.CtmMsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CtmMsgDao {
    int insertCtmMsg(CtmMsg ctmMsg);

}
