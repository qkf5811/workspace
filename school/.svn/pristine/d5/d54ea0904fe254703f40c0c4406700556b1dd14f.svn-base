package com.dkt.school.stu.dao;

import java.util.List;

import com.dkt.school.stu.dto.StudentInfoListDto;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.NewStudentPaymentOfExcelDto;
import com.dkt.school.stu.dto.StudentInfoDto;
import com.dkt.school.stu.model.StudentInfo;

public interface StudentInfoCustomMapper extends StudentInfoMapper {

	//根据excel批量录入招生信息
	public int insertStuInfoByExcelFile(
			@Param("stuList") List<StudentInfo>  stuList);
	
	/*********分页学生信息****************/
	public int getCountOfNewStudentInfo(@Param("studentName") String studentName);
	
	public List<StudentInfoDto> getNewStudentInfo(
			@Param("studentName") String studentName,
			@Param("limit")Limitation limit);
	/****************************************/
	
	
	//----------炳坚-------------
	//根据专业方向id获得选该专业的所有学生数量
	public Integer getStudentCountByMajorFieldId(@Param("majorFieldId") Integer majorFieldId);
	
	//根据专业方向id获得选该专业的所有男学生
	public List<StudentInfoDto> getManStudentsByMajorFieldId(@Param("majorFieldId") Integer majorFieldId);
	//根据专业方向id获得选该专业的所有女学生
	public List<StudentInfoDto> getGirlStudentsByMajorFieldId(@Param("majorFieldId") Integer majorFieldId);
	
	//插入新生基本信息并返回新生基本信息id
	public Integer insertStudentInfoAndGetId(StudentInfoDto studentInfoDto);
	//----------炳坚-------------

	//根据学生表获取学生基本信息
	public List<StudentInfoDto> findStudentInfoByStudent();


	/**
	 * 根据条件查询在籍生的数量，返回一个Integer类型
	 * @param name
	 * @param className
	 * @param sexType
	 * @param status
	 * @param studentStatus
	 * @return
	 */
	public Integer countBySearch(

	 @Param("name") String name,@Param("className") String className,@Param("sexType") Integer sexType,@Param("status") Integer status,@Param("studentStatus") Integer studentStatus);

	/**
	 * 根据条件模糊分页查询在籍生信息
	 * @param name
	 * @param className
	 * @param sexType
	 * @param status
	 * @param studentStatus
	 * @param limit
	 * @return
	 */
	public List<StudentInfoListDto> selectByLimit(@Param("name") String name,@Param("className") String className,@Param("sexType") Integer sexType,@Param("status") Integer status,@Param("studentStatus") Integer studentStatus,@Param("limit") Limitation limit);

	/**
	 * 根据在籍生的id查询在籍生信息
	 * @param id
	 * @return
	 */
	public StudentInfoListDto selectByStudentId(@Param("id") int id);
	
	/**
	 * 根据身份证获取该学生在学生信息表的id
	 * @param idCard
	 * @return
	 */
	public int selectIdByIdCard(@Param("idCard")String idCard);

	/**
	 * 批量更新设置学生信息表的录取号
	 * @param list
	 */
	public void updateAdmissionByNewStudentPaymentOfExcelDto(
			@Param("list")List<NewStudentPaymentOfExcelDto> list);

	/**
	 * 获取报取同一个专业方向下未分班的学生名单
	 * @param id
	 * @return
	 */
	public List<StudentInfo> getToBeDividedStudentsByMajorFieldId(@Param("majorFieldId")int majorFieldId);
	
	/**
	 * 获取报取同一个专业方向下已经分班的学生名单
	 * @param id
	 * @return
	 */
	public List<StudentInfo> getDividedStudentsByMajorFieldId(@Param("majorFieldId")int majorFieldId);

	/**
	 * 
	 * @Title: getSexTypeByStudentId
	 * @author 赖继鹏
	 * @Description: 根据学生Id获取学生性别
	 * @param studentId
	 * @return     
	 * @throws
	 */
	public String getSexTypeByStudentId(@Param("studentId")int studentId);

	/**
	 * 根据学生的idCard查询该学生的信息
	 * @author 冯其康
	 * @param idCard
	 * @return
	 */
	public StudentInfo findStudentinfoByIdCard(
			@Param("idCard") String idCard);

	/**
	 * 根据学生的学籍号查询该学生的信息
	 * @author stephen
	 * @param name
	 * @return
	 */
	public StudentInfo findStudentInfoByStudentNumber(
			@Param("studentNumber") String studentNumber);

	/**
	 * 批量更新学生信息
	 * @param updList
	 */
	public int updateByList(
			@Param("list")List<StudentInfo> updList);

}
