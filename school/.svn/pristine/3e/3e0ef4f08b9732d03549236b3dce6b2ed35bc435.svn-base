package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.ReformRecordDto;

public interface ReformRecordCustomMapper extends ReformRecordMapper{
	
	public Integer countBySearch(
			@Param("itemCode") String itemCode,
			@Param("reformUserName") String reformUserName);
	
	public List<ReformRecordDto> selectByLimit(
			@Param("itemCode") String itemCode,
			@Param("reformUserName") String reformUserName,
			@Param("equName") String equName,
			@Param("equBrand") String equBrand,
			@Param("limit") Limitation limit);
	
	public ReformRecordDto selectReformRecordDtoByReformRecordId(@Param("reformRecordId") Integer reformRecordId);
}
