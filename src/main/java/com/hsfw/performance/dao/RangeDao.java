package com.hsfw.performance.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface RangeDao {
    public List<HashMap<String, String>> getRangeInfoByGameTypeCN(@Param("gameTypeCN") String gameTypeCN,
                                                                  @Param("cellType") String cellType);
}
