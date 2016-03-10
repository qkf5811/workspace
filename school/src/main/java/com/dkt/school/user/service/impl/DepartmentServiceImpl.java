package com.dkt.school.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.user.dao.DepartmentCustomMapper;
import com.dkt.school.user.model.Department;
import com.dkt.school.user.model.DepartmentExample;
import com.dkt.school.user.service.DepartmentService;

/*
 *@Title: DepartmentServiceImpl.java
 *@Package com.dkt.school.user.service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:07:14
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentCustomMapper departmentMapper;



	public DepartmentCustomMapper getDepartmentMapper() {
		return departmentMapper;
	}

	@Autowired
	public void setDepartmentMapper(DepartmentCustomMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}


	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		return departmentMapper.selectByExample(new DepartmentExample());
	}

	public int addDeparement(Department department){
		return departmentMapper.insert(department);
	}

	public Department findDepartmentByDepartmentId(Integer departmentId) {
		return departmentMapper.selectByPrimaryKey(departmentId);
	}

	public List<Department> findDepartmentByParentId(Integer parentId) {

		DepartmentExample departmentExample=new DepartmentExample();
		DepartmentExample.Criteria criteria=departmentExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		return departmentMapper.selectByExample(departmentExample);
	}

	public Integer hasChildrenDepartment(Integer departmentId) {
		return departmentMapper.hasChildrenDepartment(departmentId);
	}

	@Override
	public int updateDepartment(Department department) {
		return departmentMapper.updateByPrimaryKey(department);
	}

	@Override
	public int deleteDepartmentByDepartmentId(Integer departementId) {
		//查找父部门id是departementId的部门
		List<Department> departmentList=this.findDepartmentByParentId(departementId);
		int departmentListSize=departmentList.size();
		//假如该部门存在子部门，先删除子部门，再删除该部门
		if(departmentListSize>0){
			for(int i=0;i<departmentListSize;i++){
				departmentMapper.deleteByPrimaryKey(departmentList.get(i).getId());
			}
			return departmentMapper.deleteByPrimaryKey(departementId);

		}else {
			return departmentMapper.deleteByPrimaryKey(departementId);
		}
	}

	public int hasDepartmentByName(String name) {
		return departmentMapper.hasDepartmentByName(name);
	}

}

