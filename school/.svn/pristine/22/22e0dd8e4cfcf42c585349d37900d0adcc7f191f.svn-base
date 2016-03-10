package com.dkt.school.tea.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.dkt.school.stu.service.StudentChangeService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeaChangeDto;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.service.TeaChangeService;
import com.dkt.school.tea.service.TeacherService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/tea")
public class TeaChangeController {
	public final static Logger logger = LoggerFactory
			.getLogger(TeaChangeController.class);
	
	private TeaChangeService teaChangeService;
	
	private TeacherService teacherService;

	private EnumerationService enumerationService;
	
	

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}

	
	
	public TeaChangeService getTeaChangeService() {
		return teaChangeService;
	}

	@Autowired
	public void setTeaChangeService(TeaChangeService teaChangeService) {
		this.teaChangeService = teaChangeService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}
	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	//教师异动首页
	@RequestMapping("/teaChangeList")
	public String teaChangeList() {
		return "tea/teaChangeList";
	}
	
	/**
	 * 查询所有教师异动
	 * 
	 * @param name
	 * @param code
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeaChangeList")
	public String getTeaChangeList(String name, String code, PaginationCustom page) {
		int total = teaChangeService.getTeaChangeCount(name,code);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<TeaChangeDto> teaChangeDto = teaChangeService.getTeaChangesByPage(name,code,page);
		for(TeaChangeDto teaChange:teaChangeDto){
			Date date=teaChange.getChangeDate();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			teaChange.setChangeDateStr(dateShow);			
		}
		
		Gson gson = new Gson();
		JsonArray teaChangeListJa = gson.toJsonTree(teaChangeDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", teaChangeListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 跳转到添加教师异动的页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/toAddTeaChange")
	public String toAddTeaChange(Model model) {	
		List<EnumerationValue> teaChangeTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_CHANGE_TYPE);
		model.addAttribute("teaChangeTypeList", teaChangeTypeList);
		return "tea/newTeaChange";
	}
	
	
	/**
	 * 查询所有教师信息
	 * 
	 * @param name
	 * @param code
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeaList")
	public String getTeaList(String name, String code, PaginationCustom page) {
		int total = teacherService.getTeaCount(name,code);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<TeacherDto> teacherDto = teacherService.getTeachersByPage(name,code,page);
		Gson gson = new Gson();
		JsonArray teacherListJa = gson.toJsonTree(teacherDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", teacherListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	//添加学籍异动
	@ResponseBody
	@RequestMapping("/addTeaChange")
	public String addTeaChange(TeaChangeDto teaChangeDto) {
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(teaChangeDto.getChangeDateStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teaChangeDto.setChangeDate(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(teaChangeDto));
		resultJo.addProperty("result", teaChangeService.addStudentChange(teaChangeDto));
		return resultJo.toString();
	}	
	
	
	/**
	 * 根据id删除教师异动
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteTeaChange")
	public String deleteTeaChange(Integer id,String code){
		JsonObject jsonObject=new JsonObject();
		Integer result = teaChangeService.deleteTeaChangeById(id,code);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
	
}
