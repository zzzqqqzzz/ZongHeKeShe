package com.zzz.jiadian.service.impl;

import com.zzz.jiadian.dao.PictureDao;
import com.zzz.jiadian.entity.Picture;
import com.zzz.jiadian.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao pictureDao;


    @Override
    public Picture selectPictureById(int pid) {
        return pictureDao.selectPictureById(pid);
    }

    @Override
    public ArrayList<Picture> selectPictureByGid(int gid) {
        return pictureDao.selectPictureByGid(gid);
    }
}
