package com.dkt.school.fin.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.StudentAccountDto;
import com.dkt.school.tea.dto.TeacherTotalInfoDto;

public interface StudentAccountCustomMapper extends StudentAccountMapper{
	//取得学生账号的数量
	public Integer getStudentAccountCount(@Param("finStuName") String finStuName,
			@Param("finGrade") Integer finGrade, 
			@Param("finClassName") String finClassName,
			@Param("finMajor") Integer finMajor,@Param("finField")Integer finField);
	
	//分页模糊查询学生账号
	public List<StudentAccountDto> selectByLimit(@Param("finStuName") String finStuName,
			@Param("finGrade") Integer finGrade, 
			@Param("finClassName") String finClassName,
			@Param("finMajor") Integer finMajor,@Param("finField")Integer finField, 
			@Param("limit") Limitation limit);	
	
	//根据学生id找到学生账号信息
	public StudentAccountDto findStudentAccountByStudentId(@Param("studentId") Integer studentId );
	
	//查询学生账号
	public List<StudentAccountDto> getStudentAccounts();		
	
	/**
	 * 通过学生账号List批量学生账号记录添加
	 * @param dtoList
	 * @return
	 */
	public int addStudentAccountByList(@Param("dtoList")List<StudentAccountDto> dtoList);
	
	/**
	 * 通过学生账号List批量更新学生账号记录添加
	 * @param dtoList
	 * @return
	 */
	public int updateStudentAccountrByList(@Param("dtoList")List<StudentAccountDto> dtoList);
	/**
	 * 根据dto批量删除学生账号
	 * @param dtoList
	 */
	public void deleteStudentAccountByList(@Param("dtoList")List<StudentAccountDto> dtoList);
	
	//取得所有未录入的学生的id
	public List<Integer> getStudentIdsByNotSettingStudentAccount();
	
	//查找相同的账号
	public String findSameAccount(@Param("account")String account,@Param("studentId")Integer studentId);
	
}
