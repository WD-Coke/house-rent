package com.easyrent.service;

import com.easyrent.pojo.Orderform;
import com.easyrent.pojo.ReturnResult;

public interface OrderService {
    public ReturnResult createOrder(Orderform order);
    public ReturnResult findOrderByaccount(String account,int pagecount);
    public ReturnResult cancelOrder(String orderid);
    public ReturnResult findOrderByHouseOwner(String account,int pagecount);
    public ReturnResult findOrderByHouseOwnerConfirm(String account,int pagecount);
    public ReturnResult findOrderByHouseOwnerCancel(String account,int pagecount);
    public ReturnResult checkConfirmOrder(String orderid);
    public ReturnResult checkCancelOrder(String orderid);
    public ReturnResult deleteOrder(String orderid);
}
