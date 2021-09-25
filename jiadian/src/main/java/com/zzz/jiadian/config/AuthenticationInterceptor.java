package com.zzz.jiadian.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzz.jiadian.annotations.PassToken;
import com.zzz.jiadian.annotations.UserLoginToken;
import com.zzz.jiadian.entity.User;
import com.zzz.jiadian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Expression;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入方法之前进行的操作
        //获取token
        String token  =  request.getHeader("token");
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(PassToken.class))
        {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        String username = null;
        if(method.isAnnotationPresent(UserLoginToken.class))
        {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            Map<String,Object> map = new HashMap<>(2);
            ObjectMapper objectMapper = new ObjectMapper();
            if(userLoginToken.required()){
                if(token == null||token.equals("null")){
                    map.put("success",false);
                    map.put("msg","无token，请重新登录");
                    PrintWriter out = response.getWriter();
                    out.append(objectMapper.writeValueAsString(map));
                    return false;
                }
                //获取token的username
                username = TokenUtil.getUserNameByToken(token);
                User user = userService.getUserByName(username);
                if(user==null){
                    map.put("success",false);
                    map.put("msg","用户不存在");
                    PrintWriter out = response.getWriter();
                    out.append(objectMapper.writeValueAsString(map));
                    return false;
                }
                //验证token
                if(!TokenUtil.verify(token,user)){
                    map.put("success",false);
                    map.put("msg","token验证失败或登录已过期,请重新登录");
                    PrintWriter out = response.getWriter();
                    out.append(objectMapper.writeValueAsString(map));
                    return false;
                }


                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //方法处理之后但是并未渲染视图的时候进行的操作
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //渲染视图之后进行的操作
    }

}
