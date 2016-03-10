package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dao.EquipmentCustomMapper;
import com.dkt.school.equ.dao.EquipmentMapper;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.equ.model.Equipment;
import com.dkt.school.equ.model.EquipmentExample;
import com.dkt.school.equ.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	private EquipmentCustomMapper equipmentMapper;
	
	public EquipmentMapper getEquipmentMapper() {
		return equipmentMapper;
	}
	
	@Autowired
	public void setEquipmentMapper(EquipmentCustomMapper equipmentMapper) {
		this.equipmentMapper = equipmentMapper;
	}

	@Override
	public int addEquipment(Equipment record) {
		
		//判断设备种类信息是否完整
		if (record.getCategoryId() == null || "".equals(record.getCategoryId()) ||
			record.getName() == null || "".equals(record.getName()) || 
			record.getRemark() == null || "".equals(record.getRemark()))
			return -1;
		else {
			return equipmentMapper.insertSelective(record);
		}
	}

	/**
	 * 获取所有设备种类信息
	 */
	@Override
	public List<Equipment> getEquipmentsByCategoryId(int cid) {
		List<Equipment> equList = equipmentMapper.getEquipmentsByCategoryId(cid);
		System.out.println(equList);
		return equList;
	}

	@Override
	public int getEquipmentCount() {
		
		return equipmentMapper.getEquipmentCount();
	}

	@Override
	public List<Equipment> getEquipmentByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		return equipmentMapper.selectEquipmentByCategoryId(id);
	}

	@Override
	public List<Equipment> getAllEquipment() {
		return equipmentMapper.selectByExample(new EquipmentExample());
	}

	@Override
	public int selectCountOfEquipment(EquipmentDto dto) {
		return equipmentMapper.selectCountOfEquipment(dto);
	}

	@Override
	public List<EquipmentDto> selectTotalInfoOfEquipment(EquipmentDto dto,
			PaginationCustom page) {	
		return equipmentMapper.selectTotalInfoOfEquipment(dto, page.getLimitation());
	}

	@Override
	public int addEquipmentInfo(Equipment equipment) {		
		return equipmentMapper.insert(equipment);
	}

	@Override
	public int deleteEquipmentById(Equipment equipment) {
		return equipmentMapper.deleteByPrimaryKey(equipment.getId());
	}

	@Override
	public int updateEquipment(Equipment equipment) {
		return equipmentMapper.updateByPrimaryKeySelective(equipment);
	}

}
