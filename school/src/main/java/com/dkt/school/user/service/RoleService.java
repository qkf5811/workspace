package com.dkt.school.user.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.user.dto.RoleDto;
import com.dkt.school.user.model.Role;

/*
 *@Title: RoleService.java
 *@Package com.dkt.school.user.service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:48:13
 */
public interface RoleService {

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int addRole(Role role);
	
	/**
	 * 根据角色名查找角色
	 * @param roleName
	 * @return
	 */
	public int findRoleByRoleName(String roleName);
	
	/**
	 * 根据角色名模糊查询，并返回查询数目
	 * @param name
	 * @return int
	 */
	public int getRoleCount(String name);
	
	/**
	 * 根据角色名模糊分页查询
	 * @param name
	 * @param page
	 * @return
	 */
	public List<Role> getRolesByPage(String name,Pagination page);
	
	
	/**
	 * 更新角色内容
	 */
	public int updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	public int deleteRoleById(Integer roleId);
	
	/**
	 * 查找所有的角色
	 * @return
	 */
	public List<Role> findAllRole();
	
	/**
	 * 分配角色给该用户
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	public int assignRole(Integer userId,String roleIds);
	
	/**
	 * 根据角色id查找角色信息,返回一个RoleDto
	 * @param roleId
	 * @return
	 */
	public RoleDto findRoleDtoByRoleId(Integer roleId);
}

