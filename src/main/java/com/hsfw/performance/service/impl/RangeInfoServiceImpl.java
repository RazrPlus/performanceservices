package com.hsfw.performance.service.impl;

import com.hsfw.performance.dao.RangeDao;
import com.hsfw.performance.service.RangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class RangeInfoServiceImpl implements RangeInfoService {
    @Autowired
    RangeDao rangeDao;
    @Override
    public List<HashMap<String, String>> getRangeInfoService(String gameTypeCN,String cellType) {
        return rangeDao.getRangeInfoByGameTypeCN(gameTypeCN,cellType);
    }
}
