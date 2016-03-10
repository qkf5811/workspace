package com.dkt.school.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.user.dto.RoleDto;
import com.dkt.school.user.model.Role;

/*
 *@Title: RoleCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:15:34
 */
public interface RoleCustomMapper extends RoleMapper {
public Integer findRoleByRoleName(@Param("roleName") String roleName);
	
	public Integer countByName(@Param("name") String roleName);
	
	public List<Role> selectByLimit(@Param("name") String roleName,@Param("limit") Limitation limit);
	
	/**
	 * 根据角色id查找角色信息
	 * @param roleId
	 * @return
	 */
	public RoleDto selectRoleDtoByRoleId(@Param("roleId") Integer roleId);
}

