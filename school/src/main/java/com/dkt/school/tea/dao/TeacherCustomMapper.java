package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.SelectedOfExportTeacher;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.dto.TeacherTotalInfoDto;
import com.dkt.school.tea.model.Teacher;

public interface TeacherCustomMapper extends TeacherMapper{
	//取得教师的数量
	public Integer getTeacherCount();
	//模糊查询取得教师的数量
	public Integer getTeaCount(
			@Param("name") String name,
			@Param("code") String code);
	/**
	* 根据学号和姓名模糊分页查询
	* 
	* @param code
	* @param name
	* @param page
	* @return
	*/
	public List<TeacherDto> selectByLimit(
			@Param("name") String name,
			@Param("code") String code, 
			@Param("limit") Limitation limit);
	
	//根据编号取得教师
	public TeacherDto findTeacher(String code);

	
	//根据userId取得教师
	public TeacherDto getTeacherByUserId(Integer userId);

	
	/**冯其康* */
	//通过TeacherTotalInfoDto查找教师所有信息
		public List<TeacherTotalInfoDto> searchTotalInfoOfTeacher(@Param("dto")TeacherTotalInfoDto dto,
																  @Param("limit") Limitation limit);
		//得到所有教师信息的记录数
		public int searchCountOfTeacherTotalInfo(@Param("dto")TeacherTotalInfoDto dto);
		
		//添加教师
		public int insertNewTeacherByDto(@Param("dto")TeacherTotalInfoDto dto);
		
		//添加教师信息
		public int insertNewTeacherInfoByDto(@Param("dto")TeacherTotalInfoDto dto);
		
		//添加教师教育经历信息
		public int insertNewTeacherEduExpByDto(@Param("dto")TeacherTotalInfoDto dto);
		
		//根据教师编号查找教师表
		public Teacher selectTeacherByCode(@Param("code")String code);
		
		//通过TeacherTotalInfoDto修改教师基本信息
		public int updateTeacherByDto(@Param("dto")TeacherTotalInfoDto dto);
		
		//通过TeacherTotalInfoDto修改教师详细信息
		public int updateTeacherInfoByDto(@Param("dto")TeacherTotalInfoDto dto);
		
		//通过TeacherTotalInfoDto修改教师教育经历信息
		public int updateTeacherEduExpByDto(@Param("dto")TeacherTotalInfoDto dto);
		
		//根据页面选择的导出条件和id数组导出教师信息
		public List<TeacherTotalInfoDto> searchTotalInfoOfTeacherByIdsAndSelected(
				@Param("idArr")int[] idArr,
				@Param("dto")SelectedOfExportTeacher dto);
		
		//根据教师id查询教师完整信息
		public TeacherTotalInfoDto searchTeacherTotalInfoByTeacherId(@Param("teacherId")int teacherId);
		
		//根据教师id查询教师个人完整信息
		public TeacherTotalInfoDto searchTeacherAllInfoByTeacherId(@Param("teacherId")int teacherId);


		//添加教育经历信息
		public int insertNewTeacherEduExp(@Param("eduExp")TeacherEduExperienceDto eduExp);

		/**
		 * 通过教师List批量添加教师记录添加
		 * @param dtoList
		 * @return
		 */
		public int addTeacherByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);
		
		/**
		 * 通过教师List批量更新教师记录添加
		 * @param dtoList
		 * @return
		 */
		public int updateTeacherByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);
		
		/**
		 * 通过教师List批量添加教师信息记录
		 * @param dtoList
		 * @return
		 */
		public int addTeacherInfoByExcel(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);
		
		/**
		 * 通过通过教师List批量更新教师信息记录
		 * @param dtoList
		 * @return
		 */
		public int updateTeacherInfoByExcel(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);

		/**
		 * 通过教师List批量添加用户记录
		 * @param dtoList
		 * @return
		 */
		public int addUserByExcel(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);
		
		/**
		 * 通过教师List批量更新用户记录
		 * @param dtoList
		 * @return
		 */
		public int updateUserByExcel(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);

		/**
		 * 根据dto得到教师id的list
		 * @param dtoList
		 * @return
		 */
		public List<Integer> getTeacherIdArrByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);

		public List<Integer> getUserIdArrByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);

		public int updateUserIdByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);

		//添加教育信息后更新教师信息表里的学历(取最大)
		public int updateTeacherInfoDegreeType(@Param("teacherId")int teacherId);
		
		/*cxj*/
		//由用户id获得教师id
		public Integer getTeacherIdByUserId(@Param("userId")Integer userId);
		
		//根据teacherId获取班级id
		public Integer getClassIdByTeacherId(@Param("teacherId")Integer teacherId);
		
		//根据老师id获取年级id
		public Integer getGradeIdByClassId(@Param("classId")Integer classId);
		
		/**
		 * 根据dto批量删除教师
		 * @param dtoList
		 */
		public void deleteTeacherByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);
		
		/**
		 * 根据dto批量删除教师信息
		 * @param dtoList
		 */
		public void deleteTeacherInfoByList(@Param("dtoList")List<TeacherTotalInfoDto> dtoList);
	
		/**
		 * 获得所有teacher
		 * @return
		 */
		public List<Teacher> getAllTeacher();


}
