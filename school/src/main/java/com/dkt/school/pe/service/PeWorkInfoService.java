package com.dkt.school.pe.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.pe.dto.PeWorkInfoDto;
import com.dkt.school.pe.dto.PeWorkTaskDto;
import com.dkt.school.pe.model.PeWorkInfo;
import com.dkt.school.pe.model.PeWorkTask;

public interface PeWorkInfoService {
	
	/**
	 * 查询体育工作信息的记录数量
	 * @param info
	 * @return
	 */
	public int queryPeWorkInfoCount(PeWorkInfo info);
	
	/**
	 * 分页查询体育工作信息
	 * @param info
	 * @param page
	 * @return
	 */
	public List<PeWorkInfo> queryPeWorkList(PeWorkInfo info, PaginationCustom page);
	
	/**
	 * 添加体育工作信息 
	 * @param info
	 * @return
	 */
	public int addPeWorkInfo(PeWorkInfo info);
	
	/**
	 * 更新体育工作信息
	 * @param info
	 * @return
	 */
	public int updatePeWorkInfo(PeWorkInfo info);
	
	/**
	 * 删除体育工作信息
	 * @param id
	 * @return
	 */
	public int deletePeWorkInfo(Integer id);
	
	/**
	 * 查询工作任务分配情况的记录数量
	 * @param dto
	 * @return
	 */
	public int queryPeWorkTaskCount(PeWorkInfoDto dto);
	
	/**
	 * 查询工作任务分配情况的记录分页信息
	 * @param dto
	 * @param page
	 * @return
	 */
	public List<PeWorkTaskDto> queryPeWorkTaskList(PeWorkInfoDto dto, PaginationCustom page);
	
	/**
	 * 删除工作任务信息
	 * @param id
	 * @return
	 */
	public int deletePeWorkTaskById(Integer id);

	/**
	 * 设置体育工作任务
	 * @param task
	 * @return
	 */
	public int addPeWorkTask(PeWorkTask task);
}
