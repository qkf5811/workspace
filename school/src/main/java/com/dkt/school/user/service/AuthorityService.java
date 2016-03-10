package com.dkt.school.user.service;

import java.util.List;

import com.dkt.school.user.model.Authority;

/*
 *@Title: AuthorityService.java
 *@Package com.dkt.school.user.service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:51:40
 */
public interface AuthorityService {

	public int addAuthority(Authority authority);
	
	/**
	 * 查找所有权限
	 * @return
	 */
	public List<Authority> findAllAuthoritys();
	
	/**
	 * 根据用户id查找所有的权限，返回权限的id
	 * @param userId
	 * @return
	 */
	public List<Integer> findAuthorityIdsByUserId(Integer userId);
	
	/**
	 * 分配权限给该角色
	 * @param roleId
	 * @param authIds
	 * @return
	 */
	public int assignAuthority(Integer roleId,String authIds);
}

