package com.zzz.jiadian.service.impl;


import com.zzz.jiadian.dao.UserDao;
import com.zzz.jiadian.entity.User;
import com.zzz.jiadian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User selectUser(User user) {
        return userDao.selectUser(user);
    }

    @Override
    public ArrayList<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User getUser(int uid) {
        return userDao.getUser(uid);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
