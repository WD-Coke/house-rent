package com.easyrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误页跳转
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("404")
    public String error404(){
        return "error404";
    }
    @RequestMapping("500")
    public String error500(){

        System.out.println(500);
        return "error500";
    }
}
