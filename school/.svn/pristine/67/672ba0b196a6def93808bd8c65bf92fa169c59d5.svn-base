package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.equ.model.Equipment;


public interface EquipmentCustomMapper extends EquipmentMapper {
	
	//获取所有设备种类信息
	public List<Equipment> getEquipmentsByCategoryId(int cid);

	public int getEquipmentCount();

	public Equipment getEquipmentByName(
			@Param("categoryId") Integer categoryId, 
			@Param("name") String name);
	
	public List<Equipment> selectEquipmentByCategoryId(@Param("id") Integer id);

	/**
	 * 获取符合条件的设备种类数量
	 * 
	 * @param dto
	 * @return
	 */
	public int selectCountOfEquipment(@Param("dto") EquipmentDto dto);

	/**
	 * 获取符合条件的设备种类列表
	 * 
	 * @param dto
	 * @param page
	 * @return
	 */
	public List<EquipmentDto> selectTotalInfoOfEquipment(
			@Param("dto") EquipmentDto dto, @Param("limit") Limitation limit);
}
