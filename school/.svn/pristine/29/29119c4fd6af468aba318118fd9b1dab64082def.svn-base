package com.dkt.school.user.service.impl;

import java.util.List;

import com.dkt.school.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.user.dao.RoleAuthorityCustomMapper;
import com.dkt.school.user.dao.RoleCustomMapper;
import com.dkt.school.user.dao.UserAuthorityCustomMapper;
import com.dkt.school.user.dao.UserRoleCustomMapper;
import com.dkt.school.user.dto.RoleDto;
import com.dkt.school.user.service.RoleService;

/*
 *@Title: RoleServiceImpl.java
 *@Package com.dkt.school.user.service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:49:09
 */

@Service
public class RoleServiceImpl implements RoleService {

	private RoleCustomMapper roleCustomMapper;	
	private UserRoleCustomMapper userRoleCustomMapper;
	private RoleAuthorityCustomMapper roleAuthorityCustomMapper;
	private UserAuthorityCustomMapper userAuthorityCustomMapper;
	
	
	public RoleCustomMapper getRoleCustomMapper() {
		return roleCustomMapper;
	}
	
	@Autowired
	public void setRoleCustomMapper(RoleCustomMapper roleCustomMapper) {
		this.roleCustomMapper = roleCustomMapper;
	}

	public UserRoleCustomMapper getUserRoleCustomMapper() {
		return userRoleCustomMapper;
	}
	
	@Autowired
	public void setUserRoleCustomMapper(UserRoleCustomMapper userRoleCustomMapper) {
		this.userRoleCustomMapper = userRoleCustomMapper;
	}
	
	public RoleAuthorityCustomMapper getRoleAuthorityCustomMapper() {
		return roleAuthorityCustomMapper;
	}

	@Autowired
	public void setRoleAuthorityCustomMapper(
			RoleAuthorityCustomMapper roleAuthorityCustomMapper) {
		this.roleAuthorityCustomMapper = roleAuthorityCustomMapper;
	}

	public UserAuthorityCustomMapper getUserAuthorityCustomMapper() {
		return userAuthorityCustomMapper;
	}
	
	@Autowired
	public void setUserAuthorityCustomMapper(
			UserAuthorityCustomMapper userAuthorityCustomMapper) {
		this.userAuthorityCustomMapper = userAuthorityCustomMapper;
	}

	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleCustomMapper.insert(role);
	}

	public int findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleCustomMapper.findRoleByRoleName(roleName);
	}

	public List<Role> getRolesByPage(String name, Pagination page) {
		// TODO Auto-generated method stub
		return roleCustomMapper.selectByLimit(name, page.getLimitation());
	}

	public int getRoleCount(String name) {
		// TODO Auto-generated method stub
		return roleCustomMapper.countByName(name);
	}

	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleCustomMapper.updateByPrimaryKey(role);
	}

	public int deleteRoleById(Integer roleId) {
		// TODO Auto-generated method stub
		//删除用户和角色中间表的数据
		UserRoleExample userRoleExample=new UserRoleExample();
		UserRoleExample.Criteria criteriaByUserRole=userRoleExample.createCriteria();
		criteriaByUserRole.andRoleIdEqualTo(roleId);
		userRoleCustomMapper.deleteByExample(userRoleExample);
		//删除角色和权限中间表的数据
		RoleAuthorityExample roleAuthorityExample=new RoleAuthorityExample();
		RoleAuthorityExample.Criteria criteria=roleAuthorityExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		roleAuthorityCustomMapper.deleteByExample(roleAuthorityExample);
		//删除用户、角色和权限中间表的数据
		UserAuthorityExample userAuthorityExample=new UserAuthorityExample();
		UserAuthorityExample.Criteria criteriaByUserAuthority=userAuthorityExample.createCriteria();
		criteriaByUserAuthority.andRoleIdEqualTo(roleId);
		userAuthorityCustomMapper.deleteByExample(userAuthorityExample);
		//再删除角色
		return roleCustomMapper.deleteByPrimaryKey(roleId);
	}

	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return roleCustomMapper.selectByExample(new RoleExample());
	}

	public int assignRole(Integer userId, String roleIds) {
		// TODO Auto-generated method stub
		
		Integer result=0;
		//删除该用户的角色数据
		UserRoleExample example=new UserRoleExample();
		UserRoleExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		userRoleCustomMapper.deleteByExample(example);
		
		//删除该用户的角色和权限关联表数据
		UserAuthorityExample userAuthorityExample=new UserAuthorityExample();
		UserAuthorityExample.Criteria uaCriteria=userAuthorityExample.createCriteria();
		uaCriteria.andUserIdEqualTo(userId);
		userAuthorityCustomMapper.deleteByExample(userAuthorityExample);
		
		
		//添加用户角色数据
		String[] roleIdList=roleIds.split(",");
		for(int i=0;i<roleIdList.length;i++){
			if(!"".equals(roleIdList[i].trim())){
				Integer roleId=Integer.parseInt(roleIdList[i].trim());
				UserRole userRole=new UserRole();
				userRole.setUserId(userId);
				userRole.setRoleId(roleId);
				result=userRoleCustomMapper.insert(userRole);
				
				//添加该用户的角色和权限关联数据
				List<Integer> AuthorityIds=roleAuthorityCustomMapper.findAllAuthorityIdByRoleId(roleId);
				for(int a=0;a<AuthorityIds.size();a++){
					UserAuthority userAuthority=new UserAuthority();
					userAuthority.setUserId(userId);
					userAuthority.setRoleId(roleId);
					userAuthority.setAuthorityId(AuthorityIds.get(a));
					userAuthorityCustomMapper.insert(userAuthority);
					
				}
			}
		}
		return result;
	}

	public RoleDto findRoleDtoByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleCustomMapper.selectRoleDtoByRoleId(roleId);
	}

}

