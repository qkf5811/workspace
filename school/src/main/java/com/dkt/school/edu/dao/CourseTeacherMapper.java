package com.dkt.school.edu.dao;

import com.dkt.school.edu.model.CourseTeacher;
import com.dkt.school.edu.model.CourseTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTeacherMapper {
    int countByExample(CourseTeacherExample example);

    int deleteByExample(CourseTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTeacher record);

    int insertSelective(CourseTeacher record);

    List<CourseTeacher> selectByExample(CourseTeacherExample example);

    CourseTeacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTeacher record, @Param("example") CourseTeacherExample example);

    int updateByExample(@Param("record") CourseTeacher record, @Param("example") CourseTeacherExample example);

    int updateByPrimaryKeySelective(CourseTeacher record);

    int updateByPrimaryKey(CourseTeacher record);
}