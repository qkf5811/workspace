package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.UseRecordCustomMapper;
import com.dkt.school.equ.dao.UseRecordMapper;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.exception.BorrowRecordException;
import com.dkt.school.equ.exception.UseRecordException;
import com.dkt.school.equ.model.UseRecord;
import com.dkt.school.equ.service.UseRecordService;
import com.dkt.school.user.dto.UserDto;

@Service
public class UseRecordServiceImpl implements UseRecordService {

	@Autowired
	private UseRecordMapper urMapper;

	@Autowired
	private UseRecordCustomMapper urcMapper;

	// 根据领用记录Id删除某一条领用记录
	public int deleteUseRecordById(Integer useRecordId) {
		
		return urMapper.deleteByPrimaryKey(useRecordId);
	}

	// 根据领用记录Id查找某一条领用记录
	@Override
	public UseRecordDto findUseRecordById(Integer useRecordId) {
		if (useRecordId == null) {
			throw new UseRecordException();
		}
		UseRecord useRecord = urcMapper.findUseRecordById(useRecordId);
		UseRecordDto urDto = new UseRecordDto();
		BeanUtils.copyProperties(useRecord, urDto);
		return urDto;
	}

	// 取得领用记录的总数
	@Override
	public Integer getUseReportCount(Integer itemId,String name) {
		return urcMapper.getUseReportCount(itemId, name);
	}

	/**
	 * 根据设备ID和姓名模糊分页查询
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	@Override
	public List<UseRecordDto> getUseRecordsByPage(Integer itemId, String name,
			Pagination page) {
		return urcMapper.selectByLimit(itemId, name, page.getLimitation());
	}

	// 新建一条领用记录
	@Override
	public Integer addUseRecord(UseRecordDto urd) {
		int result = 0;
		if (urd.getItemId() == null || "".equals(urd.getItemId())) {
			return -1;
		}
		// 判断领用记录是否存在
		UseRecordDto urDto = urcMapper.selectUseRecordDtoByItemId(urd
				.getItemId());
		if (urDto == null) {
			return urMapper.insert(urd);
		} else {
			result = -2;
		}
		return result;
	}

	// 根据领用记录id查找领用记录信息
	@Override
	public UseRecordDto findUseRecordDtoByItemId(Integer itemId) {
		return urcMapper.selectUseRecordDtoByItemId(itemId);
	}

	// 更新一条领用记录
	@Override
	public Integer updateUseRecord(UseRecordDto useRecordDto) {
		System.out.println("xinxi:"+useRecordDto.getId());
		return urcMapper.updateUseRecord(useRecordDto);
	}

	// 根据设备Id删除领用记录
	@Override
	public Integer deleteUseRecordByItemId(Integer itemId) {

		return urcMapper.deleteUseRecordByItemId(itemId);
	}

}
