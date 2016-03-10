package com.dkt.school.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.model.User;

/*
 *@Title: UserCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2014年12月23日下午2:58:46
 */
public interface UserCustomMapper extends UserMapper {

	public Integer checkPassword(
			@Param("account") String account,
			@Param("password") String password);

	public User getUserByPassword(
			@Param("account") String account,
			@Param("password") String password);

	public UserDto selectUserDtoByAccount(

	@Param("account") String account);

	public User selectUserByAccount(

	@Param("account") String account);

	public Integer countBySearch(
			@Param("account") String account,
			@Param("name") String name,
			@Param("departmentId") Integer departmentId);

	public List<UserDto> selectByLimit(
			@Param("account") String account,
			@Param("name") String name,
			@Param("departmentId") Integer departmentId,
			@Param("limit") Limitation limit);
	
	
	public UserDto selectUserDtoByUserId(@Param("userId") Integer userId);

	public int changePassword(
			@Param("id") Integer id, 
			@Param("password")String password);


	public List<User> selectUserByDepartmentId(@Param("departmentId") Integer departmentId);
	
}
