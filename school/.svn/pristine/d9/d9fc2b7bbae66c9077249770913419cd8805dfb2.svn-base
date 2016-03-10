package com.dkt.school.edu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.service.TeachCourseService;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.sch.dto.StudyYearDto;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeacherFamilyDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/edu")
public class SetTeacherCourseController {
	public final static Logger logger = LoggerFactory
			.getLogger(SetTeacherCourseController.class);

	private TeachCourseService teachCourseService;
	
	private EnumerationService enumerationService;
	
	

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}

	public TeachCourseService getTeachCourseService() {
		return teachCourseService;
	}

	@Autowired
	public void setTeachCourseService(TeachCourseService teachCourseService) {
		this.teachCourseService = teachCourseService;
	}

	// 跳转到设置教师任教课程首页
	@RequestMapping("/setTeacherCourseList")
	public String setTeacherCourseList(Model model) {
		//取得所有的学期类型
		List<EnumerationValue> termTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		//取得所有的学年类型
		List<StudyYear> studyYearList = teachCourseService.getAllStudyYear();
		model.addAttribute("termTypeList", termTypeList);
		model.addAttribute("studyYearList", studyYearList);
		return "edu/setTeacherCourseList";
	}

	/**
	 * 查询单个教师的任教科目信息
	 * 
	 * @param name
	 * @param code
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeachCourseList")
	public String getTeachCourseList(Integer studyYearId,Integer termType,String courseName,String major,String grade,String field,String name, String code, PaginationCustom page) {
		//根据条件取得教师授课记录的数量
		int total = teachCourseService.getTeachCourseCount(studyYearId,termType,courseName,major,grade,field,name,code);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		//分页模糊查询教师授课记录
		List<TeachCourseDto> teachCourseDto = teachCourseService.getTeachCourseByPage(studyYearId,termType,courseName,major,grade,field,name,code,page);
		String str=null;
		//日期格式
		for(TeachCourseDto teachCourse:teachCourseDto){
			Date date1=teachCourse.getStartDate();
			Date date2=teachCourse.getEndDate();
			Date date3=teachCourse.getExamDate();
			Date date4=teachCourse.getInputTime();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow1=null;
			String dateShow2=null;
			String dateShow3=null;
			String dateShow4=null;
			
			try {
				dateShow1=dateFormat.format(date1);
				dateShow2=dateFormat.format(date2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(date3!=null) {
				try {
					dateShow3=dateFormat.format(date3);
					teachCourse.setExamDateStr(dateShow3);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(date4!=null) {
				try {
					dateShow4=dateFormat.format(date4);
					teachCourse.setInputTimeStr(dateShow4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			teachCourse.setStartDateStr(dateShow1);	
			teachCourse.setEndDateStr(dateShow2);	
			
			
			str=teachCourse.getStudyYearName()+'('+teachCourse.getStartDateStr()+'~'+teachCourse.getEndDateStr()+')';
			teachCourse.setStudyYearDateStr(str);
		}
		
		Gson gson = new Gson();
		JsonObject resultJson = new JsonObject();
		JsonArray teachCourseListJa = gson.toJsonTree(teachCourseDto, List.class)
				.getAsJsonArray();
		resultJson.add("rows", teachCourseListJa);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	/**
	 * 编辑教师授课信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditTeachCourse")
	public String toEditTeachCourse(Integer id,Model model){
		model.addAttribute("teachCourseId", id);
		return "edu/editTeachCourse";
	}
	
	/**
	 * 根据id查找教师授课记录信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeachCourse")
	public String getTeachCourse(Integer id) {
		//根据id找到教师授课记录
		TeachCourseDto tcDto = teachCourseService.findTeachCourseById(id);
		//日期格式转换
		Date date1=tcDto.getExamDate();
		Date date2=tcDto.getInputTime();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateShow1=null;
		String dateShow2=null;
		try {
			dateShow1=dateFormat.format(date1);
			dateShow2=dateFormat.format(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tcDto.setExamDateStr(dateShow1);
		tcDto.setInputTimeStr(dateShow2);
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("tcDto", gson.toJsonTree(tcDto));
		return resultJson.toString();
	}

}
