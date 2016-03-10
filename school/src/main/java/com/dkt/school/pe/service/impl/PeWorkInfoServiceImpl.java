package com.dkt.school.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.pe.dao.PeWorkInfoCustomMapper;
import com.dkt.school.pe.dao.PeWorkTaskMapper;
import com.dkt.school.pe.dto.PeWorkInfoDto;
import com.dkt.school.pe.dto.PeWorkTaskDto;
import com.dkt.school.pe.model.PeWorkInfo;
import com.dkt.school.pe.model.PeWorkTask;
import com.dkt.school.pe.service.PeWorkInfoService;

@Service
public class PeWorkInfoServiceImpl implements PeWorkInfoService {
	
	private PeWorkInfoCustomMapper pwcm;
	
	private PeWorkTaskMapper pwt;
	
	
	public PeWorkTaskMapper getPwt() {
		return pwt;
	}
	@Autowired
	public void setPwt(PeWorkTaskMapper pwt) {
		this.pwt = pwt;
	}
	public PeWorkInfoCustomMapper getPwcm() {
		return pwcm;
	}
	@Autowired
	public void setPwcm(PeWorkInfoCustomMapper pwcm) {
		this.pwcm = pwcm;
	}

	@Override
	public int queryPeWorkInfoCount(PeWorkInfo info) {
		return pwcm.selectPeWorkInfoCount(info);
	}

	@Override
	public List<PeWorkInfo> queryPeWorkList(PeWorkInfo info, PaginationCustom page) {
		return pwcm.selectPeWorkInfoList(info, page.getLimitation());
	}

	@Override
	public int addPeWorkInfo(PeWorkInfo info) {
		return pwcm.insert(info);
	}

	@Override
	public int updatePeWorkInfo(PeWorkInfo info) {
		return pwcm.updateByPrimaryKey(info);
	}

	@Override
	public int deletePeWorkInfo(Integer id) {
		return pwcm.deleteByPrimaryKey(id);
	}
	@Override
	public int queryPeWorkTaskCount(PeWorkInfoDto dto) {
		return pwcm.selectPeWorkTaskCount(dto);
	}
	@Override
	public List<PeWorkTaskDto> queryPeWorkTaskList(PeWorkInfoDto dto, PaginationCustom page) {
		return pwcm.selectPeWorkTaskList(dto, page.getLimitation());
	}
	@Override
	public int deletePeWorkTaskById(Integer id) {
		return pwt.deleteByPrimaryKey(id);
	}
	@Override
	public int addPeWorkTask(PeWorkTask task) {
		return pwt.insert(task);
	}
}
