package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.MaintainRecordDto;
import com.dkt.school.equ.model.MaintainRecord;


/*
 *@Title: EnumerationService.java
 *@Package com.dkt.youshi.system.Service
 *@Description: TODO添加描述
 *@author 炳坚
 *@date 2015年5月11日下午15:34:59
 */
public interface MaintainRecordService {
	
	public boolean addMaintainRecord(MaintainRecord maintainRecord);
	
	/**
	 * 根据设备项编号和维护人员姓名模糊分页查询
	 * 
	 * @param itemCode
	 * @param maintainUserName
	 * @param page
	 * @return
	 */
	public List<MaintainRecordDto> getMaintainRecordsByPage(String itemCode, String maintainUserName,String equName,String equBrand,
			Pagination page);
	
	/**
	 * 根据设备项编号和维护人员名称模糊查询，并返回查询数目
	 * 
	 * @param itemCode
	 * @param maintainUserName
	 * @return
	 */
	public Integer getMaintainRecordCount(String itemCode, String maintainUserName);
	
	/**
	 * 根据维护记录id查找用户信息，返回一个UserDto
	 * 
	 * @param userId
	 * @return
	 */
	public MaintainRecordDto findMaintainRecordDtoByMaintainRecordId(Integer userId);
	
	/**
	 * 更新维护记录信息
	 * 
	 * @param maintainRecord
	 * @return
	 */
	public int updateMaintainRecord(MaintainRecordDto maintainRecord);
	
	
	/**
	 * 根据维护记录id删除维护记录信息
	 * 
	 * @param maintainRecordId
	 * @return
	 */
	public int deleteMaintainRecordByMaintainRecordId(Integer maintainRecordId);
	
}
