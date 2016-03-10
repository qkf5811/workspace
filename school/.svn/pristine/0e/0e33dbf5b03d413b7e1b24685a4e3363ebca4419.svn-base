package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.UseApplication;
import com.dkt.school.equ.model.UseApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UseApplicationMapper {
    int countByExample(UseApplicationExample example);

    int deleteByExample(UseApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UseApplication record);

    int insertSelective(UseApplication record);

    List<UseApplication> selectByExample(UseApplicationExample example);

    UseApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UseApplication record, @Param("example") UseApplicationExample example);

    int updateByExample(@Param("record") UseApplication record, @Param("example") UseApplicationExample example);

    int updateByPrimaryKeySelective(UseApplication record);

    int updateByPrimaryKey(UseApplication record);
}