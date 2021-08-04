package com.easyrent.service.impl;

import com.easyrent.mapper.HouseMapper;
import com.easyrent.pojo.House;
import com.easyrent.pojo.ReturnResult;
import com.easyrent.service.UpdateHouseService;
import com.easyrent.utils.AccountGenerateUtils;
import com.easyrent.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class UpdateHouseServiceImpl implements UpdateHouseService{
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 修改房屋状态
     * @param housseid 房间号
     * @param houseState 状态码
     * @return
     */
    @Override
    public ReturnResult updateHouseState(String housseid,int houseState) {
        House house = new House();
        house.setHouseid(housseid);
        house.setHousestate(houseState);
        int i = houseMapper.updateByPrimaryKeySelective(house);
        System.out.println(i);
        return new ReturnResult("成功","200",null);
    }

    /**
     * 新建房屋
     * @param house 房屋基本信息
     * @param files 房屋图片
     * @return
     */
    @Override
    public ReturnResult createHouse(House house , MultipartFile[] files) {
        house.setHousestate(0);
        house.setHouseid(AccountGenerateUtils.account(10));
        house.setHousecreate(new Date());
        FileUploadUtils.upload("upload",files,house);
        int i = houseMapper.insertSelective(house);
        if (i!=0)
        return new ReturnResult("新建成功","200",null);
        else return new ReturnResult("新建失败","422",null);
    }

    /**
     * 删除房屋
     * @param houseid 房屋id
     * @return
     */
    @Override
    public ReturnResult deleteHouseByHouseid(String houseid) {
        House house =  new House();
        house.setHouseid(houseid);
        house.setHousestate(3);
        int i = houseMapper.updateByPrimaryKeySelective(house);
        if (i!=0) return new ReturnResult("删除成功","204",null);
        else return new ReturnResult("删除失败，未找到相应房屋信息","422",null);
    }

    /**
     * 修改房屋信息
     * @param house 房屋信息
     * @param files 房间图片
     * @return
     */
    @Override
    public ReturnResult updateHouseByHouseid(House house, MultipartFile[] files) {
        house.setHousestate(0);
        FileUploadUtils.upload("upload",files,house);
        int i = houseMapper.updateByPrimaryKeySelective(house);
        if (i!=0)
            return new ReturnResult("修改成功","200",null);
        else return new ReturnResult("修改失败","422",null);
    }
}
