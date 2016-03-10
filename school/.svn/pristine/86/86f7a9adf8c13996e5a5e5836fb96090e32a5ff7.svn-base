package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.BorrowRecordCustomMapper;
import com.dkt.school.equ.dao.BorrowRecordMapper;
import com.dkt.school.equ.dto.BorrowRecordDto;

import com.dkt.school.equ.service.BorrowRecordService;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

	@Autowired
	private BorrowRecordMapper brMapper;

	@Autowired
	private BorrowRecordCustomMapper brcMapper;

	// 取得借用记录的总数
	@Override
	public Integer getBorrowReportCount(Integer itemId,
			String name) {
		return brcMapper.getBorrowReportCount(itemId, name);
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
	public List<BorrowRecordDto> getBorrowRecordsByPage(Integer itemId,
			String name, Pagination page) {
		return brcMapper.selectByLimit(itemId, name, page.getLimitation());
	}

	// 新建一条借用记录
	@Override
	public Integer addBorrowRecord(BorrowRecordDto brDto) {
		int result = 0;
		if (brDto.getItemId() == null || "".equals(brDto.getItemId())) {
			return -1;
		}
		// 判断领用记录是否存在
		BorrowRecordDto urD = brcMapper.selectBorrowRecordDtoByItemId(brDto
				.getItemId());
		if (urD == null) {
			return brMapper.insert(brDto);
		} else {
			result = -2;
		}
		return result;
	}

	// 根据itemId删除一条借用记录
	@Override
	public Integer deleteBorrowRecordByItemId(Integer itemId) {
		return brcMapper.deleteBorrowRecordByItemId(itemId);
	}

	// 根据借用记录id查找借用记录信息
	@Override
	public BorrowRecordDto findBorrowRecordDtoByItemId(Integer itemId) {
		return brcMapper.selectBorrowRecordDtoByItemId(itemId);
	}

	// 更新一条借用记录
	@Override
	public Integer updateBorrowRecord(BorrowRecordDto borrowRecordDto) {
		return brcMapper.updateBorrowRecord(borrowRecordDto);
	}

}
