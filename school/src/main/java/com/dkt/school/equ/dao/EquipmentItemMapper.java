package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.EquipmentItem;
import com.dkt.school.equ.model.EquipmentItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentItemMapper {
    int countByExample(EquipmentItemExample example);

    int deleteByExample(EquipmentItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentItem record);

    int insertSelective(EquipmentItem record);

    List<EquipmentItem> selectByExample(EquipmentItemExample example);

    EquipmentItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipmentItem record, @Param("example") EquipmentItemExample example);

    int updateByExample(@Param("record") EquipmentItem record, @Param("example") EquipmentItemExample example);

    int updateByPrimaryKeySelective(EquipmentItem record);

    int updateByPrimaryKey(EquipmentItem record);
}