package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.equ.model.Equipment;


public interface EquipmentService {
	//添加设备种类信息
	public int addEquipment(Equipment record);
	
	//获取设备种类信息
	public List<Equipment> getEquipmentsByCategoryId(int id);

	public int getEquipmentCount();
	
	//根据设备分类获取设备种类
		public List<Equipment> getEquipmentByCategoryId(Integer id);

		/**
		 * 获取所有的设备种类
		 * @return
		 */
		public List<Equipment> getAllEquipment();

		/**
		 * 获取符合条件的设备种类数量
		 * @param dto
		 * @return
		 */
		public int selectCountOfEquipment(EquipmentDto dto);

		/**
		 * 获取符合条件的设备种类列表
		 * @param dto
		 * @param page
		 * @return
		 */
		public List<EquipmentDto> selectTotalInfoOfEquipment(EquipmentDto dto,
				PaginationCustom page);

	    /**
	     * 添加设备种类
	     * @param equipment
	     * @return
	     */
		public int addEquipmentInfo(Equipment equipment);

		/**
		 * 删除设备种类
		 * @param equipment
		 * @return
		 */
		public int deleteEquipmentById(Equipment equipment);

		/**
		 * 修改设备种类
		 * @param equipment
		 * @return
		 */
		public int updateEquipment(Equipment equipment);
}
