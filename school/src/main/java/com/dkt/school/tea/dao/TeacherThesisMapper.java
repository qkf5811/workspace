package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.TeacherThesis;
import com.dkt.school.tea.model.TeacherThesisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherThesisMapper {
    int countByExample(TeacherThesisExample example);

    int deleteByExample(TeacherThesisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherThesis record);

    int insertSelective(TeacherThesis record);

    List<TeacherThesis> selectByExample(TeacherThesisExample example);

    TeacherThesis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherThesis record, @Param("example") TeacherThesisExample example);

    int updateByExample(@Param("record") TeacherThesis record, @Param("example") TeacherThesisExample example);

    int updateByPrimaryKeySelective(TeacherThesis record);

    int updateByPrimaryKey(TeacherThesis record);
}