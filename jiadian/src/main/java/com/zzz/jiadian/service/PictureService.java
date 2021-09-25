package com.zzz.jiadian.service;

import com.zzz.jiadian.entity.Picture;

import java.util.ArrayList;

public interface PictureService {

    Picture selectPictureById(int id);

    ArrayList<Picture> selectPictureByGid(int gid);

}
