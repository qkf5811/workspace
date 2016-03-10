package com.dkt.school.equ.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.UseApplicationDto;

public interface UseApplicationService {
	//取得领用申请的数量
	public Integer getUseApplicationCount(Integer  userId,String name,String equipName,Integer applicationStatus);
	
	//分页模糊查询领用申请记录
	public List<UseApplicationDto> getUseApplicationByPage(Integer  userId,String name,String equipName,Integer applicationStatus,PaginationCustom page);

	//添加申请草稿
	public Integer addWithDraft(UseApplicationDto useApplicationDto);
	
	//添加申请记录
	public Integer addNewUseApplication(UseApplicationDto useApplicationDto);
	
	//更新申请草稿
	public Integer editWithDraft(UseApplicationDto useApplicationDto);
	
	//编辑草稿，然后提交
	public Integer editUseApplicationToAdd(UseApplicationDto useApplicationDto);
	
	//删除申请草稿
	public Integer deleteUseApplication(Integer id,Integer applicationId);
	
	
}
