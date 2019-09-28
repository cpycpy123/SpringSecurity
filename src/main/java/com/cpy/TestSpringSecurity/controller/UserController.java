package com.cpy.TestSpringSecurity.controller;

import com.cpy.TestSpringSecurity.pojo.User;
import com.cpy.TestSpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/info")
    @ResponseBody
    public User selectUser(){
        return userService.selectUserByUsername("cpy ");
    }

}
