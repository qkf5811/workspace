package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.ReformRecordDto;
import com.dkt.school.equ.model.ReformRecord;


/*
 *@Title: EnumerationService.java
 *@Package com.dkt.youshi.system.Service
 *@Description: TODO添加描述
 *@author 炳坚
 *@date 2015年5月16日上午8:34:59
 */
public interface ReformRecordService {
	
	public boolean addReformRecord(ReformRecord reformRecord);
	
	/**
	 * 根据设备项编号和改造人员姓名模糊分页查询
	 * 
	 * @param itemCode
	 * @param reformUserName
	 * @param page
	 * @return
	 */
	public List<ReformRecordDto> getReformRecordsByPage(String itemCode, String reformUserName,String equName,String equBrand,
			Pagination page);
	
	/**
	 * 根据设备项编号和改造人员名称模糊查询，并返回查询数目
	 * 
	 * @param itemCode
	 * @param reformUserName
	 * @return
	 */
	public Integer getReformRecordCount(String itemCode, String reformUserName);
	
	/**
	 * 根据改造记录id查找用户信息，返回一个ReformRecordDto
	 * 
	 * @param userId
	 * @return
	 */
	public ReformRecordDto findReformRecordDtoByReformRecordId(Integer userId);
	
	/**
	 * 更新改造记录信息
	 * 
	 * @param reformRecord
	 * @return
	 */
	public int updateReformRecord(ReformRecordDto reformRecord);
	
	
	/**
	 * 根据改造记录id删除改造记录信息
	 * 
	 * @param reformRecordId
	 * @return
	 */
	public int deleteReformRecordByReformRecordId(Integer reformRecordId);
	
}
