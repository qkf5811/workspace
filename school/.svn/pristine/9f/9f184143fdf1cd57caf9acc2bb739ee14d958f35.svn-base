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
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CourseOfManualAdjustDto;
import com.dkt.school.edu.service.CourseOfManualAdjustService;
import com.dkt.school.sch.service.CampusService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("edu")
public class ManualAdjustCourseController {

	private static final Logger logger = LoggerFactory.getLogger(ManualAdjustCourseController.class);
	
	@Autowired	
	private CourseOfManualAdjustService comaService;
	
	@Autowired
	private EnumerationService enumService;
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private CampusService campusService;
	
	@RequestMapping("manualAdjustCourse")
	public String manualAdjustCourse(Model model) {
		
		model.addAttribute("weekDay", enumService.getEnumValueListByEnumId(EnumerationType.WEEK_DAY));
		model.addAttribute("sections", enumService.getEnumValueListByEnumId(EnumerationType.SECTION_TYPE));
		model.addAttribute("majorId", majorService.getAllMajorInfo());
		model.addAttribute("campusId", campusService.getAllCampus());
		model.addAttribute("courseType", enumService.getEnumValueListByEnumId(EnumerationType.COURSE_TYPE));
		model.addAttribute("examineType", enumService.getEnumValueListByEnumId(EnumerationType.EXAMINE_TYPE));
		return "edu/manualAdjustCourse";
	}
	
	/**
	 * 根据教师id查询教师课程表
	 * @param teaName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findCourseOfTeacherInTerm")
	public String findCourseOfTeacherInTerm(Integer id) {
		
		logger.info("----------------根据教师id查询所有课程----------------");
		JsonObject resultJson = new JsonObject();
		System.out.println(id);
		
		List<CourseInTeaCourseTableDto> list = comaService.findCourseOfTeacherByTeacherId(id);
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		resultJson.add("rows", ja);
		return resultJson.toString();
	}
	/**
	 * 根据条件查询课程信息
	 * @param code
	 * @param name
	 * @param teaName
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findCourseByConditionsOfManualAdjustCourse")
	public String findCourseByConditionsOfManualAdjustCourse(String code,
															 String name,
															 String teaName,
															 PaginationCustom page) {
		logger.info("----------------根据条件查询课程信息，用来手动调课---------------");
		JsonObject resultJson = new JsonObject();
		int total = comaService.findCountOfCourseByConditions(code, name, teaName, page);
		System.out.println("查询出来的记录数量: "  + total);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<CourseOfManualAdjustDto> list = comaService.
				findCourseListByConditions(code, name, teaName, page);
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	/**
	 * 根据教师课程信息更新教师课程
	 * (手动调课)
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toUpdateCourseOfTeacher")
	public String toUpdateCourseOfTeacher(CourseInTeaCourseTableDto dto) {
		
		logger.info("---------------根据教师课程信息更新教师课程-----------------");
		JsonObject resultJson = new JsonObject();
		
		System.out.println("页面的教师课程信息: \n" + dto.toString());
		//1.更新课程计划表(major,field)
		//2.更新时间地点(schedule表)
		//3.更新上课班级
		List<CourseInTeaCourseTableDto> list = comaService.updateCourseOfTeacherInTeacherCourseTable(dto);
/*		if (list == null)
			resultJson.addProperty("result", "-1"); //上课时间冲突
		else if (list.size() > 1) {
			resultJson.addProperty("result", "-2"); //有多门课程与该课程冲突
		} else if (list.size() == 1 && list.get(0).getTeacherId() != dto.getTeacherId()) { 
			resultJson.addProperty("result", "-3");//有一门课程与该课程冲突
		}else if (list.size() == 1 && list.get(0).getTeacherId() == dto.getTeacherId()) {
			resultJson.addProperty("result", "1"); //更新成功
		} */
		resultJson.add("result", new Gson().toJsonTree(list, List.class).getAsJsonArray());
		return resultJson.toString();
	}
}
