package com.dkt.school.sch.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dto.CampusDto;
import com.dkt.school.sch.dao.CampusCustomMapper;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.service.CampusService;

@Service
public class CampusServiceImpl implements CampusService {

	@Autowired
	private CampusCustomMapper campusCustomMapper;
	
	public CampusCustomMapper getCampusCustomMapper() {
		return campusCustomMapper;
	}

	@Autowired
	public void setCampusCustomMapper(CampusCustomMapper campusCustomMapper) {
		this.campusCustomMapper = campusCustomMapper;
	}
	
	@Override
	public List<Campus> getAllCampus() {
		
		return campusCustomMapper.selectAllCampus();
	}

	public int addCampus(Campus campus) {
		return campusCustomMapper.insert(campus);
	}
	public List<Campus> getCampusByPage(CampusDto campusDto,
			Pagination page) {
		return campusCustomMapper.selectByLimit(campusDto, page.getLimitation());
	}

	public int getCampusCount(CampusDto campusDto) {
		return campusCustomMapper.getCampusCount(campusDto);
	}

	public int updateCampus(Campus campus) {

		return campusCustomMapper.updateByPrimaryKeySelective(campus);
	}

	public int deleteCampusById(Integer campusId) {

		return campusCustomMapper.deleteByPrimaryKey(campusId);
	}
	public CampusDto findCampusDtoByCampusId(Integer campusId) {
		return campusCustomMapper.selectCampusDtoByCampusId(campusId);
	}

}
