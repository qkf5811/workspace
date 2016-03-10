package com.dkt.school.edu.dao;

import com.dkt.school.edu.model.CoursePlan;
import com.dkt.school.edu.model.CoursePlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursePlanMapper {
    int countByExample(CoursePlanExample example);

    int deleteByExample(CoursePlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoursePlan record);

    int insertSelective(CoursePlan record);

    List<CoursePlan> selectByExample(CoursePlanExample example);

    CoursePlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoursePlan record, @Param("example") CoursePlanExample example);

    int updateByExample(@Param("record") CoursePlan record, @Param("example") CoursePlanExample example);

    int updateByPrimaryKeySelective(CoursePlan record);

    int updateByPrimaryKey(CoursePlan record);
}