package com.easyrent.controller;

import com.easyrent.pojo.ReturnResult;
import com.easyrent.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 首页轮播图展示
 */
@Controller
public class ContentController {
    @Autowired
    public ContentService contentService;

    @RequestMapping("/content")
    @ResponseBody
    public ReturnResult mainIndex(HttpServletRequest request) {
        ReturnResult returnResult = contentService.mainPage();
        return returnResult;
    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
