package com.dkt.school.tea.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherWorkExperienceDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.model.TeacherWorkExperience;

public interface TeacherResumeService {

	/**
	 * 获取教师教育经历列表
	 * @param code 
	 * @param name 
	 * @param limit
	 * @return
	 */
	public List<TeacherWorkExperienceDto> getTeacherWorkList(String code,String name, Limitation limit);

	/**
	 * 获取教师工作经历记录数
	 * @Param code
	 * @param name
	 * @return
	 */
	public Integer getTeacherWorkCount(String code, String name);

	/**
	 * 删除具体的教职工履历项目
	 * @param id
	 * @return
	 */
	public int deleteTeaWorkItem(Integer id);

	/**
	 * 根据id获取单个履历条目
	 * @param id
	 * @return
	 */
	public TeacherWorkExperienceDto getTeacherWorkExperienceById(Integer id);

	/**
	 * 更新某条具体的履历项
	 * @param record
	 * @return
	 */
	public int updateResumeItem(TeacherWorkExperience record);
	
	/**
	 * 增加个人履历信息条目
	 * @param record 
	 * @return
	 */
	public int addSingleResumeInfo(TeacherWorkExperience record);

	/**
	 * 获取教职工数量
	 * @param name
	 * @param code
	 * @return
	 */
	public int getTeahcerCount(String name,String code);

	/**
	 * 
	 * @param name
	 * @param code
	 * @param limit
	 * @return
	 */
	public List<Teacher> getAllTeacher(String name,String code,Limitation limit);

	/**
	 * 导入教师履历信息
	 * @param inputStream
	 * @param ext
	 * @return
	 */
	public int importTeaResumeByXLS(InputStream inputStream, String ext);
	
	/**
	 * 根据code获取教师id
	 * @param code
	 * @return
	 */
	public int getTeacherIdByCode(String code);

	/**
	 * 下载教职工简历excel
	 * @param in
	 * @param file
	 */
	public void downloadTeaResumeExcel(InputStream in,File file);

	/**
	 * 获取单个老师的简历记录数
	 * @param id
	 * @return
	 */
	public Integer getSingleWorkExperienceCount(Integer id);

	/**
	 * 获取单个老师的简历集合
	 * @param id
	 * @return
	 */
	public List<TeacherWorkExperienceDto> getSingleWorkExperienceById(Integer id);
	

}
