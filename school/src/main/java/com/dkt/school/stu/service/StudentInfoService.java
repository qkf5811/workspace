package com.dkt.school.stu.service;

import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.StudentInfoDto;
import com.dkt.school.stu.dto.StudentInfoListDto;
import com.dkt.school.stu.model.StudentInfo;

public interface StudentInfoService {
	
	//录入招生信息记录
	public int addStudentInfo(StudentInfo si);
	
	//根据excel批量录入招生信息
	public long addStuInfoByExcel(InputStream in, String format);
	
	/*********分页查找招生信息****************/
	public int getCountOfNewStudentInfo(String studentName);
	
	public List<StudentInfoDto> getNewStudentInfo(String studentName, PaginationCustom page);
	/****************************************/
	
	//根据studentInfo得到studentInfoDto
	public void getStudentInfoDtoList(List<StudentInfoDto> tmp);
	
	//----------------炳坚--------------------
	//根据专业方向id获得选该专业的所有学生数量
	public Integer getStudentCountByMajorFieldId(Integer majorFieldId);
	
	//根据专业方向id获得选该专业的所有学生
	public List<StudentInfoDto> getManStudentsByMajorFieldId(Integer majorFieldId);
	
	//根据专业方向id获得选该专业的所有学生
	public List<StudentInfoDto> getGirlStudentsByMajorFieldId(Integer majorFieldId);
	//----------------炳坚--------------------


	//根据数据库记录的得到studnetDto 
	public void toStudentInfoDtoList(List<StudentInfoDto> stuInfoList);


	/**
	 * 根据在籍生信息条件模糊查询，并返回查询数目
	 * @param name
	 * @param className
	 * @param sexType
	 * @param status
	 * @param studentStatus
	 * @return
	 */
	public int getStuCount(String name,String className,Integer sexType,Integer status,Integer studentStatus);


	/**
	 * 根据在籍生信息条件模糊分页查询
	 * @param name
	 * @param className
	 * @param sexType
	 * @param status
	 * @param studentStatus
	 * @param page
	 * @return
	 */
	public List<StudentInfoListDto> getStudentsByPage(String name,String className,Integer sexType,Integer status,Integer studentStatus,Pagination page);

	/**
	 * 根据studentInfo的id查找在籍生的基本信息
	 * @param id
	 * @return
	 */
	public StudentInfoListDto getStudentByStudentId(int id);

	/**
	 * 编辑在籍生的基本信息
	 * @param studentInfo
	 * @return
	 */
	public int updateStudentInfo(StudentInfo studentInfo);

}
