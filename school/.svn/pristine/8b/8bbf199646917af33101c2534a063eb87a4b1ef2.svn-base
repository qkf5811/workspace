package com.dkt.school.fin.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.StudentAccountDto;
import com.dkt.school.stu.dto.StudentDto;

public interface StudentAccountService {
	//取得学生账号的数量
	public Integer getStudentAccountCount(String finStuName, Integer finGrade,String finClassName, Integer finMajor, Integer finField);

	//分页模糊查询学生账号
	public List<StudentAccountDto> getStudentAccountsByPage(String finStuName, Integer finGrade,String finClassName, Integer finMajor, Integer finField,PaginationCustom page);

	//更新学生账号信息
	public Integer updateStudentAccount(StudentAccountDto studentAccountDto);
	
	//添加学生账号记录
	public Integer addStudentAccount(StudentAccountDto studentAccountDto);
	
	//查询学生账号
	public List<StudentAccountDto> getStudentAccounts();
	
	//查找所有的学生
	public List<StudentDto> findAllStudent();
	
	/**
	 * 根据模板文件路径填充学生银行账号信息
	 * @param stuIds
	 * @param dir
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getStudentAccountExcel(Integer[] stuIds, File dir) throws FileNotFoundException, IOException;
	
	/**
	 * 通过excel导入学生账号信息
	 * @param inputStream
	 * @param format
	 * @return
	 */
	public long addStudentAccountByExcel(InputStream inputStream,
			String format);
	
	//取得所有未录入的学生的id
	public List<Integer> getStudentIdsByNotSettingStudentAccount();
}
