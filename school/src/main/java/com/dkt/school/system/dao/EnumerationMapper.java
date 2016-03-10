package com.dkt.school.system.dao;

import com.dkt.school.system.model.Enumeration;
import com.dkt.school.system.model.EnumerationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnumerationMapper {
    int countByExample(EnumerationExample example);

    int deleteByExample(EnumerationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Enumeration record);

    int insertSelective(Enumeration record);

    List<Enumeration> selectByExample(EnumerationExample example);

    Enumeration selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Enumeration record, @Param("example") EnumerationExample example);

    int updateByExample(@Param("record") Enumeration record, @Param("example") EnumerationExample example);

    int updateByPrimaryKeySelective(Enumeration record);

    int updateByPrimaryKey(Enumeration record);
}