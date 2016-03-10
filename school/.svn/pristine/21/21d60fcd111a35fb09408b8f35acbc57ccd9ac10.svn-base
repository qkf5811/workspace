package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.CourseScoreDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.stu.model.Student;

public interface CourseScoreCustomMapper extends CourseScoreMapper{
	
	/**
	 * 根据老师id取得所有的课程
	 * @param classId
	 * @param teacherId
	 * @return
	 * 2015年8月24日上午10:28:26
	 */
	public List<Course> getCourseByTeacherId(@Param("classId")Integer classId,@Param("teacherId")Integer teacherId);
	
	/**
	 * 查出班里学生成绩录入
	 * @param studyYearId
	 * @param termType
	 * @param courseId
	 * @param examDate
	 * @param scoreType
	 * @return
	 * 2015年8月24日下午3:39:11
	 */
	public List<Student> getStuToScoreInput(@Param("courseId")Integer courseId);
	
	
	public List<Student> getStuByClass(@Param("classId")Integer classId);
	
	/**
	 * 添加学生课程成绩
	 * @param dtoList
	 * @return
	 * 2015年8月28日下午3:12:00
	 */
	public int addCourseScores(@Param("dtoList")List<CourseScoreDto> dtoList);
	
	
	
	/**
	 * 取得课程授课ID
	 * @param studyYearId
	 * @param termType
	 * @param courseId
	 * @param examDate
	 * @param scoreType
	 * @param teacherId
	 * @param classId
	 * @return
	 * 2015年8月28日下午3:09:26
	 */
	public List<Integer> getTeaCourseId(Integer studyYearId,Integer termType,String courseId
			,String examDate,String scoreType,Integer teacherId,Integer classId);
	
	
	/**
	 * 授课老师的课程
	 * @param teacherId
	 * @return
	 * 2015年8月29日上午10:10:55
	 */
	public List<TeachCourseDto> getTeacherCourseList(@Param("teacherId")Integer teacherId,@Param("dto")TeachCourseDto dto
			,@Param("limit")Limitation limit);
	
	/**
	 * 授课老师的课程条数
	 * @param teacherId
	 * @param dto
	 * @return
	 * 2015年9月14日上午11:07:41
	 */
	public int getTeacherCourseCount(@Param("teacherId")Integer teacherId,@Param("dto")TeachCourseDto dto);
	
	
	/**
	 * 更新授课表
	 * @param courseId
	 * @param examDate
	 * @param scoreType
	 * @param usualScoreRatio
	 * @return
	 * 2015年8月29日上午11:59:08
	 */
	public int updateTeachCourse(@Param("courseId")Integer courseId,@Param("examDate")String examDate
			,@Param("scoreType")String scoreType,@Param("usualScoreRatio")Float usualScoreRatio
			,@Param("dateTime")String dateTime);
	
	
	/**
	 * 课程成绩数据
	 * @param dto
	 * @return
	 * 2015年9月15日上午10:59:25
	 */
	public List<CourseScoreDto> getCourseScoreList(@Param("dto") CourseScoreDto dto);
	
	/**
	 * 所有课程条数
	 * @param dto
	 * @return
	 * 2015年9月15日上午11:01:05
	 */
	public int getAllCourseCount(@Param("dto") TeachCourseDto dto);
	
	/**
	 * 所有课程数据
	 * @param dto
	 * @return
	 * 2015年9月15日上午11:01:07
	 */
	public List<TeachCourseDto> getAllCourseList(@Param("dto") TeachCourseDto dto,@Param("limit")Limitation limit);
	
	/**
	 * 成绩统计数据
	 * @param dto
	 * @return
	 * 2015年9月16日下午4:17:16
	 */
	public List<CourseScoreDto> getCourseCountList(@Param("dto") TeachCourseDto dto);
	
	/**
	 * 课程信息
	 * @param dto
	 * @return
	 * 2015年9月17日上午10:59:51
	 */
	public TeachCourseDto getCourseDto(@Param("dto") TeachCourseDto dto);
	
	
	/**
	 * 查找当前学年
	 * @param value
	 * @return
	 * 2015年9月22日上午9:46:39
	 */
	public int getCurrentValue(@Param("value") String value);
	
	/**
	 * 查找是否已有成绩 
	 * @param value
	 * @return
	 * 2015年9月22日上午9:46:39
	 */
	public int IsExistScore(@Param("courseId") String courseId,@Param("classId") String classId);
	
}
