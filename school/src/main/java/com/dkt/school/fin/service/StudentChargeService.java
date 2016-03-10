package com.dkt.school.fin.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.StudentChargeDto;
import com.dkt.school.fin.dto.StudentChargeOfArrearsDto;

/**
 * 
 * <p>Title: StudentChargeService</p>
 * <p>Description: </p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月1日上午9:25:33
 *
 */

public interface StudentChargeService {
	/**
	 * 根据条件查询学生欠费信息的记录数
	 * @author 冯其康
	 * @param gradeId
	 * @param fieldId
	 * @param page
	 * @return
	 */
	public int findCountOfStudentChargeOfArrears(int gradeId, int majorId, int fieldId, PaginationCustom page);
	
	/**
	 * 根据条件查询学生欠费信息
	 * @author 冯其康
	 * @param gradeId
	 * @param fieldId
	 * @param page
	 * @return
	 */
	public List<StudentChargeOfArrearsDto> findOfStudentChargeOfArrears(int gradeId, int majorId, int fieldId, PaginationCustom page);

	/**
	 * 填充学生欠费信息模板
	 * @param gradeId
	 * @param fieldId
	 * @param dir
	 */
	public int getArreasInfoExcel(int gradeId, int majorId, int fieldId, File dir);

	/**
	 * 根据条件获取学生收费信息列表信息的记录数
	 * @author 赖继鹏
	 * @param studentChargeDto
	 * @return
	 */
	int getStudentChargeCount(StudentChargeDto studentChargeDto);

	/**
	 * 根据条件获取学生收费信息列表信息
	 * @author 赖继鹏
	 * @param studentChargeDto
	 * @param page
	 * @return
	 */
	List<StudentChargeDto> getStudentChargeListByPage(
			StudentChargeDto studentChargeDto, PaginationCustom page);

	/**
	 * 
	 * @Title: toCountAllStudentsCharge
	 * @author 赖继鹏
	 * @Description: 计算应扣学费
	 * @return     
	 * @throws
	 */
	public String toCountAllStudentsCharge();

	public void exportStuChargeInfo(HttpServletResponse response,
			Integer studyYearId, Integer termTypeId, Integer gradeId);

	public Integer getCurrentStudyYear();

}
