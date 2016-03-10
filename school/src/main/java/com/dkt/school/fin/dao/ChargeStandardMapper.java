package com.dkt.school.fin.dao;

import com.dkt.school.fin.model.ChargeStandard;
import com.dkt.school.fin.model.ChargeStandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargeStandardMapper {
    int countByExample(ChargeStandardExample example);

    int deleteByExample(ChargeStandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChargeStandard record);

    int insertSelective(ChargeStandard record);

    List<ChargeStandard> selectByExample(ChargeStandardExample example);

    ChargeStandard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChargeStandard record, @Param("example") ChargeStandardExample example);

    int updateByExample(@Param("record") ChargeStandard record, @Param("example") ChargeStandardExample example);

    int updateByPrimaryKeySelective(ChargeStandard record);

    int updateByPrimaryKey(ChargeStandard record);
}