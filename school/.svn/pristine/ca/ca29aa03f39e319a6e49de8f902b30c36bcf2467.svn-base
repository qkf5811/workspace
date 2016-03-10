package com.dkt.school.stu.dao;

import com.dkt.school.stu.model.StuChangeClass;
import com.dkt.school.stu.model.StuChangeClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuChangeClassMapper {
    int countByExample(StuChangeClassExample example);

    int deleteByExample(StuChangeClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuChangeClass record);

    int insertSelective(StuChangeClass record);

    List<StuChangeClass> selectByExample(StuChangeClassExample example);

    StuChangeClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuChangeClass record, @Param("example") StuChangeClassExample example);

    int updateByExample(@Param("record") StuChangeClass record, @Param("example") StuChangeClassExample example);

    int updateByPrimaryKeySelective(StuChangeClass record);

    int updateByPrimaryKey(StuChangeClass record);
}