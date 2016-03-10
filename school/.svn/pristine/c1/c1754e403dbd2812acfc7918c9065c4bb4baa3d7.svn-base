package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.TeacherChange;
import com.dkt.school.tea.model.TeacherChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherChangeMapper {
    int countByExample(TeacherChangeExample example);

    int deleteByExample(TeacherChangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherChange record);

    int insertSelective(TeacherChange record);

    List<TeacherChange> selectByExample(TeacherChangeExample example);

    TeacherChange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherChange record, @Param("example") TeacherChangeExample example);

    int updateByExample(@Param("record") TeacherChange record, @Param("example") TeacherChangeExample example);

    int updateByPrimaryKeySelective(TeacherChange record);

    int updateByPrimaryKey(TeacherChange record);
}