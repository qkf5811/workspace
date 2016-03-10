package com.dkt.school.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.user.dao.RoleAuthorityCustomMapper;
import com.dkt.school.user.model.RoleAuthority;
import com.dkt.school.user.service.RoleAuthorityService;

/*
 *@Title: RoleAuthorityServiceImpl.java
 *@Package com.dkt.school.user.service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:02:03
 */

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

	private RoleAuthorityCustomMapper roleAuthorityCustomMapper;
	

	

	public RoleAuthorityCustomMapper getRoleAuthorityCustomMapper() {
		return roleAuthorityCustomMapper;
	}
	
	@Autowired
	public void setRoleAuthorityCustomMapper(
			RoleAuthorityCustomMapper roleAuthorityCustomMapper) {
		this.roleAuthorityCustomMapper = roleAuthorityCustomMapper;
	}

	public int addRoleAuthority(RoleAuthority roleAuthority) {
		// TODO Auto-generated method stub
		return roleAuthorityCustomMapper.insert(roleAuthority);
	}

	public List<Integer> findAllAuthorityIdByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleAuthorityCustomMapper.findAllAuthorityIdByRoleId(roleId);
		
	}

}

