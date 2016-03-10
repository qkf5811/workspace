package com.dkt.school.stu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.DivideClassDto;
import com.dkt.school.stu.dto.StudentToBeDividedDto;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.service.ClazzService;
import com.dkt.school.stu.service.DivideClassSettingService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;




/**
 * 分班功能模块重构
 * @author Lai JiPeng
 *
 */


@Controller
@RequestMapping("/stu")
public class NewDivideClassController {

	 public final static Logger logger = LoggerFactory
	            .getLogger(ClassController.class);

	    private MajorService majorService;
	    private DivideClassSettingService divideClassSettingService;
	    private EnumerationService enumerationService;
	    private ClazzService clazzService;

	    
		public ClazzService getClazzService() {
			return clazzService;
		}
		@Autowired
		public void setClazzService(ClazzService clazzService) {
			this.clazzService = clazzService;
		}
		
		public EnumerationService getEnumerationService() {
			return enumerationService;
		}
		@Autowired
		public void setEnumerationService(EnumerationService enumerationService) {
			this.enumerationService = enumerationService;
		}
		
		public DivideClassSettingService getDivideClassSettingService() {
			return divideClassSettingService;
		}
		@Autowired
		public void setDivideClassSettingService(
				DivideClassSettingService divideClassSettingService) {
			this.divideClassSettingService = divideClassSettingService;
		}
		
		public MajorService getMajorService() {
			return majorService;
		}
		@Autowired
		public void setMajorService(MajorService majorService) {
			this.majorService = majorService;
		}
				
		
		 /**
	     * 进入分班设置的首页
	     * @return
	     */
	    @RequestMapping("/toDivideClassSettingList")
	    public String toDivideClassSettingList(Model model){
	        return "stu/newDivideClass";
	    }
	    
	    
	    /**
	     * 进入手动分班设置的页面
	     * @return
	     */
	    @RequestMapping("/toNotAutoDivideClassSettingList")
	    public String toNotAutoDivideClassSetting(Model model){
	    	List<EnumerationValue> statusList = enumerationService.getEnumValueListByEnumId(EnumerationType.STU_STATUS);
	    	List<EnumerationValue> booleanList = enumerationService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
	        List<Major> majorList=majorService.getAllMajorInfo();
	        model.addAttribute("majorList",majorList);
	        model.addAttribute("statusList", statusList);
	        model.addAttribute("booleanList", booleanList);
	        return "stu/notAutoDivideClassSettingList";
	    }
	    
	
	    /**
	     * 查询出各个专业的分班情况
	     * @param page
	     * @return
	     */
		@ResponseBody
		@RequestMapping("/getInfoOfDivideClass")
		public String getInfoOfDivideClass(PaginationCustom page) {
			logger.info("-----------获取分班信息---------------");
			JsonObject resultJson = new JsonObject();
			// total:所有记录数并设置page的属性
			int total = divideClassSettingService.selectCountOfTotalInfoOfDivideClass();
			page.setCurrentPage(page.getPage());
			page.setPageRecorders(page.getRows());
			page.setTotalRows(total);
			// 查询记录
			List<DivideClassDto> divideClassInfoList =
					divideClassSettingService.selectTotalInfoOfDivideClass(page);
			// 设置日期str属性
			JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
					.toJsonTree(divideClassInfoList, List.class).getAsJsonArray();
			resultJson.add("rows", ja);
			resultJson.addProperty("total", total);
			return resultJson.toString();
		}
		
		
		/**
		 * -查询进行手动分班设置的学生列表
		 * @param dto
		 * @param page
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getStudentListToDivide")
		public String getStudentListToDivide(StudentToBeDividedDto dto, PaginationCustom page) {
			//System.out.println("StudentToBeDividedDto : "+dto);
			logger.info("-----------查询学生列表进行手动分班设置---------------");
			JsonObject resultJson = new JsonObject();
			// total:所有记录数并设置page的属性
			int total = divideClassSettingService.selectCountOfStudentsToDivide(dto);
			page.setCurrentPage(page.getPage());
			page.setPageRecorders(page.getRows());
			page.setTotalRows(total);
			// 查询记录
			List<StudentToBeDividedDto> studentList =
					divideClassSettingService.selectStudentsToDivide(dto,page);			
			// 设置日期str属性
			JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
					.toJsonTree(studentList, List.class).getAsJsonArray();
			resultJson.add("rows", ja);
			resultJson.addProperty("total", total);
			return resultJson.toString();
		}
		
		/**
		 * 根据专业方向id得到一年级的班级的json串
		 * @param majorFieldId
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getClassByMajorField")
		public String getClassByMajorField(Integer majorFieldId) {
			logger.info("---------------根据专业方向id得到班级的json串-------------------");			
			List<ClazzDto> list = clazzService.getClassOfGradeOneByMajorFieldId(majorFieldId);
			JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
			return ja.toString();
		}
	    

		/**
		 * 根据专业方向id检测得到班级的记录数
		 * @param majorFieldId
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getClassByMajorFieldTest")
		public String getClassByMajorFieldTest(
				@RequestParam(required=false, defaultValue="0", value="majorFieldId") int majorFieldId) {
			JsonObject resultJson = new JsonObject();
			logger.info("---------------根据专业方向i检测得到班级的记录数-------------------");			
			List<ClazzDto> list = clazzService.getClassOfGradeOneByMajorFieldId(majorFieldId);
			resultJson.addProperty("result", list.size());
			return resultJson.toString();
		}
		
		
		/**
		 * 根据MarjorFieldId和ClassID获取学号
		 * @param majorFieldId
		 * @param classId
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getCodeByMarjorFieldIdAndClassID")
		public String getCodeByMarjorFieldIdAndClassID(
				@RequestParam(required=false, defaultValue="0", value="majorFieldId") int majorFieldId, 
				@RequestParam(required=false, defaultValue="0", value="classId") int classId){
			logger.info("---------------根据MarjorFieldId和ClassID获取学号-------------------");
			String code=divideClassSettingService.getCodeByMarjorFieldIdAndClassID(majorFieldId,classId);			
			JsonObject resultJson = new JsonObject();	
			resultJson.addProperty("code",code);	
			return resultJson.toString();
		}
		
		/**
		 * 添加学生分班信息记录
		 * @param student
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/addNewStudentInAClass")
		public String addNewStudentInAClass(Student student) {
			JsonObject resultJson = new JsonObject();
			logger.info("---------------添加学生分班信息记录-------------------");					    
			resultJson.addProperty("result", divideClassSettingService.addNewStudentInAClass(student));
			return resultJson.toString();
		}
		
		/**
		 * 执行自动分班设置
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/autoDivideClassSetting")
		public String autoDivideClassSetting() {
			JsonObject resultJson = new JsonObject();
			logger.info("---------------执行自动分班设置-------------------");					    
			resultJson.addProperty("result", divideClassSettingService.autoDivideClassSetting());
			return resultJson.toString();
		}

}
