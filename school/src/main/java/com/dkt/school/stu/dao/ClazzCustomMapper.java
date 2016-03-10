package com.dkt.school.stu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.DivideClassDto;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.model.Clazz;

public interface ClazzCustomMapper extends ClazzMapper{
	//查询所有
	public List<Clazz> getAllClass();



	//----------炳坚-------------
	//根据专业方向id查看该专业方向的班数
	public Integer getClassCountByMajorFieldId(@Param("majorFieldId")Integer majorFieldId);

	//根据专业方向id查找所有的班别
	public List<ClazzDto> getClassByMajorFieldId(@Param("majorFieldId")Integer majorFieldId);

	//根据班级名字查找班级
	public ClazzDto getClassByClassName(@Param("className")String className);
	//----------炳坚-------------




	//取得班级数量
	public Integer getClassCount(@Param("majorFieldClassName") String majorFieldClassName,
			@Param("gradeName") String gradeName);



	//分页模糊查询
	public List<ClazzDto> getClazzsByPage(
			@Param("majorFieldClassName") String majorFieldClassName,
			@Param("gradeName") String gradeName,
			@Param("limit") Limitation limit);

	//根据专业方向+班级信息来查找班级
	public ClazzDto getClassByMajorFieldClassName(String MajorFieldClass);


	/**
	 * 根据条件查询班级的数量，返回一个Integer类型
	 * @param name
	 * @param gradeId
	 * @param majorFieldId
	 * @param teacherName
	 * @return
	 */
	public Integer countBySearch(@Param("name") String name,@Param("gradeId") Integer gradeId,@Param("majorFieldId") Integer majorFieldId,@Param("teacherName") String teacherName);
	
	
	
	/**
	 * 根据老师id查询班级数量
	 * @param id
	 * @return
	 * 2015年8月21日下午5:22:08
	 */
	public int myClassCount(@Param("teacherId") Integer id);
	
	
	/**
	 * 
	 * @param teacherId
	 * @param limit
	 * @return
	 * 2015年8月22日上午9:37:20
	 */
	public List<ClazzDto> getMyClassByTeacherId(@Param("teacherId")Integer teacherId,@Param("limit") Limitation limit);

    /**
     * 根据条件模糊分页查询班级信息
     * @param name
     * @param gradeId
     * @param majorFieldId
     * @param teacherName
     * @param limit
     * @return
     */
	public List<ClazzDto> selectByLimit(@Param("name") String name,@Param("gradeId") Integer gradeId,@Param("majorFieldId") Integer majorFieldId,@Param("teacherName") String teacherName,@Param("limit") Limitation limit);

	/**
	 * 根据班级id查询班级信息和相关的开设专业信息
	 * @param id
	 * @return
	 */
	public ClazzDto selectClazzDtoByClazzId(@Param("id") Integer id);



	/**
	 * 查询出各个专业的分班情况
	 * @param limit
	 * @return
	 */
	public List<DivideClassDto> selectTotalInfoOfDivideClass(@Param("limit") Limitation limit);



	/**
	 *  查询出各个专业的分班情况的记录数
	 * @return
	 */
	public int selectCountOfTotalInfoOfDivideClass();



	/**
	 * 
	 * @Title: getClassOfGradeOneByMajorFieldId
	 * @author 赖继鹏
	 * @Description: 根据专业方向获取一年级的所有班级
	 * @param majorFieldId
	 * @return     
	 * @throws
	 */
	public List<ClazzDto> getClassOfGradeOneByMajorFieldId(@Param("majorFieldId")int majorFieldId);
}
