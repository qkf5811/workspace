package com.dkt.school.user.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.model.User;

/*
 *@Title: UserService.java
 *@Package com.dkt.school.user.service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月5日下午5:22:23
 */
public interface UserService {
	public int addUser(UserDto user);

	public List<User> searchAllUserByPage(Pagination page);

	public boolean checkPasswordByLogin(String account, String password);

	public String getJsonByLogin(String account, String password);

	public User getUserByPassword(String account, String password);

	public UserDto getUserByAccount(String account);

	/**
	 * 根据用户名模糊查询，并返回查询数目
	 * 
	 * @param name
	 * @return
	 */
	public Integer getUserCount(String account, String name,Integer departmentId);

	/**
	 * 根据用户名和姓名模糊分页查询
	 * 
	 * @param account
	 * @param name
	 * @param page
	 * @return
	 */
	public List<UserDto> getUsersByPage(String account, String name,Integer departmentId,
			Pagination page);

	/**
	 * 根据用户id查找用户信息，返回一个UserDto
	 * 
	 * @param userId
	 * @return
	 */
	public UserDto findUserDtoByUserId(Integer userId);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(UserDto user);

	/**
	 * 根据用户id删除用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public int deleteUserByUserId(Integer userId);
	
	/**
	 * 查找所有的用户
	 * @return  list
	 * @author 炳坚
	 */
	public List<User> findAllUser();

	/**
	 * 更改用户密码
	 * @param user
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public int changePassword(User user, String oldPassword, String newPassword);

	/**
	 * 根据部门id查找用户
	 * @param departmentId
	 * @return
	 */
	public List<User> getUserByDepartmentIdForLogin(Integer departmentId);
}
