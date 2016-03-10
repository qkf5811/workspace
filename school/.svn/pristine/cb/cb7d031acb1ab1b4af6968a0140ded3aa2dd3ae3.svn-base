package com.dkt.school.equ.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.MaintainRecordCustomMapper;
import com.dkt.school.equ.dto.MaintainRecordDto;
import com.dkt.school.equ.model.MaintainRecord;
import com.dkt.school.equ.service.MaintainRecordService;

@Service
public class MaintainRecordServiceImpl implements MaintainRecordService{
	
	private MaintainRecordCustomMapper maintainRecordCustomMapper;
	
	@Autowired
	public void setMaintainRecordCustomMapper(
			MaintainRecordCustomMapper maintainRecordCustomMapper) {
		this.maintainRecordCustomMapper = maintainRecordCustomMapper;
	}
	public MaintainRecordCustomMapper getMaintainRecordCustomMapper() {
		return maintainRecordCustomMapper;
	}

	@Override
	public boolean addMaintainRecord(MaintainRecord maintainRecord) {
		// TODO Auto-generated method stub
		if(maintainRecord!=null){
			System.out.println("record不为null");
			maintainRecordCustomMapper.insert(maintainRecord);
			return true;
		}
		return false;
	}
	
	
	public Integer getMaintainRecordCount(String itemCode, String maintainUserName) {
		// TODO Auto-generated method stub
		return maintainRecordCustomMapper.countBySearch(itemCode, maintainUserName);
	}
	
	@Override
	public List<MaintainRecordDto> getMaintainRecordsByPage(String itemCode,
			String maintainUserName, String equName,String equBrand,Pagination page) {
		// TODO Auto-generated method stub
		return maintainRecordCustomMapper.selectByLimit(itemCode, maintainUserName,equName ,equBrand,page.getLimitation());
	}
	@Override
	public MaintainRecordDto findMaintainRecordDtoByMaintainRecordId(
			Integer maintainRecordId) {
		// TODO Auto-generated method stub
		MaintainRecordDto  maintainRecord=maintainRecordCustomMapper.selectMaintainRecordDtoByMaintainRecordId(maintainRecordId);
		Date date=maintainRecord.getMaintainDate();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date!=null){
			//maintainRecord.setMaintainDate(dateformat.format(date));
			maintainRecord.setMaintainRecordSTime(dateformat.format(date));
		}
		return maintainRecord;
	}
	@Override
	public int updateMaintainRecord(MaintainRecordDto maintainRecord) {
		// TODO Auto-generated method stub
		return maintainRecordCustomMapper.updateByPrimaryKey(maintainRecord);
	}
	@Override
	public int deleteMaintainRecordByMaintainRecordId(Integer maintainRecordId) {
		// TODO Auto-generated method stub
		return maintainRecordCustomMapper.deleteByPrimaryKey(maintainRecordId);
	}

}
