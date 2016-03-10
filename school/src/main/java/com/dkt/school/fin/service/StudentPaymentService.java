package com.dkt.school.fin.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.StudentPaymentDto;

public interface StudentPaymentService {

	/**
	 * 获取学生缴费信息列表
	 * @param stuPayName
	 * @param stuPayCode
	 * @param limit
	 * @return
	 */
	List<StudentPaymentDto> getStudentPaymentList(String stuPayName,
									String stuPayCode,Limitation limit);

	/**
	 * 获取学生缴费信息记录数
	 * @param stuPayName
	 * @param stuPayCode
	 * @return
	 */
	Integer getStudentPaymentCount(String stuPayName,String stuPayCode);

	/**
	 * 导入批扣excel文件
	 * @param inputStream
	 * @param ext
	 */
	Integer uploadStuPayInfoExcel(InputStream inputStream, String ext);

	/**
	 * 导出批扣文件前请求数据
	 * @param param
	 * @return
	 */
	List<StudentPaymentDto> exportStuPayList(String param);

	/**
	 * 往excel文件里填充数据
	 * @param list
	 * @param file
	 */
	void export2Excel(List<StudentPaymentDto> list, File file);
}
