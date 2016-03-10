package com.dkt.school.spt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.spt.dto.SptMeetingDto;
import com.dkt.school.spt.model.SptMeeting;

public interface SptMeetingCustomMapper extends SptMeetingMapper {
	
	/**
	 * 查询运动会记录数量
	 * @param dto
	 * @return
	 */
	public int selectSptMeetingCount(@Param("dto")SptMeetingDto dto);
	
	/**
	 * 查询运动会记录
	 * @param dto
	 * @param limit
	 * @return
	 */
	public List<SptMeeting> selectSptMeetingList(@Param("dto")SptMeetingDto dto, @Param("limit")Limitation limit);
}
