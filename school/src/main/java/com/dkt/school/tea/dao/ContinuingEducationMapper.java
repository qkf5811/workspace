package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.ContinuingEducation;
import com.dkt.school.tea.model.ContinuingEducationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContinuingEducationMapper {
    int countByExample(ContinuingEducationExample example);

    int deleteByExample(ContinuingEducationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContinuingEducation record);

    int insertSelective(ContinuingEducation record);

    List<ContinuingEducation> selectByExample(ContinuingEducationExample example);

    ContinuingEducation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContinuingEducation record, @Param("example") ContinuingEducationExample example);

    int updateByExample(@Param("record") ContinuingEducation record, @Param("example") ContinuingEducationExample example);

    int updateByPrimaryKeySelective(ContinuingEducation record);

    int updateByPrimaryKey(ContinuingEducation record);
}