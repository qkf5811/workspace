package com.dkt.school.edu.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.common.util.DateUtil;
import com.dkt.school.edu.dao.CourseScoreCustomMapper;
import com.dkt.school.edu.dao.TeachCourseCustomMapper;
import com.dkt.school.edu.dto.CourseCountDto;
import com.dkt.school.edu.dto.CourseScoreByStudentDto;
import com.dkt.school.edu.dto.CourseScoreDto;
import com.dkt.school.edu.dto.StudentInfoDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.model.CourseScore;
import com.dkt.school.edu.model.TeachCourse;
import com.dkt.school.edu.service.CourseScoreService;
import com.dkt.school.edu.service.TeachCourseService;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorFieldService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.service.ClazzService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.service.TeacherService;
import com.dkt.school.user.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/edu")
public class CourseScoreController {

	public final static Logger logger = LoggerFactory
			.getLogger(CourseScoreController.class);

	private ClazzService clazzService;
	private GradeService gradeService;
	private MajorService majorService;
	private MajorFieldService majorFieldService;

	private CourseScoreService courseScoreService;

	private EnumerationService enumerationService;

	@Autowired
	private TeachCourseService teachCourseService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private CourseScoreCustomMapper csMapper;

	@Autowired
	private TeachCourseCustomMapper tcMapper;

	/**
	 * 进入当前学年学期授课教程页面
	 * 
	 * @return
	 */
	@RequestMapping("/courseScoreList")
	public String courseScoreList(Model model) {
		return "edu/courseScoreList";
	}

	/**
	 * 学生查询成绩页面
	 * 
	 * @return
	 */
	@RequestMapping("/stuScoreQuery")
	public String stuScoreQuery() {
		return "edu/stuScoreQuery";
	}

	/**
	 * 根据老师的Id查出授课教程
	 * 
	 * @param id
	 * @param page
	 * @return 2015年8月22日上午11:09:20
	 */
	@ResponseBody
	@RequestMapping("/getTeacherCourseList")
	public String getTeacherCourseList(HttpSession session, TeachCourseDto dto,
			PaginationCustom page) {
		JsonObject resultJson = new JsonObject();
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		 User user = (User)session.getAttribute("user");
		 if (user == null) {
		 return resultJson.toString();
		 }
		 Integer userId = user.getId();
//		Integer userId = 25;
		 dto.setStudyYearId(csMapper.getCurrentValue("study_year"));
		 dto.setTermType(csMapper.getCurrentValue("term_type"));
		Integer teacherId = teacherService.getTeacherIdByUserId(userId);
		List<TeachCourseDto> course = courseScoreService.getTeacherCourseList(
				teacherId, dto, page);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray classesJsonArray = gson.toJsonTree(course, List.class)
				.getAsJsonArray();
		resultJson.add("rows", classesJsonArray);
		int total = course != null ? course.size() : 0;
		resultJson.addProperty("total", total);
		page.setTotalRows(total);
		return resultJson.toString();
	}

	/**
	 * 成绩录入界面
	 * 
	 * @param courseId
	 * @return 2015年8月29日上午10:37:20
	 */
	@RequestMapping("/courseScoreInput")
	public String courseScoreInput(String course, Model model) {
		/*
		if(csMapper.IsExistScore(courseId.split(",")[0], courseId.split(",")[1]) >  0) {
			
		}*/
		Integer courseId = Integer.parseInt(course.split(",")[0]);
		
		TeachCourseDto teachCourse = teachCourseService.findTeachCourseById(courseId);
		
		// 考试性质
		List<EnumerationValue> examNatureList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.EXAM_NATURE_TYPE);
		// 等级制成绩类型
		List<EnumerationValue> gradeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.GRADE_SCORE_TYPE);

		model.addAttribute("examNatureList", new Gson().toJson(examNatureList));
		model.addAttribute("gradeList", new Gson().toJson(gradeList));
		model.addAttribute("courseId", course);
		String courseName = teachCourse.getStudyYearName() + " " + teachCourse.getTermTypeStr() + " <"
					+ teachCourse.getCourseName() + "> " + teachCourse.getClasses();
		model.addAttribute("courseName", courseName);
