package com.dkt.school.user.service;

import java.util.List;

import com.dkt.school.user.model.Department;

/*
 *@Title: DepartmentService.java
 *@Package com.dkt.school.user.service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:05:01
 */
public interface DepartmentService {
	
	/**
	 * 查找所有的部门
	 * @return
	 */
	public List<Department> findAllDepartment();

	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	public int addDeparement(Department department);

	/**
	 * 根据departmentId查找部门信息
	 * @param departmentId
	 * @return
	 */
	public Department findDepartmentByDepartmentId(Integer departmentId);

	/**
	 * 根据parentId查找部门信息
	 * @param parentId
	 * @return
	 */
	public List<Department> findDepartmentByParentId(Integer parentId);

	/**
	 * 判断该departmentId的部门是否存在children Department
	 * @param departmentId
	 * @return
	 */
	public Integer hasChildrenDepartment(Integer departmentId);

	/**
	 * 更新department信息
	 * @param department
	 * @return
	 */
	public int updateDepartment(Department department);

	/**
	 * 根据departementId删除department信息
	 * @param departementId
	 * @return
	 */
	public int deleteDepartmentByDepartmentId(Integer departementId);

	/**
	 * 根据部门名称判断是否存在Department
	 * @param name
	 * @return
	 */
	public int hasDepartmentByName(String name);


}

