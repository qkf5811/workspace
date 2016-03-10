package com.dkt.school.spt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.spt.dto.SptMeetingItemDto;

public interface SptMeetingItemCustomMapper extends SptMeetingItemMapper {
	
	/**
	 * 查询所有运动会项目类型
	 * @return
	 */
	public List<Map<Integer, String>> selectStpMeetingItemType();
	
	/**
	 * 查询运动会项目的记录数量
	 * @param dto
	 * @return
	 */
	public int selectSptMeetingItemCount(@Param("dto")SptMeetingItemDto dto);

	/**
	 * 查询运动会项目的记录
	 * @param dto
	 * @param limitation
	 * @return
	 */
	public List<SptMeetingItemDto> selectSptMeetingItem(@Param("dto")SptMeetingItemDto dto, @Param("limit")Limitation limitation);
}
