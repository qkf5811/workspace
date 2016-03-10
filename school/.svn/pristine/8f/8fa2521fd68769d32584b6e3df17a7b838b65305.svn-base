package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.TeacherWorkExperience;
import com.dkt.school.tea.model.TeacherWorkExperienceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherWorkExperienceMapper {
    int countByExample(TeacherWorkExperienceExample example);

    int deleteByExample(TeacherWorkExperienceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherWorkExperience record);

    int insertSelective(TeacherWorkExperience record);

    List<TeacherWorkExperience> selectByExample(TeacherWorkExperienceExample example);

    TeacherWorkExperience selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherWorkExperience record, @Param("example") TeacherWorkExperienceExample example);

    int updateByExample(@Param("record") TeacherWorkExperience record, @Param("example") TeacherWorkExperienceExample example);

    int updateByPrimaryKeySelective(TeacherWorkExperience record);

    int updateByPrimaryKey(TeacherWorkExperience record);
}