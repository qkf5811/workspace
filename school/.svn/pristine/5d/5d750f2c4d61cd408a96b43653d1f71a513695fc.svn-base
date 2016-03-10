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
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeacherRewardDto;
import com.dkt.school.tea.service.TeacherRewardService;
import com.dkt.school.user.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 * @author JanGin Chan
 */

@RequestMapping("/tea")
@Controller
public class TeacherRewardController {

	@Autowired
	private EnumerationService es;
	@Autowired
	private TeacherRewardService trs;
	@Autowired
	private StudyYearService sys;
	
	@RequestMapping("/toTeaRewardList")
	public String toTeaRewardList(){
		return "/tea/teaRewardList";
	}
	
	@RequestMapping("/toGetSingleRewardList")
	public String toGetSingleRewardList(Model model){
		List<StudyYear> sList = sys.getAllStudyYear();
		model.addAttribute("sList", sList);
		return "/tea/oneTeaRewardList";
	}
	
	@ResponseBody
	@RequestMapping("/getTeaRewardList")
	public String getTeaRewardList(String name,String code,PaginationCustom page){
		int totalRows = trs.getTeaRewardCount(name,code);
		System.out.println("记录数数量="+totalRows);
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(totalRows);
		List<TeacherRewardDto> list = trs.getTeaRewardList(name,code,page.getLimitation());
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total",totalRows);
		return json.toString();
	}
	
	@RequestMapping("/toAddTeaRewardInfo")
	public String toAddTeaRewardInfo(Model model){
		List<EnumerationValue> termList = 
					es.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		List<EnumerationValue> rewardList = 
					es.getEnumValueListByEnumId(EnumerationType.TEACHER_REWARD_TYPE);
		List<StudyYear> studyYearList = sys.getAllStudyYear();
		model.addAttribute("tList", termList);
		model.addAttribute("rList", rewardList);
		model.addAttribute("sList", studyYearList);
		return "/tea/teaRewardInfo";
	}
	
	@ResponseBody
	@RequestMapping("/getAllTeacherList")
	public String getAllTeacherList(String code,String name,PaginationCustom page){
		int totalRows = trs.getTeacherCount(code,name);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		List<TeacherRewardDto> list = trs.getTeacherList(code, name, page.getLimitation());
		System.out.println("list的大小:="+list.size());
		JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
		jsonObject.add("rows", jsArr);
		jsonObject.addProperty("total",totalRows);
		return jsonObject.toString();
	}
	
	@ResponseBody
	@RequestMapping("/addTeaRewardItem")
	public String addTeaRewardItem(TeacherRewardDto dto){
		JsonObject json = new JsonObject();
		json.addProperty("result", trs.addTeaRewardItem(dto));
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/deleteTeaRewardItem")
	public String deleteTeaRewardItem(Integer id){
		JsonObject json = new JsonObject();
		json.addProperty("success", trs.deleteTeaRewardItemById(id));
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/getSingleTeacherRewardList")
	public String getSingleTeacherRewardList(HttpServletRequest request,
						Integer schoolYearId,Integer schoolTermType,String title,PaginationCustom page){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Integer teacherId = null;
		if (user != null){
			teacherId = trs.getTeacherIdByUserId(user.getId());
			//System.out.println("\n\n\n\n"+teacherId.equals(user.getId())+"\n\n\n\n");
		}
		int totalRows = trs.getSpecifiedTeacherRewardCount(teacherId,schoolYearId,schoolTermType,title);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		List<TeacherRewardDto> list = trs.getSpecifiedTeacherRewardList(teacherId,schoolYearId,schoolTermType,title, page.getLimitation());
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		JsonArray jsArr = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total",totalRows);
		return json.toString();
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
}
