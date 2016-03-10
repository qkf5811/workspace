package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.MaintainRecordDto;

public interface MaintainRecordCustomMapper extends MaintainRecordMapper{
	
	public Integer countBySearch(
			@Param("itemCode") String itemCode,
			@Param("maintainUserName") String maintainUserName);
	
	public List<MaintainRecordDto> selectByLimit(
			@Param("itemCode") String itemCode,
			@Param("maintainUserName") String maintainUserName,
			@Param("equName") String equName,
			@Param("equBrand") String equBrand,
			@Param("limit") Limitation limit);
	
	public MaintainRecordDto selectMaintainRecordDtoByMaintainRecordId(@Param("maintainRecordId") Integer maintainRecordId);
}
