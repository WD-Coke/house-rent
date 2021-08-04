package com.easyrent.controller;
import com.easyrent.pojo.Orderform;
import com.easyrent.pojo.ReturnResult;
import com.easyrent.pojo.User;
import com.easyrent.pojo.UserLoginResult;
import com.easyrent.service.OrderService;
import com.easyrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单相关查询和用户部分修改订单
 */

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 用户查询自己的订单
     * @param account 账号
     * @param pagecount 当前页码
     * @return
     */
    @GetMapping("/findmyorder")
    @ResponseBody
    public ReturnResult findOrderByAccount(String account,@RequestParam(defaultValue = "1") int pagecount){
        return orderService.findOrderByaccount(account,pagecount);
    }

    /**
     *取消订单
     * @param orderid 订单号
     * @return
     */
    @PostMapping("cancelorder")
    @ResponseBody
    public ReturnResult cancelOreder(@RequestParam String orderid){
        return orderService.cancelOrder(orderid);
    }

    /**
     *删除订单
     * @param orderid 订单号
     * @return
     */
    @PostMapping("deletemyorder")
    @ResponseBody
    public ReturnResult deleteOreder(@RequestParam String orderid){
        return orderService.deleteOrder(orderid);
    }

    /**
     *房东查看待确认订单
     * @param account
     * @param pagecount
     * @return
     */
    @GetMapping("/findownconfirmorder")
    @ResponseBody
    public ReturnResult findOrderByAccountConfirm(String account,@RequestParam(defaultValue = "1") int pagecount){
        return orderService.findOrderByHouseOwnerConfirm(account,pagecount);
    }

    /**
     *房东查看申请取消订单
     * @param account
     * @param pagecount
     * @return
     */
    @GetMapping("/findowncancelorder")
    @ResponseBody
    public ReturnResult findOrderByAccountCancel(String account,@RequestParam(defaultValue = "1") int pagecount){
        return orderService.findOrderByHouseOwnerCancel(account,pagecount);
    }

    /**
     *房东查看全部订单
     * @param account
     * @param pagecount
     * @return
     */
    @GetMapping("/findownorder")
    @ResponseBody
    public ReturnResult findOwnOreder(String account,@RequestParam(defaultValue = "1") int pagecount){
        return orderService.findOrderByHouseOwner(account,pagecount);
    }


}
