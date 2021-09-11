package com.zzz.jiadian.dao;

import com.zzz.jiadian.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Mapper
@Repository
public interface UserDao {

    int insertUser(User user);
    User selectUser(User user);
    ArrayList<User> selectAll();
    User getUser(int uid);
    User getUserByName(String username);
}
