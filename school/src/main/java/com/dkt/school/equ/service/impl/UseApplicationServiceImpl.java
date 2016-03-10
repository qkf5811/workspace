package com.dkt.school.equ.service.impl;

import java.util.List;













import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.apv.dao.ApplicationCustomMapper;
import com.dkt.school.apv.model.Application;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dao.UseApplicationCustomMapper;
import com.dkt.school.equ.dto.UseApplicationDto;
import com.dkt.school.equ.service.UseApplicationService;

@Service
public class UseApplicationServiceImpl implements UseApplicationService{
	
	@Autowired
	private UseApplicationCustomMapper useApplicationCustomMapper;
	
	@Autowired
	private ApplicationCustomMapper applicationCustomMapper;
	
	//取得领用申请的数量
	@Override
	public Integer getUseApplicationCount(Integer userId, String name,
			String equipName, Integer applicationStatus) {
		// TODO Auto-generated method stub
		System.out.println("123213");
		return useApplicationCustomMapper.getUseApplicationCount(userId,name,equipName,applicationStatus);
	}

	//分页模糊查询领用申请记录
	@Override
	public List<UseApplicationDto> getUseApplicationByPage(Integer userId,
			String name, String equipName, Integer applicationStatus,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return useApplicationCustomMapper.getUseApplicationByPage(userId,name,equipName,applicationStatus,page.getLimitation());
	}

	//添加申请草稿
	@Override
	public Integer addWithDraft(UseApplicationDto useApplicationDto) {
		Application application = new Application();
		application.setApplicationStatus(useApplicationDto.getApplicationStatus());
		application.setApplicationType(useApplicationDto.getApplicationType());
		application.setAppTime(useApplicationDto.getAppTime());
		application.setDepartId(useApplicationDto.getDepartId());
		application.setName(useApplicationDto.getApvApplicationName());
		application.setNodeId(useApplicationDto.getNodeId());
		application.setReason(useApplicationDto.getReason());
		application.setRemark(useApplicationDto.getRemark());
		application.setUserId(useApplicationDto.getUserId());
		
		//插入审批申请表数据
		applicationCustomMapper.insert(application);
	    //取出刚插入的记录的id
		Integer applicationId=applicationCustomMapper.selectMaxId();
		//插入领用申请表数据
		
		useApplicationDto.setApplicationId(applicationId);
		
		return useApplicationCustomMapper.insert(useApplicationDto);
	}

	//添加申请记录
	@Override
	public Integer addNewUseApplication(UseApplicationDto useApplicationDto) {
		Application application = new Application();
		application.setApplicationStatus(useApplicationDto.getApplicationStatus());
		application.setApplicationType(useApplicationDto.getApplicationType());
		application.setAppTime(useApplicationDto.getAppTime());
		application.setDepartId(useApplicationDto.getDepartId());
		application.setName(useApplicationDto.getApvApplicationName());
		application.setNodeId(useApplicationDto.getNodeId());
		application.setReason(useApplicationDto.getReason());
		application.setRemark(useApplicationDto.getRemark());
		application.setUserId(useApplicationDto.getUserId());
		//插入审批申请表数据
		applicationCustomMapper.insert(application);
	    //取出刚插入的记录的id
		Integer applicationId=applicationCustomMapper.selectMaxId();
		//插入领用申请表数据
		
		useApplicationDto.setApplicationId(applicationId);
		
		return useApplicationCustomMapper.insert(useApplicationDto);
	}

	//更新申请草稿
	@Override
	public Integer editWithDraft(UseApplicationDto useApplicationDto) {
		Application application = new Application();
		application.setId(useApplicationDto.getApplicationId());
		application.setApplicationStatus(useApplicationDto.getApplicationStatus());
		application.setApplicationType(useApplicationDto.getApplicationType());
		application.setAppTime(useApplicationDto.getAppTime());
		application.setDepartId(useApplicationDto.getDepartId());
		application.setName(useApplicationDto.getApvApplicationName());
		application.setNodeId(useApplicationDto.getNodeId());
		application.setReason(useApplicationDto.getReason());
		application.setRemark(useApplicationDto.getRemark());
		application.setUserId(useApplicationDto.getUserId());
		//更新申请表数据
		applicationCustomMapper.updateByPrimaryKey(application);
		
		return useApplicationCustomMapper.updateByPrimaryKey(useApplicationDto);
	}
	
	//编辑草稿，然后提交
	@Override
	public Integer editUseApplicationToAdd(UseApplicationDto useApplicationDto) {
		Application application = new Application();
		application.setId(useApplicationDto.getApplicationId());
		application.setApplicationStatus(useApplicationDto.getApplicationStatus());
		application.setApplicationType(useApplicationDto.getApplicationType());
		application.setAppTime(useApplicationDto.getAppTime());
		application.setDepartId(useApplicationDto.getDepartId());
		application.setName(useApplicationDto.getApvApplicationName());
		application.setNodeId(useApplicationDto.getNodeId());
		application.setReason(useApplicationDto.getReason());
		application.setRemark(useApplicationDto.getRemark());
		application.setUserId(useApplicationDto.getUserId());
		//更新申请表数据
		applicationCustomMapper.updateByPrimaryKey(application);
		
		return useApplicationCustomMapper.updateByPrimaryKey(useApplicationDto);
	}

	@Override
	public Integer deleteUseApplication(Integer id, Integer applicationId) {
		applicationCustomMapper.deleteByPrimaryKey(applicationId);
		
		return useApplicationCustomMapper.deleteByPrimaryKey(id);
	}


	

}
