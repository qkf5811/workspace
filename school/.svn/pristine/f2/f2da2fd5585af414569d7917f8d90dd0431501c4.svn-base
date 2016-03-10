package com.dkt.school.edu.dao;

import com.dkt.school.edu.model.TeachTask;
import com.dkt.school.edu.model.TeachTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachTaskMapper {
    int countByExample(TeachTaskExample example);

    int deleteByExample(TeachTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeachTask record);

    int insertSelective(TeachTask record);

    List<TeachTask> selectByExample(TeachTaskExample example);

    TeachTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeachTask record, @Param("example") TeachTaskExample example);

    int updateByExample(@Param("record") TeachTask record, @Param("example") TeachTaskExample example);

    int updateByPrimaryKeySelective(TeachTask record);

    int updateByPrimaryKey(TeachTask record);
}