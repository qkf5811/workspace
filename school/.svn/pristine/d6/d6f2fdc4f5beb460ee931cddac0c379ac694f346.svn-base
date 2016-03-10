package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.UseRecord;
import com.dkt.school.equ.model.UseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UseRecordMapper {
    int countByExample(UseRecordExample example);

    int deleteByExample(UseRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UseRecord record);

    int insertSelective(UseRecord record);

    List<UseRecord> selectByExample(UseRecordExample example);

    UseRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UseRecord record, @Param("example") UseRecordExample example);

    int updateByExample(@Param("record") UseRecord record, @Param("example") UseRecordExample example);

    int updateByPrimaryKeySelective(UseRecord record);

    int updateByPrimaryKey(UseRecord record);
}