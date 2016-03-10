package com.dkt.school.tea.dao;

import com.dkt.school.tea.model.TeacherReward;
import com.dkt.school.tea.model.TeacherRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherRewardMapper {
    int countByExample(TeacherRewardExample example);

    int deleteByExample(TeacherRewardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherReward record);

    int insertSelective(TeacherReward record);

    List<TeacherReward> selectByExample(TeacherRewardExample example);

    TeacherReward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherReward record, @Param("example") TeacherRewardExample example);

    int updateByExample(@Param("record") TeacherReward record, @Param("example") TeacherRewardExample example);

    int updateByPrimaryKeySelective(TeacherReward record);

    int updateByPrimaryKey(TeacherReward record);
}