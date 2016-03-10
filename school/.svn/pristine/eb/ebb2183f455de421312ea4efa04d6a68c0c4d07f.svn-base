package com.dkt.school.fin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.StudentChargeDto;
import com.dkt.school.fin.dto.StudentChargeOfArrearsDto;
import com.dkt.school.fin.dto.StudentChargeToBankDto;
import com.dkt.school.fin.model.StudentCharge;

/**
 * 
 * <p>Title: StudentChargeCustomMapper</p>
 * <p>Description: </p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月1日上午9:26:25
 *
 */
public interface StudentChargeCustomMapper extends StudentChargeMapper {
	
	/**
	 * 根据条件查询学生欠费信息的记录数
	 * @author 冯其康
	 * @param gradeId
	 * @param fieldId
	 * @param limit
	 * @return
	 */
	public int selectCountOfStudentChargeOfArrearsDto(
			@Param("gradeId")int gradeId,
			@Param("majorId")int majorId,
			@Param("fieldId")int fieldId,
			@Param("limit")Limitation limit);
	
	/**
	 * 根据条件查询学生欠费信息
	 * @author 冯其康
	 * @param gradeId
	 * @param fieldId
	 * @param limit
	 * @return
	 */
	public List<StudentChargeOfArrearsDto> selectStudentChargeOfArrearsDto(
			@Param("gradeId")int gradeId,
			@Param("majorId")int majorId,
			@Param("fieldId")int fieldId,
			@Param("limit")Limitation limit);


	/**
	 * 
	 * @Title: selectStudentChargeCount
	 * @author 赖继鹏
	 * @Description: 根据条件获取学生收费信息列表信息的记录数
	 * @param dto
	 * @return     
	 * @throws
	 */
	int selectStudentChargeCount(@Param("dto")StudentChargeDto dto);


	/**
	 * 
	 * @Title: selectStudentChargeListByPage
	 * @author 赖继鹏
	 * @Description: 根据条件获取学生收费信息列表信息
	 * @param dto
	 * @param limit
	 * @return     
	 * @throws
	 */
	List<StudentChargeDto> selectStudentChargeListByPage(
			@Param("dto")StudentChargeDto dto, @Param("limit")Limitation limit);

	/**
	 * 
	 * @Title: insertAllStudentCharge
	 * @author 赖继鹏
	 * @Description: 把所有学生扣费信息插入数据库
	 * @param toInsertStudentChargeList
	 * @return     
	 * @throws
	 */
	public int insertAllStudentCharge( @Param("sC")
			StudentCharge studentCharge);

	/**
	 * 
	 * @Title: updateStudentChargeByMultiCon
	 * @author 赖继鹏
	 * @Description: 更新学生扣费信息
	 * @param studentCharge     
	 * @throws
	 */
	public void updateStudentChargeByMultiCon(@Param("sC")StudentCharge studentCharge);

	/**
	 * 
	 * @Title: selectStudentChargeCountBeModi
	 * @author 赖继鹏
	 * @Description: 查询当扣费记录是否需要更新
	 * @param studentCharge
	 * @return     
	 * @throws
	 */
	public int selectStudentChargeCountBeModi(@Param("sC")StudentCharge studentCharge);


	/**
	 * @Title:selectStudentChargeListByExport
	 * @author 龚硕晓
	 * @description:根据条件导出欠费的学生资料
	 * @param studyYear
	 * @param termType
	 * @param gradeId
	 * @param limit
	 * @return
	 */
	public List<StudentChargeToBankDto> selectStudentChargeListByExport(
			@Param("studyYearId")Integer studyYearId,@Param("termTypeId")Integer termTypeId,
			@Param("gradeId")Integer gradeId);

	public Integer getCurrentStudyYear();

}
