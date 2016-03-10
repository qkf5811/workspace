package com.dkt.school.fin.dao;

import com.dkt.school.fin.model.StudentCharge;
import com.dkt.school.fin.model.StudentChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentChargeMapper {
    int countByExample(StudentChargeExample example);

    int deleteByExample(StudentChargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentCharge record);

    int insertSelective(StudentCharge record);

    List<StudentCharge> selectByExample(StudentChargeExample example);

    StudentCharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentCharge record, @Param("example") StudentChargeExample example);

    int updateByExample(@Param("record") StudentCharge record, @Param("example") StudentChargeExample example);

    int updateByPrimaryKeySelective(StudentCharge record);

    int updateByPrimaryKey(StudentCharge record);
}