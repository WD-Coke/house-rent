package com.easyrent.service.impl;

import com.easyrent.mapper.RealnameinformationMapper;
import com.easyrent.pojo.Realnameinformation;
import com.easyrent.service.RealNameService;
import org.springframework.beans.factory.annotation.Autowired;

public class RealNameServiceImpl implements RealNameService {
    @Autowired
    RealnameinformationMapper realnameinformationMapper;
    @Override
    public void insertInfoormation(Realnameinformation realnameinformation) {
        realnameinformationMapper.insert(realnameinformation);

    }
}
