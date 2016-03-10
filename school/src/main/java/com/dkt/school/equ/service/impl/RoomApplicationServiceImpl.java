package com.dkt.school.equ.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.apv.dao.ApplicationCustomMapper;
import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.apv.model.Application;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.util.DateUtil;
import com.dkt.school.equ.dao.RoomApplicationCustomMapper;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.dto.RoomApplicationDto;
import com.dkt.school.equ.model.RoomApplication;
import com.dkt.school.equ.service.RoomApplicationService;
@Service
public class RoomApplicationServiceImpl implements RoomApplicationService {

	@Autowired
	private RoomApplicationCustomMapper roomApplicationMapper;
	
	@Autowired
	private ApplicationCustomMapper applicationCustomMapper;

	@Override
	public int getRoomApplicationCount(FunctionRoomDto dto) {
		// TODO Auto-generated method stub
		return roomApplicationMapper.getRoomApplicationCount(dto);
	}

	@Override
	public List<FunctionRoomDto> getRoomApplicatioByPage(FunctionRoomDto dto,
			Pagination page) {
		// TODO Auto-generated method stub
		return roomApplicationMapper.getRoomApplicatioByPage(dto,page.getLimitation());
	}

	@Override
	public int deleteRoomApplication(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addRoomApplication(RoomApplication obj) {
		// TODO Auto-generated method stub
		return roomApplicationMapper.insert(obj);
	}

	@Override
	public int updateRoomApplication(FunctionRoomDto dto) {
		String dateTime = DateUtil.getDateTime();
		Date date = DateUtil.getDateTime(dateTime);
		Application app= applicationCustomMapper.selectByPrimaryKey(dto.getApplicationId());
		app.setApplicationStatus(dto.getStatus());
//		app.setNodeId(dto.getNodeId());
		app.setReason(dto.getReason());
		app.setRemark(dto.getRemark());
		app.setName(dto.getName());
	//	app.setUserId(dto.getUseUserId());
//		app.setDepartId(dto.getDepartId());
		app.setAppTime(date);
		int result = applicationCustomMapper.updateByPrimaryKey(app);
		
		RoomApplication room = roomApplicationMapper.selectByPrimaryKey(dto.getId());
		
		room.setFunctionRoomId(dto.getFunctionRoomId());
		room.setRemark(dto.getRemark());
	//	room.setUseUserId(dto.getUseUserId());
		room.setUseFromDate(DateUtil.getDateTime(dto.getUseFromDateStr()+ ":00"));
		room.setUseToDate(DateUtil.getDateTime(dto.getUseToDateStr()+ ":00"));
		return roomApplicationMapper.updateByPrimaryKey(room);
	}

	@Override
	public int addApplication(FunctionRoomDto dto) {
		String dateTime = DateUtil.getDateTime();
		Date date = DateUtil.getDateTime(dateTime);
		ApplicationDto app= new ApplicationDto();
		app.setApplicationType(41004);
		app.setApplicationStatus(dto.getStatus());
	//	app.setNodeId(dto.getNodeId());
		app.setReason(dto.getReason());
		app.setRemark(dto.getRemark());
		app.setName(dto.getName());
		app.setUserId(dto.getUseUserId());
		app.setDepartId(dto.getDepartId());
		app.setAppTime(date);
		int result = applicationCustomMapper.insert(app);
		
		RoomApplicationDto room = new  RoomApplicationDto();
		room.setApplicationId(app.getId());
		room.setFunctionRoomId(dto.getFunctionRoomId());
		room.setRemark(dto.getRemark());
		room.setUseUserId(dto.getUseUserId());
		room.setUseFromDate(DateUtil.getDateTime(dto.getUseFromDateStr()+ ":00"));
		room.setUseToDate(DateUtil.getDateTime(dto.getUseToDateStr()+ ":00"));
		return roomApplicationMapper.insert(room);
	}

}
