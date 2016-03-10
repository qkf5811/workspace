package com.dkt.school.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.user.dao.UserCustomMapper;
import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.model.User;
import com.dkt.school.user.model.UserExample;
import com.dkt.school.user.service.UserService;
import com.google.gson.JsonObject;

/*
 *@Title: UserServiceImpl.java
 *@Package com.dkt.school.user.service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月5日下午5:25:27
 */
@Service
public class UserServiceImpl implements UserService {

private UserCustomMapper userMapper;
	
//	private StandardPasswordEncoder encoder;
	
	public UserCustomMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserCustomMapper userMapper) {
		this.userMapper = userMapper;
	}
	
//	public StandardPasswordEncoder getEncoder() {
//		return encoder;
//	}
//	
//	@Autowired
//	public void setEncoder(StandardPasswordEncoder encoder) {
//		this.encoder = encoder;
//	}

	public int addUser(UserDto user) {
		// TODO Auto-generated method stub
		int result = 0;
		//判断用户信息是否完整
		if (user.getAccount() == null || "".equals(user.getAccount())
				|| user.getPassword() == null || "".equals(user.getPassword())
				|| user.getName() == null || "".equals(user.getName())) {
			return -1;
		}
		//判断用户是否存在
		UserDto userTemp = userMapper.selectUserDtoByAccount(user.getAccount());
	
		if (userTemp == null) {
			
			//加密数据
//			user.setPassword(encoder.encode(user.getPassword()));
			
			return userMapper.insert(user);
		} else {
			result = -2;
		}
		return result;
	}

	public List<User> searchAllUserByPage(Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}

	// 登录前验证帐号和密码
	public boolean checkPasswordByLogin(String account, String password) {
		// TODO Auto-generated method stub
		int isFind = userMapper.checkPassword(account, password);
		if (isFind > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 登录
	public String getJsonByLogin(String account, String password) {
		JsonObject jsonObject = new JsonObject();
		int isFind = userMapper.checkPassword(account, password);

		if (isFind > 0) {
			jsonObject.addProperty("status", "success");

			JsonObject userJson = new JsonObject();

			User user = userMapper.selectUserByAccount(account);
			userJson.addProperty("id", user.getId());
			userJson.addProperty("account", user.getAccount());
			userJson.addProperty("name", user.getName());
			userJson.addProperty("sex", user.getSexType());
			userJson.addProperty("departmentId", user.getDepartmentId());

			jsonObject.add("User", userJson);

		} else {
			jsonObject.addProperty("status", "failure");

		}

		return jsonObject.toString();
	}

	// 根据帐号和密码获取用户
	public User getUserByPassword(String account, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByPassword(account, password);
	}

	public UserDto getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return userMapper.selectUserDtoByAccount(account);
	}

	public Integer getUserCount(String account, String name,Integer departmentId) {
		// TODO Auto-generated method stub
		return userMapper.countBySearch(account, name,departmentId);
	}

	public List<UserDto> getUsersByPage(String account, String name,Integer departmentId,
			Pagination page) {
		// TODO Auto-generated method stub
		return userMapper.selectByLimit(account, name,departmentId, page.getLimitation());
	}

	public UserDto findUserDtoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserDtoByUserId(userId);
	}

	public int updateUser(UserDto user) {
		// TODO Auto-generated method stub
	if(userMapper.selectByPrimaryKey(user.getId()).getAccount().equals(user.getAccount())==false){
		if(userMapper.selectUserByAccount(user.getAccount())!=null){
			return -2;
		}else{
			return userMapper.updateByPrimaryKey(user);
		}
	}else{
		return userMapper.updateByPrimaryKey(user);
	}

	}

	public int deleteUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userId);
	}

	
	/**
	 * @author 炳坚
	 */
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public int changePassword(User user, String oldPassword, String newPassword) {
		if (oldPassword == null || "".equals(oldPassword)) {
			return -1;
		}
		if (newPassword == null || "".equals(newPassword)) {
			return -1;
		}
		if (!oldPassword.equals(user.getPassword())) {
			return -2;
		}
		return userMapper.changePassword(user.getId(), newPassword);
	}

	@Override
	public List<User> getUserByDepartmentIdForLogin(Integer departmentId) {
		return userMapper.selectUserByDepartmentId(departmentId);
	}


}

