package com.easyrent.controller;

import com.easyrent.pojo.Orderform;
import com.easyrent.pojo.ReturnResult;
import com.easyrent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 订单操作
 */
@Controller
public class UserOperateOrederController {

    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     * @param order 订单信息
     * @return
     */
    @PostMapping("/createorder")
    @ResponseBody
    public ReturnResult createOrder(Orderform order){
        Date date = new Date();
        order.setCheckintime(date);
        order.setConditional(0);
        order.setUsercancelcondition(0);
        return orderService.createOrder(order);
    }

    /**
     * 确认订单
     * @param orderid 订单号
     * @return
     */
    @PostMapping("/checkorder")
    @ResponseBody
    public ReturnResult checkConfirmOrder(String orderid){
        return orderService.checkConfirmOrder(orderid);
    }

    /**
     * 取消订单
     * @param orderid 订单号
     * @return
     */
    @PostMapping("/checkcancelorder")
    @ResponseBody
    public ReturnResult checkCancelOrder(String orderid){
        return orderService.checkCancelOrder(orderid);
    }

}
