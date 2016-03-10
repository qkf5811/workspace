package com.dkt.school.pe.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.pe.dao.PePersonInfoCustomMapper;
import com.dkt.school.pe.dto.PePersonInfoDto;
import com.dkt.school.pe.model.PePersonInfo;
import com.dkt.school.pe.service.PePersonInfoService;
@Service
public class PePersonInfoServiceImpl implements PePersonInfoService {
	
	private PePersonInfoCustomMapper ppcm;
	
	public PePersonInfoCustomMapper getPpcm() {
		return ppcm;
	}
	@Autowired
	public void setPpcm(PePersonInfoCustomMapper ppcm) {
		this.ppcm = ppcm;
	}

	@Override
	public List<PePersonInfoDto> queryPersonInfoList(Integer position, String name, PaginationCustom page) {
		return ppcm.selectPersonInfoList(position, name, page.getLimitation());
	}

	@Override
	public PePersonInfoDto queryPersonInfo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePersonInfo(Integer id) {
		return ppcm.deleteByPrimaryKey(id);
	}

	@Override
	public int updatePersonInfo(PePersonInfo pi) {
		return ppcm.updateByPrimaryKeySelective(pi);
	}
	
	public List<Map<Integer, String>> queryPosition() {
		return ppcm.selectAllPePosition();
	}
	
	@Override
	public int queryPersonInfoCount(Integer workGroupPosition, String teaNameInWorkGroup) {
		return ppcm.selectPersonInfoCount(workGroupPosition, teaNameInWorkGroup);
	}
	@Override
	public List<PePersonInfo> queryByTeaCode(String code) {
		return ppcm.selectPePersonInfoByTeaCode(code);
	}
	@Override
	public Integer queryTeaIinfoIdByCode(String code) {
		return ppcm.selectTeaInfoIdByCode(code);
	}
	@Override
	public int savePePersonInfo(PePersonInfoDto dto) {
		PePersonInfo record = new PePersonInfo();
		record.setDuty(dto.getDuty());
		record.setPosition(dto.getPosition());
		record.setRemark(dto.getRemark());
		record.setTeaInfoId(dto.getTeaInfoId());
		return ppcm.insert(record);
	}
}
