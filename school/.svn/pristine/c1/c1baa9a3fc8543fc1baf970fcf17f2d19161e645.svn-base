package com.dkt.school.stu.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.Student;

public interface StudentChangeService {

	//取得学籍异动的数量
	public Integer getStudentChangeCount(String name, String code);
	
	//模糊查詢取得学籍异动
	public List<StudentChangeDto> getStudentChangesByPage(String name, String code, PaginationCustom page);

	//根据学号取得学生
	public StudentDto findStudent(String code);
	
	//新增学籍异动
	public Integer addStudentChange(StudentChangeDto scDto);
	
	//根据id查找studentChange
	public StudentChangeDto findStudentChangeById(Integer id);
	
	//更新学籍异动
	public Integer updateStudentChange(StudentChangeDto scDto);
	
	//删除学籍异动
	public Integer deleteStudentChangeById(Integer id,String code);
	
	//取得所有学生信息
	public List<StudentDto> findAllStudents();
	
	//模糊查詢取得学生信息
	public List<StudentDto> getStudentsByPage(String name, String code,PaginationCustom page);
	
	//根据班级id取得班级名
	public String getClassNameByClassId(Integer classId);
	//根据班级名取得班级
	public ClazzDto getClassByClassName(String className);
	
	//取得班级数量
	public Integer getClassCount(String majorFieldClassName,String gradeName);
	
	//分页模糊查询
	public List<ClazzDto> getClazzsByPage(String majorFieldClassName,String gradeName, PaginationCustom page);
	
	//根据专业方向+班级信息来查找班级
	public ClazzDto getClassByMajorFieldClassName(String MajorFieldClass);
	
	//取得学生数量
	public Integer getStudentsCount(String name,String code);
}
