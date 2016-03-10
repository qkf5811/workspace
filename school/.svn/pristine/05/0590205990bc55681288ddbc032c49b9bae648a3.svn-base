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
import com.dkt.school.tea.dto.TeacherThesisDto;
import com.dkt.school.tea.service.AllThesisService;
import com.dkt.school.tea.service.TeaFamilyService;
import com.dkt.school.tea.service.TeacherService;
import com.dkt.school.tea.service.TeacherThesisService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/tea")
public class ThesisController {
	public final static Logger logger = LoggerFactory
			.getLogger(ThesisController.class);
	
	private AllThesisService allThesisService;
	
	private TeacherThesisService teacherThesisService;
	
	private TeacherService teacherService; 
	
	private TeaFamilyService teaFamilyService;
	

	private EnumerationService enumerationService;
	
	

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

	public AllThesisService getAllThesisService() {
		return allThesisService;
	}

	@Autowired
	public void setAllThesisService(AllThesisService allThesisService) {
		this.allThesisService = allThesisService;
	}

	public TeacherThesisService getTeacherThesisService() {
		return teacherThesisService;
	}

	@Autowired
	public void setTeacherThesisService(TeacherThesisService teacherThesisService) {
		this.teacherThesisService = teacherThesisService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	//转到所有论文著作首页
	@RequestMapping("/allThesisList")
	public String allThesisList(Model model) {
		List<EnumerationValue> teacherThesisTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_THESIS_TYPE);
		model.addAttribute("teacherThesisTypeList", teacherThesisTypeList);
		return "tea/allThesisList";
	}
	
	//转到单个教职工论文著作首页
	@RequestMapping("/teacherThesisList")
	public String teacherThesisList(Integer userId,Model model) {
		TeacherDto teacherDto = teacherService.getTeacherByUserId(userId);
		if(teacherDto!=null) {
			model.addAttribute("code", teacherDto.getCode());
			model.addAttribute("name", teacherDto.getName());
		}else {
			
		}
		
		model.addAttribute("userId", userId);
		return "tea/teacherThesisList";	
	}	
	
	/**
	 * 查询所有论文著作
	 * 
	 * @param name
	 * @param code
	 * @param thesisType
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllThesisList")
	public String getAllThesisList(String name, String code,Integer thesisType, PaginationCustom page) {
		int total = allThesisService.getAllThesisCount(name,code,thesisType);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<TeacherThesisDto> teacherThesisDto = allThesisService.getAllThesisByPage(name,code,thesisType,page);
		for(TeacherThesisDto teacherThesis:teacherThesisDto){
			Date date=teacherThesis.getPublishDate();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherThesis.setPublishDateStr(dateShow);		
		}
		
		Gson gson = new Gson();
		JsonArray teacherThesisJa = gson.toJsonTree(teacherThesisDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", teacherThesisJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	
	/**
	 * 查询单人论文著作
	 * 
	 * @param thesisType
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherThesisList")
	public String getTeacherThesisList(Integer  userId,Integer thesisType, PaginationCustom page) {
		Gson gson = new Gson();
		JsonObject resultJson = new JsonObject();
		TeacherDto teacherDto = teacherService.getTeacherByUserId(userId);
		if(teacherDto!=null) {
			Integer teacherId = teacherDto.getId();
			int total = teacherThesisService.getTeacherThesisCount(teacherId);
			// 设置当前页面所选择的每页记录数
			page.setPageRecorders(page.getRows());
			page.setCurrentPage(page.getPage());
			page.setTotalRows(total);
			List<TeacherThesisDto> teacherThesisDto = teacherThesisService.getTeacherThesisByPage(teacherId,thesisType,page);
			for(TeacherThesisDto teacherThesis:teacherThesisDto){
				Date date=teacherThesis.getPublishDate();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				String dateShow=null;
				try {
					dateShow=dateFormat.format(date);
				} catch (Exception e) {
					e.printStackTrace();
				}
				teacherThesis.setPublishDateStr(dateShow);		
			}
			JsonArray teacherThesisJa = gson.toJsonTree(teacherThesisDto, List.class)
					.getAsJsonArray();
			
			resultJson.add("rows", teacherThesisJa);
			resultJson.addProperty("total", total);
		}else {
			List<TeacherThesisDto> teacherThesisDtoNull=new ArrayList<TeacherThesisDto>();
			JsonArray teacherThesisJaNull = gson.toJsonTree(teacherThesisDtoNull, List.class)
					.getAsJsonArray();
			
			resultJson.add("rows", teacherThesisJaNull);
			resultJson.addProperty("total", 0);
		}
		
		
		
		

		return resultJson.toString();
	}
	
	/**
	 * 根据id删除论文著作
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteThesis")
	public String deleteThesis(Integer id){
		JsonObject jsonObject=new JsonObject();
		Integer result = allThesisService.deleteThesis(id);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
	/**
	 * 根据id删除论文著作
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteTeacherThesis")
	public String deleteTeacherThesis(Integer id){
		JsonObject jsonObject=new JsonObject();
		Integer result = teacherThesisService.deleteThesis(id);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
	
	
	/**
	 * 跳转到添加论文著作的页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/toAddTeacherThesis")
	public String toAddTeacherThesis(Integer userId,Model model) {	
		TeacherDto teacherDto = teacherService.getTeacherByUserId(userId);
		List<EnumerationValue> teacherThesisTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_THESIS_TYPE);
		model.addAttribute("teacherThesisTypeList", teacherThesisTypeList);
		model.addAttribute("teacherId", teacherDto.getId());
		return "tea/newTeacherThesis";
	}
	
	
	//添加论文著作
	@ResponseBody
	@RequestMapping("/addTeacherThesis")
	public String addTeacherThesis(TeacherThesisDto teacherThesisDto) {
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(teacherThesisDto.getPublishDateStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherThesisDto.setPublishDate(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(teacherThesisDto));
		resultJo.addProperty("result", teacherThesisService.addTeacherThesis(teacherThesisDto));
		return resultJo.toString();
	}		
	
	/**
	 * 编辑论文著作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditTeacherThesis")
	public String toEditTeacherThesis(Integer id,String code,Model model){
		List<EnumerationValue> teacherThesisTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_THESIS_TYPE);
		model.addAttribute("teacherThesisTypeList", teacherThesisTypeList);
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		System.out.println("code:"+code);
		return "tea/editTeacherThesis";
	}
	
	/**
	 * 根据id查找论文著作信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherThesis")
	public String getTeacherThesis(Integer id) {
		TeacherThesisDto ttDto=teacherThesisService.getTeacherThesisById(id);
		System.out.println("ttdto:"+ttDto.getAuthorOrder());
		Date date=ttDto.getPublishDate();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateShow=null;
		try {
			dateShow=dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ttDto.setPublishDateStr(dateShow);
		JsonObject resultJson = new JsonObject();
		
		Gson gson = new Gson();
		
		resultJson.add("ttDto", gson.toJsonTree(ttDto));
		return resultJson.toString();
	}	
	
	
	/**
	 * 保存编辑论文著作信息的数据
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editTeacherThesis")
	public String editTeacherThesis(TeacherThesisDto teacherThesisDto){
		TeacherDto teacherDto=teaFamilyService.getTeacherByCode(teacherThesisDto.getCode());
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(teacherThesisDto.getPublishDateStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherThesisDto.setPublishDate(date);
		teacherThesisDto.setTeacherId(teacherDto.getId());
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", teacherThesisService.updateTeacherThesis(teacherThesisDto));
		return jsonObject.toString();
	}
	
}
