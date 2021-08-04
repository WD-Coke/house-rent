package com.easyrent.utils;

import com.easyrent.pojo.HouseSearchResult;
import com.easyrent.pojo.ReturnResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PagesUtils {
    public static ReturnResult infoResult(List list){

        PageInfo pageInfo = new PageInfo(list);
        List resultList = pageInfo.getList();
        HouseSearchResult houseSearchResult =new HouseSearchResult();
        houseSearchResult.setSize((int)pageInfo.getTotal());
        houseSearchResult.setData(resultList);
        return new ReturnResult("查询成功","200",houseSearchResult);
    }
}
