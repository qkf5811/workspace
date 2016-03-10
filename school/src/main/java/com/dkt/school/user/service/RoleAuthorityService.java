package com.dkt.school.user.service;

import java.util.List;

import com.dkt.school.user.model.RoleAuthority;

/*
 *@Title: RoleAuthorityService.java
 *@Package com.dkt.school.user.service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:00:29
 */
public interface RoleAuthorityService {
	
	public int addRoleAuthority(RoleAuthority roleAuthority);

	//根据角色id查找该角色id的所有权限
	public List<Integer> findAllAuthorityIdByRoleId(Integer roleId);
}

