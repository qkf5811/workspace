package com.dkt.school.pe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.pe.dto.PeWorkInfoDto;
import com.dkt.school.pe.dto.PeWorkTaskDto;
import com.dkt.school.pe.model.PeWorkInfo;

public interface PeWorkInfoCustomMapper extends PeWorkInfoMapper {
	
	/**
	 * 查询体育工作信息的记录数量
	 * @param info
	 * @return
	 */
	public int selectPeWorkInfoCount(@Param("info")PeWorkInfo info);
	
	/**
	 * 分页查询体育工作信息
	 * @param info
	 * @param limit
	 * @return
	 */
	public List<PeWorkInfo> selectPeWorkInfoList(@Param("info")PeWorkInfo info, @Param("limit")Limitation limit);
	
	/**
	 * 查询工作任务分配情况的记录数量
	 * @param dto
	 * @return
	 */
	public int selectPeWorkTaskCount(@Param("dto")PeWorkInfoDto dto);
	
	/**
	 * 查询工作任务分配情况的记录分页信息
	 * @param dto
	 * @param limitation
	 * @return
	 */
	public List<PeWorkTaskDto> selectPeWorkTaskList(@Param("dto")PeWorkInfoDto dto, @Param("limit")Limitation limitation);
}
