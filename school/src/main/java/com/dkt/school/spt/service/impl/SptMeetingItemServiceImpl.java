package com.dkt.school.spt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.spt.dao.SptMeetingItemCustomMapper;
import com.dkt.school.spt.dto.SptMeetingItemDto;
import com.dkt.school.spt.model.SptMeetingItem;
import com.dkt.school.spt.service.SptMeetingItemService;
@Service
public class SptMeetingItemServiceImpl implements SptMeetingItemService {
	
	private SptMeetingItemCustomMapper smicm;
	
	public SptMeetingItemCustomMapper getSmicm() {
		return smicm;
	}
	@Autowired
	public void setSmicm(SptMeetingItemCustomMapper smicm) {
		this.smicm = smicm;
	}


	@Override
	public List<Map<Integer, String>> querySptMeetingItemType() {
		return smicm.selectStpMeetingItemType();
	}
	@Override
	public int queryStpMeetingitemCount(SptMeetingItemDto dto) {
		return smicm.selectSptMeetingItemCount(dto);
	}
	@Override
	public List<SptMeetingItemDto> queryStpMeetingItemList(SptMeetingItemDto dto, PaginationCustom page) {
		return smicm.selectSptMeetingItem(dto, page.getLimitation());
	}
	@Override
	public int addSptMeetingItem(SptMeetingItem item) {
		return smicm.insert(item);
	}
	@Override
	public int removeSptMeetingItem(Integer id) {
		return smicm.deleteByPrimaryKey(id);
	}
	@Override
	public int updateSptMeetingItem(SptMeetingItem item) {
		return smicm.updateByPrimaryKey(item);
	}
}
