package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.UseRecordDto;




public interface BorrowRecordService {
	//取得借用记录的总数
	public Integer getBorrowReportCount(Integer itemId,String name);
	
	/**
	 * 根据设备ID和姓名模糊分页查询
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	public List<BorrowRecordDto> getBorrowRecordsByPage(Integer itemId,String name,Pagination page);

	//新建一条借用记录
	public Integer addBorrowRecord(BorrowRecordDto brDto);
	
	//根据itemId删除一条借用记录
	public Integer deleteBorrowRecordByItemId(Integer itemId);
	
	//根据借用记录id查找借用记录信息
	public BorrowRecordDto findBorrowRecordDtoByItemId(Integer itemId);
	
	//更新一条借用记录
	public Integer updateBorrowRecord(BorrowRecordDto borrowRecordDto);
}
