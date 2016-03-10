package com.dkt.school.stu.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.model.Clazz;

/**
 * 班别业务逻辑层接口
 * @author benson
 *
 */
public interface ClazzService {
	
	/**
	 * 根据专业方向id获取班级总数
	 * @param majorFieldId
	 * @return
	 */
	public Integer getClassCountByMajorFieldId(Integer majorFieldId);
	
	/**
	 * 根据专业方向id获取所有班级
	 * @param majorFieldId
	 * @return
	 */
	public List<ClazzDto> getClassByMajorFieldId(Integer majorFieldId);
	
	/**
	 * 根据相对应专业的总人数和该专业开设的总班数进行随机分班
	 */
	public Integer toDivideClass(Integer majorFieldId,Integer majorFieldStuCount,Integer classCount);


	/**
	 * 根据班级信息条件模糊查询，并返回查询数目
	 * @param name
	 * @param gradeId
	 * @param majorFieldId
	 * @param teacherName
	 * @return
	 */
	public int getClassCount(String name,Integer gradeId,Integer majorFieldId,String teacherName);
	
	/**
	 * 根据老师id查询班级数量
	 * @param id
	 * @return
	 * 2015年8月21日下午5:22:08
	 */
	public int myClassCount(Integer id);
	

	/**
	 * 根据班级信息条件模糊分页查询
	 * @param name
	 * @param gradeId
	 * @param majorFieldId
	 * @param teacherName
	 * @param page
	 * @return
	 */
	public List<ClazzDto> getClassesByPage(String name,Integer gradeId,Integer majorFieldId,String teacherName,Pagination page);
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * 2015年8月22日上午9:28:02
	 */
	public List<ClazzDto> getMyClassesByPage(Integer id,Pagination page);


	/**
	 * 添加班级
	 * @param clazz
	 * @return
	 */
	public int addClazz(Clazz clazz);


	/**
	 * 更新班级信息
	 * @param clazz
	 * @return
	 */
	public int updateClazz(Clazz clazz);

	/**
	 * 根据班级id删除班级信息
	 * @param id
	 * @return
	 */
	public int deleteClazzById(Integer id);

	/**
	 * 根据班级id获取班级信息
	 * @param id
	 * @return
	 */
	public ClazzDto findClazzByClazzId(Integer id);

	/**
	 * 
	 * @Title: getClassOfGradeOneByMajorFieldId
	 * @author 赖继鹏
	 * @Description:根据专业方向获取一年级的所有班级
	 * @param majorFieldId
	 * @return     
	 * @throws
	 */
	public List<ClazzDto> getClassOfGradeOneByMajorFieldId(int majorFieldId);

	/**
	 * 
	 * @Title: getClassCountByteaId
	 * @author 赖继鹏
	 * @Description: 根据教师Id获取班级数量
	 * @param teacherId
	 * @return     
	 * @throws
	 */
	public int getClassCountByteaId(int teacherId);

	/**
	 * 
	 * @Title: getClassNameById
	 * @author 赖继鹏
	 * @Description: 获取班级名称
	 * @param classId
	 * @return     
	 * @throws
	 */
	public String getClassNameById(int classId);

	
}
