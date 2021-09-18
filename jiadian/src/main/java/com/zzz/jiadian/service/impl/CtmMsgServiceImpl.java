package com.zzz.jiadian.service.impl;


import com.zzz.jiadian.dao.CtmMsgDao;
import com.zzz.jiadian.entity.CtmMsg;
import com.zzz.jiadian.service.CtmMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CtmMsgServiceImpl implements CtmMsgService {

    @Autowired
    CtmMsgDao ctmMsgDao;

    @Override
    public int insertCtmMsg(CtmMsg ctmMsg) {
        return ctmMsgDao.insertCtmMsg(ctmMsg);
    }


}
