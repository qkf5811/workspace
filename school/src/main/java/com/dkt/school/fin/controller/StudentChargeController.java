package com.dkt.school.fin.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.dkt.school.edu.service.CoursePlanSettingService;
import com.dkt.school.edu.service.TeachCourseService;
import com.dkt.school.fin.dto.StudentChargeDto;
import com.dkt.school.fin.service.StudentChargeService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * <p>
 * Title: StudentChargeController
 * </p>
 * <p>
 * Description: 学费录入信息列表
 * </p>
 * <p>
 * Company: 江门市多科特科技发展有限公司
 * </p>
 * 
 * @author 赖继鹏
 * @date 2015年9月1日上午9:24:26
 * 
 */
@Controller
@RequestMapping("/fin")
public class StudentChargeController {

	public final static Logger logger = LoggerFactory
			.getLogger(ChargeStandardController.class);
	private StudentChargeService studentChargeService;
	private CoursePlanSettingService coursePlanSettingService;
	private EnumerationService enumerationService;
	private StudyYearService studyYearService;

	@Autowired
	private TeachCourseService teachCourseService;

	public StudyYearService getStudyYearService() {
		return studyYearService;
	}

	@Autowired
	public void setStudyYearService(StudyYearService studyYearService) {
		this.studyYearService = studyYearService;
	}

	public CoursePlanSettingService getCoursePlanSettingService() {
		return coursePlanSettingService;
	}

	@Autowired
	public void setCoursePlanSettingService(
			CoursePlanSettingService coursePlanSettingService) {
		this.coursePlanSettingService = coursePlanSettingService;
	}

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}

	public StudentChargeService getStudentChargeService() {
		return studentChargeService;
	}

	@Autowired
	public void setStudentChargeService(
			StudentChargeService studentChargeService) {
		this.studentChargeService = studentChargeService;
	}

	/**
	 * 
	 * @Title: tostudentChargeList
	 * @author 赖继鹏
	 * @Description: 进入学费录入信息列表首页
	 * @param model
	 * @return
	 * @throws
	 */
	@RequestMapping("/toStudentChargeList")
	public String tostudentChargeList(Model model) {
		List<EnumerationValue> termTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		List<Grade> gradeList = coursePlanSettingService.getAllGradeInfo();
		List<StudyYear> studyYearList = studyYearService.getAllStudyYear();
		model.addAttribute("termTypeList", termTypeList);
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("studyYearList", studyYearList);
		return "fin/studentChargeList";
	}

	/**
	 * 
	 * @Title: getStudentChargeList
	 * @author 赖继鹏
	 * @Description: 根据条件获取学生收费信息列表信息
	 * @param studentChargeDto
	 * @param page
	 * @return
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/getStudentChargeList")
	public String getStudentChargeList(StudentChargeDto studentChargeDto,
			PaginationCustom page) {
		int total = studentChargeService
				.getStudentChargeCount(studentChargeDto);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<StudentChargeDto> studentChargeList = studentChargeService
				.getStudentChargeListByPage(studentChargeDto, page);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray chargeStandardListJsonArray = gson.toJsonTree(
				studentChargeList, List.class).getAsJsonArray();

		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", chargeStandardListJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();

	}

	/**
	 * 
	 * @Title: toCountAllStudentsCharge
	 * @author 赖继鹏
	 * @Description: 计算应扣学费
	 * @return
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/toCountAllStudentsCharge")
	public String toCountAllStudentsCharge() {
		JsonObject resultJson = new JsonObject();
		logger.info("---------------计算应扣学费-------------------");
		String returnCode=studentChargeService.toCountAllStudentsCharge();
		
		String[] can = returnCode.split(",");
		int insertCount=Integer.parseInt(can[0]);
		int updateCount=Integer.parseInt(can[1]);
		
		resultJson.addProperty("insertCount", insertCount);
		resultJson.addProperty("updateCount", updateCount);
		
		return resultJson.toString();
	}

	/**
	 * @Title: chargeExportPage
	 * @author 龚硕晓
	 * @Description: 跳转到导出应扣学费页面
	 * @return
	 * @throws
	 */
	@RequestMapping("/chargeExportPage")
	public String chargeExportPage(Model model) {
		List<StudyYear> studyYearList = teachCourseService.getAllStudyYear();
		List<Grade> gradeList = coursePlanSettingService.getAllGradeInfo();
		model.addAttribute("studyYearList", studyYearList);
		model.addAttribute("gradeList", gradeList);
		/*
		 * Integer currentStudyYear=stuChargeService.getCurrentStudyYear();
		 * if(currentStudyYear==null){ currentStudyYear=0; }
		 * model.addAttribute("currentStudyYear", currentStudyYear);
		 */
		return "fin/testExport";
	}

	/**
	 * @Title: exportList
	 * @author 龚硕晓
	 * @Description: 导出应扣学费
	 * @return
	 * @throws
	 */
	@RequestMapping("/exportList")
	public void exportList(HttpServletResponse response,
			@RequestParam("studyYear") String studyYear,
			@RequestParam("termType") String termType,
			@RequestParam("grade") String grade) {

		Integer studyYearId;
		Integer termTypeId;
		Integer gradeId;

		if (studyYear.equals("0") || studyYear == "" || studyYear == null) {
			studyYearId = -1;
		} else {
			studyYearId = Integer.parseInt(studyYear);
		}

		if (termType.equals("0") || termType == "" || termType == null) {
			termTypeId = -1;
		} else {
			termTypeId = Integer.parseInt(termType);
		}

		if (grade.equals("0") || grade == "" || grade == null) {
			gradeId = -1;
		} else {
			gradeId = Integer.parseInt(grade);
		}

		studentChargeService.exportStuChargeInfo(response, studyYearId,
				termTypeId, gradeId);
	}

	/**
	 * @Title: exportList
	 * @author 龚硕晓
	 * @Description: 获取当前学年
	 * @return
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/getCurrentStudyYear")
	public String getCurrentStudyYear() {
		JsonObject resultJson = new JsonObject();

		Integer currentStudyYear = studentChargeService.getCurrentStudyYear();

		if (currentStudyYear == null) {
			currentStudyYear = 0;
		}

		resultJson.addProperty("result", currentStudyYear.toString());
		return resultJson.toString();
	}
}
