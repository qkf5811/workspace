package com.dkt.school.sch.dao;

import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.model.MajorFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MajorFieldMapper {
    int countByExample(MajorFieldExample example);

    int deleteByExample(MajorFieldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MajorField record);

    int insertSelective(MajorField record);

    List<MajorField> selectByExample(MajorFieldExample example);

    MajorField selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MajorField record, @Param("example") MajorFieldExample example);

    int updateByExample(@Param("record") MajorField record, @Param("example") MajorFieldExample example);

    int updateByPrimaryKeySelective(MajorField record);

    int updateByPrimaryKey(MajorField record);
}