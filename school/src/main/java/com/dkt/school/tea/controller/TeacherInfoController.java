package com.dkt.school.tea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tea")
public class TeacherInfoController {
	
	
	@RequestMapping("/teaInfo")
	public String teacherInfo() {
		
		return "/tea/teaInfo";
	}
}
