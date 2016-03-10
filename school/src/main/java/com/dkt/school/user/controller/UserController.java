package com.dkt.school.user.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.dkt.school.system.dto.SysLogDto;
import com.dkt.school.system.service.SysLogService;
import com.dkt.school.user.model.*;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.common.util.ListUtil;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.user.dto.AuthorityDto;
import com.dkt.school.user.dto.RoleDto;
import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.service.AuthorityService;
import com.dkt.school.user.service.DepartmentService;
import com.dkt.school.user.service.RoleService;
import com.dkt.school.user.service.UserRoleService;
import com.dkt.school.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
 *@Title: UserController.java
 *@Package com.dkt.school.user.Controller
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月5日下午5:20:35
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	public final static Logger logger = LoggerFactory
			.getLogger(UserController.class);

	private UserService userService;

	private AuthorityService authorityService;

	private RoleService roleService;

	private UserRoleService userRoleService;
	
	private EnumerationService enumerationService;
	
	private DepartmentService departmentService;
	
	private SysLogService sysLogService;


	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	@Autowired
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}
	
	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}


	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public SysLogService getSysLogService() {
		return sysLogService;
	}

	@Autowired
	public void setSysLogService(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}

	/**
	 * 保存添加的用户数据
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(UserDto user) {
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(user));

		//设置新增帐号的冻结状态为否 2001为"是"，2002为"否"
		user.setIsBlocked(2002);
		resultJo.addProperty("result", userService.addUser(user));
		return resultJo.toString();

	}

	/**
	 * 跳转到添加用户的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddUser")
	public String toAddUser(Model model) {
		List<EnumerationValue> sexList = enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		List<Department> departments=departmentService.findAllDepartment();
		model.addAttribute("sexList", sexList);
		model.addAttribute("departments", departments);
		return "user/newUser";
	}
	
	/**
	 * 编辑用户
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditUser")
	public String toEditUser(Integer id,Model model){
		List<EnumerationValue> sexList=enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		List<Department> departments=departmentService.findAllDepartment();
		List<EnumerationValue> booleanList=enumerationService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
//		List<Role> roles=roleService.findAllRole();
		
		model.addAttribute("userId", id);
		model.addAttribute("sexList", sexList);
		model.addAttribute("departments", departments);
		model.addAttribute("booleanList", booleanList);
//		model.addAttribute("roles", roles);
		
		return "user/editUser";
	}
	
	/**
	 * 保存编辑用户的数据
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editUser")
	public String editUser(UserDto user){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("result", userService.updateUser(user));
		return jsonObject.toString();
	}
	
	/**
	 * 根据用户id删除用户数据
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", userService.deleteUserByUserId(id));
		return jsonObject.toString();
		
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */

	@RequestMapping("/login")
	public String login(User user) {

		// userService.checkPasswordByLogin(user.getAccount(),
		// user.getPassword());
		//
		// String status=userService.getJsonByLogin(user.getAccount(),
		// user.getPassword());
		// System.out.println(status);

		if (userService
				.getUserByPassword(user.getAccount(), user.getPassword()) != null) {
			// JsonObject jsonObject = new JsonObject();
			return "index";
		} else {
			return "login";
		}

	}

	@RequestMapping("/userList")
	public String userList() {

		return "user/userList";
	}

	/**
	 * 查询所有用户
	 * 
	 * @param account
	 * @param name
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getUserList")
	public String getUserList(String account, String name,Integer departmentId, PaginationCustom page) {
//		System.out.println(account + " " + name);
		int total = userService.getUserCount(account, name,departmentId);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<UserDto> userList = userService
				.getUsersByPage(account, name,departmentId, page);

		Gson gson = new Gson();
		JsonArray userListJa = gson.toJsonTree(userList, List.class)
				.getAsJsonArray();

		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", userListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}

	@RequestMapping("/userAssignAuth")
	public String userAssignAuthority(Integer id, Model model) {

		List<Authority> authList = authorityService.findAllAuthoritys();
		List<Integer> userAuthIdList = authorityService
				.findAuthorityIdsByUserId(id);

		List<AuthorityDto> authorityDtos = new ArrayList<AuthorityDto>();

		for (Authority auth : authList) {
			AuthorityDto authorityDto = new AuthorityDto();
			authorityDto.setId(auth.getId());
			authorityDto.setName(auth.getName());
			authorityDto.setRemark(auth.getRemark());

			if (userAuthIdList.contains(auth.getId())) {
				authorityDto.setChecked(true);
			}
			authorityDtos.add(authorityDto);
		}

		String authIds = ListUtil.integerListToString(userAuthIdList);

		model.addAttribute("userId", id);
		model.addAttribute("authList", authorityDtos);
		model.addAttribute("authIds", authIds);

		return "user/userAuths";
	}

	/**
	 * 为该用户分配角色
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/userAssignRole")
	public String userAssignRole(Integer id,Model model){
		List<Role> roleList=roleService.findAllRole();
		List<Integer> roleIdList=userRoleService.findAllRoleIdByUserId(id);
		List<RoleDto> roleDtoList=new ArrayList<RoleDto>();
		
		for(Role role:roleList){
			RoleDto roleDto=new RoleDto();
			roleDto.setId(role.getId());
			roleDto.setName(role.getName());
			roleDto.setRemark(role.getRemark());
			
			if(roleIdList.contains(role.getId())){
				roleDto.setChecked(true);
			}
			roleDtoList.add(roleDto);
		}
		String roleIds=ListUtil.integerListToString(roleIdList);
		model.addAttribute("userId", id);
		model.addAttribute("roleList", roleDtoList);
		model.addAttribute("roleIds", roleIds);
		
		return "user/userAssignRoles";
		
	}
	
	/**
	 * 更新用户的角色数据
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateUserRole")
	public String updateUserRole(Integer userId,String roleIds){

		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", roleService.assignRole(userId, roleIds));
		
		
		return jsonObject.toString();
	}

	/**
	 * 根据用户id查找用户信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getUser")
	public String getUser(Integer id) {
		UserDto user = userService.findUserDtoByUserId(id);
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("user", gson.toJsonTree(user));
		return resultJson.toString();
	}

	public String assignAuth(Integer userId, String authIds) {
		JsonObject resultJson = new JsonObject();
		// resultJson.addProperty("success", authorityService);
		return resultJson.toString();
	}


	/**
	 * 添加部门信息
	 * @param department
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addDepartment")
	public String addDepartemnt(Department department){
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(department));
		if(departmentService.hasDepartmentByName(department.getName())>0){
			resultJo.addProperty("result", -2);
		}else {
			resultJo.addProperty("result", departmentService.addDeparement(department));
		}
		return resultJo.toString();
	}

	/**
	 * 发送数据给添加部门页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toAddDepartment")
	public String findAllDepartmentByAdd(){
		List<Department> departments=departmentService.findAllDepartment();


		System.out.println(new Gson().toJson(departments));
		return new Gson().toJson(departments);
	}

	/**
	 * 发送数据给修改部门页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toEditDepartment")
	public String findAllDepartmentByEdit(){
		List<Department> departments=departmentService.findAllDepartment();


		System.out.println(new Gson().toJson(departments));
		return new Gson().toJson(departments);
	}

	/**
	 * 修改部门信息
	 * @param department
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editDepartment")
	public String editDepartemnt(Department department){
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(department));

		if(departmentService.findDepartmentByDepartmentId(department.getId()).getName().equals(department.getName())==false){
			if(departmentService.hasDepartmentByName(department.getName())>0){
				resultJo.addProperty("result", -2);
				System.out.println("-2");
			}else{
				resultJo.addProperty("result", departmentService.updateDepartment(department));
			}

		}else{
			resultJo.addProperty("result", departmentService.updateDepartment(department));
		}

		return resultJo.toString();


	}

	/**
	 * 根据部门id删除部门信息
	 * @param departmentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment(Integer departmentId){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", departmentService.deleteDepartmentByDepartmentId(departmentId));
		return jsonObject.toString();
	}

	/**
	 * 进入查找所有部门信息的页面
	 * @return
	 */
	@RequestMapping("/toFindAllDepartemnt")
	public String toFindAllDepartemnt(){

		return "user/departmentList";
	}


	/**
	 * 查询所有部门信息，返回树状结构的json格式
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllDepartment")
	public String findAllDepartment(Integer id){

		String treeJson=null;

		List<Map<String,Object>> childrenItems=new ArrayList<Map<String, Object>>();
		List<Department> departments=null;


		Map<String,Object> childrenItem=null;

		if(id==null){
			List<Map<String,Object>> items=new ArrayList<Map<String, Object>>();
			Map<String,Object> item=null;

			id=0;

			item=new HashMap<String, Object>();
			item.put("id", 0);

			item.put("text", "全部");
			item.put("state", "open");

			departments=departmentService.findDepartmentByParentId(id);


			for(Department d:departments){
				childrenItem=new HashMap<String, Object>();
				childrenItem.put("id", d.getId());
				childrenItem.put("text",d.getName());

				childrenItem.put("remark",d.getRemark());

				Map<String,Object> attr=new HashMap<String, Object>();
				attr.put("parentId",d.getParentId());

				childrenItem.put("attributes", attr);

				if(departmentService.hasChildrenDepartment(d.getId())!=null){
					childrenItem.put("state","closed");
				}else{
					childrenItem.put("state","");
				}


				childrenItems.add(childrenItem);
			}



			item.put("children",childrenItems);
			items.add(item);
			treeJson=new Gson().toJson(items);


		}else {

			departments = departmentService.findDepartmentByParentId(id);



			for (Department d : departments) {
				childrenItem = new HashMap<String, Object>();
				childrenItem.put("id", d.getId());
				childrenItem.put("text", d.getName());

				childrenItem.put("remark",d.getRemark());

				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("parentId", d.getParentId());

				childrenItem.put("attributes", attr);

				if (departmentService.hasChildrenDepartment(d.getId()) != null) {
					childrenItem.put("state", "closed");
				} else {
					childrenItem.put("state", "");
				}


				childrenItems.add(childrenItem);
			}





			treeJson = new Gson().toJson(childrenItems);


		}

		return treeJson;
	}

	@RequestMapping("/toGetSysLogList")
	public String toGetSysLogList(Model model){

		List<EnumerationValue> operTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.OPER_TYPE);
		model.addAttribute("operTypeList",operTypeList);
		return "user/sysLogList";
	}

	/**
	 * 根据条件查询操作日志记录
	 * @param startTime
	 * @param stopTime
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSysLogList")
	public String getSysLogList(Integer operType,String userName,String startTime,String stopTime,PaginationCustom page){


		int total=sysLogService.getSysLogCount(operType,userName,startTime,stopTime);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		//根据条件查找操作，返回一个list集合
		List<SysLogDto> sysLogDtos=sysLogService.getSysLogsByPage(operType,userName,startTime,stopTime,page);
		//自定义json的日期格式
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		JsonArray sysLogDtosJsonArray=gson.toJsonTree(sysLogDtos, List.class).getAsJsonArray();

		JsonObject resultJson=new JsonObject();
		resultJson.add("rows", sysLogDtosJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}

	// 显示修改密码的界面
	@RequestMapping("/changePasswordView")
	public String changePasswordView() {
		return "user/userPassword";
	}

	// 修改密码
	@ResponseBody
	@RequestMapping("/changePassword")
	public String changePassword(HttpSession session,
	@RequestParam(value = "oldpassword") String oldpassword,
	@RequestParam(value = "password") String password) {
		JsonObject resultJo = new JsonObject();
		// 获取登陆用户的信息
		UserDto user = (UserDto) session.getAttribute("user");
		if (user == null) {
			return resultJo.toString();
		}
		
		resultJo.addProperty("result",
				userService.changePassword(user, oldpassword, password));
		return resultJo.toString();
	}

	@ResponseBody
	@RequestMapping("/getUserAccountForLogin")
	public String getUserNameAndAccountByDepartmentIdForLogin(Integer departmentId){
		List<User> userDtoList=userService.getUserByDepartmentIdForLogin(departmentId);
		JsonArray userListJsonArray=new Gson().toJsonTree(userDtoList,List.class).getAsJsonArray();

		return userListJsonArray.toString();
	}

	/**
	 * 数据绑定，用于string类型转成date类型
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}
}

