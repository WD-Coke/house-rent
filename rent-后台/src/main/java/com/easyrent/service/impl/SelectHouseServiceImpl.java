package com.easyrent.service.impl;

import com.easyrent.mapper.HouseMapper;
import com.easyrent.pojo.*;
import com.easyrent.service.SelectHouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SelectHouseServiceImpl  implements SelectHouseService {
    @Autowired
    HouseMapper houseMapper;

    /**
     * 默认排序方式
     * @param houseaddress 房间地址
     * @param houserent 房间价格，格式为lower-higher
     * @param houseroom  卧室数量
     * @param pagecount 当前页面
     * @param pagesize  页面大小
     * @return
     */
    @Override
    public ReturnResult searchDefault(String houseaddress, String houserent, String houseroom,String housedescribe,String housetype, int pagecount, int pagesize) {
        System.out.println("service get:"+ houseaddress);
        if (!(houserent==null)&& houserent.length()!=0) {
            if (rent(houserent)!=null){
                return rent(houserent);
            }
        }
        HouseExample houseExample = sethouseExample(houseaddress,houserent,houseroom,housedescribe, housetype);

        return doSearch(houseExample,pagecount,pagesize) ;
    }

    /**
     * 按照租金排序
     * @param houseaddress 地址
     * @param houserent 价格
     * @param houseroom 居室大小
     * @param pagecount 当前页码
     * @param pagesize 页面大小
     * @param order 排序信息
     * @return
     */
    @Override
    public ReturnResult searchRent(String houseaddress, String houserent, String houseroom,String housedescribe,String housetype, int pagecount, int pagesize, String order) {
        if (!(houserent==null)) {
            if (rent(houserent)!=null){
                return rent(houserent);
            }
        }
        HouseExample houseExample = sethouseExample(houseaddress,houserent,houseroom,housedescribe,housetype);
        houseExample.setOrderByClause("houserent "+order);
        return doSearch(houseExample,pagecount,pagesize) ;
    }

    /**
     * 按照面积排序
     * @param houseaddress 地址
     * @param houserent 价格
     * @param houseroom 居室大小
     * @param pagecount 当前页码
     * @param pagesize 页面大小
     * @param order 排序信息
     * @return
     */
    @Override
    public ReturnResult searchArea(String houseaddress, String houserent, String houseroom,String housedescribe,String housetype, int pagecount, int pagesize, String order) {
        if (!(houserent==null)) {
            if (rent(houserent)!=null){
                return rent(houserent);
            }
        }
        HouseExample houseExample = sethouseExample(houseaddress,houserent,houseroom, housedescribe,housetype);
        houseExample.setOrderByClause("housearea "+order);
        return doSearch(houseExample,pagecount,pagesize) ;
    }

    /**
     * 根据房屋id查找房屋
     * @param houseid 房屋id
     * @return
     */
    @Override
    public ReturnResult searchHsouseByid(String houseid) {
        ReturnResult returnResult = new ReturnResult();
        House house = null;
        house = houseMapper.selectByPrimaryKey(houseid);
        if (house==null){
            returnResult.setMessage("未找到相关资源");
            returnResult.setStatus("404");
            return returnResult;
        }
        returnResult.setStatus("200");
        returnResult.setMessage("获取成功");
        returnResult.setData(house);
        return returnResult;
    }

    /**
     * 根据房东查找房屋
     * @param account 房东账号
     * @param pagecount 当前页码
     * @param pagesize 页面大小
     * @return
     */
    @Override
    public ReturnResult searchHouseByAccount(String account,int pagecount,int pagesize) {
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andHousestateNotEqualTo(3);
        criteria.andAccountEqualTo(account);
        houseExample.setOrderByClause("housecreate DESC");
        PageHelper.startPage(pagecount,pagesize);
        List<House> houses = houseMapper.selectByExample(houseExample);
        PageInfo pageInfo = new PageInfo(houses);
        HouseSearchResult houseSearchResult = new HouseSearchResult();
        houseSearchResult.setSize((int)pageInfo.getTotal());
        houseSearchResult.setData(houses);
       ReturnResult returnResult = new ReturnResult();
        returnResult.setMessage("查询成功");
        returnResult.setStatus("200");
        returnResult.setData(houseSearchResult);
        return  returnResult;

    }

    /***
     * 执行查询内容
     * @param houseExample 查询条件
     * @param pagecount 当前页码
     * @param pagesize 页面大小
     * @return
     */
    public ReturnResult doSearch(HouseExample houseExample,int pagecount, int pagesize){
        PageHelper.startPage(pagecount,pagesize);
        List<House> houses = houseMapper.selectByExample(houseExample);
        PageInfo pageInfo = new PageInfo(houses);
        List<HouseShort> houseShorts = new ArrayList<>();
        //逐条插入数据
        Iterator<House> iterator = houses.iterator();
        while (iterator.hasNext()){
            HouseShort houseShort= new HouseShort();
            House house = iterator.next();
            houseShort.setHouseid(house.getHouseid());
            houseShort.setHouseaddress(house.getHouseaddress());
            houseShort.setHousearea(house.getHousearea());
            houseShort.setHousedescribe(house.getHousedescribe());
            houseShort.setHousename(house.getHousename());
            houseShort.setHousemainpic(house.getHousemainpic());
            houseShort.setHouserent(house.getHouserent());
            houseShort.setHouseroom(house.getHouseroom());
            houseShorts.add(houseShort);
        }
        HouseSearchResult houseSearchResult = new HouseSearchResult();
        houseSearchResult.setSize((int)pageInfo.getTotal());
        houseSearchResult.setData(houseShorts);
        ReturnResult returnResult = new ReturnResult();
        returnResult.setMessage("查询成功");
        returnResult.setStatus("200");
        returnResult.setData(houseSearchResult);
        return  returnResult;
    }

    /**
     * 设置查询参数
     * @param houseaddress 房屋地址
     * @param houserent 房屋价格
     * @param houseroom 房屋居室信息
     * @return
     */
    public HouseExample sethouseExample(String houseaddress, String houserent, String houseroom ,String housedescribe,String housetype){
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andHousestateEqualTo(1);
        HouseExample houseExample1 = new HouseExample();
        HouseExample.Criteria criteria1 = houseExample1.createCriteria();
        int lowerrent,higherrent;
        if (!(houseaddress==null)&&houseaddress.length()!=0){
            criteria.andHouseaddressLike("%"+houseaddress+"%");
            System.out.println("字符串拼接:"+"%"+houseaddress+"%");
        }
        if (!(houserent==null)&&houserent.length()!=0) {
            String[] strings = houserent.split("~");
            if (strings.length==2){
            lowerrent = Integer.parseInt(strings[0]);
            higherrent = Integer.parseInt(strings[1]);
            criteria.andHouserentBetween(lowerrent,higherrent);}
            else{
                if (strings[0].equals("100")){
                    lowerrent = 0;
                    higherrent = 100;
                    criteria.andHouserentBetween(lowerrent,higherrent);
                }else{
                    lowerrent = 300;
                    higherrent = 99999;
                    criteria.andHouserentBetween(lowerrent,higherrent);
                }
            }

        }
        if (!(houseroom==null)&&houseroom.length()!=0)
            criteria.andHouseroomLike("%"+houseroom+"%");
        if (!(housedescribe==null)&&housedescribe.length()!=0)criteria.andHousenameLike("%"+housedescribe+"%");
        if (!(housetype==null)&&housetype.length()!=0)criteria.andHousetypeEqualTo(housetype);
        return houseExample;

    }
    /**
     * 判断rent字符串是否合法
     * @param s 需要判断的字符串
     * @return
     */
    public ReturnResult rent(String s){
        String[] strings = s.split("~");
        if (strings.length>2)
        {
            ReturnResult returnResult = new ReturnResult();
            returnResult.setMessage("请求参数错误");
            returnResult.setStatus("400");
            return  returnResult;
        }
       else if (strings.length==2){
            if (Integer.parseInt(strings[0])>Integer.parseInt(strings[1])){
                ReturnResult returnResult = new ReturnResult();
                returnResult.setMessage("请求参数错误");
                returnResult.setStatus("400");
                return  returnResult;
            }
        }
         return null;
    }
}
