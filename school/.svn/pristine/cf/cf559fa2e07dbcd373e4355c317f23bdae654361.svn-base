package com.dkt.school.stu.dao;

import com.dkt.school.stu.model.StudentReward;
import com.dkt.school.stu.model.StudentRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentRewardMapper {
    int countByExample(StudentRewardExample example);

    int deleteByExample(StudentRewardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentReward record);

    int insertSelective(StudentReward record);

    List<StudentReward> selectByExample(StudentRewardExample example);

    StudentReward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentReward record, @Param("example") StudentRewardExample example);

    int updateByExample(@Param("record") StudentReward record, @Param("example") StudentRewardExample example);

    int updateByPrimaryKeySelective(StudentReward record);

    int updateByPrimaryKey(StudentReward record);
}