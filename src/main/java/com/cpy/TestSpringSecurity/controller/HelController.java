package com.cpy.TestSpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelController {

    @RequestMapping(value = "/hello")
    @ResponseBody//返回json数据
    public String showHel(){
        return "hello world";
    }

}
