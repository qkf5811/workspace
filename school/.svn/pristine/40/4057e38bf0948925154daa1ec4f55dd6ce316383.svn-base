package com.dkt.school.tea.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dto.SelectedOfExportTeacher;
import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.dto.TeacherTotalInfoDto;


public interface TeacherTotalInfoService {

	public List<TeacherTotalInfoDto> searchTeacherTotalInfo(TeacherTotalInfoDto teaTotalInfo, PaginationCustom page);
	
	public int searchCountOfTeacherTotalInfo(TeacherTotalInfoDto dto);
	
	public void setTeacherTotalInfoDtoStr(List<TeacherTotalInfoDto> dtoList);
	
	/**
	 * 添加教师信息
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int addNewTeacher(TeacherTotalInfoDto dto) throws Exception;
	
	/**
	 * 修改教师完整信息
	 * @param dto
	 * @return
	 */
	public int editTeacherTotalInfo(TeacherTotalInfoDto dto);

	/**
	 * 根据teacher id和选择需要导出的字段导出花名册
	 * @param idArr
	 * @param dto
	 * @param file
	 */
	public void exportRoster(int[] idArr, SelectedOfExportTeacher dto, File file);
	
	/**
	 * 根据模板文件路径填充教师个人信息
	 * @param teacherId
	 * @param dir
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getTeacherInfoExcel(int teacherId, File dir) throws FileNotFoundException, IOException;
	
	/**
	 * 根据id获得某个教师的完整信息
	 * @param id
	 * @return
	 */
	public TeacherTotalInfoDto searchTeacherTotalInfoDtoById(int id);
	
	/**
	 * 根据id获得某个教师的个人完整信息
	 * @param id
	 * @return
	 */
	public TeacherTotalInfoDto searchTeacherAllInfoDtoById(int id);

	/**
	 * 添加教育经历信息
	 * @param eduExp
	 * @return
	 */
	public int addTeacherEduExp(TeacherEduExperienceDto eduExp);

	/**
	 * 通过excel导入教师信息
	 * @param inputStream
	 * @param format
	 * @return
	 */
	public long addTeacherTotalInfoByExcel(InputStream inputStream,
			String format);

	public void dtoListToDtoStrList(List<TeacherTotalInfoDto> list);
	
	public void dtoListChangeToDtoStrList(List<TeacherTotalInfoDto> dtoList);
}
