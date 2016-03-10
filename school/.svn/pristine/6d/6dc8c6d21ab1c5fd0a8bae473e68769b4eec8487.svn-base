package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.ScrapRecord;
import com.dkt.school.equ.model.ScrapRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScrapRecordMapper {
    int countByExample(ScrapRecordExample example);

    int deleteByExample(ScrapRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScrapRecord record);

    int insertSelective(ScrapRecord record);

    List<ScrapRecord> selectByExample(ScrapRecordExample example);

    ScrapRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScrapRecord record, @Param("example") ScrapRecordExample example);

    int updateByExample(@Param("record") ScrapRecord record, @Param("example") ScrapRecordExample example);

    int updateByPrimaryKeySelective(ScrapRecord record);

    int updateByPrimaryKey(ScrapRecord record);
}