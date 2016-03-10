package com.dkt.school.apv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.apv.dto.ApprovalNodeDto;
import com.dkt.school.common.page.Limitation;

public interface ApprovalNodeCustomMapper extends ApprovalNodeMapper {

	/**
	 * 根据申请类型来查找审批流程
	 * @param applicationType
	 * @return
	 */
	public List<ApprovalNodeDto> selectApproveNodeByApplicationType(
			@Param("applicationType")int applicationType,
			@Param("limit")Limitation limit);

	/**
	 * 根据申请类型来查找审批流程的数量
	 * @param applicationType
	 * @param limitation
	 * @return
	 */
	public int selectApproveNodeCountByApplicationType(
			@Param("applicationType")int applicationType, 
			@Param("limit")Limitation limitation);

	/**
	 * 添加审批节点
	 * @param dto
	 * @return
	 */
	public int insertNewApprovalNode(
			@Param("dto")ApprovalNodeDto dto);

	/**
	 * 批量更新审批节点的顺序
	 * @param tmp
	 * @return
	 */
	public int updateApprovalNodeSeqByList(
			@Param("dtoList")List<ApprovalNodeDto> tmp);

}
