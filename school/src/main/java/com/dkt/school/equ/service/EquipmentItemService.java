package com.dkt.school.equ.service;

import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.EquipmentItemDto;
import com.dkt.school.equ.dto.EquipmentUseDto;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.model.EquipmentItem;
/**
 * 
 * @author JanGin Chan
 * 2015年5月09日
 */
public interface EquipmentItemService {

	/**
	 * 根据id查询某个设备的具体使用情况
	 * @param id
	 * @return
	 */
	public EquipmentUseDto getEquipmentUseDtoById(Integer id);
	
	/**
	 * 根据给定条件查询设备明细
	 * @return
	 */
	public List<EquipmentItemDto> findEquipmentItemDtoByCondition(String category,Integer useStatus,Integer source,String buyTime,PaginationCustom page);
	
	/**
	 * 查找全部设备
	 * @return
	 */
	public List<EquipmentItem> findAllEquipmentItem();
	/**
	 * 根据条件查询设备明细记录条数
	 * @param category
	 * @param useStatus
	 * @param buyTime
	 * @return
	 */
	Integer selectEquipmentItemCount(String category,Integer useStatus,Integer source,String buyTime);

		//添加设备项目信息
	public int addEquipmentItem(EquipmentItemDto record);
	
	//设备领用
	public int[] useEquipmentItem(UseRecordDto record);
	
	//设备借用
	public int[] borrowEquipmentItem(BorrowRecordDto record);
	
	//根据设备的标号修改状态
	public int returnEquipmentItem(String code);
	
	//获取记录总数
	public int getEquipmentItemCount(int equipmentId);
	
	//根据page和 sequipmentId获取equipmentItem
	public List<EquipmentItemDto> getEquipmentItemByPage(int equipmentId, boolean isFree, Pagination page);
	
	//根据归还条件获取设备信息
	public List<EquipmentItemDto> getEquipmentItemByConditions(int equipmentId, String code, int userId, Pagination page);

	//根据归还条件获取所有设备数量
	public int getEquipmentItemCountByCondition(int equipmentId, String code,
			int userId);
	
	//获得equipmentItemDto的list
	public void getEquipmentItemDtoList(List<EquipmentItemDto> dtoList, StorageService storageService);

	public int getEquipmentItemCountWith(int equipmentId);
	
	//根据设备编号获取设备记录
	public EquipmentItemDto getEquipmentItemByCode(String code, PaginationCustom page);

	//根据excel表批量导入设备信息
	public String addEquipmentItemsByExcel(InputStream in, String format);
}
