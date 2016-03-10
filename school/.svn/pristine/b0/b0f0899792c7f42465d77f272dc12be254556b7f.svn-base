package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.model.BorrowRecord;





public interface BorrowRecordCustomMapper {

	//根据借用记录Id查找某一条借用记录
	public BorrowRecord findBorrowRecordById(Integer borrowRecordId);
	
	//取得借用记录的总数
	public Integer getBorrowReportCount(@Param("itemId") Integer itemId,
			@Param("name") String name);
	
	/**
	 * 根据设备ID和姓名模糊分页查询
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	public List<BorrowRecordDto> selectByLimit(
			@Param("itemId") Integer itemId,
			@Param("name") String name, 
			@Param("limit") Limitation limit);
	
	public BorrowRecordDto selectBorrowRecordDtoByItemId(
			@Param("itemId") Integer itemId);
	
	//根据设备Id删除借用记录
	public Integer deleteBorrowRecordByItemId(@Param("itemId") Integer itemId);
	
	public Integer updateBorrowRecord(BorrowRecordDto record);
}
