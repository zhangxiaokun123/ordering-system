package com.ly.orderingsystem.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "主页接口")
public class PageController {
    @RequestMapping("/hello")
    @ResponseBody
    public String page(){
        return "hello";
    }
}
