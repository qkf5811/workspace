package com.dkt.school.sch.service.impl;

import java.util.List;

import com.dkt.school.sch.model.MajorFieldExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dao.MajorCustomMapper;
import com.dkt.school.sch.dao.MajorFieldCustomMapper;
import com.dkt.school.sch.dto.MajorFieldDto;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.service.MajorFieldService;
@Service
public class MajorFieldServiceImpl implements MajorFieldService {

	@Autowired	
	private MajorFieldCustomMapper majorFieldMapper;
	
	@Autowired
	private MajorCustomMapper majorMapper;
	
	@Override
	public List<MajorField> getMajorFieldInfoByMajorId(int majorId) {
		// TODO Auto-generated method stub
		return majorFieldMapper.getMajorFieldByMajorId(majorId);
	}

	@Override
	public List<MajorFieldDto> getMajorFieldInfoByMajorIdByPage(int majorId,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return majorFieldMapper.getMajorFieldInfoByPage(majorId, page.getLimitation());
	}

	@Override
	public List<MajorFieldDto> getAllMajorFieldInfoByPage(PaginationCustom page) {
		// TODO Auto-generated method stub
		return majorFieldMapper.getAllMajorFieldInfoByPage(page.getLimitation());
	}

	@Override
	public int getMajorFieldCountByMajorId(int majorId) {
		
		return majorFieldMapper.getMajorFieldCountByMajorId(majorId);
	}

	@Override
	public int getMajorFieldCount() {
		// TODO Auto-generated method stub
		return majorFieldMapper.getMajorFieldCount();
	}

	@Override
	public int addMajorField(MajorField majorField) {
		
		return majorFieldMapper.insert(majorField);
	}

	@Override
	public int deleteMajorFieldById(int id) {
		
		return majorFieldMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void toMajorFieldDto(List<MajorFieldDto> dtoList) {
		// TODO Auto-generated method stub
		List<Major> list = majorMapper.getAllMajorInfo();

		for (int i = 0; i < dtoList.size(); ++i) {
			for (int j = 0; j < list.size(); ++j) {
				if (list.get(j).getId() == dtoList.get(i).getMajorId()) {
					dtoList.get(i).setMajorStr(list.get(j).getName());
					break;
				}
			}
		}
	}

	@Override
	public int editMajorFieldName(int majorFieldId, String newName) {
		// TODO Auto-generated method stub
		return majorFieldMapper.editMajorFieldName(majorFieldId, newName);
	}

	@Override
	public List<MajorField> getAllMajorField() {
		return majorFieldMapper.selectByExample(new MajorFieldExample());
	}
	//吴俊鹏
	@Override
	public int updateMajorField(MajorField majorField) {

		return majorFieldMapper.updateByPrimaryKeySelective(majorField);
	}
}
