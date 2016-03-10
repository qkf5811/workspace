package com.dkt.school.stu.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.stu.dao.StuChangeClassCustomMapper;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.StuChangeClass;
import com.dkt.school.stu.model.StudentChange;
import com.dkt.school.stu.service.StuChangeClassService;

@Service
public class StuChangeClassServiceImpl implements StuChangeClassService {

	@Autowired
	private StuChangeClassCustomMapper stuChangeClassMapper;

	@Autowired
	private StudentCustomMapper studentMapper;
	
	@Override
	public int getStuChangeClassCount(StudentChangeDto dto) {
		return stuChangeClassMapper.getStuChangeClassCount(dto);
	}

	@Override
	public List<StudentChangeDto> getStuChangeClassListData(StudentChangeDto dto,Pagination page) {
		return stuChangeClassMapper.getStuChangeClassListData(dto,page.getLimitation());
	}

	@Override
	public int stuChangeClassSave(StudentChangeDto obj) {
		StuChangeClass model = new StuChangeClass();
		BeanUtils.copyProperties(obj, model);
		
		int result =0;
		if (obj.getChangeType()== null || "".equals(obj.getChangeType())
				||obj.getStudentId()== null || "".equals(obj.getStudentId()) ){
			return -1;
		}
		
		//改变学生的班别和学籍状态
		StudentDto studentDto = studentMapper.findStudent(obj.getCode());
		studentDto.setClassId(obj.getIntoClassId());
		studentMapper.updateByPrimaryKey(studentDto);
		return stuChangeClassMapper.insert(model);
	}

	@Override
	public int stuChangeClassUpdate(StudentChangeDto obj) {
		StuChangeClass model = new StuChangeClass();
		BeanUtils.copyProperties(obj, model);
		return stuChangeClassMapper.updateByPrimaryKey(model);
	}

	@Override
	public int stuChangeClassDelete(Integer id,String code) {
		StudentDto studentDto = studentMapper.findStudent(code);
		List<StudentChangeDto> studentChangeDtos=stuChangeClassMapper.findStudentChangeByCode(code);
		int length=studentChangeDtos.size();
		if(length==1){
			studentDto.setClassId(studentChangeDtos.get(length-1).getOutClassId());
			/*//学籍状态为0，表示为正常
			studentDto.setStatus(0);*/
			
		}
		//查找出来n（n>1)条记录，则删除1~(n-1)之间的任何一条记录，班级和学籍状态不会改变
		if(length>1 &&studentChangeDtos.get(length-1).getId()==id){
			studentDto.setClassId(studentChangeDtos.get(length-2).getIntoClassId());
		/*	studentDto.setStatus(studentChangeDtos.get(length-2).getChangeType());	*/	
		}
		studentMapper.updateByPrimaryKey(studentDto);
		return stuChangeClassMapper.deleteByPrimaryKey(id);
	}

	@Override
	public StudentChange getStuChangeClassById(Integer id) {
		return stuChangeClassMapper.getStuChangeClassById(id);
	}

	

}
