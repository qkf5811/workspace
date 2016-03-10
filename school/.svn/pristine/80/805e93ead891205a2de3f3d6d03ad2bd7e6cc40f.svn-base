package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dao.TeaChangeCustomMapper;
import com.dkt.school.tea.dao.TeacherCustomMapper;
import com.dkt.school.tea.dto.TeaChangeDto;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.TeaChangeService;
import com.dkt.school.user.dao.UserCustomMapper;
import com.dkt.school.user.model.User;
@Service
public class TeaChangeServiceImpl implements TeaChangeService{
	
	@Autowired
	private TeaChangeCustomMapper teaChangeCustomMapper;
	
	@Autowired
	private TeacherCustomMapper teacherCustomMapper;
	
	@Autowired
	private UserCustomMapper userCustomMapper;
	
	//取得教师异动的数量
	@Override
	public Integer getTeaChangeCount(String name,String code) {
		// TODO Auto-generated method stub
		return teaChangeCustomMapper.getTeaChangeCount(name,code);
	}
	
	//模糊查询取得教师异动的信息
	@Override
	public List<TeaChangeDto> getTeaChangesByPage(String name,String code,PaginationCustom page) {
		return teaChangeCustomMapper.selectByLimit(name,code, page.getLimitation());
	}
	//新增教师异动
	@Override
	public Integer addStudentChange(TeaChangeDto tcDto) {
		int result =0;
		if (tcDto.getChangeType()== null || "".equals(tcDto.getChangeType())
				||tcDto.getTeacherId()== null || "".equals(tcDto.getTeacherId()) ){
			return -1;
		}
		//改变教师的职位状态
		Teacher teacher = teacherCustomMapper.selectByPrimaryKey(tcDto.getTeacherId());
		//病休19001==在职11001，调用19002==聘用11003，退休19004==退休11002，离职19003==离职11004
		if(tcDto.getChangeType()==19001) {
			teacher.setPositionType(11001);
		}
		if(tcDto.getChangeType()==19002) {
			teacher.setPositionType(11003);
		}
		if(tcDto.getChangeType()==19003) {
			Teacher tea=teacherCustomMapper.selectByPrimaryKey(tcDto.getTeacherId());
			User user=userCustomMapper.selectByPrimaryKey(tea.getUserId());
			user.setIsBlocked(2001);
			userCustomMapper.updateByPrimaryKey(user);
			teacher.setPositionType(11004);
		}
		if(tcDto.getChangeType()==19004) {
			teacher.setPositionType(11002);
		}
		teacherCustomMapper.updateByPrimaryKey(teacher);
		
		return teaChangeCustomMapper.insert(tcDto);
	}
	//删除教师异动
	@Override
	public Integer deleteTeaChangeById(Integer id, String code) {
		//改变学生的班别和学籍状态
		TeacherDto teacherDto = teacherCustomMapper.findTeacher(code);
		List<TeaChangeDto> teaChangeDtos=teaChangeCustomMapper.findTeaChangeByCode(code);
		int length=teaChangeDtos.size();
		if(length==1){
			//病休==在职11001，调用==聘用11003，退休==退休11002，离职==离职11004
			//病休改为聘用，调用改为聘用，退休改为聘用，离职改为聘用
			teacherDto.setPositionType(11003);
			
			/*if(teaChangeDtos.get(length-1).getChangeType()==19001) {
				teacherDto.setPositionType(11003);
			}
			if(teaChangeDtos.get(length-1).getChangeType()==19002) {
				teacherDto.setPositionType(11003);
			}*/
			if(teaChangeDtos.get(length-1).getChangeType()==19003) {
				User user=userCustomMapper.selectByPrimaryKey(teacherDto.getUserId());
				user.setIsBlocked(2002);
				userCustomMapper.updateByPrimaryKey(user);
			}
			/*if(teaChangeDtos.get(length-1).getChangeType()==19004) {
				teacherDto.setPositionType(11003);
			}*/
		}
		//查找出来n（n>1)条记录，则删除1~(n-1)之间的任何一条记录，在职状态不会改变
		if(length>1 &&teaChangeDtos.get(length-1).getId()==id){
			if(teaChangeDtos.get(length-2).getChangeType()==19001) {
				teacherDto.setPositionType(11001);
			}
			if(teaChangeDtos.get(length-2).getChangeType()==19002) {
				teacherDto.setPositionType(11003);
			}
			if(teaChangeDtos.get(length-2).getChangeType()==19003) {
				teacherDto.setPositionType(11004);
			}
			if(teaChangeDtos.get(length-2).getChangeType()==19004) {
				teacherDto.setPositionType(11002);
			}
		}
		teacherCustomMapper.updateByPrimaryKey(teacherDto);
		return teaChangeCustomMapper.deleteByPrimaryKey(id);		
	}


}
