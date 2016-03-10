package com.dkt.school.edu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.edu.dto.CourseCountDto;
import com.dkt.school.edu.dto.CourseScoreByStudentDto;
import com.dkt.school.edu.dto.StudentInfoDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.stu.model.Student;

public interface CourseScoreService {
	//取得所有的学年
	public List<StudyYear> getAllStudyYear();
	
	/**
	 * 根据老师id取得所有的课程
	 * @param teacherId
	 * @return
	 * 2015年8月24日上午10:02:08
	 */
	public List<Course> getCourseByTeacherId(Integer classId ,Integer teacherId);
	
	/**
	 * 查出班里学生
	 * @param studyYearId
	 * @param termType
	 * @param courseName
	 * @param examDate
	 * @param scoreType
	 * @return
	 * 2015年8月24日下午2:24:49
	 */
	public List<Student> getStuToScoreInput(Integer courseId);
	
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
	 * 添加学生课程成绩
	 * @param courseScore
	 * @return
	 * 2015年8月27日上午10:52:41
	 */
	public int addCourseScores(String[] numberboxs,String[] examScore,String[] totalScore,Integer[] examNature,
			Integer[] studentId,Integer teachCourseId,String scoreType);
	
	
	/**
	 * 授课老师的课程
	 * @param teacherId
	 * @return
	 * 2015年8月29日上午10:10:55
	 */
	public List<TeachCourseDto> getTeacherCourseList(Integer teacherId,TeachCourseDto dto,Pagination page);
	
	/**
	 * 更新授课表
	 * @param courseId
	 * @param examDate
	 * @param scoreType
	 * @param usualScoreRatio
	 * @return
	 * 2015年8月29日上午11:59:08
	 */
	public int updateTeachCourse(Integer courseId,String examDate,String scoreType,Float usualScoreRatio,String dateTime);

	public List<CourseScoreByStudentDto> getStuCourseScoreList(String studentCode);

	public StudentInfoDto getStudentInfo(String studentCode);

	public List<Map<String, Object>> getStudyYearAndTermName(String studentCode);

	
	/**
	 * 成绩统计数据
	 * @param dto
	 * @return
	 * 2015年9月16日下午4:17:16
	 */
	public Map<String,CourseCountDto> getCourseCountList(TeachCourseDto dto);

	/**
	 * 查询学号是否存在
	 * @param studentCode
	 * @return 
	 */
	public Integer isExistStudentCode(String studentCode);

	/**
	 * 查询对应学年、学期、班、课程成绩 
	 * @author HIU
	 * @param studyYear
	 * @param termName
	 * @param courseCode
	 * @param className
	 * @return
	 */
	public List<CourseScoreByStudentDto> getScoreByCourse(String studentCode,String studyYear, String termName,
			String courseCode, String className);

	public HashMap<String, Object> getscoreRegion(String string, String string2, String string3,
			String string4, String string5);
	
}
