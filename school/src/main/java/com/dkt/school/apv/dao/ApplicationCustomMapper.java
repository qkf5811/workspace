package com.dkt.school.apv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.common.page.Limitation;

public interface ApplicationCustomMapper extends ApplicationMapper{
	//根据条件取得个人申请记录数
	public Integer getApvApplicationCount(@Param("userId") Integer userId,@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus);	
		
	/**
	* //分页查询个人申请记录
	* 
	* @param page
	* @return
	*/
	public List<ApplicationDto> selectByLimit(@Param("userId") Integer userId,
			@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus, 
			@Param("limit") Limitation limit);	
	
	/**
	 * 跟新申请记录的申请状态
	 * @param status
	 * @return
	 */
	public int updateApplicationStatus(
			@Param("applicationId")int applicationId,
			@Param("status")int status);

	/**
	 * 根据条件查询所有还没审批的申请表的数量
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public int selectCountOfApplicationWithoutPass(@Param("userId") Integer userId,@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus);

	/**
	 * 根据条件查询所有还没审批的申请表
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public List<ApplicationDto> selectApplicationListWithoutPass(
			@Param("userId") Integer userId,@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus,
			@Param("limit") Limitation limit);

	/**
	 * 根据id更新审批节点node_id
	 * @param applicationId
	 * @param id
	 */
	public void updateNodeIdById(
			@Param("id")Integer applicationId,
			@Param("nodeId")Integer id);

	/**
	 * 根据条件查询已经审批的（通过、不通过）申请表的数量
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public int selectCountOfApplicationWithApproved(@Param("userId") Integer userId,@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus);

	/**
	 * 根据条件查询已经审批的（通过、不通过）申请表
	 * @param userId
	 * @param name
	 * @param applicationType
	 * @param user
	 * @param applicationStatus
	 * @return
	 */
	public List<ApplicationDto> selectApplicationListWithApproved(
			@Param("userId") Integer userId,@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus,
			@Param("limit") Limitation limit);
	
	//根据条件取得所有申请记录数
	public Integer getAllApvApplicationCount(@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus);	
	
	//取出表中最大的id
	public Integer selectMaxId();
		
	/**
	* //分页查询所有申请记录
	* 
	* @param page
	* @return
	*/
	public List<ApplicationDto> getAllApvApplicationByPage(
			@Param("name") String name,
			@Param("applicationType") Integer applicationType, 
			@Param("user") String user,
			@Param("applicationStatus")Integer applicationStatus, 
			@Param("limit") Limitation limit);			
}
