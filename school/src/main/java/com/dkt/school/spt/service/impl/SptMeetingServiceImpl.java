package com.dkt.school.spt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.spt.dao.SptMeetingCustomMapper;
import com.dkt.school.spt.dto.SptMeetingDto;
import com.dkt.school.spt.model.SptMeeting;
import com.dkt.school.spt.service.SptMeetingService;
@Service
public class SptMeetingServiceImpl implements SptMeetingService {
	
	private SptMeetingCustomMapper smcm;
	
	
	public SptMeetingCustomMapper getSmcm() {
		return smcm;
	}
	@Autowired
	public void setSmcm(SptMeetingCustomMapper smcm) {
		this.smcm = smcm;
	}

	@Override
	public int queryStpMeetingCount(SptMeetingDto dto) {
		return smcm.selectSptMeetingCount(dto);
	}

	@Override
	public List<SptMeeting> queryStpMeetingList(SptMeetingDto dto, PaginationCustom page) {
		return smcm.selectSptMeetingList(dto, page.getLimitation());
	}
	@Override
	public int addStpMeetingInfo(SptMeeting meet) {
		return smcm.insertSelective(meet);
	}
	@Override
	public int updateSptMeeting(SptMeeting meet) {
		return smcm.updateByPrimaryKey(meet);
	}
	@Override
	public int deleteSptMeetingById(Integer id) {
		return smcm.deleteByPrimaryKey(id);
	}
}
