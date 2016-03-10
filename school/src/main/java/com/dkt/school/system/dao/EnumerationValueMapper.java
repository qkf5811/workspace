package com.dkt.school.system.dao;

import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.model.EnumerationValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnumerationValueMapper {
    int countByExample(EnumerationValueExample example);

    int deleteByExample(EnumerationValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnumerationValue record);

    int insertSelective(EnumerationValue record);

    List<EnumerationValue> selectByExample(EnumerationValueExample example);

    EnumerationValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnumerationValue record, @Param("example") EnumerationValueExample example);

    int updateByExample(@Param("record") EnumerationValue record, @Param("example") EnumerationValueExample example);

    int updateByPrimaryKeySelective(EnumerationValue record);

    int updateByPrimaryKey(EnumerationValue record);
}