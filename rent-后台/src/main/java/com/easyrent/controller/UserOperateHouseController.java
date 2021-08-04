package com.easyrent.controller;

import com.easyrent.pojo.House;
import com.easyrent.pojo.ReturnResult;
import com.easyrent.service.SelectHouseService;
import com.easyrent.service.UpdateHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 房东操作房屋
 */
@Controller
public class UserOperateHouseController {
    @Autowired
    SelectHouseService selectHouseService;
    @Autowired
    UpdateHouseService updateHouseService;

    /**
     * 房东查看自己的房屋
     * @param account 房东id
     * @param pagesize 页面大小
     * @param pagecount 当前页面
     * @return
     */
    @GetMapping("/myhouse/{accountid}")
    @ResponseBody
    public ReturnResult searchMyHosue(@PathVariable(value = "accountid") String account, @RequestParam(defaultValue = "5") int pagesize, @RequestParam(defaultValue = "1") int pagecount){
        return selectHouseService.searchHouseByAccount(account,pagecount,pagesize);
    }

    /**
     * 创建房屋
     * @param house 房屋信息
     * @param file 房屋图片
     * @param request
     * @return
     */
    @PostMapping("/createhouse")
    @ResponseBody
    public ReturnResult createMyHosue(House house, MultipartFile[] file , HttpServletRequest request){
        Map parameterMap = request.getParameterMap();
        Set set = parameterMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println(next+"-->"+ parameterMap.get(next));
        }
        return  updateHouseService.createHouse(house,file);
    }

    /**
     * 修改房屋
     * @param house 房屋信息
     * @param file 房屋图片
     * @return
     */
    @PostMapping("/alerthouse")
    @ResponseBody
    public ReturnResult updateMyHouseByHouseId(House house,MultipartFile[] file){
        return  updateHouseService.updateHouseByHouseid(house,file);
    }

    /**
     * 删除房屋
     * @param houseid 房屋id
     * @return
     */
    @DeleteMapping("/deletemyhouse")
    @ResponseBody
    public ReturnResult deleteHouse(String houseid){
        System.out.println("houseid是:"+houseid);
        return  updateHouseService.deleteHouseByHouseid(houseid);
    }

}
