package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.TeacherFamily;
import com.dkt.school.tea.model.TeacherFamilyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherFamilyMapper {
    int countByExample(TeacherFamilyExample example);

    int deleteByExample(TeacherFamilyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherFamily record);

    int insertSelective(TeacherFamily record);

    List<TeacherFamily> selectByExample(TeacherFamilyExample example);

    TeacherFamily selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherFamily record, @Param("example") TeacherFamilyExample example);

    int updateByExample(@Param("record") TeacherFamily record, @Param("example") TeacherFamilyExample example);

    int updateByPrimaryKeySelective(TeacherFamily record);

    int updateByPrimaryKey(TeacherFamily record);
}