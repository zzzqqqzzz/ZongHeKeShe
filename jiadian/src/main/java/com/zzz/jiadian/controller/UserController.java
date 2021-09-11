package com.zzz.jiadian.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzz.jiadian.annotations.PassToken;
import com.zzz.jiadian.annotations.UserLoginToken;
import com.zzz.jiadian.config.TokenUtil;
import com.zzz.jiadian.entity.User;
import com.zzz.jiadian.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/selectAll")
    public ArrayList<User> selectAll(){
        return userService.selectAll();
    }

    @PassToken
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login() throws JsonProcessingException {
        User user = new User();
        user.setUsername("11");
        user.setPassword("11");
        User userforbase =  userService.getUserByName(user.getUsername());


        if(userforbase==null){
            return objectMapper.writeValueAsString("登录失败，用户不存在");
        }
        if(!userforbase.getPassword().equals(user.getPassword())){
            return objectMapper.writeValueAsString("登录失败，密码错误");
        }
        String token = TokenUtil.getToken(userforbase);
        return token;
    }

    @UserLoginToken
    @RequestMapping("/getmessage")
    public String getmessage() throws JsonProcessingException {
        return objectMapper.writeValueAsString("你已经通过验证");
    }
}
