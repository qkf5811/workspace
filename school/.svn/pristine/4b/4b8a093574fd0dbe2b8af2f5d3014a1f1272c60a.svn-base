package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.MaintainRecord;
import com.dkt.school.equ.model.MaintainRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaintainRecordMapper {
    int countByExample(MaintainRecordExample example);

    int deleteByExample(MaintainRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaintainRecord record);

    int insertSelective(MaintainRecord record);

    List<MaintainRecord> selectByExample(MaintainRecordExample example);

    MaintainRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaintainRecord record, @Param("example") MaintainRecordExample example);

    int updateByExample(@Param("record") MaintainRecord record, @Param("example") MaintainRecordExample example);

    int updateByPrimaryKeySelective(MaintainRecord record);

    int updateByPrimaryKey(MaintainRecord record);
}