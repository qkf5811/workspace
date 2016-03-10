package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.ReformRecord;
import com.dkt.school.equ.model.ReformRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReformRecordMapper {
    int countByExample(ReformRecordExample example);

    int deleteByExample(ReformRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReformRecord record);

    int insertSelective(ReformRecord record);

    List<ReformRecord> selectByExample(ReformRecordExample example);

    ReformRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReformRecord record, @Param("example") ReformRecordExample example);

    int updateByExample(@Param("record") ReformRecord record, @Param("example") ReformRecordExample example);

    int updateByPrimaryKeySelective(ReformRecord record);

    int updateByPrimaryKey(ReformRecord record);
}