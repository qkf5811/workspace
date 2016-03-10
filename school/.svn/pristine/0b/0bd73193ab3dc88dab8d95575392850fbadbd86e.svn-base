package com.dkt.school.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/*
 *@Title: RoleAuthorityCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:30:10
 */
public interface RoleAuthorityCustomMapper extends RoleAuthorityMapper {

	//根据角色id查找该角色id的所有权限
		public List<Integer> findAllAuthorityIdByRoleId(@Param("roleId") Integer roleId);
}

