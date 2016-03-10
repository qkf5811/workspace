package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.ScrapRecordDto;
import com.dkt.school.equ.model.ScrapRecord;


/*
 *@Title: EnumerationService.java
 *@Package com.dkt.youshi.system.Service
 *@Description: TODO添加描述
 *@author 炳坚
 *@date 2015年5月16日上午9:34:59
 */
public interface ScrapRecordService {
	
	public boolean addScrapRecord(ScrapRecord scrapRecord);
	
	/**
	 * 根据设备项编号和报废人员姓名模糊分页查询
	 * 
	 * @param itemCode
	 * @param scrapUserName
	 * @param page
	 * @return
	 */
	public List<ScrapRecordDto> getScrapRecordsByPage(String itemCode, String scrapUserName,String equName,String equBrand,
			Pagination page);
	
	/**
	 * 根据设备项编号和报废人员名称模糊查询，并返回查询数目
	 * 
	 * @param itemCode
	 * @param scrapUserName
	 * @return
	 */
	public Integer getScrapRecordCount(String itemCode, String scrapUserName);
	
	/**
	 * 根据报废记录id查找用户信息，返回一个ScrapRecordDto
	 * 
	 * @param userId
	 * @return
	 */
	public ScrapRecordDto findScrapRecordDtoByScrapRecordId(Integer userId);
	
	/**
	 * 更新报废记录信息
	 * 
	 * @param scrapRecord
	 * @return
	 */
	public int updateScrapRecord(ScrapRecordDto scrapRecord);
	
	
	/**
	 * 根据报废记录id删除报废记录信息
	 * 
	 * @param scrapRecordId
	 * @return
	 */
	public int deleteScrapRecordByScrapRecordId(Integer scrapRecordId);
	
}
