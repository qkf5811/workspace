package com.dkt.school.edu.dao;

import com.dkt.school.edu.model.TeachCourse;
import com.dkt.school.edu.model.TeachCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachCourseMapper {
    int countByExample(TeachCourseExample example);

    int deleteByExample(TeachCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeachCourse record);

    int insertSelective(TeachCourse record);

    List<TeachCourse> selectByExample(TeachCourseExample example);

    TeachCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeachCourse record, @Param("example") TeachCourseExample example);

    int updateByExample(@Param("record") TeachCourse record, @Param("example") TeachCourseExample example);

    int updateByPrimaryKeySelective(TeachCourse record);

    int updateByPrimaryKey(TeachCourse record);
}