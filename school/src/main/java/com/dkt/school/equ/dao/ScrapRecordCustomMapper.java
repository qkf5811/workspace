package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.ScrapRecordDto;

public interface ScrapRecordCustomMapper extends ScrapRecordMapper{
	
	public Integer countBySearch(
			@Param("itemCode") String itemCode,
			@Param("scrapUserName") String scrapUserName);
	
	public List<ScrapRecordDto> selectByLimit(
			@Param("itemCode") String itemCode,
			@Param("scrapUserName") String scrapUserName,
			@Param("equName") String equName,
			@Param("equBrand") String equBrand,
			@Param("limit") Limitation limit);
	
	public ScrapRecordDto selectScrapRecordDtoByScrapRecordId(@Param("scrapRecordId") Integer scrapRecordId);
}
