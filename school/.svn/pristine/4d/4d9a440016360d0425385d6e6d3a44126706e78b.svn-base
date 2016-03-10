package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherThesisDto;

public interface TeacherThesisCustomMapper extends TeacherThesisMapper{
		//取得个人论文著作的数量
		public Integer getTeacherThesisCount(Integer teacherId);
		
		//取得论文著作的数量
		public Integer getAllThesisCount(@Param("name") String name,
				@Param("code") String code, 
				@Param("thesisType") Integer thesisType);
			
		/**
		 * 查询个人论文著作
		 * 
		 * @param teacherId
		 * @param thesisType
		 * @param page
		 * @return
		 */
		public List<TeacherThesisDto> selectByLimitAndTeacherId(
				@Param("teacherId") Integer teacherId,
				@Param("thesisType") Integer thesisType, 
				@Param("limit") Limitation limit);
		/**
		 * 查询所有论文著作
		 * 
		 * @param name
		 * @param code
		 * @param thesisType
		 * @param page
		 * @return
		 */
		public List<TeacherThesisDto> selectByLimit(
				@Param("name") String name,
				@Param("code") String code, 
				@Param("thesisType") Integer thesisType, 
				@Param("limit") Limitation limit);
		
		//根据id查找论文著作信息
		public TeacherThesisDto getTeacherThesisById(Integer id);
}
