package com.nxj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nxj.entity.User;
import com.nxj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController  {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        logger.info("登录页面");
        return "login.html";
    }

/*    @RequestMapping(value = "/user/login")
    public String login(String username, String passwd) {
        logger.info("用户名：" + username + "密码：" + passwd);

        User user = userService.selectByUserName(username);
        if(user != null && user.getPasswd().equals(passwd)) {
            return "redirect:/home";
        }else {
            return "redirect:/index";
        }
    }*/

/*    @RequestMapping(value = "/user/login")
    public String login(String jsonstr) {
        JSONObject jsonObject = JSON.parseObject(jsonstr);
        String username = jsonObject.getString("username");
        String passwd = jsonObject.getString("passwd");
        logger.info("用户名：" + username + "密码：" + passwd);
        User user = userService.selectByUserName(username);
        if(user == null) {
            return "用户名不存在";
        }else if(user.getPasswd().equals(passwd)) {
//            return "redirect:/home";
            return "success";
        }else {
            return "密码错误";
        }
    }*/


    @RequestMapping(value = "/user/login")
    public String login(User user) {
        String username = user.getUsername();
        String passwd = user.getPasswd();
        logger.info("用户名：" + username + "密码：" + passwd);

        User user2 = userService.selectByUserName(username);
        if(user2 != null && user2.getPasswd().equals(passwd)) {
            return "redirect:/home";
        }else {
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/home")
    public String home() {
        logger.info("后台管理——首页");
        return "index.html";
    }

}
