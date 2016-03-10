package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.RoomApplication;
import com.dkt.school.equ.model.RoomApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomApplicationMapper {
    int countByExample(RoomApplicationExample example);

    int deleteByExample(RoomApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomApplication record);

    int insertSelective(RoomApplication record);

    List<RoomApplication> selectByExample(RoomApplicationExample example);

    RoomApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomApplication record, @Param("example") RoomApplicationExample example);

    int updateByExample(@Param("record") RoomApplication record, @Param("example") RoomApplicationExample example);

    int updateByPrimaryKeySelective(RoomApplication record);

    int updateByPrimaryKey(RoomApplication record);
}