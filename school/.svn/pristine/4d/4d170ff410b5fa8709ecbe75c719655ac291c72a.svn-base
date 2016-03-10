package com.dkt.school.equ.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.EquipmentItemDto;
import com.dkt.school.equ.dto.EquipmentUseDto;
import com.dkt.school.equ.model.EquipmentItem;

public interface EquipmentItemCustomMapper extends EquipmentItemMapper {
	
	public EquipmentItem selectByCode(String code);

	//获取某种设备的记录数
	public int getEquipmentItemCount(int equipmentId);
	
	//获取某种设备的记录数
	public int getEquipmentItemCountWithFree(int equipmentId);

	//根据page 和equipmentId 获取equipmentItem的list
	public List<EquipmentItemDto> getEquipmentItemByPage(
			@Param("equipmentId") int equipmentId,
			@Param("isFree") boolean isFree,
			@Param("limit") Limitation limit);
	
	//根据归还条件获取设备信息
	public List<EquipmentItemDto> getEquipmentItemByConditions(
			@Param("equipmentId")int equipmentId,
			@Param("code")String code,
			@Param("userId")int userId,
			@Param("limit") Limitation limit);
	
	//根据归还条件获取符合条件的设备数量
	public int getEquipmentItemCountByConditions(
			@Param("equipmentId")int equipmentId,
			@Param("code")String code,
			@Param("userId")int userId);

	//根据设备编号获取设备记录
	public EquipmentItemDto getEquipmentItemByCode(
			@Param("code")String code,
			@Param("limit")Limitation limitation);
	
	/**
	 * 根据id查询出设备的具体使用情况
	 * @param id
	 * @return
	 */
	EquipmentUseDto getEquipmentUseDtoById(@Param("id")Integer id);
	/**
	 * 根据条件查询出设备记录数
	 * @param category
	 * @param useStatus
	 * @param source
	 * @return
	 */
	Integer selectEquipmentItemCount(@Param("category")String category,@Param("useStatus")Integer useStatus,@Param("source")Integer source,@Param("buyTime")String buyTime);
	/**
	 * 查询设备所有明细并分页
	 * @param params
	 * @return
	 */
	List<EquipmentItemDto> findAllEquipmentItems(Map<String,Object> params);
	
	/**
	 * 根据条件查询设备并分页
	 * @return
	 */
	List<EquipmentItemDto> selectEquipmentItemDtoByLimit(@Param("category") String category,@Param("useStatus")Integer useStatus,
									@Param("source")Integer source,@Param("buyTime")String buyTime,@Param("limit")Limitation limit);

	/**
	 * 通过List插入多条记录
	 * @param totalList
	 * @return
	 */
	public int insertByList(
			@Param("list")List<EquipmentItemDto> totalList);

	
}
