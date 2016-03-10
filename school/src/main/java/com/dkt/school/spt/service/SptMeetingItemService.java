package com.dkt.school.spt.service;

import java.util.List;
import java.util.Map;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.spt.dto.SptMeetingItemDto;
import com.dkt.school.spt.model.SptMeetingItem;

public interface SptMeetingItemService {
	
	/**
	 *  查询所有运动会项目类型
	 * @return
	 */
	public List<Map<Integer, String>> querySptMeetingItemType();

	/**
	 * 查询运动会项目的记录数量
	 * @param dto
	 * @return
	 */
	public int queryStpMeetingitemCount(SptMeetingItemDto dto);

	/**
	 * 查询运动会项目的记录
	 * @param dto
	 * @param page
	 * @return
	 */
	public List<SptMeetingItemDto> queryStpMeetingItemList(SptMeetingItemDto dto, PaginationCustom page);

	/**
	 * 添加运动会项目信息
	 * @param item
	 * @return
	 */
	public int addSptMeetingItem(SptMeetingItem item);

	/**
	 * 删除运动会项目信息
	 * @param id
	 * @return
	 */
	public int removeSptMeetingItem(Integer id);

	/**
	 * 更新运动会项目信息
	 * @param item
	 * @return
	 */
	public int updateSptMeetingItem(SptMeetingItem item);
}
