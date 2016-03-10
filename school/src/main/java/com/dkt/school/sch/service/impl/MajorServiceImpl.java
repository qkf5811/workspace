package com.dkt.school.sch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dao.MajorCustomMapper;
import com.dkt.school.sch.dao.MajorFieldCustomMapper;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.service.MajorService;

@Service
public class MajorServiceImpl implements MajorService {

	@Autowired
	private MajorCustomMapper majorMapper;
	
	@Autowired
	private MajorFieldCustomMapper majorFieldMapper;
	
	@Override
	public List<Major> getAllMajorInfo() {
		
		return majorMapper.getAllMajorInfo();
	}
	
	@Override
	public int addNewMajor(Major major) {
		
		return majorMapper.insert(major);
	}

	@Override
	public int deleteMajor(int id) {
		int count = majorFieldMapper.deleteByMajorId(id);
		
		return majorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateMajor(Major major) {

		return majorMapper.updateByPrimaryKeySelective(major);
	}
	@Override
	public List<Major> getAllMajor() {
		return majorMapper.getAllMajor();
	}

	@Override
	public List<MajorField> getFieldByMajorId(Integer majorId) {
		return majorMapper.getFieldByMajorId(majorId);
	}

	@Override
	public int getAllMajorCountByPage(PaginationCustom page) {
		// TODO Auto-generated method stub
		return majorMapper.selectMajorCountByPage(page.getLimitation());
	}

	@Override
	public List<Major> getAllMajorByPage(PaginationCustom page) {
		// TODO Auto-generated method stub
		return majorMapper.selectMajorByPage(page.getLimitation());
	}

	

}
