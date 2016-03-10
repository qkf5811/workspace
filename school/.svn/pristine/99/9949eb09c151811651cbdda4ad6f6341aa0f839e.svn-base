package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.UseApplicationDto;


public interface UseApplicationCustomMapper extends UseApplicationMapper{
	//根据条件取得个人申请记录数
	public Integer getUseApplicationCount(@Param("userId") Integer userId,@Param("name") String name,
			@Param("equipName") String equipName,
			@Param("applicationStatus")Integer applicationStatus);	
	/**
	* //分页查询个人申请记录
	* 
	* @param page
	* @return
	*/
	public List<UseApplicationDto> getUseApplicationByPage(@Param("userId") Integer userId,@Param("name") String name,
			@Param("equipName") String equipName,
			@Param("applicationStatus")Integer applicationStatus, 
			@Param("limit") Limitation limit);		
}
