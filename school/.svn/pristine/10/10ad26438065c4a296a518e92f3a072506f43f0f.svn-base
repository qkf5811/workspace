package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.model.UseRecord;
import com.dkt.school.user.dto.UserDto;



public interface UseRecordCustomMapper {
	
	//根据领用记录Id查找某一条领用记录
	public UseRecord findUseRecordById(Integer useRecordId);
	
	//取得领用记录的总数
	public Integer getUseReportCount(@Param("itemId") Integer itemId,
			@Param("name") String name);
	
	/**
	 * 根据设备ID和姓名模糊分页查询
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	public List<UseRecordDto> selectByLimit(
			@Param("itemId") Integer itemId,
			@Param("name") String name, 
			@Param("limit") Limitation limit);
	
	public UseRecordDto selectUseRecordDtoByItemId(
			@Param("itemId") Integer itemId);
	
	//根据领用记录id查找领用记录信息
	public UseRecordDto selectUseRecordDtoByUseRecordId(@Param("useRecordId") Integer useRecordId);

	//根据设备Id删除领用记录
	public Integer deleteUseRecordByItemId(@Param("itemId") Integer itemId);
	
	public Integer updateUseRecord(UseRecordDto record);
}
