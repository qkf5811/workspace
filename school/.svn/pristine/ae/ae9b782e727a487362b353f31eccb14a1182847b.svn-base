package com.dkt.school.stu.dao;

import com.dkt.school.stu.model.StudentFamily;
import com.dkt.school.stu.model.StudentFamilyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentFamilyMapper {
    int countByExample(StudentFamilyExample example);

    int deleteByExample(StudentFamilyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentFamily record);

    int insertSelective(StudentFamily record);

    List<StudentFamily> selectByExample(StudentFamilyExample example);

    StudentFamily selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentFamily record, @Param("example") StudentFamilyExample example);

    int updateByExample(@Param("record") StudentFamily record, @Param("example") StudentFamilyExample example);

    int updateByPrimaryKeySelective(StudentFamily record);

    int updateByPrimaryKey(StudentFamily record);
}