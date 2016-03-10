package com.dkt.school.tea.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherFamilyDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.TeaFamilyService;
import com.dkt.school.tea.service.TeacherService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/tea")
public class TeaFamilyController {
	public final static Logger logger = LoggerFactory
			.getLogger(TeaFamilyController.class);
	
	private TeaFamilyService teaFamilyService;
	
	
	private EnumerationService enumerationService;
	
	private TeacherService teacherService;
	
	

	public TeacherService getTeacherService() {
		return teacherService;
	}

	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}
	public TeaFamilyService getTeaFamilyService() {
		return teaFamilyService;
	}

	@Autowired
	public void setTeaFamilyService(TeaFamilyService teaFamilyService) {
		this.teaFamilyService = teaFamilyService;
	}


	//教师异动首页
	@RequestMapping("/teaFamilyList")
	public String teaFamilyList(Integer id,Model model) {
		Teacher tea = teacherService.selectByPrimaryKey(id);
		String name = tea.getName();
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		return "tea/teaFamilyList";
	}	
	
	
	/**
	 * 查询单个教职工的家庭信息
	 * 
	 * @param name
	 * @param code
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeaFamilyList")
	public String getTeaFamilyList(Integer id, PaginationCustom page) {
		int total = teaFamilyService.getTeaFamilyCountById(id);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<TeacherFamilyDto> teacherFamilyDto = teaFamilyService.getTeaFamilyById(id,page);
		for(TeacherFamilyDto teacherFamily:teacherFamilyDto){
			Date date=teacherFamily.getBirthday();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherFamily.setBirthdayStr(dateShow);			
		}
		
		Gson gson = new Gson();
		JsonObject resultJson = new JsonObject();
		JsonArray teaFamilyListJa = gson.toJsonTree(teacherFamilyDto, List.class)
				.getAsJsonArray();
		resultJson.add("rows", teaFamilyListJa);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	
	
	
	
	/**
	 * 跳转到添加教师家庭信息的页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/toAddTeacherFamily")
	public String toAddTeacherFamily(Model model,Integer teacherId) {
		model.addAttribute("teacherId", teacherId);
		List<EnumerationValue> sexList=enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		model.addAttribute("sexList", sexList);
		List<EnumerationValue> teaRelationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_RELATION_TYPE);
		model.addAttribute("teaRelationTypeList", teaRelationTypeList);
		Teacher tea = teacherService.selectByPrimaryKey(teacherId);
		String name = tea.getName();
		model.addAttribute("name", name);
		return"tea/newTeaFamily";
	}
	
	
	//添加教职工家庭信息
	@ResponseBody
	@RequestMapping("/addTeaFamily")
	public String addTeaFamily(TeacherFamilyDto teacherFamilyDto) {
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(teacherFamilyDto.getBirthdayStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherFamilyDto.setBirthday(date);
		
		
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(teacherFamilyDto));
		resultJo.addProperty("result", teaFamilyService.addTeaFamily(teacherFamilyDto));
		return resultJo.toString();
	}	
	
	/**
	 * 编辑教职工家庭信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditTeacherFamily")
	public String toEditTeacherFamily(Integer id,Integer teacherId,Model model){
		model.addAttribute("id", id);
		model.addAttribute("teacherId", teacherId);
		List<EnumerationValue> sexList=enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		model.addAttribute("sexList", sexList);
		List<EnumerationValue> teaRelationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_RELATION_TYPE);
		model.addAttribute("teaRelationTypeList", teaRelationTypeList);
		Teacher tea = teacherService.selectByPrimaryKey(id);
		String name = tea.getName();
		model.addAttribute("name", name);
		return "tea/editTeacherFamily";
	}
	/**
	 * 根据id查找教职工家庭信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherFamily")
	public String getTeacherFamily(Integer id,Integer teacherId) {
		TeacherFamilyDto tfDto=teaFamilyService.findTeaFamilyById(id);
		Date date=tfDto.getBirthday();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateShow=null;
		try {
			dateShow=dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tfDto.setBirthdayStr(dateShow);
		JsonObject resultJson = new JsonObject();
		
		Gson gson = new Gson();
		resultJson.add("tfDto", gson.toJsonTree(tfDto));
		return resultJson.toString();
	}	
	
	/**
	 * 保存编辑教职工家庭信息的数据
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editTeacherFamily")
	public String editTeacherFamily(TeacherFamilyDto teacherFamilyDto){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(teacherFamilyDto.getBirthdayStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherFamilyDto.setBirthday(date);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", teaFamilyService.updateTeacherFamily(teacherFamilyDto));
		return jsonObject.toString();
	}
	
	
	/**
	 * 根据id删除教职工家庭信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteTeaFamily")
	public String deleteTeaFamily(Integer id){
		JsonObject jsonObject=new JsonObject();
		Integer result = teaFamilyService.deleteTeaFamilyById(id);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
}
