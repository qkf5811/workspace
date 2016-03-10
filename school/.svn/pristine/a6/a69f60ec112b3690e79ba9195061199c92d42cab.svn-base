package com.dkt.school.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.user.model.Authority;

/*
 *@Title: AuthorityCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:23:49
 */
public interface AuthorityCustomMapper extends AuthorityMapper {
	public List<Authority> findAllAuthoritys();
	
	public List<Integer> findAuthorityIdsByUserId(@Param("userId") Integer userId);
}

