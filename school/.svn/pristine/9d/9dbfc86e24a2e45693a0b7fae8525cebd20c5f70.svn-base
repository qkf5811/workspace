package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.UseRecordDto;

public interface UseRecordService {
	//新建一条领用记录
	public Integer addUseRecord(UseRecordDto useRecordDto);
	
	//更新一条领用记录
	public Integer updateUseRecord(UseRecordDto useRecordDto);
	
	public Integer deleteUseRecordByItemId(Integer itemId);
	
	//根据领用记录Id查找某一条领用记录
	public UseRecordDto findUseRecordById(Integer useRecordId); 
	
	//取得领用记录的总数
	public Integer getUseReportCount(Integer itemId,String name);
	
	/**
	 * 根据设备ID和姓名模糊分页查询
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	public List<UseRecordDto> getUseRecordsByPage(Integer itemId,String name,Pagination page);
	
	//根据领用记录Id删除某一条领用记录
	public int deleteUseRecordById(Integer useRecordId);
	
	//根据领用记录id查找领用记录信息
	public UseRecordDto findUseRecordDtoByItemId(Integer itemId);
}
