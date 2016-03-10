package com.dkt.school.apv.service;

import java.util.List;

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.user.dto.DepartmentDto;

public interface ApvApplicationService {
	
	//根据条件取得个人申请记录数
	public Integer getApvApplicationCount(Integer userId,String name,Integer applicationType,String user,Integer applicationStatus);

	//分页查询个人申请记录
	public List<ApplicationDto> getApvApplicationByPage(Integer userId,String name,Integer applicationType,String user,Integer applicationStatus,PaginationCustom page);
	
	//根据条件取得所有申请记录数
	public Integer getAllApvApplicationCount(String name,Integer applicationType,String user,Integer applicationStatus);

	//分页查询所有申请记录
	public List<ApplicationDto> getAllApvApplicationByPage(String name,Integer applicationType,String user,Integer applicationStatus,PaginationCustom page);

	//根据条件取得部门记录数
	public Integer getDepartmentCount(String name);
	
	//根据条件取得设备记录数
	public Integer getEquipmentAmount(String name,String model);

	//分页查询所有部门记录
	public List<DepartmentDto> getDepartmentByPage(String name,PaginationCustom page);
	
	//分页查询所有设备记录
	public List<EquipmentDto> getEquipmentByPage(String name,String model,PaginationCustom page);
	
	//添加申请草稿
	public Integer addWithDraft(ApplicationDto applicationDto);
	
	//更新申请草稿
	public Integer editWithDraft(ApplicationDto applicationDto);
	
	//添加申请
	public Integer addNewApplication(ApplicationDto applicationDto);
	
	//编辑草稿到提交申请
	public Integer editApplicationToAdd(ApplicationDto applicationDto);
	
	//根据id删除申请草稿
	public Integer deleteApplication(Integer id);

	/**
	 * 根据条件查询所有还没审批的申请表的数量
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public int findCountOfApplicationWithoutPass(Integer userId, String name,
			Integer applicationType, String user, Integer applicationStatus);

	/**
	 * 根据条件查询所有还没通过申请的申请表
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public List<ApplicationDto> findApplicationListWithoutPass(Integer userId,
			String name, Integer applicationType, String user,
			Integer applicationStatus, PaginationCustom page);

	/**
	 * 根据条件查询已经审批的（通过、不通过）申请表的数量
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public int findCountOfApplicationWithApproved(Integer userId, String name,
			Integer applicationType, String user, Integer applicationStatus);

	/**
	 * 根据条件查询已经审批的（通过、不通过）申请表
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public List<ApplicationDto> findApplicationListWithApproved(Integer userId,
			String name, Integer applicationType, String user,
			Integer applicationStatus, PaginationCustom page);
	
}
