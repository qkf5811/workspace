package com.dkt.school.fin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.NewStudentPaymentOfExcelDto;
import com.dkt.school.fin.model.NewStudentPayment;

public interface NewStudentPaymentCustomMapper extends NewStudentPaymentMapper {

	/**
	 * 根据新生缴费资料list导入新生缴费资料
	 * @param list
	 * @return
	 */
	public int insertNewStudentPaymentByExcel(@Param("list")List<NewStudentPaymentOfExcelDto> list);

	/**
	 * 根据学生信息id批量删除新生缴费记录
	 * @param list
	 * @return
	 */
	public int deleteNewStudentPaymentsBystuId(
			@Param("list")List<NewStudentPaymentOfExcelDto> list);

	/**
	 * 根据学生信息id来 查询新生缴费资料记录
	 * @param list
	 * @return
	 */
	public List<NewStudentPaymentOfExcelDto> selectNewStudentPaymentsByStudentInfoId(
			List<NewStudentPaymentOfExcelDto> list);

	/**
	 * 根据页面条件查找新生缴费资料记录数量
	 * @param name
	 * @param idCard
	 * @param fieldId
	 * @param limitation
	 * @return
	 */
	public int selectNewStudentPaymentCountByPage(
			@Param("name")String name,
			@Param("admissionNumber")String admissionNumber,
			@Param("idCard")String idCard,
			@Param("fieldId")int fieldId, 
			@Param("limit")Limitation limitation);

	/**
	 * 根据页面条件查找新生缴费资料记录
	 * @param name
	 * @param idCard
	 * @param fieldId
	 * @param limitation
	 * @return
	 */
	public List<NewStudentPaymentOfExcelDto> selectNewStudentPaymentByPage(
			@Param("name")String name,
			@Param("admissionNumber")String admissionNumber,
			@Param("idCard")String idCard,
			@Param("fieldId")int fieldId, 
			@Param("limit")Limitation limitation);


	/**
	 * 根据学生信息id查询新生缴费记录
	 * @param id
	 * @return
	 */
	public NewStudentPayment selectNewStudentPaymentByStudentInfoId(
			@Param("id")int id);

	/**
	 * 根据list批量更新新生缴费记录
	 * @param updList
	 * @return
	 */
	public int updateByList(
			@Param("updList")List<NewStudentPaymentOfExcelDto> updList);
}
