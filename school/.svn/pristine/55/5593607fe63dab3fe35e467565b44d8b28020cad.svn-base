package com.dkt.school.tea.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeacherPunishmentDto;
import com.dkt.school.tea.model.TeacherPunishment;
import com.dkt.school.tea.service.TeacherPunishmentService;
import com.dkt.school.user.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/** 
 * @author JanGin Chan
 */
@Controller
@RequestMapping("/tea")
public class TeacherPunishmentController {
	
	@Autowired
	private EnumerationService es;
	@Autowired
	private TeacherPunishmentService tps;
	@Autowired
	private StudyYearService sys;
	
	@RequestMapping("/toTeaPunishmentList")
	public String toTeaPunishmentList(){
		return "/tea/teaPunishmentList";
	}
	
	@RequestMapping("/toGetSinglePunishList")
	public String toGetSinglePunishList(Model model){
		List<StudyYear> sList = sys.getAllStudyYear();
		model.addAttribute("sList",sList);
		return "/tea/oneTeaPunishList";
	}
	
	@ResponseBody
	@RequestMapping("/getTeaPunishmentList")
	public String getTeaPunishmentList(String name,String code,PaginationCustom page){
		int totalRows = tps.getTeaPunishmentCount();
		System.out.println("记录数数量="+totalRows);
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(totalRows);
		List<TeacherPunishmentDto> list = tps.getTeaPunishmentList(name,code,page.getLimitation());
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total",totalRows);
		return json.toString();
	}
	
	@RequestMapping("/toAddTeaPunishmentInfo")
	public String toAddTeaPunishmentInfo(Model model){
		List<EnumerationValue> termList = 
						es.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		List<EnumerationValue> punishList = 
						es.getEnumValueListByEnumId(EnumerationType.TEACHER_PUNISHMENT_TYPE);
		List<StudyYear> studyYearList = sys.getAllStudyYear();
		model.addAttribute("sList", studyYearList);
		model.addAttribute("termList", termList);
		model.addAttribute("pList", punishList);
		return "/tea/teaPunishmentInfo";
	}
	
	@ResponseBody
	@RequestMapping("/findAllTeacherList")
	public String findAllTeacherList(String code,String name,PaginationCustom page){
		int totalRows = tps.getTeacherCount(code,name);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		List<TeacherPunishmentDto> list = tps.getTeacherList(code, name, page.getLimitation());
		System.out.println("list的大小:="+list.size());
		JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
		jsonObject.add("rows", jsArr);
		jsonObject.addProperty("total",totalRows);
		return jsonObject.toString();
	}
	
	@ResponseBody
	@RequestMapping("/addTeaPunishmentItem")
	public String addTeaPunishmentItem(TeacherPunishment tr){
		System.out.println("\n\n"+tr+"\n\n");
		JsonObject json = new JsonObject();
		json.addProperty("result", tps.addTeaPunishmentItem(tr));
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/getSingleTeacherPunishList")
	public String getSingleTeacherPunishList(HttpServletRequest request,
			Integer schoolYearId,Integer schoolTermType,String title,
			PaginationCustom page){
		//System.out.println("学年="+schoolYearId+"学期="+schoolTermType+"名称="+title);
		User user = (User)request.getSession().getAttribute("user");
		Integer teacherId = null;
		if (user != null){
			teacherId = tps.getTeacherIdByUserId(user.getId());
		}
		int totalRows = tps.getSpecifiedTeacherPunishCount(teacherId,schoolYearId,schoolTermType,title);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		List<TeacherPunishmentDto> list = tps.getSpecifiedTeacherPunishList(teacherId, 
				schoolYearId,schoolTermType,title,page.getLimitation());
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject json = new JsonObject();
		JsonArray jsArr = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total",totalRows);
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/deleteTeaPunishmentItem")
	public String deleteTeaPunishmentItem(Integer id){
		JsonObject json = new JsonObject();
		json.addProperty("success", tps.deleteTeaPunishmentItemById(id));
		return json.toString();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
}
