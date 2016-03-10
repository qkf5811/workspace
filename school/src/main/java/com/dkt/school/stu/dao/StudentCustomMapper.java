package com.dkt.school.stu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.dto.StudentToBeDividedDto;
import com.dkt.school.stu.model.Student;


public interface StudentCustomMapper extends StudentMapper{

	//根据学生Id取得学生Id
	public StudentDto findStudent(String code);

	//取得所有学生的信息
	public List<StudentDto> findAllStudents();

	/**
	 * 根据学号和姓名、班级模糊分页查询
	 *
	 * @param code
	 * @param name
	 * @param classId
	 * @param page
	 * @return
	 */
	public List<StudentDto> selectStudentsByLimit(
			@Param("name") String name,
			@Param("code") String code,
			@Param("limit") Limitation limit);

	// 根据查询条件和page查找student表((模糊查询))
	public List<StudentDto> searchStudentByConditionWithPage(
			@Param("condition") String condition,
			@Param("limit") Limitation limit);

	// 根据查询条件和page查找student表 的记录数量 (模糊查询)
	public int searchCountOfStudentByConditionWithPage(
			@Param("condition") String condition);

	// 根据page查找student表
	public List<StudentDto> searchStudentByPage(@Param("limit") Limitation limit);

	// 根据page查找student表 的数量
	public int searchCountOfStudentByPage();

	//根据班级姓名学号查询学生信息
	public int searchStudentCountByThreeCondition(
			@Param("className")String className,
			@Param("studentName")String studentName,
			@Param("studentCode")String studentCode);
	public List<StudentDto> searchStudentByThreeCondition(
			 @Param("className")String className,
			 @Param("studentName")String studentName,
			 @Param("studentCode")String studentCode,
			 @Param("limit")Limitation limit);

	// 学生注册
	public int regist(@Param("ids") int[] ids);


	//----------炳坚-------------
	/**
	 * 批量导入学生分班的信息
	 */
	public int insertDivideClassByExcellFile(@Param("students")List<Student> students);

	/**
	 * 通过学号查找学生
	 */
	public StudentDto getStudentByCode(@Param("code")String code);
	//----------炳坚-------------

	//取得学生数量
	public Integer getStudentCount(@Param("name") String name,
			@Param("code") String code);
	
	
	
	
	/**
	 * 查询进行手动分班设置的学生列表
	 * @author 赖继鹏
	 * @param dto
	 * @param limitation
	 * @return
	 */
	public List<StudentToBeDividedDto> selectStudentsToDivide(
			@Param("dto")StudentToBeDividedDto dto, @Param("limit")Limitation limit);

	/**
	 * 查询进行手动分班设置的学生人数
	 * @author 赖继鹏
	 * @param dto
	 * @return
	 */
	public int selectCountOfStudentsToDivide(@Param("dto")StudentToBeDividedDto dto);

	/**
	 * 根据majorFieldId获取到学生的最大编号
	 * @author 赖继鹏
	 * @param majorFieldId
	 * @return
	 */
	public int getLastStuIdByClassId(@Param("classId")int classId);

	/**
	 * 根据majorFieldId获取到所对应班级的学生人数
	 * @author 赖继鹏
	 * @param classId
	 * @return
	 */
	public int getStuCountByClassId(@Param("classId")int classId);

	//根据学生id查找学生信息
	public StudentDto findStudentBystuId(@Param("studentId")int studentId);


	/**
	 * 批量插入学生到学生表
	 * @author 赖继鹏
	 * @param toInsertStudentsList
	 * @return
	 */
	public int insertAllStudents(@Param("toInsertStudentsList")List<Student> toInsertStudentsList);


	//-----------------吴俊鹏---------------------
			/**
			 * 根据班别、姓名、学号、是否免学费模糊查询，并返回查询数目
			 * @author 吴俊鹏
			 * @param studentDto
			 * @return int
			 */
			public int countByNameCodeClassNameTuition(
					@Param("studentDto") StudentDto studentDto);
			
			/**
			 * 根据班别、姓名、学号、是否免学费模糊分页查询
			 * @author 吴俊鹏
			 * @param courseDto
			 * @param page
			 * @return
			 */
			public List<Student> selectByLimit( 
					@Param("studentDto") StudentDto studentDto,
					 @Param("limit")Limitation limit);
			
			/**
			 * 一键设置学费免费
			 * @author 吴俊鹏
			 * @param setFreeIds
			 * @return
			 */
			public int setTuitionFree(@Param("setFreeIds") int[] setFreeIds);
			
			/**
			 * 一键取消学费免费
			 * @author 吴俊鹏
			 * @param cancelFreeIds
			 * @return
			 */
			public int cancelTuitionFree(@Param("cancelFreeIds") int[] cancelFreeIds);
			
			//根据学生id找到免学费学生信息
			public StudentDto findFreeTuitionStudentByStudentId(@Param("id") Integer id );
			
			/**
			 * 通过List批量更新免学费学生信息添加
			 * @param dtoList
			 * @return
			 */
			public int updateFreeTuitionStudent(@Param("dto")StudentDto dto);
			
			//-----------------吴俊鹏---------------------
	
	

	/**
	 * 
	 * @Title: selectStudentByMultiCondition
	 * @author 赖继鹏
	 * @Description: 根据专业方向ID、年级ID获取符合条件的学生列表
	 * @param gradeId
	 * @param majorFieldId
	 * @return     
	 * @throws
	 */
	public List<Student> selectStudentByMultiCondition(@Param("gradeId")int gradeId,
			@Param("majorFieldId")int majorFieldId);


}
