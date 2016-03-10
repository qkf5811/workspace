package com.dkt.school.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.user.dao.AuthorityMapper;
import com.dkt.school.user.dao.RoleAuthorityCustomMapper;
import com.dkt.school.user.dao.UserAuthorityCustomMapper;
import com.dkt.school.user.dao.UserRoleCustomMapper;
import com.dkt.school.user.model.Authority;
import com.dkt.school.user.model.AuthorityExample;
import com.dkt.school.user.model.RoleAuthority;
import com.dkt.school.user.model.RoleAuthorityExample;
import com.dkt.school.user.model.UserAuthority;
import com.dkt.school.user.model.UserAuthorityExample;
import com.dkt.school.user.service.AuthorityService;

/*
 *@Title: AuthorityServiceImpl.java
 *@Package com.dkt.school.user.service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:52:58
 */

@Service
public class AuthorityServiceImpl implements AuthorityService {

	private AuthorityMapper authorityMapper;
	
	private UserAuthorityCustomMapper userAuthorityCustomMapper;
	
	private RoleAuthorityCustomMapper roleAuthorityCustomMapper;
	
	private UserRoleCustomMapper userRoleCustomMapper;
	
	public AuthorityMapper getAuthorityMapper() {
		return authorityMapper;
	}

	@Autowired
	public void setAuthorityMapper(AuthorityMapper authorityMapper) {
		this.authorityMapper = authorityMapper;
	}



	public UserAuthorityCustomMapper getUserAuthorityCustomMapper() {
		return userAuthorityCustomMapper;
	}
	
	@Autowired
	public void setUserAuthorityCustomMapper(
			UserAuthorityCustomMapper userAuthorityCustomMapper) {
		this.userAuthorityCustomMapper = userAuthorityCustomMapper;
	}

	public RoleAuthorityCustomMapper getRoleAuthorityCustomMapper() {
		return roleAuthorityCustomMapper;
	}
	
	@Autowired
	public void setRoleAuthorityCustomMapper(
			RoleAuthorityCustomMapper roleAuthorityCustomMapper) {
		this.roleAuthorityCustomMapper = roleAuthorityCustomMapper;
	}

	public UserRoleCustomMapper getUserRoleCustomMapper() {
		return userRoleCustomMapper;
	}

	@Autowired
	public void setUserRoleCustomMapper(UserRoleCustomMapper userRoleCustomMapper) {
		this.userRoleCustomMapper = userRoleCustomMapper;
	}

	public int addAuthority(Authority authority) {
		// TODO Auto-generated method stub
		return authorityMapper.insert(authority);
	}

	public List<Authority> findAllAuthoritys() {
		// TODO Auto-generated method stub
		return authorityMapper.selectByExample(new AuthorityExample());
	}

	public List<Integer> findAuthorityIdsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userAuthorityCustomMapper.selectAuthorityIdsByUserId(userId);
	}

	public int assignAuthority(Integer roleId, String authIds) {
		// TODO Auto-generated method stub
		Integer result =0;
		//删除该角色的权限数据
		RoleAuthorityExample roleAuthorityExample=new RoleAuthorityExample();
		RoleAuthorityExample.Criteria criteria=roleAuthorityExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		
		roleAuthorityCustomMapper.deleteByExample(roleAuthorityExample);
		
		//删除该角色和用户、权限关联表数据
		
		UserAuthorityExample userAuthorityExample=new UserAuthorityExample();
		UserAuthorityExample.Criteria uaCriteria=userAuthorityExample.createCriteria();
		uaCriteria.andRoleIdEqualTo(roleId);
		userAuthorityCustomMapper.deleteByExample(userAuthorityExample);
		
		
		
		String[] authorityIdList=authIds.split(",");
		
		//查找拥有该角色的所有用户
		List<Integer> userIds=userRoleCustomMapper.findAllUserIdByRoleId(roleId);
		
		//添加角色权限数据
		for(int i=0;i<authorityIdList.length;i++){
			if(!"".equals(authorityIdList[i].trim())){
				Integer authorityId=Integer.parseInt(authorityIdList[i].trim());
				RoleAuthority roleAuthority=new RoleAuthority();
				roleAuthority.setRoleId(roleId);
				roleAuthority.setAuthorityId(authorityId);
				result=roleAuthorityCustomMapper.insert(roleAuthority);
				
				//添加该角色的用户和权限关联数据
				for(int a=0;a<userIds.size();a++){
					UserAuthority userAuthority=new UserAuthority();
					userAuthority.setRoleId(roleId);
					userAuthority.setUserId(userIds.get(a));
					userAuthority.setAuthorityId(authorityId);
					
					userAuthorityCustomMapper.insert(userAuthority);
				}
			}
		}
		
		
		return result;
	}

}

