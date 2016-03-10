package com.dkt.school.sch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.sch.model.School;
import com.dkt.school.sch.service.SchoolService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("sch")
public class SchoolController {

	private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	EnumerationService enumService;
	
	@RequestMapping("/schoolEdit")
	public String schoolEdit(Model model) {
		logger.info("[index] Turning to school edit page.");
		
		School school = schoolService.getSchoolInfo();
		model.addAttribute("school", school);
		
		// 学校类型
		List<EnumerationValue> schoolTypeList = enumService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TYPE);
		model.addAttribute("schoolTypeList", schoolTypeList);
		
		// 学校性质
		List<EnumerationValue> natureTypeList = enumService.getEnumValueListByEnumId(EnumerationType.SCHOOL_NATURE_TYPE);
		model.addAttribute("natureTypeList", natureTypeList);
		
		return "sch/schoolEdit";
	}

	@ResponseBody
	@RequestMapping("/updateSchool")
	public String updateSchool(School school) {
		JsonObject resultJo = new JsonObject();
		resultJo.addProperty("result", schoolService.updateSchool(school));
		return resultJo.toString();
	}

}
