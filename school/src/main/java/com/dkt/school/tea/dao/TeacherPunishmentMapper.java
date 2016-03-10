package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.TeacherPunishment;
import com.dkt.school.tea.model.TeacherPunishmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherPunishmentMapper {
    int countByExample(TeacherPunishmentExample example);

    int deleteByExample(TeacherPunishmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherPunishment record);

    int insertSelective(TeacherPunishment record);

    List<TeacherPunishment> selectByExample(TeacherPunishmentExample example);

    TeacherPunishment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherPunishment record, @Param("example") TeacherPunishmentExample example);

    int updateByExample(@Param("record") TeacherPunishment record, @Param("example") TeacherPunishmentExample example);

    int updateByPrimaryKeySelective(TeacherPunishment record);

    int updateByPrimaryKey(TeacherPunishment record);
}