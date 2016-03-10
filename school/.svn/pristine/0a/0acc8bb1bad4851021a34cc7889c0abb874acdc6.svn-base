package com.dkt.school.apv.service;

import java.util.List;

import com.dkt.school.apv.dto.ApprovalNodeDto;
import com.dkt.school.common.page.PaginationCustom;

public interface ApprovalSettingService {

	/**
	 * 根据申请类型来查询审批流程的数量
	 * @param applicationType
	 * @param page
	 * @return
	 */
	public int findApproveSettingCountByApplicationType(int applicationType, PaginationCustom page);
	
	/**
	 * 根据申请类型来查询审批流程
	 * @param applicationType
	 * @param page
	 * @return
	 */
	public List<ApprovalNodeDto> findApproveSettingByApplicationType(int applicationType, PaginationCustom page);

	/**
	 * 根据dto添加审批节点
	 * @param dto
	 * @return
	 */
	public String addNewApprivalNode(ApprovalNodeDto dto);
	
	/**
	 * 批量更新审批节点的顺序
	 * @param tmp
	 * @return
	 */
	public int updateApprovalNodeSeqByList(List<ApprovalNodeDto> tmp);

	/**
	 * 根据审批节点id查询审批节点
	 * @param id
	 * @return
	 */
	public Object findApproveNodeById(int id);

	/**
	 * 根据dto更新审批节点(编辑)
	 * @param dto
	 * @return
	 */
	public int updateApprovalNodeByDto(ApprovalNodeDto dto);

	/**
	 * 根据节点id删除审批节点
	 * @param id
	 * @return
	 */
	public int deleteApprovalNodeById(int id);
}
