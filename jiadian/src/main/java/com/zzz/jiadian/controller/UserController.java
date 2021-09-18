package com.zzz.jiadian.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzz.jiadian.annotations.PassToken;
import com.zzz.jiadian.annotations.UserLoginToken;
import com.zzz.jiadian.config.TokenUtil;
import com.zzz.jiadian.entity.CtmMsg;
import com.zzz.jiadian.entity.jsonData.LoginData;
import com.zzz.jiadian.entity.User;
import com.zzz.jiadian.entity.jsonData.RegisterData;
import com.zzz.jiadian.service.impl.CtmMsgServiceImpl;
import com.zzz.jiadian.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CtmMsgServiceImpl ctmMsgService;

    @PostMapping("/selectAll")
    public ArrayList<User> selectAll(){
        return userService.selectAll();
    }

    @PassToken
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(@RequestBody LoginData loginData) throws JsonProcessingException {

        User user = loginData.getUser();
        User userforbase =  userService.getUserByName(user.getUsername());
        Map<String,Object> resultMap = new HashMap<>(3);
        resultMap.put("success",false);

        if(userforbase==null){
            resultMap.put("msg","登录失败，用户不存在");
            return resultMap;
        }
        if(!userforbase.getPassword().equals(user.getPassword())){
            resultMap.put("msg","登录失败，密码错误");
            return resultMap;
        }
        //验证成功生成token
        resultMap.put("success",true);
        String token = TokenUtil.getToken(userforbase);
        resultMap.put("token",token);
        resultMap.put("msg",userforbase.getUsername());
        return resultMap;
    }

    @UserLoginToken
    @RequestMapping(value = "/getmessage",method = RequestMethod.POST)
    public String getmessage() throws JsonProcessingException {
        return objectMapper.writeValueAsString("你已经通过验证");
    }

    @PassToken
    @PostMapping("/checkUsername")
    public Map checkUsername(@RequestBody RegisterData registerData){
        Map<String,Object> resultMap = new HashMap<>(1);
        String username = registerData.getUser().getUsername();
        if(username!=null&&!username.equals("")&&userService.getUserByName(username) == null){
            resultMap.put("success",true);
        }
        else
            resultMap.put("success",false);
        return resultMap;
    }



    /**
     * 注册
     * @param registerData
     * @return
     */
    @PassToken
    @PostMapping("/register")
    public Map register(@RequestBody RegisterData registerData){
        Map<String,Object> resultMap = new HashMap<>(2);
        User user = registerData.getUser();
        CtmMsg ctmMsg = registerData.getCtmMsg();

        if(userService.getUserByName(user.getUsername()) == null){
            //新用户，开始注册
            userService.insertUser(user);
            //拿到uid
            int uid = userService.getUserByName(user.getUsername()).getUid();
            ctmMsg.setUid(uid);
            //记录用户详细信息
            ctmMsgService.insertCtmMsg(ctmMsg);
            resultMap.put("success",true);
            resultMap.put("msg","注册成功！");
        }
        else {
            resultMap.put("success",false);
            resultMap.put("msg","注册失败，请按要求填写信息");
        }
        return resultMap;
    }
}
