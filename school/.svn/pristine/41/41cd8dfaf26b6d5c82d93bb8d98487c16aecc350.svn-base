package com.dkt.school.stu.service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.Pagination;

import org.apache.poi.ss.usermodel.Row;

import com.dkt.school.common.page.Limitation;
//import com.dkt.school.fin.service.Student;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.Student;

public interface StudentService {
	
	//根据查询条件和page查找student表(模糊查询)
	public List<StudentDto> searchStudentByConditionWithPage(String condition, Limitation limit);
	
	//根据查询条件和page查找student表 的记录数量(模糊查询)
	public int searchCountOfStudentByConditionWithPage(String condition);
	
	//根据page查找student表
	public List<StudentDto> searchStudentByPage(Limitation limit);
	
	//根据班级姓名学号查询学生信息
	public List<StudentDto> searchStudentByThreeCondition(String className,
			String studentName,
			String StudentCode,
			Limitation limit);
	
	//根据班级姓名学号查询学生记录的数量
	public int searchStudentCountByThreeCondition(String className, String studentName, String StudentCode);
	
	//根据page查找student表 的数量
	public int searchCountOfStudentByPage();
	
	//学生注册
	public int studentRegist(int[] ids);

	//studentDto的其他页面字段赋值
	public void getStudentDto(List<StudentDto> list);

	
	//导出学籍信息
	public void getStudentInfoByExcelFile(File file);

	
	
	
	//----------------炳坚--------------------
	/**
	 * 根据导入的excell来分班
	 */
	public int toDivideClassByUploadExcel(InputStream fileInputStream,String format);
	
	/**
	 * 判断excell的第一行（标题行）是否有效
	 */
	public boolean isExcelTitleValidate(Row titleRow);
	//----------------炳坚--------------------

	
	//----------------吴俊鹏----------------
	/**
	 * 根据班别、姓名、学号、是否免学费模糊查询，并返回查询数目
	 * @author 吴俊鹏
	 * @param studentDto
	 * @return int
	 */
	public int getStudentCount(StudentDto studentDto);
	
	/**
	 * 根据班别、姓名、学号、是否免学费模糊分页查询
	 * @author 吴俊鹏
	 * @param studentDto
	 * @param page
	 * @return
	 */
	public List<Student> getStudentByPage(StudentDto studentDto,Pagination page);
	
	/**
	 * 一键设置学费免费
	 * @author 吴俊鹏
	 * @param setFreeIds
	 * @return
	 */
	public int setTuitionFree(int[] setFreeIds);
	
	/**
	 * 一键取消学费免费
	 * @author 吴俊鹏
	 * @param cancelFreeIds
	 * @return
	 */
	public int cancelTuitionFree(int[] cancelFreeIds);
	
	/**
	 * 根据模板文件路径填充免学费学生信息
	 * @param stuIds
	 * @param dir
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getFreeTuitionStudentExcel(Integer[] stuIds, File dir) throws FileNotFoundException, IOException;
	
	/**
	 * 通过excel导入学生账号信息
	 * @param inputStream
	 * @param format
	 * @return
	 */
	public String addFreeTuitionStudentByExcel(InputStream inputStream,
			String format);

	/**
	 * 
	 * @Title: getStudentsByClassId
	 * @author 赖继鹏
	 * @Description: 根据班级Id获取学生
	 * @param classId
	 * @return     
	 * @throws
	 */
	public List<Student> getStudentsByClassId(int classId);
	
	//----------------吴俊鹏---------------
}
