package com.dkt.school.equ.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.ReformRecordCustomMapper;
import com.dkt.school.equ.dto.ReformRecordDto;
import com.dkt.school.equ.model.ReformRecord;
import com.dkt.school.equ.service.ReformRecordService;

@Service
public class ReformRecordServiceImpl implements ReformRecordService{
	
	private ReformRecordCustomMapper reformRecordCustomMapper;
	
	@Autowired
	public void setReformRecordCustomMapper(
			ReformRecordCustomMapper reformRecordCustomMapper) {
		this.reformRecordCustomMapper = reformRecordCustomMapper;
	}
	public ReformRecordCustomMapper getReformRecordCustomMapper() {
		return reformRecordCustomMapper;
	}

	@Override
	public boolean addReformRecord(ReformRecord reformRecord) {
		// TODO Auto-generated method stub
		if(reformRecord!=null){
			System.out.println("record不为null");
			reformRecordCustomMapper.insert(reformRecord);
			return true;
		}
		return false;
	}
	
	
	public Integer getReformRecordCount(String itemCode, String reformUserName) {
		// TODO Auto-generated method stub
		return reformRecordCustomMapper.countBySearch(itemCode, reformUserName);
	}
	
	@Override
	public List<ReformRecordDto> getReformRecordsByPage(String itemCode,
			String reformUserName,String equName,String equBrand, Pagination page) {
		// TODO Auto-generated method stub
		return reformRecordCustomMapper.selectByLimit(itemCode, reformUserName, equName,equBrand,page.getLimitation());
	}
	@Override
	public ReformRecordDto findReformRecordDtoByReformRecordId(
			Integer reformRecordId) {
		// TODO Auto-generated method stub
		ReformRecordDto  reformRecord=reformRecordCustomMapper.selectReformRecordDtoByReformRecordId(reformRecordId);
		Date date=reformRecord.getReformDate();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date!=null){
			reformRecord.setReformRecordSTime(dateformat.format(date));
		}
		return reformRecord;
	}
	@Override
	public int updateReformRecord(ReformRecordDto reformRecord) {
		// TODO Auto-generated method stub
		return reformRecordCustomMapper.updateByPrimaryKey(reformRecord);
	}
	@Override
	public int deleteReformRecordByReformRecordId(Integer reformRecordId) {
		// TODO Auto-generated method stub
		return reformRecordCustomMapper.deleteByPrimaryKey(reformRecordId);
	}

}
