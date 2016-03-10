package com.dkt.school.stu.dao;

import com.dkt.school.stu.model.StudentChange;
import com.dkt.school.stu.model.StudentChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentChangeMapper {
    int countByExample(StudentChangeExample example);

    int deleteByExample(StudentChangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentChange record);

    int insertSelective(StudentChange record);

    List<StudentChange> selectByExample(StudentChangeExample example);

    StudentChange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentChange record, @Param("example") StudentChangeExample example);

    int updateByExample(@Param("record") StudentChange record, @Param("example") StudentChangeExample example);

    int updateByPrimaryKeySelective(StudentChange record);

    int updateByPrimaryKey(StudentChange record);
}