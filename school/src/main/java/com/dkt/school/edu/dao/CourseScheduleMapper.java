package com.dkt.school.edu.dao;

import com.dkt.school.edu.model.CourseSchedule;
import com.dkt.school.edu.model.CourseScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseScheduleMapper {
    int countByExample(CourseScheduleExample example);

    int deleteByExample(CourseScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseSchedule record);

    int insertSelective(CourseSchedule record);

    List<CourseSchedule> selectByExample(CourseScheduleExample example);

    CourseSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseSchedule record, @Param("example") CourseScheduleExample example);

    int updateByExample(@Param("record") CourseSchedule record, @Param("example") CourseScheduleExample example);

    int updateByPrimaryKeySelective(CourseSchedule record);

    int updateByPrimaryKey(CourseSchedule record);
}