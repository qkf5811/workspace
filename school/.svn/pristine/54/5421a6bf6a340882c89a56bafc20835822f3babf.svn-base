package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.FunctionRoom;
import com.dkt.school.equ.model.FunctionRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionRoomMapper {
    int countByExample(FunctionRoomExample example);

    int deleteByExample(FunctionRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FunctionRoom record);

    int insertSelective(FunctionRoom record);

    List<FunctionRoom> selectByExample(FunctionRoomExample example);

    FunctionRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FunctionRoom record, @Param("example") FunctionRoomExample example);

    int updateByExample(@Param("record") FunctionRoom record, @Param("example") FunctionRoomExample example);

    int updateByPrimaryKeySelective(FunctionRoom record);

    int updateByPrimaryKey(FunctionRoom record);
}