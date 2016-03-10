package com.dkt.school.edu.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CoursePlanOfCourseScheduleDto;
import com.dkt.school.edu.dto.CourseScheduleDto;
import com.dkt.school.edu.model.CourseSchedule;


public interface CourseScheduleService {
	
	/**
	 * 根据用户的id来获取他们相应的课表
	 * @param userId
	 * @return
	 */
	List<CourseScheduleDto> getPersonalCourseScheduleByUserId(
			Integer userId);

	/**
	 * 根据model更新
	 * @param schedule
	 * @return
	 */
	public int updateBySchedule(CourseSchedule schedule);

	/**
	 * 条件查询课程表
	 * @param gradeClass
	 * @param teacherName
	 * @return
	 */
	List<CourseScheduleDto> findCourseSchedule(Integer gradeId,String classes,
			String teacherName);
	
	/**
	 * @author 冯其康
	 * 根据专业和方向查询课程
	 * @param majorId
	 * @param fieldId
	 * @return
	 */
	public List<CourseInTeaCourseTableDto> findCourseByClassId(int fieldId);

	/**
	 * 教师查看班级课表
	 * @param gradeId
	 * @param classId
	 * @return
	 */
	List<CourseScheduleDto> showClassSchedule(Integer gradeId, Integer classId);

	/**
	 * @author 冯其康
	 * 根据排课表id删除课程记录
	 * @param scheduleId
	 * @return
	 */
	public int removeCourseScheduleById(int scheduleId);

	/**
	 * @author 冯其康
	 * 查询课程计划的数量
	 * @param majorId
	 * @param fieldId
	 * @param courseName
	 * @return
	 */
	public int findCountOfCoursePlanInCourseSchedule(int majorId, int fieldId,
			String courseName, String className);

	/**
	 * @author 冯其康
	 * 查询课程计划
	 * @param majorId
	 * @param fieldId
	 * @param courseName
	 * @param page
	 * @return
	 */
	List<CoursePlanOfCourseScheduleDto> findCoursePlanInCourseSchedule(
			int majorId, int fieldId, String courseName, String className,PaginationCustom page);

	/**
	 * 添加排课记录
	 * @param cs
	 * @return
	 */
	int addCourseSchedule(CourseSchedule cs);

	/**
	 * @author 冯其康
	 * 判断课程是否有冲突
	 * @param cs
	 * @param classId
	 * @return
	 */
	public int isConflit(CourseSchedule cs, int classId);

	/**
	 * 导入课表数据到给定目录的excel文件
	 * @param file
	 * @param list
	 */
	public void exportSchedule2Xls(File file, List<CourseScheduleDto> list);

	/**
	 * 导入课表
	 * @param in
	 * @param ext
	 * @return
	 * @throws Exception 
	 */
	Integer importCourseScheduleByExcel(InputStream in, String ext) throws Exception;

}
