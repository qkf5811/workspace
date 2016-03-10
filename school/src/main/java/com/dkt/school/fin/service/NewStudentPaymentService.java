package com.dkt.school.fin.service;

import java.io.InputStream;
import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.NewStudentPaymentOfExcelDto;

public interface NewStudentPaymentService {

	/**
	 * 通过Excel导入新生缴费资料
	 * @param in
	 * @return
	 */
	public long importNewStudentPaymentByExcel(InputStream in);

	/**
	 * 根据页面条件查找新生缴费资料记录数量
	 * @param name
	 * @param idCard
	 * @param fieldId
	 * @param page
	 * @return
	 */
	public int findNewStudentPaymentCountByPage(String name, String admissionNumber, String idCard,
			int fieldId, PaginationCustom page);

	/**
	 * 根据页面条件查找新生缴费资料记录
	 * @param name
	 * @param idCard
	 * @param fieldId
	 * @param page
	 * @return
	 */
	public List<NewStudentPaymentOfExcelDto> findNewStudentPaymentByPage(
			String name, String admissionNumber, String idCard, int fieldId, PaginationCustom page);
}
