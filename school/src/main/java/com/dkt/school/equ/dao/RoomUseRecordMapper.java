package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.RoomUseRecord;
import com.dkt.school.equ.model.RoomUseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomUseRecordMapper {
    int countByExample(RoomUseRecordExample example);

    int deleteByExample(RoomUseRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomUseRecord record);

    int insertSelective(RoomUseRecord record);

    List<RoomUseRecord> selectByExample(RoomUseRecordExample example);

    RoomUseRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomUseRecord record, @Param("example") RoomUseRecordExample example);

    int updateByExample(@Param("record") RoomUseRecord record, @Param("example") RoomUseRecordExample example);

    int updateByPrimaryKeySelective(RoomUseRecord record);

    int updateByPrimaryKey(RoomUseRecord record);
}