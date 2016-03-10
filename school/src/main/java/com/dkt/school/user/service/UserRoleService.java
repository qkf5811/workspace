package com.dkt.school.user.service;

import java.util.List;

import com.dkt.school.user.model.UserRole;

/*
 *@Title: UserRoleService.java
 *@Package com.dkt.school.user.service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:57:18
 */
public interface UserRoleService {
	
	public int addUserRole(UserRole userRole);
	
	//根据用户id查找该用户的所有角色id
	public List<Integer> findAllRoleIdByUserId(Integer userId);

	/**
	 * 根据用户id查询对应的roleId 
	 * @param userId
	 * @return
	 */
	public int getRoleIdByUserId(Integer userId);
}

