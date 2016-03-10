package com.dkt.school.user.dao;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.user.dto.DepartmentDto;
import com.dkt.school.user.model.Department;

import org.apache.ibatis.annotations.Param;

/*
 *@Title: DepartmentCustomMapper.java
 *@Package com.dkt.school.user.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:39:10
 */
public interface DepartmentCustomMapper extends DepartmentMapper {

    /**
     * 判断是否存在children Department
     * @param departmentId
     * @return
     */
    public Integer hasChildrenDepartment(@Param("departmentId") Integer departmentId);

    /**
     * 根据部门名称判断是否存在Department
     * @param name
     * @return
     */
    public int hasDepartmentByName(@Param("name") String name);

    //根据条件取得部门记录数
  	public Integer getDepartmentCount(@Param("name") String name) ;

  	//分页查询所有部门记录
  	public List<DepartmentDto> getDepartmentByPage(@Param("name") String name,
  			@Param("limit") Limitation limit);

}

