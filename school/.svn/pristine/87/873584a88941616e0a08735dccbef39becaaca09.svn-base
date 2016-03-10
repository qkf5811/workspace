package com.dkt.school.sch.service.impl;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dto.ClassRoomDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.sch.dao.ClassRoomCustomMapper;
import com.dkt.school.sch.model.ClassRoom;
import com.dkt.school.sch.model.ClassRoomExample;
import com.dkt.school.sch.service.ClassRoomService;
@Service
public class ClassRoomServiceImpl implements ClassRoomService {

	@Autowired
	private ClassRoomCustomMapper classRoomMapper;
	@Override
	public List<ClassRoom> getClassRoomByBuilding(int id) {
		// TODO Auto-generated method stub
		return classRoomMapper.selectClassRoomByBuildingId(id);
	}

	@Override
	public int getClassRoomCount(String name, Integer campusId,Integer buildingId, Integer roomType) {
		return classRoomMapper.countBySearch(name,campusId,buildingId,roomType);
	}

	@Override
	public List<ClassRoomDto> getClassRoomByPage(String name, Integer campusId,Integer buildingId, Integer roomType, Pagination page) {
		return classRoomMapper.selectByLimit(name,campusId,buildingId,roomType,page.getLimitation());
	}

	@Override
	public int addClassRoom(ClassRoom classRoom) {
		return classRoomMapper.insert(classRoom);
	}

	@Override
	public int updateClassRoom(ClassRoom classRoom) {
		return classRoomMapper.updateByPrimaryKey(classRoom);
	}

	@Override
	public int deleteClassRoom(Integer id) {
		return classRoomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ClassRoom findClassRoomByClassRoomId(Integer id) {
		return classRoomMapper.selectClassRoomDtoByClassRoomId(id);
	}

	@Override
	/**
	 * @author 吴俊鹏
	 */
	public List<ClassRoom> getAllClassRoom() {
		// TODO Auto-generated method stub
		return classRoomMapper.selectByExample(new ClassRoomExample());
	}

	@Override
	public List<ClassRoom> getClassByBuildingIdForStorage(int id) {
		// TODO Auto-generated method stub
		return classRoomMapper.getClassByBuildingIdForStorage(id);
	}

}
