package com.dkt.school.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dkt.school.sch.model.School;
import com.dkt.school.sch.service.SchoolService;
import com.dkt.school.system.model.SysLog;
import com.dkt.school.system.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.service.UserService;

import java.util.Date;

/*
 *@Title: BaseController.java
 *@Package com.dkt.school.base.controller
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午4:49:31
 */

@Controller
public class BaseController {

public final static Logger logger=LoggerFactory.getLogger(BaseController.class);


	@Autowired
	private UserService userService;

	@Autowired
	private SchoolService schoolService;

	private SysLogService sysLogService;
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SysLogService getSysLogService() {
		return sysLogService;
	}

	@Autowired
	public void setSysLogService(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}

	//权限检查
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String accessDenied(Model model){
		return "accessDenied";
	}
	
	/**
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpSession session) {
		SecurityContext secCtx=SecurityContextHolder.getContext();
		//获取权限
		Authentication auth=secCtx.getAuthentication();
		//获取用户名
		Object principal=auth.getPrincipal();
		String userName="";
		if(principal instanceof UserDetails){
			userName=((UserDetails) principal).getUsername();
		}else{
			userName=principal.toString();
		}
		
		UserDto user = userService.getUserByAccount(userName);
		session.setAttribute("user", user);
		
		School school = schoolService.getSchoolInfo();
		session.setAttribute("schoolName", school.getName());

		if(user!=null) {
			SysLog sysLog = new SysLog();
			sysLog.setOperType(3001);
			sysLog.setUserId(user.getId());
			sysLog.setCreateTime(new Date());
			sysLogService.addSysLog(sysLog);
		}

		if(user!=null&&user.getIsBlocked()==2001){
			return "blockedLogin";
		}
		return "index";
	}
	
	
	//进入登录界面
	@RequestMapping("/login")
	public String login(HttpSession session){
		School school = schoolService.getSchoolInfo();
		session.setAttribute("schoolName", school.getName());
		return "login";
	}
	
	/**
	 * 登出功能
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "success";
	}
	
	/**
	 * 重复登录提示功能
	 * @return
	 */
	@RequestMapping("/reLogin")
	public String loginTimeOutOrRepeatLogin(){
		return "reLogin";
	}
}

