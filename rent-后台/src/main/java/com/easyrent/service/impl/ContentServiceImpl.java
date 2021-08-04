package com.easyrent.service.impl;

import com.easyrent.mapper.ContentMapper;
import com.easyrent.pojo.Content;
import com.easyrent.pojo.ContentExample;
import com.easyrent.pojo.ReturnResult;
import com.easyrent.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    /**
     * 获取首页轮播图信息
     * @return
     */
    @Override
    public ReturnResult mainPage() {
        List<Content> contents = contentMapper.selectByExample(new ContentExample());
        int count = contents.size();
        ReturnResult returnResult = new ReturnResult();
        returnResult.setData(contents);
        returnResult.setStatus("200");
        returnResult.setMessage("加载成功");
        return returnResult;
    }
}
