package com.dkt.school.fin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.StudentPaymentDto;

public interface StudentPaymentCustomMapper extends StudentPaymentMapper{

	/**
	 * 获得学生的缴费信息列表
	 * @param stuPayName
	 * @param stuPayCode
	 * @param limit
	 * @return
	 */
	List<StudentPaymentDto> getStuPayList(@Param("stuPayName")String stuPayName,
								@Param("stuPayCode")String stuPayCode,
								@Param("limit")Limitation limit);
	
	/**
	 * 学生缴费信息记录条数
	 * @param stuPayName
	 * @param stuPayCode
	 * @return
	 */
	Integer getStuPayCount(@Param("stuPayName")String stuPayName,
							@Param("stuPayCode")String stuPayCode);

	
	/**
	 * 导出成批扣文件前查询数据
	 * @param list
	 * @return
	 */
	List<StudentPaymentDto> exportStuPayList(@Param("list")List<String> list);
	
	/**
	 * 插入批扣信息表的记录(对应student_payment表)
	 * @param list
	 * @return
	 */
	Integer insertStuPayList(@Param("list")List<StudentPaymentDto> list);
	
	/**
	 * 插入批扣信息表的记录(对应student_charge表)
	 */
	Integer insertStuChargeList(@Param("list")List<StudentPaymentDto> list);

	
}
