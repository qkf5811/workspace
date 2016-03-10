package com.dkt.school.edu.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseToQueryScoByHTDto;
import com.dkt.school.edu.service.QueryScoreByHeadTeaService;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.service.ClazzService;
import com.dkt.school.stu.service.StudentService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.service.TeacherService;
import com.dkt.school.user.dto.UserDto;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * 
 * <p>Title: ScoreQueryOfHeadTeacherController</p>
 * <p>Description: 成绩查询--班主任</p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月10日下午4:12:49
 *
 */

@Controller
@RequestMapping("/edu")
public class ScoreQueryOfHeadTeacherController {

	public final static Logger logger = LoggerFactory
            .getLogger(ScoreQueryOfHeadTeacherController.class);
	
	private TeacherService teacherService;
	
	private StudentService studentService;
	
	private ClazzService clazzService;
	
	private QueryScoreByHeadTeaService queryScoreByHeadTeaService;
	
	private EnumerationService enumerationService;
	
	private StudyYearService studyYearService;
	
	
    public EnumerationService getEnumerationService() {
		return enumerationService;
	}
    @Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}
	public StudyYearService getStudyYearService() {
		return studyYearService;
	}
	@Autowired
	public void setStudyYearService(StudyYearService studyYearService) {
		this.studyYearService = studyYearService;
	}
	public QueryScoreByHeadTeaService getQueryScoreByHeadTeaService() {
		return queryScoreByHeadTeaService;
	}
    @Autowired
	public void setQueryScoreByHeadTeaService(
			QueryScoreByHeadTeaService queryScoreByHeadTeaService) {
		this.queryScoreByHeadTeaService = queryScoreByHeadTeaService;
	}
	public ClazzService getClazzService() {
		return clazzService;
	}
    @Autowired
	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

    @Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	@Autowired 
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
    
	
    /**
     * 
     * @Title: toScoreQueryByStuOfHeadTeacher
     * @author 赖继鹏
     * @Description: 进入按学生个人查询成绩的页面
     * @param model
     * @return     
     * @throws
     */
    @RequestMapping("/toScoreQueryByStuOfHeadTeacher")
	public String toScoreQueryByStuOfHeadTeacher(Model model,HttpSession session){
    	// 获取登陆用户的信息
    	UserDto user = (UserDto) session.getAttribute("user");
    	if(user!=null){
    		//System.out.println("userName: "+user.getName());
    		if(user.getId()==1||user.getName().equals("admin")){
	       		model.addAttribute("errorStr", "管理员，您不是班主任，没有相关权限查询该类型成绩！");
				return "edu/scoreQueryError";
	       	}
    		TeacherDto teacherDto=teacherService.getTeacherByUserId(user.getId());
    		if(null!=teacherDto){
    			int teacherId=teacherDto.getId();
    			int clazzCount=clazzService.getClassCountByteaId(teacherId);
    			if(clazzCount==1){
    		    	int classId=teacherService.getClassIdByTeacherId(teacherId);
    		    	List<Student> studentList = studentService.getStudentsByClassId(classId);
    		    	model.addAttribute("studentList", studentList);
    			}else{
    				model.addAttribute("errorStr", "抱歉，您不是班主任或者您管理的班级不止一个，没有相关权限查询该类型成绩！");
    				return "edu/scoreQueryError";
    			}				
    		}
    	}else{
    		model.addAttribute("errorStr", "抱歉，您没有相关权限查询该类型成绩！");
    		return "edu/scoreQueryError";

    	}

		return "edu/scoreQueryByStuOfHeadTeacher";
	}
    
    /**
     * 
     * @Title: toScoreQueryByCourseOfHeadTeacher
     * @author 赖继鹏
     * @Description: 进入按课程查询成绩的页面
     * @param model
     * @return     
     * @throws
     */
    @RequestMapping("/toScoreQueryByCourseOfHeadTeacher")
   	public String toScoreQueryByCourseOfHeadTeacher(Model model,HttpSession session){
    	// 获取登陆用户的信息
    	UserDto user = (UserDto) session.getAttribute("user");
    	if(user!=null){
    		//System.out.println("userName: "+user.getName());
    		if(user.getId()==1||user.getName().equals("admin")){
	       		model.addAttribute("errorStr", "管理员，您不是班主任，没有相关权限查询该类型成绩！");
				return "edu/scoreQueryError";
	       	}
    		TeacherDto teacherDto=teacherService.getTeacherByUserId(user.getId());
    		if(null!=teacherDto){
    			int teacherId=teacherDto.getId();
    			int clazzCount=clazzService.getClassCountByteaId(teacherId);
    			System.out.println(clazzCount);
    			if(clazzCount==1){
    		       	int classId=teacherService.getClassIdByTeacherId(teacherId);
    		       	System.out.println(classId);
    		       	if(classId==0){
    		       		model.addAttribute("errorStr", user.getName()+"老师，您所管理的班级还没有开设任何课程！");
        				return "edu/scoreQueryError";
    		       	}
    		       	List<Student> studentList = studentService.getStudentsByClassId(classId);
    		       	//取得所有的学期类型
    		       	List<EnumerationValue> termTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
    		        //取得所有的学年类型
    		        List<StudyYear> studyYearList = studyYearService.getAllStudyYear();
    		       	model.addAttribute("teacherId", teacherId);
    		       	model.addAttribute("classId", classId);
    		       	model.addAttribute("studentList", studentList);
    		       	model.addAttribute("termTypeList", termTypeList);
    		       	model.addAttribute("studyYearList", studyYearList);
    			}else{
    				model.addAttribute("errorStr", "抱歉，您不是班主任或者您管理的班级不止一个，没有相关权限查询该类型成绩！");
    				return "edu/scoreQueryError";
    			}				
    		}
    	}else{
    		model.addAttribute("errorStr", "抱歉，您没有相关权限查询该类型成绩！");
    		return "edu/scoreQueryError";

    	}
       	
   		return "edu/scoreQueryByCourseOfHeadTeacher";
   	}
    
    
    /**
     * 
     * @Title: searchCourseToQueryScoByHT
     * @author 赖继鹏
     * @Description: 查询班级对应的所有课程
     * @param request
     * @param dto
     * @param page
     * @return     
     * @throws
     */
    @ResponseBody
	@RequestMapping("/getCourseToQueryScoByHTList")
	public String searchCourseToQueryScoByHT(HttpServletRequest request,CourseToQueryScoByHTDto dto, PaginationCustom page) {
		logger.info("-----------查询班级对应的所有课程---------------");
		String classId=request.getParameter("classId");
		if (classId!="") {
			dto.setClassId(Integer.parseInt(classId));
		}	
		JsonObject resultJson = new JsonObject();
		// total:所有记录数并设置page的属性
		int total = queryScoreByHeadTeaService.selectCountOfCourseToQueryScoByHT(dto);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		// 查询记录
		List<CourseToQueryScoByHTDto> courseToQueryScoByHTList =
				queryScoreByHeadTeaService.selectCourseToQueryScoByHT(dto,page);

		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
				.toJsonTree(courseToQueryScoByHTList, List.class).getAsJsonArray();

		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
    
    
    /**
     * @throws UnsupportedEncodingException 
     * 
     * @Title: queryScoreByTeachCourseId
     * @author 赖继鹏
     * @Description: 根据teachCourseId查询班级学生的成绩
     * @param request
     * @param model
     * @return     
     * @throws
     */
    @RequestMapping("/queryScoreByTeachCourseId")
    public String queryScoreByTeachCourseId(HttpServletRequest request,Model model) throws UnsupportedEncodingException{
    	String classId=request.getParameter("classId");
    	String teachCourseId=request.getParameter("teachCourseId");
    	String courseId=request.getParameter("courseId");
    	String coursePlanId=request.getParameter("coursePlanId");
    	String studyYearId=request.getParameter("studyYearId");
    	String termTypeId=request.getParameter("termTypeId");
    	List<Student> studentList = studentService.getStudentsByClassId(Integer.parseInt(classId));
    	//根据学生和teachCourseId查询每个学生对应的成绩
    	List<String> scoreList = queryScoreByHeadTeaService.
    			getScoreByStuAndTCId(studentList,teachCourseId,courseId,coursePlanId,studyYearId,termTypeId);
    	model.addAttribute("studentList", studentList);
    	model.addAttribute("scoreList", scoreList);
//    	model.addAttribute("studyYear", new String(request.getParameter("studyYear").getBytes("iso-8859-1"), "utf-8"));
//    	model.addAttribute("termType", new String(request.getParameter("termType").getBytes("iso-8859-1"), "utf-8"));
//    	model.addAttribute("courseName", new String(request.getParameter("courseName").getBytes("iso-8859-1"), "utf-8"));
//    	model.addAttribute("courseCode", new String(request.getParameter("courseCode").getBytes("iso-8859-1"), "utf-8"));
    	model.addAttribute("studyYear",request.getParameter("studyYear"));
    	model.addAttribute("termType", request.getParameter("termType"));
    	model.addAttribute("courseName", request.getParameter("courseName"));
    	model.addAttribute("courseCode", request.getParameter("courseCode"));
    	return "edu/queryScoreByTeachCourseId";
    }
    
    
    
    
    
    /**
     * 
     * @Title: queryScoreByCoursePlan
     * @author 赖继鹏
     * @Description: 根据课程计划查询当前学年当前学期的全班学生各科成绩
     * @param request
     * @param model
     * @return
     * @throws UnsupportedEncodingException     
     * @throws
     */
    @RequestMapping("/queryScoreByCoursePlan")
    public String queryScoreByCoursePlan(Model model,HttpSession session) throws UnsupportedEncodingException{
    	// 获取登陆用户的信息
    	UserDto user = (UserDto) session.getAttribute("user");
    	if(user!=null){
    		//System.out.println("userName: "+user.getName());
    		if(user.getId()==1||user.getName().equals("admin")){
	       		model.addAttribute("errorStr", "管理员，您不是班主任，没有相关权限查询该类型成绩！");
				return "edu/scoreQueryError";
	       	}
    		TeacherDto teacherDto=teacherService.getTeacherByUserId(user.getId());
    		if(null!=teacherDto){
    			int teacherId=teacherDto.getId();
    			int clazzCount=clazzService.getClassCountByteaId(teacherId);
    			if(clazzCount==1){
    		       	int classId=teacherService.getClassIdByTeacherId(teacherId);
    		       	//获取班级名称
    		       	String className=clazzService.getClassNameById(classId);
    		       	
    		    	List<Student> studentList = studentService.getStudentsByClassId(classId);
    		    	
    		    	//该班级当前学年当前学期对应的所有课程
    		    	CourseToQueryScoByHTDto dto=new CourseToQueryScoByHTDto();
    		    	dto.setClassId(classId);
    		    	dto.setStudyYearId(Integer.parseInt(queryScoreByHeadTeaService.getCurrentStudyYear()));
    		    	dto.setTermType(Integer.parseInt(queryScoreByHeadTeaService.getCurrentTermType()));
    		    	List<CourseToQueryScoByHTDto> courseToQueryScoByHTList =
    						queryScoreByHeadTeaService.selectCourseToQueryScoByHT(dto,null);
    		    	//存储每个学生对应的每门成绩的容器
    		    	Map<String, String> scoreMap = new HashMap<String, String>();
    		    	scoreMap=queryScoreByHeadTeaService.getScoreByStuAndCoursePlan(studentList,null,courseToQueryScoByHTList);
    		    	System.out.println("通过Map.keySet遍历key和value：");
    				/*for (String key : scoreMap.keySet()) {
    					System.out.println("key= "+ key + " and value= " + scoreMap.get(key));
    				}*/		
    		    	model.addAttribute("studentList", studentList);
    		    	model.addAttribute("scoreMap", scoreMap);
    		    	model.addAttribute("courseToQueryScoByHTList", courseToQueryScoByHTList);
    		    	model.addAttribute("courseCount", courseToQueryScoByHTList.size());
    		    	model.addAttribute("className", className);
    			}else{
    				model.addAttribute("errorStr", "抱歉，您不是班主任或者您管理的班级不止一个，没有相关权限查询该类型成绩！");
    				return "edu/scoreQueryError";
    			}				
    		}
    	}else{
    		model.addAttribute("errorStr", "抱歉，您没有相关权限查询该类型成绩！");
    		return "edu/scoreQueryError";

    	}
    	
    	return "edu/queryScoreByCoursePlan";
    }
    

}
