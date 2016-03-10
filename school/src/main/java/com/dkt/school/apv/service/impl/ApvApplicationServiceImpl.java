package com.dkt.school.apv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.apv.dao.ApplicationCustomMapper;
import com.dkt.school.apv.dao.ApprovalNodeCustomMapper;
import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.apv.dto.ApprovalNodeDto;
import com.dkt.school.apv.model.Application;
import com.dkt.school.apv.service.ApvApplicationService;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dao.EquipmentCustomMapper;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.user.dao.DepartmentCustomMapper;
import com.dkt.school.user.dto.DepartmentDto;

@Service
public class ApvApplicationServiceImpl implements ApvApplicationService{
	@Autowired
	private ApplicationCustomMapper applicationCustomMapper;
	
	@Autowired
	private DepartmentCustomMapper departmentCustomMapper;
	
	@Autowired 
	private ApprovalNodeCustomMapper ancMapper;
	
	@Autowired
	private EquipmentCustomMapper equipmentCustomMapper;
	
	//根据条件取得申请记录数
	@Override
	public Integer getApvApplicationCount(Integer userId,String name, Integer applicationType,
			String user, Integer applicationStatus) {
		// TODO Auto-generated method stub
		if (userId == null) {
			userId = 0;
		}
		return applicationCustomMapper.getApvApplicationCount(userId,name,applicationType,
				user,applicationStatus);
	}

	//分页查询所有申请记录
	@Override
	public List<ApplicationDto> getApvApplicationByPage(Integer userId,String name,
			Integer applicationType, String user, Integer applicationStatus,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.selectByLimit(userId,name,applicationType,
				user,applicationStatus, page.getLimitation());
	}

	//根据条件取得部门记录数
	@Override
	public Integer getDepartmentCount(String name) {
		// TODO Auto-generated method stub
		return departmentCustomMapper.getDepartmentCount(name);
	}

	//分页查询个人部门记录
	@Override
	public List<DepartmentDto> getDepartmentByPage(String name,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return departmentCustomMapper.getDepartmentByPage(name, page.getLimitation());
	}
	
	//添加申请草稿
	@Override
	public Integer addWithDraft(ApplicationDto applicationDto) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.insert(applicationDto);
	}
	
	//添加申请
	@Override
	public Integer addNewApplication(ApplicationDto applicationDto) {
		// TODO Auto-generated method stub

		//根据申请类型将申请记录的node_id初始化为该类型的步骤1的node_id
		System.out.println("先初始化审批节点");
		List<ApprovalNodeDto> list = ancMapper.selectApproveNodeByApplicationType(applicationDto.getApplicationType(), null);
		for (ApprovalNodeDto dto : list) {
			if (dto.getSeq() == 1) {
				System.out.println("找到nodeid!");
				applicationDto.setNodeId(dto.getId());
			}
		}
			
		return applicationCustomMapper.insert(applicationDto);
	}

	//更新申请草稿
	@Override
	public Integer editWithDraft(ApplicationDto applicationDto) {
		// TODO Auto-generated method stub
		System.out.println("先初始化审批节点");
		List<ApprovalNodeDto> list = ancMapper.selectApproveNodeByApplicationType(applicationDto.getApplicationType(), null);
		for (ApprovalNodeDto dto : list) {
			if (dto.getSeq() == 1) {
				System.out.println("找到nodeid!");
				applicationDto.setNodeId(dto.getId());
			}
		}
		return applicationCustomMapper.updateByPrimaryKey(applicationDto);
	}

	//编辑草稿到提交申请
	@Override
	public Integer editApplicationToAdd(ApplicationDto applicationDto) {
		// TODO Auto-generated method stub
		System.out.println("先初始化审批节点");
		List<ApprovalNodeDto> list = ancMapper.selectApproveNodeByApplicationType(applicationDto.getApplicationType(), null);
		for (ApprovalNodeDto dto : list) {
			if (dto.getSeq() == 1) {
				System.out.println("找到nodeid!");
				applicationDto.setNodeId(dto.getId());
			}
		}
		return applicationCustomMapper.updateByPrimaryKey(applicationDto);
	}

	//根据id删除申请草稿
	@Override
	public Integer deleteApplication(Integer id) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int findCountOfApplicationWithoutPass(Integer userId, String name,
			Integer applicationType, String user, Integer applicationStatus) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.selectCountOfApplicationWithoutPass(userId,name,applicationType,
				user,applicationStatus);
	}

	@Override
	public List<ApplicationDto> findApplicationListWithoutPass(Integer userId,
			String name, Integer applicationType, String user,
			Integer applicationStatus, PaginationCustom page) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.selectApplicationListWithoutPass(userId,name,applicationType,
				user,applicationStatus, page.getLimitation());
	}

	@Override
	public int findCountOfApplicationWithApproved(Integer userId, String name,
			Integer applicationType, String user, Integer applicationStatus) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.selectCountOfApplicationWithApproved(userId, name, applicationType, user, applicationStatus);
	}

	@Override
	public List<ApplicationDto> findApplicationListWithApproved(Integer userId,
			String name, Integer applicationType, String user,
			Integer applicationStatus, PaginationCustom page) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.selectApplicationListWithApproved(userId, name, applicationType, user, applicationStatus, page.getLimitation());
	}

	//根据条件取得所有申请记录数
	@Override
	public Integer getAllApvApplicationCount(String name,
			Integer applicationType, String user, Integer applicationStatus) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.getAllApvApplicationCount(name,applicationType,
				user,applicationStatus);
	}

	//分页查询所有部门记录
	@Override
	public List<ApplicationDto> getAllApvApplicationByPage(String name,
			Integer applicationType, String user, Integer applicationStatus,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return applicationCustomMapper.getAllApvApplicationByPage(name,applicationType,
				user,applicationStatus, page.getLimitation());
	}

	//根据条件取得设备记录数
	@Override
	public Integer getEquipmentAmount(String name, String model) {
		
		return null;
	}

	//分页查询所有设备记录
	@Override
	public List<EquipmentDto> getEquipmentByPage(String name, String model,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return null;
	}

}
