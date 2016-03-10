package com.dkt.school.spt.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.spt.dto.SptMeetingDto;
import com.dkt.school.spt.model.SptMeeting;

public interface SptMeetingService {
	
	/**
	 * 查询运动会信息的记录数量
	 * @param dto
	 * @return
	 */
	public int queryStpMeetingCount(SptMeetingDto dto);
	
	/**
	 * 查询运动会信息的记录
	 * @param dto
	 * @param page
	 * @return
	 */
	public List<SptMeeting> queryStpMeetingList(SptMeetingDto dto, PaginationCustom page);

	/**
	 * 添加运动会信息
	 * @param meet
	 * @return
	 */
	public int addStpMeetingInfo(SptMeeting meet);

	/**
	 * 更新运动会信息
	 * @param meet
	 * @return
	 */
	public int updateSptMeeting(SptMeeting meet);

	/**
	 * 删除运动会信息
	 * @param id
	 * @return
	 */
	public int deleteSptMeetingById(Integer id);
}
