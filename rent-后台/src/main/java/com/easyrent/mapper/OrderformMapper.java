package com.easyrent.mapper;

import com.easyrent.pojo.Orderform;
import com.easyrent.pojo.OrderformExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderformMapper {
    int countByExample(OrderformExample example);

    int deleteByExample(OrderformExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    List<Orderform> selectByExample(OrderformExample example);

    Orderform selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Orderform record, @Param("example") OrderformExample example);

    int updateByExample(@Param("record") Orderform record, @Param("example") OrderformExample example);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);
}
