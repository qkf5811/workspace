package com.dkt.school.sch.dao;

import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.model.StudyYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyYearMapper {
    int countByExample(StudyYearExample example);

    int deleteByExample(StudyYearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudyYear record);

    int insertSelective(StudyYear record);

    List<StudyYear> selectByExample(StudyYearExample example);

    StudyYear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudyYear record, @Param("example") StudyYearExample example);

    int updateByExample(@Param("record") StudyYear record, @Param("example") StudyYearExample example);

    int updateByPrimaryKeySelective(StudyYear record);

    int updateByPrimaryKey(StudyYear record);
}