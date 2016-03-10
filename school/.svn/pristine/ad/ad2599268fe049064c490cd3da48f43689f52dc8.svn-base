package com.dkt.school.tea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tea")
public class MyInformationController {
	public final static Logger logger = LoggerFactory
			.getLogger(MyInformationController.class);
	
	
	//教师异动首页
	@RequestMapping("/myInformation")
	public String myInformation(Model model,Integer userId) {
		model.addAttribute("id", userId);
		return "tea/myInformation";
	}
}
