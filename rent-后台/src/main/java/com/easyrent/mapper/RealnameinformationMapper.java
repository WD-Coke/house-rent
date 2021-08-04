package com.easyrent.mapper;

import com.easyrent.pojo.Realnameinformation;
import com.easyrent.pojo.RealnameinformationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealnameinformationMapper {
    int countByExample(RealnameinformationExample example);

    int deleteByExample(RealnameinformationExample example);

    int deleteByPrimaryKey(String idnumber);

    int insert(Realnameinformation record);

    int insertSelective(Realnameinformation record);

    List<Realnameinformation> selectByExample(RealnameinformationExample example);

    Realnameinformation selectByPrimaryKey(String idnumber);

    int updateByExampleSelective(@Param("record") Realnameinformation record, @Param("example") RealnameinformationExample example);

    int updateByExample(@Param("record") Realnameinformation record, @Param("example") RealnameinformationExample example);

    int updateByPrimaryKeySelective(Realnameinformation record);

    int updateByPrimaryKey(Realnameinformation record);
}