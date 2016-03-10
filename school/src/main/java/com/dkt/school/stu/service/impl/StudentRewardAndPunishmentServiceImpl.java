package com.dkt.school.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dao.StudentPunishmentCustomMapper;
import com.dkt.school.stu.dao.StudentPunishmentMapper;
import com.dkt.school.stu.dao.StudentRewardCustomMapper;
import com.dkt.school.stu.dao.StudentRewardMapper;
import com.dkt.school.stu.dto.StudentPunishmentDto;
import com.dkt.school.stu.dto.StudentRewardDto;
import com.dkt.school.stu.model.StudentPunishment;
import com.dkt.school.stu.model.StudentReward;
import com.dkt.school.stu.service.StudentRewardAndPunishmentService;

/**
 * Created by JanGin on 2015/6/12.
 */
@Service
public class StudentRewardAndPunishmentServiceImpl implements StudentRewardAndPunishmentService {

    @Autowired
    private StudentRewardMapper srMapper;

    @Autowired
    private StudentPunishmentMapper spMapper;
    
    @Autowired
    private StudentPunishmentCustomMapper spcMapper;
    
    @Autowired
    private StudentRewardCustomMapper srcMapper;

    public int addStudentRewardRecord(StudentReward record) {
        if (record != null){
            return srMapper.insertSelective(record);
        }
        return -1;

    }

    public int addStudentPunishmentRecord(StudentPunishment record) {
        if (record != null) {
            return spMapper.insertSelective(record);
        }
        return -1;
    }

	@Override
	public List<StudentRewardDto> getStudentRewardDtoList(
			String code,Integer rewardType,String name,
			Limitation limit) {
		List<StudentRewardDto> list = srcMapper.getStudentRewardDtoList(code, rewardType,name,limit);
		if (list != null){
			//这里数据一多我想huoxu会慢的要死
			for (StudentRewardDto dto : list){
				if (dto.getRewardType().equals(12001)){
					dto.setRewardTypeStr("三好学生");
				}
				if (dto.getRewardType().equals(12002)){
					dto.setRewardTypeStr("优秀班干");
				}
				if (dto.getRewardType().equals(12003)){
					dto.setRewardTypeStr("奖学金");
				}
			}
		}
		return list;
	}

	@Override
	public int getStudentRewardCount(String code,Integer rewardType,String name) {
	
		return srcMapper.getStudentRewardCount(code,rewardType,name);
	}

	@Override
	public int getStudentPunishmentCount(String code,Integer punishmentType,String name) {
		
		return spcMapper.getStudentPunishmentCount(code,punishmentType,name);
	}

	@Override
	public List<StudentPunishmentDto> getStudentPunishmentDtoList(
			String code,Integer punishmentType,
			String name,Limitation limit) {	
		List<StudentPunishmentDto> list = spcMapper.getStudentPunishmentDtoList(code, punishmentType,name,limit);
		if (list != null){
			for (StudentPunishmentDto dto : list){
				if (dto.getPunishmentType().equals(13001)){
					dto.setPunishmentTypeStr("通报批评");
				}
				if (dto.getPunishmentType().equals(13002)){
					dto.setPunishmentTypeStr("留校察看");
				}
				if (dto.getPunishmentType().equals(13003)){
					dto.setPunishmentTypeStr("记过");
				}
			}
		}
		return list;
	}

	@Override
	public StudentRewardDto getStudentRewardDtoById(Integer id,Integer studentId) {
		if (id != null){
			return srcMapper.getStudentRewardDtoById(id,studentId);
		}
		return null;
	}

	@Override
	public StudentPunishmentDto getStudentPunishmentDtoById(Integer id,Integer studentId) {
		if (id != null){
			return spcMapper.getStudentPunishmentDtoById(id,studentId);
		}
		return null;
	}

	@Override
	public int updateRewardInfo(StudentRewardDto srDto) {
		
		return srcMapper.updateRewardInfo(srDto);
	}

	@Override
	public int deleteRewardInfo(Integer id){
		return srcMapper.deleteByStudentId(id);
	}

	@Override
	public int deletePunishmentInfo(Integer id) {
		return spcMapper.deleteByStudentId(id);
	}

	@Override
	public int updatePunishmentInfo(StudentPunishmentDto spDto) {
		return spcMapper.updatePunishmentInfo(spDto);
	}

	@Override
	public List<StudentPunishmentDto> getAllPunishmentStuList(String name,String code,Limitation limit) {
		
		return spcMapper.getAllPunishmentStuList(name,code,limit);
	}

	@Override
	public List<StudentRewardDto> getAllRewardStuList(String name,String code,Limitation limit) {
		
		return srcMapper.getAllRewardStuList(name,code,limit);
	}

	@Override
	public int getAllRewardStuCount(String name,String code) {
		return srcMapper.getAllRewardStuCount(name,code);
	}

	@Override
	public int getAllPunishmentStuCount(String name,String code) {
		return spcMapper.getAllPunishmentStuCount(name,code);
	}
}
