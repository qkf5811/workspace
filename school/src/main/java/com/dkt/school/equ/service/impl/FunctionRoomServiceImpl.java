package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.FunctionRoomCustomMapper;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.FunctionRoom;
import com.dkt.school.equ.service.FunctionRoomService;
@Service
public class FunctionRoomServiceImpl implements FunctionRoomService {

	@Autowired
	private FunctionRoomCustomMapper functionRoomMapper;
	@Override
	public List<FunctionRoom> getFunctionRoomByBuilding(int id) {
		// TODO Auto-generated method stub
		return functionRoomMapper.selectFunctionRoomByBuildingId(id);
	}

	@Override
	public int getFunctionRoomCount(Integer buildingId,String name) {
		return functionRoomMapper.countBySearch(buildingId,name);
	}

	@Override
	public List<FunctionRoomDto> getFunctionRoomByPage(String name,Integer buildingId,Pagination page) {
		return functionRoomMapper.selectByLimit(name,buildingId,page.getLimitation());
	}

	@Override
	public int addFunctionRoom(FunctionRoom FunctionRoom) {
		return functionRoomMapper.insert(FunctionRoom);
	}

	@Override
	public int updateFunctionRoom(FunctionRoom FunctionRoom) {
		return functionRoomMapper.updateByPrimaryKey(FunctionRoom);
	}

	@Override
	public int deleteFunctionRoom(Integer id) {
		return functionRoomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public FunctionRoom findFunctionRoomById(Integer id) {
		return functionRoomMapper.selectFunctionRoomById(id);
	}

	@Override
	public int getFunctionRoomRecordCount(String funRoomName, String uName) {
		return functionRoomMapper.getFunctionRoomRecordCount(funRoomName,uName);
	}

	@Override
	public List<FunctionRoomDto> getFunctionRoomRecordByPage(
			String funRoomName, String uName, Pagination page) {
		return functionRoomMapper.selectRecordByLimit(funRoomName,uName,page.getLimitation());
	}

	

}
