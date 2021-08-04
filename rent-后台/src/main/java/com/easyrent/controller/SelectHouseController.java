package com.easyrent.controller;

import com.easyrent.pojo.ReturnResult;
import com.easyrent.service.SelectHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 搜索房屋
 */
@Controller
public class SelectHouseController {
    @Autowired
    SelectHouseService selectHouseService;
    //条件查找房源

    /**
     *
     * @param location
     * @param qhouseaddress
     * @param qhouserent
     * @param qhousebed
     * @param qhousedescribe
     * @param qhousetype
     * @param pagecount
     * @return
     */
    @GetMapping("/searchdefault")
    @ResponseBody
    public ReturnResult selectDefault(String location,String qhouseaddress,String qhouserent,String qhousebed,String qhousedescribe, String qhousetype,@RequestParam(defaultValue = "1") int pagecount){
        System.out.println("controller get:"+qhouseaddress);
        return selectHouseService.searchDefault(qhouseaddress,qhouserent,qhousebed,qhousedescribe,qhousetype,pagecount,5);
    }

    /**
     * 根据房源id获取房源详情
     * @param houseid
     * @return
     */
    @GetMapping("/house/{houseid}")
    @ResponseBody
    public ReturnResult getHouseinformation(@PathVariable("houseid") String houseid){
        return  selectHouseService.searchHsouseByid(houseid);
    }

    /**
     * 房东查询自己的房源
     * @param account
     * @param pagecount
     * @param pagesize
     * @return
     */
    @GetMapping("/myhouse")
    @ResponseBody
    public ReturnResult searchMyHouse(@RequestParam("account") String account,@RequestParam(defaultValue = "1") int pagecount,@RequestParam(value = "pagesize",defaultValue = "5") int pagesize){
        if (pagecount == 0)pagecount=1;
        return selectHouseService.searchHouseByAccount(account,pagecount,pagesize);
    }

    /**
     *
     * @param location
     * @param qhouseaddress
     * @param qhouserent
     * @param qhousebed
     * @param qhousedescribe
     * @param qhousetype
     * @param pagecount
     * @param order
     * @return
     */
    @GetMapping("/searchrent")
    @ResponseBody
    public ReturnResult selectRent(String location,String qhouseaddress,String qhouserent,String qhousebed,String qhousedescribe, String qhousetype,int pagecount,int order){
        String orderWay = "DESC";
        if (order==0)orderWay="DESC";
        else orderWay="ASC";
        return selectHouseService.searchRent(qhouseaddress,qhouserent,qhousebed,qhousedescribe,qhousetype,pagecount,5,orderWay);
    }

    /**
     *
     * @param location
     * @param qhouseaddress
     * @param qhouserent
     * @param qhousebed
     * @param qhousedescribe
     * @param qhousetype
     * @param pagecount
     * @param order
     * @return
     */
    @GetMapping("/searcharea")
    @ResponseBody
    public ReturnResult selectArea(String location,String qhouseaddress,String qhouserent,String qhousebed,String qhousedescribe, String qhousetype,int pagecount,int order){
        String orderWay = "DESC";
        if (order==0)orderWay="DESC";
        else orderWay="ASC";
        return selectHouseService.searchArea(qhouseaddress,qhouserent,qhousebed,qhousedescribe,qhousetype,pagecount,5,orderWay);
    }
}
