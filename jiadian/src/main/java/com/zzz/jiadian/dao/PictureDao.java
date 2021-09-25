package com.zzz.jiadian.dao;

import com.zzz.jiadian.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface PictureDao {

    Picture selectPictureById(int pid);

    ArrayList<Picture> selectPictureByGid(int gid);

}
