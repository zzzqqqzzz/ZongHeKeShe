package com.zzz.jiadian.service;

import com.zzz.jiadian.entity.User;

import java.util.ArrayList;

public interface UserService {
     int insertUser(User user);
     User selectUser(User user);
     ArrayList<User> selectAll();
     User getUser(int uid);
     User getUserByName(String username);

}
