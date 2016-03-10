package com.dkt.school.edu.service;

import java.util.List;
import java.util.Map;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseToQueryScoByHTDto;
import com.dkt.school.stu.model.Student;

/**
 * 
 * <p>Title: QueryScoreByHeadTeaService</p>
 * <p>Description:用于处理班主任成绩查询的业务逻辑接口 </p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月14日上午10:17:32
 *
 */
public interface QueryScoreByHeadTeaService {

	/**
	 * 
	 * @Title: selectCountOfCourseToQueryScoByHT
	 * @author 赖继鹏
	 * @Description: 根据班级、学年、学期、课程名称查询对应的所有课程数量
	 * @param dto
	 * @return     
	 * @throws
	 */
	int selectCountOfCourseToQueryScoByHT(CourseToQueryScoByHTDto dto);

	/**
	 * 
	 * @Title: selectCourseToQueryScoByHT
	 * @author 赖继鹏
	 * @Description: 根据班级、学年、学期、课程名称查询对应的所有课程
	 * @param dto
	 * @param page
	 * @return     
	 * @throws
	 */
	List<CourseToQueryScoByHTDto> selectCourseToQueryScoByHT(
			CourseToQueryScoByHTDto dto, PaginationCustom page);

	/**
	 * @param termType 
	 * @param studyYearId 
	 * @param coursePlanId 
	 * @param courseId 
	 * 
	 * @Title: getScoreByStuAndTCId
	 * @author 赖继鹏
	 * @Description: 根据学生和teachCourseId查询每个学生对应的成绩
	 * @param studentList
	 * @param teachCourseId
	 * @return     
	 * @throws
	 */
	List<String> getScoreByStuAndTCId(List<Student> studentList,
			String teachCourseId, String courseId, String coursePlanId, String studyYearId, String termType);

	/**
	 * @param courseToQueryScoByHTList 
	 * 
	 * @Title: getScoreByStuAndCoursePlan
	 * @author 赖继鹏
	 * @Description: 根据课程计划查询每个每名学生对应的成绩
	 * @param studentList
	 * @param classId
	 * @return     
	 * @throws
	 */
	Map<String, String> getScoreByStuAndCoursePlan(List<Student> studentList,
			String classId, List<CourseToQueryScoByHTDto> courseToQueryScoByHTList);
	
	/**
	 * 
	 * @Title: getCurrentStudyYear
	 * @author 赖继鹏
	 * @Description:  获取当前学年Id
	 * @return     
	 * @throws
	 */
	String getCurrentStudyYear();
	
	/**
	 * 
	 * @Title: getCurrentTermType
	 * @author 赖继鹏
	 * @Description:  获取当前学期Id
	 * @return     
	 * @throws
	 */
	String getCurrentTermType();

}
