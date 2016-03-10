package com.dkt.school.stu.controller;

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
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.service.StudentChangeService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


//学籍异动
@Controller
@RequestMapping("/stu")
public class StudentChangeController {
	public final static Logger logger = LoggerFactory
			.getLogger(StudentChangeController.class);

	private StudentChangeService scService;
	
	@Autowired
	private EnumerationService enumerationService;
	
	public StudentChangeService getScService() {
		return scService;
	}

	@Autowired
	public void setScService(StudentChangeService scService) {
		this.scService = scService;
	}

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	//@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}

	//跳转到学籍异动首页
	@RequestMapping("/studentChangeList")
	public String studentChangeList() {
		return "stu/studentChangeList";
	}	
	/***hiu*/
	@ResponseBody
	@RequestMapping("/getStudentChangeListByStuCode")
	public String getStudentChangeListByStuCode(String stuCode) {
		//JsonObject resultJson = new JsonObject();
		List<EnumerationValue> changeTypeList =enumerationService.getEnumValueListByEnumIdByStuCode(EnumerationType.CHANGE_TYPE,stuCode);	
		//resultJson.addProperty("changeTypeList", changeTypeList.toString());

		return new Gson().toJson(changeTypeList);
	}
	
	
	/**
	 * 查询所有学籍异动
	 * 
	 * @param name
	 * @param code
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStudentChangeList")
	public String getStudentChangeList(String name, String code, PaginationCustom page) {
		int total = scService.getStudentChangeCount(name,code);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<StudentChangeDto> scDto = scService.getStudentChangesByPage(name,code,page);
		for(StudentChangeDto studentChangeDto:scDto){
			Date date1=studentChangeDto.getIntoClassDate();
			Date date2=studentChangeDto.getOutClassDate();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow1=null;
			String dateShow2=null;
			try {
				if(date1!=null){//hiu添加判断是否为空
				   dateShow1=dateFormat.format(date1);
				   studentChangeDto.setIntoClassDateStr(dateShow1);
				}   
				if(date2!=null){
				   dateShow2=dateFormat.format(date2);
				   studentChangeDto.setOutClassDateStr(dateShow2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			studentChangeDto.setOutClassName(scService.getClassNameByClassId(studentChangeDto.getOutClassId()));
			studentChangeDto.setIntoClassName(scService.getClassNameByClassId(studentChangeDto.getIntoClassId()));
			
			
		}
		
		Gson gson = new Gson();
		JsonArray studentChangeListJa = gson.toJsonTree(scDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", studentChangeListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 跳转到添加学籍异动的页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/toAddStudentChange")
	public String toAddStudentChange(Model model) {
		/*HIU 注释 2015-09-30，不加载所有异动类型，只加载除了当前学号、当前类型外的异动类型
		List<EnumerationValue> changeTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.CHANGE_TYPE);
		model.addAttribute("changeTypeList", changeTypeList);
		*/
		return "stu/newStudentChange";
	}
	
	//添加学籍异动
	@ResponseBody
	@RequestMapping("/addStudentChange")
	public String addStudentChange(StudentChangeDto scDto) throws ParseException {
		
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	
		
		if(scDto.getStudentStatus()!=null && (scDto.getStudentStatus().equals("14002") || scDto.getStudentStatus().equals("14003"))){
		   Date date1=null;
		   date1=dateFormat.parse(scDto.getOutClassDateStr());
		   scDto.setOutClassDate(date1);
		   scDto.setOutClassId(scService.getClassByMajorFieldClassName(scDto.getOutClassName()).getId());
		}
		
		if(scDto.getStudentStatus()!=null && scDto.getStudentStatus().equals("14004")){
		   Date date2=null;
		   date2=dateFormat.parse(scDto.getIntoClassDateStr());
		   scDto.setIntoClassDate(date2);
		   scDto.setIntoClassId(scService.getClassByMajorFieldClassName(scDto.getIntoClassName()).getId());
		}
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(scDto));
		//根据学号找到StudentId,然后设进学籍异动中
		StudentDto student = scService.findStudent(scDto.getCode());
		scDto.setStudentId(student.getId());
		resultJo.addProperty("result", scService.addStudentChange(scDto));
		return resultJo.toString();
	}	
	
	/**
	 * 编辑学籍异动
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditStudentChange")
	public String toEditStudentChange(Integer id,Model model){
		model.addAttribute("id", id);
		return "stu/editStudentChange";
	}
	

	/**
	 * 根据id查找学籍异动信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStudentChange")
	public String getStudentChange(Integer id) {
		StudentChangeDto scDto=scService.findStudentChangeById(id);
		Date date1=scDto.getIntoClassDate();
		Date date2=scDto.getOutClassDate();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateShow1=null;
		String dateShow2=null;
		try {
			dateShow1=dateFormat.format(date1);
			dateShow2=dateFormat.format(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		scDto.setIntoClassDateStr(dateShow1);
		scDto.setOutClassDateStr(dateShow2);
		JsonObject resultJson = new JsonObject();
		
		Gson gson = new Gson();
		resultJson.add("scDto", gson.toJsonTree(scDto));
		return resultJson.toString();
	}
	
	/**
	 * 保存编辑学籍异动的数据
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editStudentChange")
	public String editStudentChange(StudentChangeDto scDto){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date1=null;
		Date date2=null;
		try {
			date1=dateFormat.parse(scDto.getIntoClassDateStr());
			date2=dateFormat.parse(scDto.getOutClassDateStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scDto.setIntoClassDate(date1);
		scDto.setOutClassDate(date2);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", scService.updateStudentChange(scDto));
		return jsonObject.toString();
	}
	
	
	/**
	 * 根据id删除学籍异动
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteStudentChange")
	public String deleteStudentChange(Integer id,String code){
		JsonObject jsonObject=new JsonObject();
		Integer result = scService.deleteStudentChangeById(id,code);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
	
	/**
	 * 取得所有学生的数据，并模糊查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStudentList")
	public String getStudentList(String name, String code,String className, PaginationCustom page){
		
		int total = scService.getStudentsCount(name,code);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<StudentDto> sDto = scService.getStudentsByPage(name,code,page);
		
		for(StudentDto studentDto:sDto){	
			studentDto.setClassName(scService.getClassNameByClassId(studentDto.getClassId()));
		}
		Gson gson = new Gson();
		JsonArray studentListJa = gson.toJsonTree(sDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", studentListJa);
		resultJson.addProperty("total", total);
		return resultJson.toString();
		
	}
	
	
	/**
	 * 取得所有班级的数据--年级、专业方向，并模糊查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassList")
	public String getClassList(String majorFieldClassName, String gradeName, PaginationCustom page){
		int total = scService.getClassCount(majorFieldClassName,gradeName);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<ClazzDto> clazzDtos = scService.getClazzsByPage(majorFieldClassName,gradeName,page);
		for(ClazzDto clazzDto:clazzDtos){	
			clazzDto.setClassName(clazzDto.getName());
		}
		Gson gson = new Gson();
		JsonArray clazzListJa = gson.toJsonTree(clazzDtos, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", clazzListJa);
		resultJson.addProperty("total", total);
		return resultJson.toString();
		
	}
}
