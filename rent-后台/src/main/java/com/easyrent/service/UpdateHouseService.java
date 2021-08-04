package com.easyrent.service;

import com.easyrent.pojo.House;
import com.easyrent.pojo.ReturnResult;
import org.springframework.web.multipart.MultipartFile;

public interface UpdateHouseService {
    public ReturnResult updateHouseState(String houseid,int houseState);
    public ReturnResult createHouse(House house, MultipartFile[] files );
    public ReturnResult deleteHouseByHouseid(String houseid);
    public ReturnResult updateHouseByHouseid(House house,MultipartFile[] files) ;
}
