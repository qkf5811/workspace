package com.dkt.school.edu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CoursePlanDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.service.CoursePlanSettingService;
import com.dkt.school.edu.service.CoursePlanTotalInfoService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.controller.TeacherInfoController;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 * 加载/查询后加载课程计划列表
 * @author 赖继鹏
 *
 */
@Controller
@RequestMapping("/edu")
public class CoursePlanListController {
	
	private final static Logger logger = LoggerFactory
			.getLogger(TeacherInfoController.class);
	
	
	private CoursePlanTotalInfoService coursePlanTotalInfoService;
	private CoursePlanSettingService coursePlanSettingService;	
	private EnumerationService enumerationService;
	
	

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}


	public CoursePlanTotalInfoService getCoursePlanTotalInfoService() {
		return coursePlanTotalInfoService;
	}


	@Autowired
	public void setCoursePlanTotalInfoService(
			CoursePlanTotalInfoService coursePlanTotalInfoService) {
		this.coursePlanTotalInfoService = coursePlanTotalInfoService;
	}

	public CoursePlanSettingService getCoursePlanSettingService() {
		return coursePlanSettingService;
	}

	@Autowired
	public void setCoursePlanSettingService(
			CoursePlanSettingService coursePlanSettingService) {
		this.coursePlanSettingService = coursePlanSettingService;
	}


	/**
	 * 进入课程计划设置首页
	 * @return
	 */
	@RequestMapping("/toCoursePlanList")
	public String toCoursePlanTotalInfo(Model model) {
		logger.info("-----------进入课程计划设置首页---------------");
		List<EnumerationValue> termTypeList = enumerationService.
				getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		List<EnumerationValue> courseTypeList = enumerationService.
				getEnumValueListByEnumId(EnumerationType.COURSE_TYPE);
		List<EnumerationValue> examineTypeList = enumerationService.
				getEnumValueListByEnumId(EnumerationType.EXAMINE_TYPE);
		List<Course> courseList = coursePlanSettingService.getAllCourseInfo();
		List<Grade> gradeList = coursePlanSettingService.getAllGradeInfo();
	    model.addAttribute("termTypeList", termTypeList);
	    model.addAttribute("courseTypeList", courseTypeList);
	    model.addAttribute("examineTypeList", examineTypeList);
	    model.addAttribute("courseList", courseList);
	    model.addAttribute("gradeList", gradeList);
	    
		return "edu/coursePlanList";
	}

	/**
	 * 查询到完整的课程计划信息
	 * @param dto
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCoursePlanList")
	public String searchCoursePlanTotalInfo(CoursePlanDto dto, PaginationCustom page) {
		logger.info("-----------查询课程计划---------------");
		JsonObject resultJson = new JsonObject();
		// total:所有记录数并设置page的属性
		int total = coursePlanTotalInfoService.selectCountOfCoursePlan(dto);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		// 查询记录
		List<CoursePlanDto> coursePlanList =
				coursePlanTotalInfoService.selectTotalInfoOfCoursePlan(dto,page);

		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
				.toJsonTree(coursePlanList, List.class).getAsJsonArray();

		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	
}
