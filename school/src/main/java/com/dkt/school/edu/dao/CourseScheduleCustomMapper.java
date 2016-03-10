package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CoursePlanOfCourseScheduleDto;
import com.dkt.school.edu.dto.CourseScheduleDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.model.CoursePlan;
import com.dkt.school.edu.model.CourseSchedule;
import com.dkt.school.edu.model.CourseTeacher;
import com.dkt.school.edu.model.TeachCourse;
import com.dkt.school.edu.model.TeachTask;


public interface CourseScheduleCustomMapper extends CourseScheduleMapper {
	
	/**
	 * 根据model更新
	 * @param schedule
	 * @return
	 */
	public int updateByCourseSchedule(@Param("schedule")CourseSchedule schedule);

	/**
	 * 根据用户id获取课表，用于我的课表页面
	 * @param userId
	 * @return
	 */
	public List<CourseScheduleDto> getPersonalCourseScheduleByUserId(
			@Param("userId")Integer userId);

	public List<CourseScheduleDto> findCourseSchedule(@Param("gradeId")Integer gradeId,@Param("classes")String classes,
			@Param("teacherName")String teacherName);

	/**
	 * 查看每个教师所在班级的课表
	 * @param gradeId
	 * @param classId
	 * @return
	 */
	public List<CourseScheduleDto> showClassSchedule(@Param("gradeId")Integer gradeId,
			@Param("classId")Integer classId);

	/**
	 * @author 冯其康
	 * 根据班级id查询课程
	 * @param majorId
	 * @param fieldId
	 * @return
	 */
	public List<CourseInTeaCourseTableDto> selectCourseByClassId(
			@Param("classId")int classId);

	/**
	 * @author 冯其康
	 * 查询课程计划的数量
	 * @param majorId
	 * @param fieldId
	 * @param courseName
	 * @return
	 */
	public int selectCountOfCoursePlanInCourseSchedule(
			@Param("majorId")int majorId,
			@Param("fieldId")int fieldId,
			@Param("courseName")String courseName,
			@Param("className")String className);

	/**
	 * @author 冯其康
	 * 查询课程计划
	 * @param majorId
	 * @param fieldId
	 * @param courseName
	 * @param limitation
	 * @return
	 */
	public List<CoursePlanOfCourseScheduleDto> selectCoursePlanInCourseSchedule(
			@Param("majorId")int majorId,
			@Param("fieldId")int fieldId, 
			@Param("courseName")String courseName,
			@Param("className")String className,
			@Param("limit")Limitation limitation);
	
	/**
	 * 根据学年名称获取学年id
	 * @param studyYear
	 * @return
	 */
	public Integer getStudyYearIdByStudyYear(@Param("studyYear")String studyYear);
	
	/**
	 * 根据专业获取专业的id
	 */
	public Integer getMajorIdByMajor(@Param("major")String major);
	
	/**
	 * 根据专业方向名称获取专业方向id
	 */
	public Integer getFieldIdByField(@Param("field")String field);
	
	/**
	 * 根据教室名称获取教室id
	 * @param classroom
	 * @return
	 */
	public Integer getClassRoomIdByClassRoom(@Param("classroom")String classroom);

	/**
	 * 根据学期值获取学期的类型枚举值
	 * @param term
	 * @return
	 */
	public Integer getTermTypeByTerm(@Param("term")String term);

	/**
	 * 根据课程名称获取课程id
	 * @param course
	 * @return
	 */
	public Integer getCourseIdByCourse(@Param("course")String course);

	/**
	 * 根据课程类型值获取课程类型枚举值
	 * @param course
	 * @return
	 */
	public Integer getCourseTypeByCourse(@Param("courseType")String courseType);

	/**
	 * 根据年级名称找到年级id
	 * @param grade
	 * @return
	 */
	public Integer getGradeIdByGrade(@Param("grade")String grade);

	/**
	 * 根据教师查找教师id
	 * @param teacher
	 * @return
	 */
	public Integer getTeacherIdByTeacher(@Param("teacher")String teacher);

	/**
	 * 根据星期查找星期枚举值
	 * @param stringCellValue
	 * @return
	 */
	public Integer getWeekDayIdByWeekDay(@Param("weekday")String weekday);
	/**
	 * 根据节次获取节次枚举值
	 */
	public Integer getSectionTypeBySection(@Param("section")String section);

	/**
	 * 获得考试类型枚举值
	 * @param exam
	 * @return
	 */
	public Integer getExamTypeByExam(@Param("exam")String exam);
	/**
	 * 根据班级获取班级id
	 * @param className
	 * @return
	 */
	public Integer getClassIdByClass(@Param("class")String className);
	/**
	 * 通过多个字段获取课程计划id
	 * @param majorId
	 * @param fieldId
	 * @param gradeId
	 * @param termType
	 * @param courseId
	 * @return
	 */
	public Integer getCoursePlanIdByFields(@Param("majorId")Integer majorId, 
			@Param("fieldId")Integer fieldId,@Param("gradeId")Integer gradeId, 
			@Param("termType")Integer termType, @Param("courseId")Integer courseId);

	/**
	 * 通过多个字段获取teach_course_id
	 * @param schoolYearId
	 * @param termType
	 * @param courseId
	 * @param coursePlanId
	 * @param classes
	 * @return
	 */
	public Integer getTeacherCourseIdByFields(@Param("studyYearId")Integer studyYearId,
			@Param("termType")Integer termType,
			@Param("courseId")Integer courseId,
			@Param("coursePlanId")Integer coursePlanId,
			@Param("classes")String classes);
	
	/**
	 * 插入teach_course表
	 * @param tc
	 */
	public void insertTeachCourse(@Param("tc")TeachCourse tc);
	
	/**
	 * 插入新数据后获取最新的id值
	 */
	public Integer selectLastId();
	
	/**
	 * 插入数据到edu_cs表
	 * @param cs
	 */
	public void insertCourseSchedule(@Param("cs")CourseSchedule cs);
	
	/**
	 * 插入数据到edu_cp表
	 * @param cp
	 */
	public void insertCoursePlan(@Param("cp")CoursePlan cp);
	
	/**
	 * 插入数据到edu_tt表
	 * @param tt
	public void insertTeachTask(@Param("tt")TeachTask tt);
	*/

	/**
	 * 插入数据到edu_ct表
	 * @param ct
	 */
	public void insertCourseTeacher(@Param("ct")CourseTeacher ct);

	/**
	 * 插入多条edu_tt记录
	 * @param list
	 */
	public void insertTeachTaskList(@Param("list")List<TeachTask> list);

	/**
	 * 导入课表时检查课连续周次课程冲突
	 * @param sectionType
	 * @param weekDay
	 * @param weeks
	 * @param teacherId
	 * @return
	 */
	public List<Course> findConflictCourseWeeks(@Param("sectionType")Integer sectionType,
						@Param("weekDay")Integer weekDay,@Param("weeks")String weeks,
						@Param("teacherId")Integer teacherId);
	
	/**
	 * 导入课表时检查课分散周次课程冲突
	 * @param sectionType
	 * @param weekDay
	 * @param weeks
	 * @param teacherId
	 * @return
	 */
	public List<Course> findConflictCourseWeekIds(@Param("sectionType")Integer sectionType,
			@Param("weekDay")Integer weekDay,@Param("weekIds")String weekIds,
			@Param("teacherId")Integer teacherId);

	/**
	 * 更新教师授课计划的班级信息
	 * @param classes
	 * @param teachCourseId
	 */
	public void updateTeachCourse(@Param("classes")String classes, @Param("teachCourseId")Integer teachCourseId);
}
