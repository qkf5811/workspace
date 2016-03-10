package com.dkt.school.equ.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.ScrapRecordCustomMapper;
import com.dkt.school.equ.dto.ScrapRecordDto;
import com.dkt.school.equ.model.ScrapRecord;
import com.dkt.school.equ.service.ScrapRecordService;

@Service
public class ScrapRecordServiceImpl implements ScrapRecordService{
	
	private ScrapRecordCustomMapper scrapRecordCustomMapper;
	
	@Autowired
	public void setScrapRecordCustomMapper(
			ScrapRecordCustomMapper scrapRecordCustomMapper) {
		this.scrapRecordCustomMapper = scrapRecordCustomMapper;
	}
	public ScrapRecordCustomMapper getscrapRecordCustomMapper() {
		return scrapRecordCustomMapper;
	}

	@Override
	public boolean addScrapRecord(ScrapRecord scrapRecord) {
		// TODO Auto-generated method stub
		if(scrapRecord!=null){
			System.out.println("record不为null");
			scrapRecordCustomMapper.insert(scrapRecord);
			return true;
		}
		return false;
	}
	
	
	public Integer getScrapRecordCount(String itemCode, String scrapUserName) {
		// TODO Auto-generated method stub
		return scrapRecordCustomMapper.countBySearch(itemCode,scrapUserName);
	}
	
	@Override
	public List<ScrapRecordDto> getScrapRecordsByPage(String itemCode,
			String scrapUserName,  String equName,String equBrand,Pagination page) {
		// TODO Auto-generated method stub
		return scrapRecordCustomMapper.selectByLimit(itemCode,scrapUserName, equName ,equBrand,page.getLimitation());
	}
	@Override
	public ScrapRecordDto findScrapRecordDtoByScrapRecordId(
			Integer scrapRecordId) {
		// TODO Auto-generated method stub
		System.out.println("findScrapRecordDtoByScrapRecordId");
		ScrapRecordDto  scrapRecord=scrapRecordCustomMapper.selectScrapRecordDtoByScrapRecordId(scrapRecordId);
		System.out.println("asd   "+scrapRecord.getItemCode());
		Date date=scrapRecord.getScrapDate();
		System.out.println(date);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date!=null){
			scrapRecord.setScrapRecordSTime(dateformat.format(date));
		}
		return scrapRecord;
	}
	@Override
	public int updateScrapRecord(ScrapRecordDto scrapRecord) {
		// TODO Auto-generated method stub
		return scrapRecordCustomMapper.updateByPrimaryKey(scrapRecord);
	}
	@Override
	public int deleteScrapRecordByScrapRecordId(Integer scrapRecordId) {
		// TODO Auto-generated method stub
		return scrapRecordCustomMapper.deleteByPrimaryKey(scrapRecordId);
	}

}
