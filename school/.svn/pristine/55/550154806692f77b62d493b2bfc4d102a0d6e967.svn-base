package com.dkt.school.stu.dao;

import com.dkt.school.stu.model.StudentPunishment;
import com.dkt.school.stu.model.StudentPunishmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentPunishmentMapper {
    int countByExample(StudentPunishmentExample example);

    int deleteByExample(StudentPunishmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentPunishment record);

    int insertSelective(StudentPunishment record);

    List<StudentPunishment> selectByExample(StudentPunishmentExample example);

    StudentPunishment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentPunishment record, @Param("example") StudentPunishmentExample example);

    int updateByExample(@Param("record") StudentPunishment record, @Param("example") StudentPunishmentExample example);

    int updateByPrimaryKeySelective(StudentPunishment record);

    int updateByPrimaryKey(StudentPunishment record);
}