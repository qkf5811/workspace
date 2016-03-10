package com.dkt.school.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dkt.school.user.dao.UserAuthorityCustomMapper;
import com.dkt.school.user.dao.UserCustomMapper;
import com.dkt.school.user.dto.UserDetailsDto;
import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.model.Authority;

/*
 *@Title: UserDetailsServiceImpl.java
 *@Package com.dkt.school.user.service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:51:45
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserCustomMapper userMapper;
	
	
//	@Autowired
//	private  UserRoleCustomMapper userRoleCustomMapper;
//	
//	@Autowired
//	private RoleAuthorityCustomMapper roleAuthorityCustomMapper;
	
	@Autowired
	private UserAuthorityCustomMapper userAuthMapper;
	
	
	
	public UserCustomMapper getUserMapper() {
		return userMapper;
	}



	public void setUserMapper(UserCustomMapper userMapper) {
		this.userMapper = userMapper;
	}



	public UserAuthorityCustomMapper getUserAuthMapper() {
		return userAuthMapper;
	}



	public void setUserAuthMapper(UserAuthorityCustomMapper userAuthMapper) {
		this.userAuthMapper = userAuthMapper;
	}



	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDto user = userMapper.selectUserDtoByAccount(username);
		
		if (user.getIsBlocked().equals(2002)) {
			user.setEnabled(true);
		} else {
			user.setEnabled(false);
		}

		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		List<Authority> auths = userAuthMapper.selectAuthorityByUserId(user.getId());
		
		for(int i=0;i<auths.size();i++){
			GrantedAuthority authority=new SimpleGrantedAuthority(auths.get(i).getCode());
			authorities.add(authority);
		}
		
		return new UserDetailsDto(user.getAccount(),user.getPassword(),
				user.isEnabled(),authorities,true,true,true);
	}

}

