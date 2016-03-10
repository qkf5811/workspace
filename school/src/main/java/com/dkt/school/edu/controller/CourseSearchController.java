package com.dkt.school.edu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseSearchConditionDto;
import com.dkt.school.edu.dto.CourseSearchDto;
import com.dkt.school.edu.service.CourseSearchService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/edu")
public class CourseSearchController {

	@Autowired
	private CourseSearchService csService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private EnumerationService emSerivce;
	@Autowired
	private StudyYearService studyYearService;
	
	@RequestMapping("/toSearchCourse")
	public String toSearchCourse(Model model){
		List<Grade> gradeList = gradeService.getAllGrade();
		List<Major> majorList = majorService.getAllMajor();
		List<StudyYear> studyYearList = studyYearService.getAllStudyYear();
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("majorList", majorList);
		model.addAttribute("studyYearList", studyYearList);
		return "edu/searchCourse";
	}
	
	/**
	 * 开课查询,查询条件有以下：1.开课学年，schoolYearId
	 * 					2.学期，termType
	 * 					3.老师，teacherId
	 * 					4.年级，grade
	 * 					5.班级，class
	 * 					6.专业，majorId
	 * 					7.专业方向，filed
	 * 					8.工作日，weekday
	 * 					9.周次，weekIds
	 */
	@ResponseBody
	@RequestMapping("/findCourseByCondition")
	public String findCourseByCondition(CourseSearchConditionDto condition,PaginationCustom page){

		Integer totalRows = csService.findCourseCountByCondition(condition);
		List<CourseSearchDto> list = csService.findCourseByCondition(condition,page.getLimitation());
		page.setCurrentPage(page.getPage());
		page.setRows(page.getRows());
		page.setTotalRows(totalRows);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject json = new JsonObject();
		JsonArray jsArray = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.add("rows", jsArray);
		json.addProperty("total", totalRows);
		return json.toString();
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
}
