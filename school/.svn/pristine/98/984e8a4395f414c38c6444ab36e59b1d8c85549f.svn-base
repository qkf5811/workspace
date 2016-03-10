package com.dkt.school.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.user.model.Authority;

/*
 *@Title: UserAuthorityCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:34:52
 */
public interface UserAuthorityCustomMapper extends UserAuthorityMapper {

	/**
	 * 根据用户id查找该用户的所有权限信息
	 * @param userId
	 * @return
	 */
	public List<Authority> selectAuthorityByUserId(@Param("userId") Integer userId);

	public List<Integer> selectAuthorityIdsByUserId(@Param("userId") Integer userId);
}

