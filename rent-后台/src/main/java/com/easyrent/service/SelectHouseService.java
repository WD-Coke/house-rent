package com.easyrent.service;

import com.easyrent.pojo.ReturnResult;

public interface SelectHouseService {
    public ReturnResult searchDefault(String houseaddress, String houserent, String houseroom,String housedescribe,String housetype,int pagecount, int pagesize);
    public ReturnResult searchRent(String houseaddress, String houserent, String houseroom, String housedescribe,String housetype,int pagecount, int pagesize,String order);
    public ReturnResult searchArea(String houseaddress, String houserent, String houseroom, String housedescribe,String housetype,int pagecount, int pagesize,String order);
    public ReturnResult searchHsouseByid(String houseid);
    public ReturnResult searchHouseByAccount(String account,int pagecount,int pagesize);
}
