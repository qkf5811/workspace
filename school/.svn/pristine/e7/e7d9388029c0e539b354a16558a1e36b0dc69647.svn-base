package com.dkt.school.sch.service.impl;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.model.BuildingExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.sch.dao.BuildingCustomMapper;
import com.dkt.school.sch.dto.BuildingDto;
import com.dkt.school.sch.model.Building;
import com.dkt.school.sch.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingCustomMapper buildingMapper;
	
	@Override
	public List<Building> getBuildingByCampusId(Integer id) {
		// TODO Auto-generated method stub
		return buildingMapper.selectBuildByCampusId(id);
	}

	@Override
	public List<Building> getAllBuilding() {
		return buildingMapper.selectByExample(new BuildingExample());
	}

	@Override
	public int selectCountOfBuilding(BuildingDto dto) {
		return buildingMapper.selectCountOfBuilding(dto);
	}

	@Override
	public List<BuildingDto> selectTotalInfoOfBuilding(BuildingDto dto,
			PaginationCustom page) {	
		return buildingMapper.selectTotalInfoOfBuilding(dto, page.getLimitation());
	}

	@Override
	public int addBuilding(Building building) {		
		return buildingMapper.insert(building);
	}

	@Override
	public int deleteBuildingById(Building building) {
		return buildingMapper.deleteByPrimaryKey(building.getId());
	}

	@Override
	public int updateBuilding(Building building) {
		return buildingMapper.updateByPrimaryKeySelective(building);
	}

}
