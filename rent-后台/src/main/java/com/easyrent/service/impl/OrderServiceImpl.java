package com.easyrent.service.impl;

import com.easyrent.mapper.HouseMapper;
import com.easyrent.mapper.OrderformMapper;
import com.easyrent.pojo.*;
import com.easyrent.service.OrderService;
import com.easyrent.service.UpdateHouseService;
import com.easyrent.utils.AccountGenerateUtils;
import com.easyrent.utils.PagesUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private UpdateHouseService updateHouseService;
    @Autowired
    public HouseMapper houseMapper;

    /**
     * 创建订单
     * @param order 订单页
     * @return
     */
    @Override
    public ReturnResult createOrder(Orderform order) {
        order.setOrderid(AccountGenerateUtils.account(10));
        House house = houseMapper.selectByPrimaryKey(order.getHouseid());
        order.setHousename(house.getHousename());
        orderformMapper.insert(order);
        if (updateHouseService.updateHouseState(order.getHouseid(),2).getStatus().equals("200"))
        return new ReturnResult("创建成功","200",null);
        else return new ReturnResult("创建失败","422",null);
    }

    /**
     * 根据租客账号查询订单
     * @param account 账号
     * @param pagecount 当前页码
     * @return
     */
    @Override
    public ReturnResult findOrderByaccount(String account,int pagecount) {
        OrderformExample orderformExample = new OrderformExample();
        orderformExample.setOrderByClause("checkintime DESC");
        OrderformExample.Criteria criteria = orderformExample.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andConditionalNotEqualTo(5);
        criteria.andUsercancelconditionEqualTo(0);
        PageHelper.startPage(pagecount,5);
        ReturnResult returnResult = PagesUtils.infoResult(orderformMapper.selectByExample(orderformExample));
        return returnResult;
    }

    /**
     * 房东查询等待确认订单
     * @param account 房东账号
     * @param pagecount 当前页码
     * @return
     */
    @Override
    public ReturnResult findOrderByHouseOwnerConfirm(String account,int pagecount) {
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andAccountEqualTo(account);
        List<House> houses = houseMapper.selectByExample(houseExample);
        List<String>houseid = new ArrayList<>();
        for (House house: houses
        ) {
            houseid.add(house.getHouseid());
        }
        OrderformExample orderformExample = new OrderformExample();
        orderformExample.setOrderByClause("checkintime DESC");
        OrderformExample.Criteria criteria1 = orderformExample.createCriteria();
        criteria1.andHouseidIn(houseid);
        criteria1.andConditionalEqualTo(0);
        PageHelper.startPage(pagecount,10);
        ReturnResult returnResult = PagesUtils.infoResult(orderformMapper.selectByExample(orderformExample));
        return returnResult;

    }

    /**
     * 房东查询等待确认取消订单
     * @param account 房东账号
     * @param pagecount 当前页码
     * @return
     */
    @Override
    public ReturnResult findOrderByHouseOwnerCancel(String account,int pagecount) {
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andAccountEqualTo(account);
        List<House> houses = houseMapper.selectByExample(houseExample);
        List<String>houseid = new ArrayList<>();
        for (House house: houses
        ) {
            houseid.add(house.getHouseid());
        }
        OrderformExample orderformExample = new OrderformExample();
        orderformExample.setOrderByClause("checkintime DESC");
        OrderformExample.Criteria criteria1 = orderformExample.createCriteria();
        criteria1.andHouseidIn(houseid);
        criteria1.andConditionalEqualTo(2);
        PageHelper.startPage(pagecount,10);
        ReturnResult returnResult = PagesUtils.infoResult(orderformMapper.selectByExample(orderformExample));
        return returnResult;

    }

    /**
     * 房东确认租客请求
     * @param orderid 订单号
     * @return
     */
    @Override
    public ReturnResult checkConfirmOrder(String orderid) {
        Orderform orderform = new Orderform();
        orderform.setOrderid(orderid);
        orderform = orderformMapper.selectByPrimaryKey(orderid);
        if (orderform.getOrderid().equals("")) return new ReturnResult("未找到相应订单","404",null);
        else if (orderform.getConditional()==0)orderform.setConditional(1);
        else if (orderform.getConditional()==2) {
            orderform.setConditional(3);
            updateHouseService.updateHouseState(orderform.getHouseid(), 2).getStatus().equals("200");
        }
        else return new ReturnResult("参数错误","400",null);
       orderformMapper.updateByPrimaryKeySelective(orderform);
        Orderform orderform1 = orderformMapper.selectByPrimaryKey(orderid);
        return new ReturnResult("操作成功","200",orderform1);

    }

    /**
     * 房东拒绝租客请求
     * @param orderid 订单号
     * @return
     */
    @Override
    public ReturnResult checkCancelOrder(String orderid) {
        Orderform orderform = new Orderform();
        orderform.setOrderid(orderid);
        orderform = orderformMapper.selectByPrimaryKey(orderid);
        if (orderform.getOrderid().equals("")) return new ReturnResult("未找到相应订单","404",null);
        else if (orderform.getConditional()==0)orderform.setConditional(3);
        else if (orderform.getConditional()==2)orderform.setConditional(1);
        else return new ReturnResult("参数错误","400",null);
        orderformMapper.updateByPrimaryKeySelective(orderform);
        Orderform orderform1 = orderformMapper.selectByPrimaryKey(orderid);
        return new ReturnResult("操作成功","200",orderform1);
    }

    /**
     * 租客删除id
     * @param orderid 订单号
     * @return
     */
    @Override
    public ReturnResult deleteOrder(String orderid) {
        Orderform orderform = new Orderform();
        orderform.setOrderid(orderid);
        orderform.setUsercancelcondition(1);
        orderformMapper.updateByPrimaryKeySelective(orderform);
        return new ReturnResult("操作成功","204",null);
    }

    /**
     * 租客取消订单
     * @param orderid 订单号
     * @return
     */
    @Override
    public ReturnResult cancelOrder(String orderid) {

        Orderform orderform = new Orderform();
        orderform.setOrderid(orderid);
        orderform = orderformMapper.selectByPrimaryKey(orderid);
        if (orderform.getOrderid().equals("")) return new ReturnResult("未找到相应订单","404",null);
        else if (orderform.getConditional()==0)orderform.setConditional(3);
        else if (orderform.getConditional()==1)orderform.setConditional(2);
        else return new ReturnResult("参数错误","400",null);
        orderformMapper.updateByPrimaryKeySelective(orderform);
        Orderform orderform1 = orderformMapper.selectByPrimaryKey(orderid);
        return new ReturnResult("操作成功","200",orderform1);
    }

    /**
     * 房东查看自己的所有订单
     * @param account 房东id
     * @param pagecount 当前页码
     * @return
     */
    @Override
    public ReturnResult findOrderByHouseOwner(String account,int pagecount) {
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andAccountEqualTo(account);
        List<House> houses = houseMapper.selectByExample(houseExample);
        List<String>houseid = new ArrayList<>();
        for (House house: houses
             ) {
            houseid.add(house.getHouseid());
        }
        OrderformExample orderformExample = new OrderformExample();
        orderformExample.setOrderByClause("checkintime DESC");
        OrderformExample.Criteria criteria1 = orderformExample.createCriteria();
        criteria1.andHouseidIn(houseid);
        criteria1.andConditionalNotEqualTo(5);
        PageHelper.startPage(pagecount,10);
        return PagesUtils.infoResult(orderformMapper.selectByExample(orderformExample));
    }
}