//		model.addAttribute("grade", "2014-2015学年");
//		model.addAttribute("term", "下学期");

		return "edu/courseScoreInput";
	}

	
	/**
	 * 查询是否已录入成绩 
	 * @param courseId
	 * @return
	 * 2015年9月22日上午10:02:10
	 */
	@ResponseBody
	@RequestMapping("/IsExistScore")
	public String IsExistScore(String courseId){
		
		
		if(csMapper.IsExistScore(courseId.split(",")[0], courseId.split(",")[1]) >  0) {
			return "1";
		}
		return "0";
	}
	/**
	 * 更新授课表，显示学生
	 * 
	 * @param courseId
	 * @return 2015年8月29日上午10:37:20
	 */
	@ResponseBody
	@RequestMapping("/courseScoreStartInput")
	public String courseScoreStartInput(String courseId, String examDate,
			String scoreType, Float usualScoreRatio, Model model) {
		String dateTime = DateUtil.getDateTime();
		
		int result = courseScoreService.updateTeachCourse(Integer.valueOf(courseId.split(",")[0]), examDate,
				scoreType, usualScoreRatio, dateTime);
		if (1 != result) {
			return new Gson().toJson("");
		}
//		List<Student> studentList = courseScoreService
//				.getStuToScoreInput(Integer.valueOf(courseId.split(",")[0]));
		
		List<Student> studentList = csMapper.getStuByClass(Integer.valueOf(courseId.split(",")[1]));
		return new Gson().toJson(studentList);
	}

	/**
	 * 添加成绩信息
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCourseScores")
	public String addCourseScores(
			@RequestParam(value = "numberboxs[]") String[] numberboxs,
			@RequestParam(value = "examScore[]") String[] examScore,
			@RequestParam(value = "totalScore[]") String[] totalScore,
			@RequestParam(value = "examNature[]") Integer[] examNature,
			@RequestParam(value = "studentId[]") Integer[] studentId,
			String teaCourseId, String scoreType) {
		JsonObject resultJo = new JsonObject();
		int result = 1;
		try {
			result = courseScoreService.addCourseScores(numberboxs, examScore,
					totalScore, examNature, studentId, Integer.valueOf(teaCourseId.split(",")[0]), scoreType);
		} catch (Exception e) {
			result = 0;
		}
		
		resultJo.addProperty("result", result);
		return resultJo.toString();
	}

	/**
	 * 进而学生成绩页面
	 * 
	 * @param teaCourseId
	 * @param type
	 * @param model
	 * @return 2015年9月11日下午5:11:46
	 */
	@RequestMapping("/toEditCourseScoreList")
	public String toEditCourseScoreList(String teaCourseId, Integer type,
			Model model) {
		// 考试性质
		List<EnumerationValue> examNatureList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.EXAM_NATURE_TYPE);
		// 等级制成绩类型
		List<EnumerationValue> gradeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.GRADE_SCORE_TYPE);

		TeachCourse tc = tcMapper.selectByPrimaryKey(Integer.valueOf(teaCourseId.split(",")[0]));
		model.addAttribute("examNatureList", examNatureList);
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("type", tc.getScoreType());
		model.addAttribute("bl", tc.getUsualScoreRatio());
		model.addAttribute("teaCourseId", Integer.valueOf(teaCourseId.split(",")[0]));
		model.addAttribute("classId", Integer.valueOf(teaCourseId.split(",")[1]));
		return "edu/editCourseScoreList";
	}

	/**
	 * 获取学生成绩数据列表
	 * 
	 * @param dto
	 * @param model
	 * @return 2015年9月11日下午5:11:22
	 */
	@ResponseBody
	@RequestMapping("/getEditCourseScoreList")
	public String getEditCourseScoreList(CourseScoreDto dto, Model model) {
		List<CourseScoreDto> list = csMapper.getCourseScoreList(dto);
		return new Gson().toJson(list);
	}

	/**
	 * 保存修改学生成绩
	 * 
	 * @param courseId
	 * @param model
	 * @return 2015年9月10日下午3:50:33
	 */
	@ResponseBody
	@RequestMapping("/editCourseScore")
	public String editCourseScore(CourseScore dto) {
		int result = csMapper.updateByPrimaryKeySelective(dto);
		return result + "";
	}

	/**
	 * 根据ID得授课教程
	 * 
	 * @param id
	 * @param model
	 * @return 2015年9月11日下午5:14:07
	 */
	@ResponseBody
	@RequestMapping("/getCourseScoreById")
	public String getCourseScoreById(Integer id, Model model) {
		CourseScore cs = csMapper.selectByPrimaryKey(id);
		return new Gson().toJson(cs);
	}

	/**
	 * 进入老师所有授课课程
	 * 
	 * @param model
	 * @return 2015年9月11日下午5:20:28
	 */
	@RequestMapping("/toAllTeachCourseList")
	public String toAllTeachCourseList(Model model) {
		List<StudyYear> studyYearList = teachCourseService.getAllStudyYear();
		List<EnumerationValue> termTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		List<Major> majorList = majorService.getAllMajorInfo();
		model.addAttribute("majorList", majorList);
		model.addAttribute("termTypeList", termTypeList);
		model.addAttribute("studyYearList", studyYearList);
		return "edu/allTeachCourseList";
	}

	/**
	 * 取老师所有授课课程数据
	 * 
	 * @param id
	 * @param page
	 * @return 2015年8月22日上午11:09:20
	 */
	@ResponseBody
	@RequestMapping("/getAllTeachCourseList")
	public String getAllTeachCourseList(HttpSession session,
			TeachCourseDto dto, PaginationCustom page) {
		JsonObject resultJson = new JsonObject();
		// 设置当前页面所选择的每页记录数

		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		 User user = (User)session.getAttribute("user");
		 if (user == null) {
		 return resultJson.toString();
		 }
		 Integer userId = user.getId();
		//Integer userId = 25;
		Integer teacherId = teacherService.getTeacherIdByUserId(userId);
		int total = csMapper.getTeacherCourseCount(teacherId, dto);
		List<TeachCourseDto> course = courseScoreService.getTeacherCourseList(
				teacherId, dto, page);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray classesJsonArray = gson.toJsonTree(course, List.class)
				.getAsJsonArray();
		resultJson.add("rows", classesJsonArray);
		resultJson.addProperty("total", total);
		page.setTotalRows(total);
		return resultJson.toString();
	}

	/**
	 * 成绩查看
	 * 
	 * @param teaCourseId
	 * @param type
	 * @param model
	 * @return 2015年9月14日下午2:50:20
	 */
	@RequestMapping("/showCourseScoreList")
	public String showCourseScoreList(String teaCourse, String name,
			Model model) {
		Integer courseId = Integer.parseInt(teaCourse.split(",")[0]);
		Integer classId = Integer.parseInt(teaCourse.split(",")[1]);
		
		TeachCourseDto teachCourse = teachCourseService.findTeachCourseById(courseId);
		
		// 考试性质
		List<EnumerationValue> examNatureList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.EXAM_NATURE_TYPE);
		// 等级制成绩类型
		List<EnumerationValue> gradeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.GRADE_SCORE_TYPE);

		TeachCourse tc = tcMapper.selectByPrimaryKey(courseId);
		model.addAttribute("type", tc.getScoreType());
		model.addAttribute("teaCourseId", courseId);
		model.addAttribute("classId", classId);
		String courseName = teachCourse.getStudyYearName() + " " + teachCourse.getTermTypeStr() + " <"
				+ teachCourse.getCourseName() + "> " + teachCourse.getClasses();
		model.addAttribute("name", courseName);
		return "edu/showCourseScoreList";
	}

	/**
	 * 进入老师所有授课课程
	 * 
	 * @param model
	 * @return 2015年9月11日下午5:20:28
	 */
	@RequestMapping("/toAllCourseList")
	public String toAllCourseList(Model model) {
		List<StudyYear> studyYearList = teachCourseService.getAllStudyYear();
		List<EnumerationValue> termTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		List<Major> majorList = majorService.getAllMajorInfo();
		model.addAttribute("majorList", majorList);
		model.addAttribute("termTypeList", termTypeList);
		model.addAttribute("studyYearList", studyYearList);
		return "edu/allCourseList";
	}

	/**
	 * 取老师所有授课课程数据
	 * 
	 * @param id
	 * @param page
	 * @return 2015年8月22日上午11:09:20
	 */
	@ResponseBody
	@RequestMapping("/getAllCourseList")
	public String getAllCourseList(HttpSession session, TeachCourseDto dto,
			PaginationCustom page) {
		JsonObject resultJson = new JsonObject();
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		 User user = (User)session.getAttribute("user");
		 if (user == null) {
		 return resultJson.toString();
		 }
		 Integer userId = user.getId();
//		Integer userId = 25;
		Integer teacherId = teacherService.getTeacherIdByUserId(userId);
		int total = csMapper.getAllCourseCount(dto);
		List<TeachCourseDto> course = csMapper.getAllCourseList(dto,
				page.getLimitation());
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray classesJsonArray = gson.toJsonTree(course, List.class)
				.getAsJsonArray();
		resultJson.add("rows", classesJsonArray);
		resultJson.addProperty("total", total);
		page.setTotalRows(total);
		return resultJson.toString();
	}

	/**
	 * 进入成绩统计页面
	 * 
	 * @param model
	 * @return 2015年9月15日上午11:11:47
	 */
	@RequestMapping("/toCourseCount")
    public String toCourseCount(TeachCourseDto dto,Model model){
    	TeachCourseDto course = csMapper.getCourseDto(dto);
    	dto.setName(course.getName());
    	dto.setScoreTypeStr(course.getScoreTypeStr());
    	dto.setCode(course.getCode());
    	dto.setClasses(course.getClasses());
    	dto.setMajor(course.getMajor());
    	Map<String,CourseCountDto> map =courseScoreService.getCourseCountList(dto);
    	model.addAttribute("map",map);
    	model.addAttribute("dto",dto);
        return "edu/allCourseCounts";
    }

	/**
	 * 查询学号是否存在
	 * 
	 * @author 龚硕晓
	 * @param studentCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/isExistStudentCode")
	public String isExistStudentCode(
			@RequestParam("studentCode") String studentCode) {

		JsonObject resultJson = new JsonObject();

		Integer i = courseScoreService.isExistStudentCode(studentCode);
		if (i == null || i.toString() == "" || i < 0) {
			resultJson.addProperty("msg", "系统没有" + studentCode
					+ "这个学号存在，请核对学号是否正确！");
		}
		return resultJson.toString();
	}

	/**
	 * 查询学生个人成绩
	 * 
	 * @author 龚硕晓
	 * @param studentCode
	 * @param teaCourseId
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("getStuCourseScoreList")
	public String getStuCourseScoreList(Model model,
			@RequestParam("studentCode") String studentCode,
			@RequestParam("splitByStudyYear") String splitByStudyYear) {

		String returnStr = "";

		List<CourseScoreByStudentDto> list = courseScoreService
				.getStuCourseScoreList(studentCode);
		StudentInfoDto studentInfo = courseScoreService
				.getStudentInfo(studentCode);

		model.addAttribute("scoreList",
				courseScoreService.getStuCourseScoreList(studentCode));
		model.addAttribute("studentInfo", studentInfo);

		if (splitByStudyYear.equals("0")) {
			returnStr = "edu/stuScoreList";
		} else if (splitByStudyYear.equals("1")) {
			List<Map<String, Object>> yearAndTermList = courseScoreService
					.getStudyYearAndTermName(studentCode);

			model.addAttribute("yearAndTermList", yearAndTermList);

			returnStr = "edu/stuScoreListByStudyYearSplit";
		}

		return returnStr;
	}

	/**
	 * 查询对应的班、课程成绩
	 * @author HIU
	 * @param model
	 * @param studyYear
	 * @param termName
	 * @param courseCode
	 * @param courseName
	 * @param className
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("getScoreByCourse")
	public String getScoreByCourse(Model model,
			@RequestParam("studyYear") String studyYear,
			@RequestParam("termName") String termName,
			@RequestParam("courseCode") String courseCode,
			@RequestParam("courseName") String courseName,
			@RequestParam("className") String className) throws UnsupportedEncodingException {
		
		  Map<String,String> courseInfoMap=new HashMap<String,String>();
		  courseInfoMap.put("studyYear", studyYear);
		  courseInfoMap.put("termName", termName);
		  courseInfoMap.put("courseCode", courseCode);
		  courseInfoMap.put("courseName", courseName);
		  courseInfoMap.put("className", className);
		 
		List<CourseScoreByStudentDto> list = courseScoreService
				.getScoreByCourse("", studyYear, termName, courseCode, className);

		Map<String, Object> scoreRegionMap = new HashMap<String, Object>();
		scoreRegionMap = courseScoreService.getscoreRegion("", studyYear, termName, courseCode, className);

		int listSize = list.size();
		int listHalfSize = listSize % 2 == 0 ? listSize / 2 : listSize / 2 + 1;

		model.addAttribute("scoreList", list);
		model.addAttribute("listSize", listSize);
		model.addAttribute("listHalfSize", listHalfSize);
		model.addAttribute("scoreRegionMap", scoreRegionMap);//分数段统计
		model.addAttribute("courseInfoMap", courseInfoMap);//课程信息

		return "edu/scoreListByCourse";
	}

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}

	public CourseScoreService getCourseScoreService() {
		return courseScoreService;
	}

	@Autowired
	public void setCourseScoreService(CourseScoreService courseScoreService) {
		this.courseScoreService = courseScoreService;
	}

	public ClazzService getClazzService() {
		return clazzService;
	}

	@Autowired
	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public MajorFieldService getMajorFieldService() {
		return majorFieldService;
	}

	@Autowired
	public void setMajorFieldService(MajorFieldService majorFieldService) {
		this.majorFieldService = majorFieldService;
	}
}
