package com.dkt.school.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.user.dao.UserRoleCustomMapper;
import com.dkt.school.user.model.UserRole;
import com.dkt.school.user.service.UserRoleService;

/*
 *@Title: UserRoleServiceImpl.java
 *@Package com.dkt.school.user.service.impl	
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:58:23
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleCustomMapper userRoleCustomMapper;
	
	



	public UserRoleCustomMapper getUserRoleCustomMapper() {
		return userRoleCustomMapper;
	}

	@Autowired
	public void setUserRoleCustomMapper(UserRoleCustomMapper userRoleCustomMapper) {
		this.userRoleCustomMapper = userRoleCustomMapper;
	}


	public int addUserRole(UserRole useRole) {
		// TODO Auto-generated method stub
		return userRoleCustomMapper.insert(useRole);
	}


	public List<Integer> findAllRoleIdByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
		
		return userRoleCustomMapper.findAllRoleIdByUserId(userId);
	}

	@Override
	public int getRoleIdByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userRoleCustomMapper.selectRoleIdByUserId(userId);
	}

}

