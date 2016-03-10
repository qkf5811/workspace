package com.dkt.school.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/*
 *@Title: UserRoleCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:27:05
 */
public interface UserRoleCustomMapper extends UserRoleMapper {
	/**
	 * 根据用户id查找该用户的所有角色id
	 * @param userId
	 * @return
	 */
	public List<Integer> findAllRoleIdByUserId(@Param("userId") Integer userId);
	
	/**
	 * 根据角色id查找拥有该角色的所有用户id
	 * @param roleId
	 * @return
	 */
	public List<Integer> findAllUserIdByRoleId(@Param("roleId") Integer roleId);

	/**
	 * 根据用户id查询角色id
	 * @param userId
	 * @return
	 */
	public int selectRoleIdByUserId(
			@Param("userId")Integer userId);
}

