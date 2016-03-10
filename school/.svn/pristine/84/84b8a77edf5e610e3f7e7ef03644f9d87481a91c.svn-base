package com.dkt.school.tea.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.ContinuingEducationDto;
import com.dkt.school.tea.model.ContinuingEducation;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.ContinuingEducationService;
import com.dkt.school.user.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/tea")
public class TeaContinueEduController {

	@Autowired
	private EnumerationService es;
	@Autowired
	private ContinuingEducationService ces;
	
	@RequestMapping("/toTeaContinuingEduList")
	public String toTeaContinuingEduList(){
		return "tea/teaContinueEduList";
	}
	
	@ResponseBody
	@RequestMapping("/getTeaContinueEduList")
	public String getTeaContinueEduList(String name,String code,PaginationCustom page){
		int totalRows = ces.getTeaContiueEduCount(name, code);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		List<ContinuingEducationDto> list = ces.getTeaContinueEduList(name, code, page.getLimitation());
		JsonArray jsArr = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total", totalRows);
		return json.toString();
	}
	
	@RequestMapping("/toAddTeaContinueEduItem")
	public String toAddTeaContinueEduItem(Model model){
		List<EnumerationValue> courseList 			//
				= es.getEnumValueListByEnumId(EnumerationType.TEACHER_COURSE_TYPE);
		model.addAttribute("cList",courseList);
		return "tea/addContinueEduItem";
	}
	
	@ResponseBody
	@RequestMapping("/addTeaConEduItem")
	public String addTeaConEduItem(ContinuingEducation ce){
		JsonObject json = new JsonObject();
		json.addProperty("result",ces.addTeaConEduItem(ce));
		return json.toString();
	}
	
	@RequestMapping("/toEditTeaConEduItem")
	public String toEditTeaConEduItem(Integer id,Model model){
		ContinuingEducationDto dto = ces.getTeaContinuingEduDtoById(id);
		List<EnumerationValue> courseList			// 
				= es.getEnumValueListByEnumId(EnumerationType.TEACHER_COURSE_TYPE);
		model.addAttribute("cList", courseList);
		model.addAttribute("dto", dto);
		return "tea/editTeaConEduItem";
	}
	
	@ResponseBody
	@RequestMapping("/editTeaConEduItem")
	public String editTeaConEduItem(ContinuingEducation ce){
		JsonObject json = new JsonObject();
		json.addProperty("result",ces.editTeaConEduItem(ce));
		return  json.toString();
	}
	
	/*
	 * 获取添加页面的窗口列表
	 */
	@ResponseBody
	@RequestMapping("/getAllTeaContinuingEdu")
	public String getAllTeaContinuingEdu(String name,String code,PaginationCustom page){
		
		int totalRows = ces.getTeaContinuingEduCount(name, code);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		List<Teacher> list = ces.getTeaContinuingEduList(name, code, page.getLimitation());
		JsonArray jsArr = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total", totalRows);
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/deleteTeaContinueEduItem")
	public String deleteTeaContinueEduItem(Integer id){
		JsonObject json = new JsonObject();
		json.addProperty("result", ces.deleteTeaContinueEduItem(id));
		return json.toString();
	}
	
	@RequestMapping("/toMyContinueEduPage")
	public String toMyContinueEduPage(Model model){
		List<EnumerationValue> courseList			// 
				= es.getEnumValueListByEnumId(EnumerationType.TEACHER_COURSE_TYPE);
		model.addAttribute("courseList", courseList);
		return "tea/oneContinueEdu";
	}
	
	@ResponseBody
	@RequestMapping("/getMyConEduList")
	public String getMyConEduList(HttpServletRequest request,
									String teachOrganization,String courseName,
									Integer courseType,PaginationCustom page){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject json = new JsonObject();
		Integer teacherId = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null){
			teacherId = ces.getTeacherIdByUserId(user.getId());
		} /*else {
			json.addProperty("result",-1);
			return json.toString();
		}*/
		int totalRows = ces.getMyConEduCount(teacherId,teachOrganization,courseName, courseType);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		List<ContinuingEducation> list = ces.getMyConEduList(teacherId,teachOrganization,courseName, courseType,page.getLimitation());
		JsonArray jsArr = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.add("rows", jsArr);
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
