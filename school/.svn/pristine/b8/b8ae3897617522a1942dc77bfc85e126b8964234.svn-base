package com.dkt.school.tea.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dao.TeacherCustomMapper;
import com.dkt.school.tea.dto.SelectedOfExportTeacher;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.dto.TeacherTotalInfoDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.TeacherTotalInfoService;
import com.dkt.school.user.dto.UserDto;
import com.dkt.school.user.model.Department;
import com.dkt.school.user.service.DepartmentService;
import com.dkt.school.user.service.UserService;

@Service
@Transactional
public class TeacherTotalInfoServiceImpl implements TeacherTotalInfoService {

	@Autowired
	TeacherCustomMapper teaMapper;

	@Autowired
	EnumerationService enumerationService;

	@Autowired
	MajorService majorService;

	@Autowired
	UserService userService;

	@Autowired
	DepartmentService deptService;

	@Override
	public List<TeacherTotalInfoDto> searchTeacherTotalInfo(
			TeacherTotalInfoDto teaTotalInfo, PaginationCustom page) {

		return teaMapper.searchTotalInfoOfTeacher(teaTotalInfo,
				page.getLimitation());
	}

	@Override
	public int searchCountOfTeacherTotalInfo(TeacherTotalInfoDto dto) {
		// TODO Auto-generated method stub
		return teaMapper.searchCountOfTeacherTotalInfo(dto);
	}

	// 设置TeacherTotalInfoDto的str属性
	public void setTeacherTotalInfoDtoStr(List<TeacherTotalInfoDto> dtoList) {

		List<EnumerationValue> sexList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);

		/* 婚姻状况 */

		List<EnumerationValue> nationList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);
		System.out.println(nationList.size());
		/* 职称 */

		/* 学历 */

		List<EnumerationValue> politicalFeatureList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE);
		// System.out.println(politicalFeatureList.size());
		/* 部门 */

		/* 在职状态 */

		// 设置
		for (int i = 0; i < dtoList.size(); ++i) {

			// 设置性别
			int sexTmp = dtoList.get(i).getSexType();
			if (sexTmp == sexList.get(0).getId())
				dtoList.get(i).setSexTypeStr(sexList.get(0).getName());
			else
				dtoList.get(i).setSexTypeStr(sexList.get(1).getName());

			// 设置民族
			int nationTmp = dtoList.get(i).getNationType();
			for (int j = 0; j < nationList.size(); ++j) {
				int nTemp = nationList.get(j).getId();
				// System.out.println(nTemp + ", " + nationTmp);
				if (nationTmp == nTemp) {
					dtoList.get(i)
							.setNationTypeStr(nationList.get(j).getName());
					break;
				}
			}

			// 设置政治面貌
			int politicalTmp = dtoList.get(i).getPoliticalFeatureType();
			for (int j = 0; j < politicalFeatureList.size(); ++j) {
				int pTemp = politicalFeatureList.get(j).getId();
				if (politicalTmp == pTemp) {
					dtoList.get(i).setPoliticalFeatureTypeStr(
							politicalFeatureList.get(j).getName());
				}
			}
		}
	}

	// 添加教师信息
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class, readOnly = false)
	public int addNewTeacher(TeacherTotalInfoDto dto) throws Exception {

		// 设置tea_teacher_info的teacher_id
		// dto.setTeacherId(teaMapper.selectTeacherByCode(dto.getCode()).getId());
		Teacher isRepeat = teaMapper.selectTeacherByCode(dto.getCode());
		System.out.println(isRepeat);
		if (isRepeat != null) {
			return -1; //该工号已存在!
		}
		if (dto.getBirthday() == null)
			dto.setBirthdayStr("0001-01-01");
		if (dto.getStartDate() == null)
			dto.setStartDateStr("0001-01-01");
		if (dto.getEndDate() == null)
			dto.setEndDateStr("0001-01-01");
		if (dto.getWorkStartTime() == null)
			dto.setWorkStartTimeStr("0001-01-01");
		if (dto.getTakeOfficeTime() == null)
			dto.setTakeOfficeTimeStr("0001-01-01");

		// 设置用户id
		dto.setUserId(0);

		// try{
		// 插入usr_user表
		UserDto user = new UserDto();
		user.setAccount(dto.getCode());
		user.setPassword("123456");
		user.setAddress(dto.getFamilyAddress());
		user.setDepartmentId(dto.getDepartmentId());
		user.setEmail(dto.getEmail());
		user.setMobile(dto.getMobilePhone());
		user.setName(dto.getNameOfTeacher());
		user.setPhone(dto.getOfficePhone());
		user.setSexType(dto.getSexType());
		user.setIsBlocked(2002);
		userService.addUser(user);

		UserDto tmp = userService.getUserByAccount(dto.getCode());
		// 插入tea_teacher表
		dto.setUserId(tmp.getId()); // 得到user_id
		teaMapper.insertNewTeacherByDto(dto);
		// System.out.println("教师编号:" + dto.getCode());

		int id = teaMapper.selectTeacherByCode(dto.getCode()).getId();
		// System.out.println("教师id:" + id);

		dto.setTeacherId(id);
		// 插入tea_teacher_info表
		int result = teaMapper.insertNewTeacherInfoByDto(dto);

		// 插入教师教育经历信息
		// int result = teaMapper.insertNewTeacherEduExpByDto(dto);

		// } catch(Exception e){
		// System.out.println("事务回滚");
		// throw new RuntimeException();

		return result;
		// }
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class, readOnly = false)
	public int editTeacherTotalInfo(TeacherTotalInfoDto dto) {

		if (dto.getBirthday() == null)
			dto.setBirthdayStr("0001-01-01");
		if (dto.getStartDate() == null)
			dto.setStartDateStr("0001-01-01");
		if (dto.getEndDate() == null)
			dto.setEndDateStr("0001-01-01");
		if (dto.getWorkStartTime() == null)
			dto.setWorkStartTimeStr("0001-01-01");
		if (dto.getTakeOfficeTime() == null)
			dto.setTakeOfficeTimeStr("0001-01-01");
		// 修改tea_teacher表
		teaMapper.updateTeacherByDto(dto);
		// System.out.println("修改完teacher表");
		teaMapper.updateTeacherInfoByDto(dto);
		// System.out.println("修改完teacher_info表");
		// teaMapper.updateTeacherEduExpByDto(dto);
		// System.out.println("修改完teacher_edu表");
		int result = 1;

		return result;
	}

	@Override
	public void exportRoster(int[] idArr, SelectedOfExportTeacher dto, File file) {
		// TODO Auto-generated method stub
		OutputStream out = null;
		try {
			Workbook wb = new HSSFWorkbook();
			Sheet sheet = wb.createSheet();
			// 根据dto和idArr查找
			List<TeacherTotalInfoDto> teaList = teaMapper
					.searchTotalInfoOfTeacherByIdsAndSelected(idArr, dto);
			System.out.println("教师集合大小:" + teaList.size());
			// System.out.println("id1: " + teaList.get(0).getTeacherId());
			// System.out.println("id2: " + teaList.get(1).getTeacherId());
			/*******/
			List<Major> majorList = majorService.getAllMajorInfo();
			List<EnumerationValue> titleTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.TEACHER_TITLE_TYPE);
			List<EnumerationValue> staffTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.TEACHER_STAFF_TYPE);
			List<EnumerationValue> positionTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.POSITION_TYPE);
			List<EnumerationValue> educationTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE);
			List<EnumerationValue> degreeTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE);
			List<EnumerationValue> idCardTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.ID_CARD_TYPE);
			List<EnumerationValue> countryIdList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.COUNTRY_ID);
			List<EnumerationValue> nationTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);
			List<EnumerationValue> politicalFeatureTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE);
			List<EnumerationValue> maritalStatusList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.MARITAL_STATUS);
			List<EnumerationValue> houseHoldTypeList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE);
			List<Department> deptList = deptService.findAllDepartment();

			// 创建表头
			System.out.println("创建表头:" + dto.toString());
			int index = 0;
			Row head = sheet.createRow(0);
			// 创建数据行
			List<Row> rows = new ArrayList<Row>();
			for (int i = 1; i <= teaList.size(); ++i) {
				rows.add(i - 1, sheet.createRow(i));
			}

			// 教师基本信息表头
			if (dto.isName()) {
				head.createCell(index).setCellValue("姓名");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getName());
				}
				index++;
			}
			if (dto.isCode()) {
				head.createCell(index).setCellValue("编号");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getCode());
				}
				index++;
			}
			if (dto.isMajorId()) {
				head.createCell(index).setCellValue("专业");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断专业，并设置
					for (int j = 0; j < majorList.size(); ++j) {
						int tmp1 = majorList.get(j).getId();
						int tmp2 = teaList.get(i).getMajorId();
						if (tmp1 == tmp2) {
							temp.setCellValue(majorList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isNowPosition()) {
				head.createCell(index).setCellValue("职位");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getNowPosition());
				}
				index++;
			}
			if (dto.isTitleType()) {
				head.createCell(index).setCellValue("职称");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断职称，并设置
					for (int j = 0; j < titleTypeList.size(); ++j) {
						int tmp1 = titleTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getTitleType();
						if (tmp1 == tmp2) {
							temp.setCellValue(titleTypeList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isStaffType()) {
				head.createCell(index).setCellValue("职工类型");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断职工类型，并设置
					for (int j = 0; j < staffTypeList.size(); ++j) {
						int tmp1 = staffTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getStaffType();
						if (tmp1 == tmp2) {
							temp.setCellValue(staffTypeList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isPositionType()) {
				head.createCell(index).setCellValue("职位状态");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < positionTypeList.size(); ++j) {
						int tmp1 = positionTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getPositionType();
						if (tmp1 == tmp2) {
							temp.setCellValue(positionTypeList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isWorkStartTime()) {
				head.createCell(index).setCellValue("参加工作日期");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date(teaList.get(i).getWorkStartTime()
									.getTime())));
				}
				index++;
			}
			if (dto.isTakeOfficeTime()) {
				head.createCell(index).setCellValue("在本校任职日期");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date(teaList.get(i).getTakeOfficeTime()
									.getTime())));
				}
				index++;
			}
			if (dto.isRemarkOfTeacher()) {
				head.createCell(index).setCellValue("教师基本信息备注");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getRemarkOfTeacher());
				}
				index++;
			}
			// 教师教育经历信息表头
			if (dto.isEducationType()) {
				head.createCell(index).setCellValue("教育类型");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < educationTypeList.size(); ++j) {
						int tmp1 = educationTypeList.get(j).getId();
						if (teaList.get(i).getEducationType() != null) {
							int tmp2 = teaList.get(i).getEducationType();
							if (tmp1 == tmp2) {
								temp.setCellValue(educationTypeList.get(j)
										.getName());
								break;
							}
						} else
							temp.setCellValue("");
					}
				}
				index++;
			}
			if (dto.isSchool()) {
				head.createCell(index).setCellValue("毕业学校");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getSchool());
				}
				index++;
			}
			if (dto.isMajor()) {
				head.createCell(index).setCellValue("所属专业");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getMajor());
				}
				index++;
			}
			if (dto.isStartDate()) {
				head.createCell(index).setCellValue("开始时间");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					if (teaList.get(i).getStartDate() != null)
						temp.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
								.format(new Date(teaList.get(i).getStartDate()
										.getTime())));
					else
						temp.setCellValue("");
				}
				index++;
			}
			if (dto.isEndDate()) {
				head.createCell(index).setCellValue("结束时间");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					if (teaList.get(i).getEndDate() != null)
						temp.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
								.format(new Date(teaList.get(i).getEndDate()
										.getTime())));
					else
						temp.setCellValue("");
				}
				index++;
			}
			if (dto.isDegreeType()) {
				head.createCell(index).setCellValue("学历");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < degreeTypeList.size(); ++j) {
						int tmp1 = degreeTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getDegreeType();
						if (tmp1 == tmp2) {
							temp.setCellValue(degreeTypeList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isRemarkOfTeacherEduExp()) {
				head.createCell(index).setCellValue("教师教育经历备注");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getRemarkOfTeaEdu());
				}
				index++;
			}
			// 教师详细信息表头
			if (dto.isSexType()) {
				head.createCell(index).setCellValue("性别");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					if (teaList.get(i).getSexType() == 1001)
						temp.setCellValue("男");
					else if (teaList.get(i).getSexType() == 1002)
						temp.setCellValue("女");
				}
				index++;
			}
			if (dto.isBirthday()) {
				head.createCell(index).setCellValue("出生日期");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date(teaList.get(i).getBirthday()
									.getTime())));
				}
				index++;
			}
			if (dto.isIdCardType()) {
				head.createCell(index).setCellValue("证件类型");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < idCardTypeList.size(); ++j) {
						int tmp1 = idCardTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getIdCardType();
						if (tmp1 == tmp2) {
							temp.setCellValue(idCardTypeList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isIdCard()) {
				head.createCell(index).setCellValue("证件号");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getIdCard());
				}
				index++;
			}
			if (dto.isCountryId()) {
				head.createCell(index).setCellValue("国籍");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < countryIdList.size(); ++j) {
						int tmp1 = countryIdList.get(j).getId();
						int tmp2 = teaList.get(i).getCountryId();
						if (tmp1 == tmp2) {
							temp.setCellValue(countryIdList.get(j).getName());
							break;
						}
					}
				}

				index++;
			}
			if (dto.isNationType()) {
				head.createCell(index).setCellValue("民族");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < nationTypeList.size(); ++j) {
						int tmp1 = nationTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getNationType();
						if (tmp1 == tmp2) {
							temp.setCellValue(nationTypeList.get(j).getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isPoliticalFeatureType()) {
				head.createCell(index).setCellValue("政治面貌");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < politicalFeatureTypeList.size(); ++j) {
						int tmp1 = politicalFeatureTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getPoliticalFeatureType();
						if (tmp1 == tmp2) {
							temp.setCellValue(politicalFeatureTypeList.get(j)
									.getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isNativePlace()) {
				head.createCell(index).setCellValue("户籍");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getNativePlace());
				}
				index++;
			}
			if (dto.isMaritalStatus()) {
				head.createCell(index).setCellValue("婚姻状况");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < maritalStatusList.size(); ++j) {
						int tmp1 = maritalStatusList.get(j).getId();
						int tmp2 = teaList.get(i).getMaritalStatus();
						if (tmp1 == tmp2) {
							temp.setCellValue(maritalStatusList.get(j)
									.getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isHouseholdType()) {
				head.createCell(index).setCellValue("户籍类型");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					// 判断并设置
					for (int j = 0; j < houseHoldTypeList.size(); ++j) {
						int tmp1 = houseHoldTypeList.get(j).getId();
						int tmp2 = teaList.get(i).getHouseholdType();
						if (tmp1 == tmp2) {
							temp.setCellValue(houseHoldTypeList.get(j)
									.getName());
							break;
						}
					}
				}
				index++;
			}
			if (dto.isFamilyAddress()) {
				head.createCell(index).setCellValue("家庭住址");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getFamilyAddress());
				}
				index++;
			}
			if (dto.isPostCode()) {
				head.createCell(index).setCellValue("邮编");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getPostcode());
				}
				index++;
			}
			if (dto.isFamilyPhone()) {
				head.createCell(index).setCellValue("家庭电话");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getFamilyPhone());
				}
				index++;
			}
			if (dto.isOfficePhone()) {
				head.createCell(index).setCellValue("工作电话");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getOfficePhone());
				}
				index++;
			}
			if (dto.isMobilePhone()) {
				head.createCell(index).setCellValue("移动电话");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getMobilePhone());
				}
				index++;
			}
			if (dto.isEmail()) {
				head.createCell(index).setCellValue("电子邮箱");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getEmail());
				}
				index++;
			}
			if (dto.isRemarkOfTeacherInfo()) {
				head.createCell(index).setCellValue("教师详细信息备注");
				for (int i = 0; i < teaList.size(); ++i) {
					Cell temp = rows.get(i).createCell(index);
					temp.setCellValue(teaList.get(i).getRemark());
				}
				index++;
			}

			// 填充select出的记录
			/****/
			out = new FileOutputStream(file);
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getTeacherInfoExcel(int teacherId, File dir)
			throws FileNotFoundException, IOException {

		// 得到teacherTotalInfo
		TeacherTotalInfoDto dto = this
				.searchTeacherTotalInfoByTeacherId(teacherId);
		System.out.println(dto);
		System.out.println("teacherId: " + teacherId);
		if (dto == null)
			return 0; // 教育经历信息未填写

		// 各种枚举
		List<EnumerationValue> nationList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);
		List<EnumerationValue> politicalList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE);
		List<EnumerationValue> houseHoldList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE);
		List<EnumerationValue> idCardTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.ID_CARD_TYPE);
		List<EnumerationValue> maritalList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.MARITAL_STATUS);
		List<Major> majorIdList = majorService.getAllMajorInfo();
		List<EnumerationValue> titleTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_TITLE_TYPE);
		List<EnumerationValue> staffTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_STAFF_TYPE);
		List<EnumerationValue> positionTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.POSITION_TYPE);
		List<EnumerationValue> educationTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE);
		List<EnumerationValue> degreeTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE);
		List<EnumerationValue> countryList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.COUNTRY_ID);
		List<Department> deptList = deptService.findAllDepartment();
		// 先清空模板然后设置
		InputStream in = new FileInputStream(dir);
		File outputFile = new File(dir.getParent() + "/教职工个人信息(填充).xls");
		OutputStream out = new FileOutputStream(outputFile);

		Workbook wb = new HSSFWorkbook(in);
		// System.out.println("读取excel测试: " +
		// wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
		Sheet sheet1 = wb.getSheetAt(0);
		int tmp = 0;
		// 姓名
		Cell name = sheet1.getRow(0).getCell(1);
		name.setCellType(Cell.CELL_TYPE_STRING);
		name.setCellValue(dto.getNameOfTeacher());
		// 性别
		Cell sex = sheet1.getRow(0).getCell(3);
		sex.setCellType(Cell.CELL_TYPE_STRING);
		sex.setCellValue("");
		if (dto.getSexType() != 0 || dto.getSexType() != null) {
			if (dto.getSexType() == 1001)
				sex.setCellValue("男");
			else
				sex.setCellValue("女");
		}
		// 出生年月
		Cell bir = sheet1.getRow(0).getCell(5);
		bir.setCellType(Cell.CELL_TYPE_STRING);
		bir.setCellValue("");
		if (dto.getBirthday() != null) {
			bir.setCellValue(new SimpleDateFormat("yyyy年MM月")
					.format(new java.util.Date(dto.getBirthday().getTime())));
		}
		// 证件类型
		Cell idCardType = sheet1.getRow(0).getCell(7);
		idCardType.setCellType(Cell.CELL_TYPE_STRING);
		idCardType.setCellValue("");
		int idCardTypeId = dto.getIdCardType();
		for (int i = 0; i < idCardTypeList.size(); ++i) {
			tmp = idCardTypeList.get(i).getId();
			if (tmp == idCardTypeId) {
				idCardType.setCellValue(idCardTypeList.get(i).getName());
				break;
			}
		}

		// 证件号码
		Cell idCard = sheet1.getRow(0).getCell(9);
		idCard.setCellType(Cell.CELL_TYPE_STRING);
		idCard.setCellValue("");
		if (!dto.getIdCard().trim().equals(""))
			idCard.setCellValue(dto.getIdCard());
		// 国籍
		Cell country = sheet1.getRow(1).getCell(1);
		country.setCellType(Cell.CELL_TYPE_STRING);
		country.setCellValue("");
		int countryId = dto.getCountryId();
		for (int i = 0; i < countryList.size(); ++i) {
			tmp = countryList.get(i).getId();
			if (tmp == countryId) {
				country.setCellValue(countryList.get(i).getName());
				break;
			}
		}
		// 民族
		Cell nation = sheet1.getRow(1).getCell(3);
		nation.setCellType(Cell.CELL_TYPE_STRING);
		nation.setCellValue("");
		int nationId = dto.getNationType();
		for (int i = 0; i < nationList.size(); ++i) {
			tmp = nationList.get(i).getId();
			if (tmp == nationId) {
				nation.setCellValue(nationList.get(i).getName());
				break;
			}
		}
		// 政治面貌
		Cell political = sheet1.getRow(1).getCell(5);
		political.setCellType(Cell.CELL_TYPE_STRING);
		political.setCellValue("");
		int politicalId = dto.getPoliticalFeatureType();
		for (int i = 0; i < politicalList.size(); ++i) {
			tmp = politicalList.get(i).getId();
			if (tmp == politicalId) {
				political.setCellValue(politicalList.get(i).getName());
				break;
			}
		}
		// 户籍类型
		Cell houseHold = sheet1.getRow(1).getCell(7);
		houseHold.setCellType(Cell.CELL_TYPE_STRING);
		houseHold.setCellValue("");
		int houseHoldId = dto.getHouseholdType();
		for (int i = 0; i < houseHoldList.size(); ++i) {
			tmp = houseHoldList.get(i).getId();
			if (tmp == houseHoldId) {
				houseHold.setCellValue(houseHoldList.get(i).getName());
				break;
			}
		}
		// 婚姻状态
		Cell marital = sheet1.getRow(1).getCell(9);
		marital.setCellType(Cell.CELL_TYPE_STRING);
		marital.setCellValue("");
		int maritalId = dto.getMaritalStatus();
		for (int i = 0; i < maritalList.size(); ++i) {
			tmp = maritalList.get(i).getId();
			if (tmp == maritalId) {
				marital.setCellValue(maritalList.get(i).getName());
				break;
			}
		}
		// 籍贯
		Cell nativePlace = sheet1.getRow(2).getCell(1);
		nativePlace.setCellType(Cell.CELL_TYPE_STRING);
		nativePlace.setCellValue("");
		if (!dto.getNativePlace().trim().equals("")) {
			nativePlace.setCellValue(dto.getNativePlace());
		}
		// 家庭地址
		Cell familyAddress = sheet1.getRow(3).getCell(1);
		familyAddress.setCellType(Cell.CELL_TYPE_STRING);
		familyAddress.setCellValue("");
		if (!dto.getFamilyAddress().trim().equals("")) {
			familyAddress.setCellValue(dto.getFamilyAddress());
		}
		// 邮政编码
		Cell postCode = sheet1.getRow(2).getCell(7);
		postCode.setCellType(Cell.CELL_TYPE_STRING);
		postCode.setCellValue("");
		if (!dto.getPostcode().trim().equals("")) {
			postCode.setCellValue(dto.getPostcode());
		}
		// 移动电话
		Cell mobile = sheet1.getRow(3).getCell(7);
		mobile.setCellType(Cell.CELL_TYPE_STRING);
		mobile.setCellValue("");
		if (!dto.getMobilePhone().trim().equals("")) {
			mobile.setCellValue(dto.getMobilePhone());
		}
		// 家庭电话
		Cell familyPhone = sheet1.getRow(2).getCell(9);
		familyPhone.setCellType(Cell.CELL_TYPE_STRING);
		familyPhone.setCellValue("");
		if (!dto.getFamilyPhone().trim().equals("")) {
			familyPhone.setCellValue(dto.getFamilyPhone());
		}
		// 办公电话
		Cell officePhone = sheet1.getRow(3).getCell(9);
		officePhone.setCellType(Cell.CELL_TYPE_STRING);
		officePhone.setCellValue("");
		if (!dto.getOfficePhone().trim().equals("")) {
			officePhone.setCellValue(dto.getOfficePhone());
		}
		// 电子邮箱
		Cell email = sheet1.getRow(4).getCell(1);
		email.setCellType(Cell.CELL_TYPE_STRING);
		email.setCellValue("");
		if (!dto.getEmail().trim().equals("")) {
			email.setCellValue(dto.getEmail());
		}
		// 教职工工号
		Cell code = sheet1.getRow(4).getCell(3);
		code.setCellType(Cell.CELL_TYPE_STRING);
		code.setCellValue("");
		if (!dto.getCode().trim().equals("")) {
			code.setCellValue(dto.getCode());
		}
		// 所属专业
		Cell majorId = sheet1.getRow(4).getCell(5);
		majorId.setCellType(Cell.CELL_TYPE_STRING);
		majorId.setCellValue("");
		int majorIdId = dto.getMajorId();
		for (int i = 0; i < majorIdList.size(); ++i) {
			tmp = majorIdList.get(i).getId();
			if (tmp == majorIdId) {
				majorId.setCellValue(majorIdList.get(i).getName());
				break;
			}
		}
		// 担任职位
		Cell nowPosition = sheet1.getRow(4).getCell(7);
		nowPosition.setCellType(Cell.CELL_TYPE_STRING);
		nowPosition.setCellValue("");
		if (!dto.getNowPosition().trim().equals(""))
			nowPosition.setCellValue(dto.getNowPosition());
		// 职称
		Cell titleType = sheet1.getRow(4).getCell(9);
		titleType.setCellType(Cell.CELL_TYPE_STRING);
		titleType.setCellValue("");
		int titleTypeId = dto.getTitleType();
		for (int i = 0; i < titleTypeList.size(); ++i) {
			tmp = titleTypeList.get(i).getId();
			if (tmp == titleTypeId) {
				titleType.setCellValue(titleTypeList.get(i).getName());
			}
		}
		// 部门
		Cell dept = sheet1.getRow(5).getCell(9);
		dept.setCellType(Cell.CELL_TYPE_STRING);
		dept.setCellValue("");
		int deptId = dto.getDepartmentId();
		for (int i = 0; i < titleTypeList.size(); ++i) {
			tmp = deptList.get(i).getId();
			if (tmp == deptId) {
				dept.setCellValue(deptList.get(i).getName());
			}
		}
		// 教职工类型
		Cell staffType = sheet1.getRow(5).getCell(1);
		staffType.setCellType(Cell.CELL_TYPE_STRING);
		staffType.setCellValue("");
		int staffTypeId = dto.getStaffType();
		for (int i = 0; i < staffTypeList.size(); ++i) {
			tmp = staffTypeList.get(i).getId();
			if (tmp == staffTypeId) {
				staffType.setCellValue(staffTypeList.get(i).getName());
			}
		}
		// 职位状态
		Cell positionType = sheet1.getRow(5).getCell(3);
		positionType.setCellType(Cell.CELL_TYPE_STRING);
		positionType.setCellValue("");
		int positionTypeId = dto.getPositionType();
		for (int i = 0; i < positionTypeList.size(); ++i) {
			tmp = positionTypeList.get(i).getId();
			if (tmp == positionTypeId) {
				positionType.setCellValue(positionTypeList.get(i).getName());
			}
		}
		// 参加工作日期
		Cell workStartTime = sheet1.getRow(5).getCell(5);
		workStartTime.setCellType(Cell.CELL_TYPE_STRING);
		workStartTime.setCellValue("");
		// 判断
		workStartTime.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
				.format(new java.util.Date(dto.getWorkStartTime().getTime())));
		// 在本校任职日期
		Cell takeOfficeTime = sheet1.getRow(5).getCell(7);
		takeOfficeTime.setCellType(Cell.CELL_TYPE_STRING);
		takeOfficeTime.setCellValue("");
		// 判断
		takeOfficeTime.setCellValue(new SimpleDateFormat("yyyy-MM-dd")
				.format(new java.util.Date(dto.getTakeOfficeTime().getTime())));
		// 教育类型
		Cell educationType = sheet1.getRow(6).getCell(1);
		educationType.setCellType(Cell.CELL_TYPE_STRING);
		educationType.setCellValue("");
		Integer educationTypeId = dto.getEducationType();
		if (educationTypeId != null && educationTypeId != 0)
			for (int i = 0; i < educationTypeList.size(); ++i) {
				tmp = educationTypeList.get(i).getId();
				if (tmp == educationTypeId) {
					educationType.setCellValue(educationTypeList.get(i)
							.getName());
				}
			}
		// 毕业学校
		Cell school = sheet1.getRow(6).getCell(3);
		school.setCellType(Cell.CELL_TYPE_STRING);
		school.setCellValue("");
		String schoolName = dto.getSchool();
		if (schoolName != null && !schoolName.trim().equals("")) {
			school.setCellValue(dto.getSchool());
		}
		// 所学专业
		Cell major = sheet1.getRow(6).getCell(5);
		major.setCellType(Cell.CELL_TYPE_STRING);
		major.setCellValue("");
		String majorName = dto.getMajor();
		if (majorName != null && !majorName.trim().equals("")) {
			major.setCellValue(dto.getMajor());
		}
		// 开始时间
		Cell startDate = sheet1.getRow(6).getCell(7);
		startDate.setCellType(Cell.CELL_TYPE_STRING);
		startDate.setCellValue("");
		// 判断
		if (dto.getStartDate() != null) {
			String startTimeStr = new SimpleDateFormat("yyyy-MM-dd")
					.format(new java.util.Date(dto.getStartDate().getTime()));
			if (startTimeStr != null)
				startDate.setCellValue(startTimeStr);
		}
		// 结束时间
		Cell endDate = sheet1.getRow(7).getCell(7);
		endDate.setCellType(Cell.CELL_TYPE_STRING);
		endDate.setCellValue("");
		// 判断
		if (dto.getEndDate() != null) {
			String endTimeStr = new SimpleDateFormat("yyyy-MM-dd")
					.format(new java.util.Date(dto.getEndDate().getTime()));
			if (endTimeStr != null)
				endDate.setCellValue(endTimeStr);
		}
		// 学历
		Cell degreeType = sheet1.getRow(6).getCell(9);
		degreeType.setCellType(Cell.CELL_TYPE_STRING);
		degreeType.setCellValue("");
		Integer degreeTypeId = dto.getDegreeType();
		if (degreeTypeId != null && degreeTypeId != 0)
			for (int i = 0; i < degreeTypeList.size(); ++i) {
				tmp = degreeTypeList.get(i).getId();
				if (tmp == degreeTypeId) {
					degreeType.setCellValue(degreeTypeList.get(i).getName());
					break;
				}
			}
		// 基本备注
		Cell remarkOfTeacher = sheet1.getRow(8).getCell(1);
		remarkOfTeacher.setCellType(Cell.CELL_TYPE_STRING);
		remarkOfTeacher.setCellValue("");
		if (!dto.getRemarkOfTeacher().trim().equals(""))
			remarkOfTeacher.setCellValue(dto.getRemarkOfTeacher());
		// 详细备注
		Cell remarkOfInfo = sheet1.getRow(10).getCell(1);
		remarkOfInfo.setCellType(Cell.CELL_TYPE_STRING);
		remarkOfInfo.setCellValue("");
		if (!dto.getRemark().trim().equals(""))
			remarkOfInfo.setCellValue(dto.getRemark());

		// 教育经历备注
		Cell remarkOfEduExp = sheet1.getRow(12).getCell(1);
		remarkOfEduExp.setCellType(Cell.CELL_TYPE_STRING);
		remarkOfEduExp.setCellValue("");
		if (dto.getRemarkOfTeaEdu() != null
				&& !dto.getRemarkOfTeaEdu().trim().equals(""))
			remarkOfEduExp.setCellValue(dto.getRemarkOfTeaEdu());

		System.out.println("合并行的第一行: "
				+ sheet1.getMergedRegion(0).getFirstRow());
		System.out
				.println("合并行的最后行: " + sheet1.getMergedRegion(0).getLastRow());
		System.out.println("合并行的第一列: "
				+ sheet1.getMergedRegion(0).getFirstColumn());
		System.out.println("合并行的最后列: "
				+ sheet1.getMergedRegion(0).getLastColumn());
		wb.write(out);
		// 关闭流
		in.close();
		out.close();
		return 1;
	}

	private TeacherTotalInfoDto searchTeacherTotalInfoByTeacherId(int teacherId) {

		return teaMapper.searchTeacherTotalInfoByTeacherId(teacherId);
	}

	@Override
	public TeacherTotalInfoDto searchTeacherTotalInfoDtoById(int id) {

		return teaMapper.searchTeacherTotalInfoByTeacherId(id);
	}

	@Override
	public int addTeacherEduExp(TeacherEduExperienceDto eduExp) {
		// TODO Auto-generated method stub
		eduExp.setStartDateStr(new SimpleDateFormat("yyyy-MM-dd").format(eduExp
				.getStartDate()));
		eduExp.setEndDateStr(new SimpleDateFormat("yyyy-MM-dd").format(eduExp
				.getEndDate()));
		int result = teaMapper.insertNewTeacherEduExp(eduExp);
		if (result == 1)
			result = teaMapper.updateTeacherInfoDegreeType(eduExp
					.getTeacherId());
		return result;
	}

	// 填充str字段
	public void dtoListToDtoStrList(List<TeacherTotalInfoDto> dtoList) {
		for (int i = 0; i < dtoList.size(); ++i) {
			System.out.println("count:"+dtoList.size());
			// 出生日期
			if (dtoList.get(i).getBirthday() != null)
				dtoList.get(i).setBirthdayStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList
								.get(i).getBirthday()));
			// 从教日期
			if (dtoList.get(i).getWorkStartTime() != null)
				dtoList.get(i).setWorkStartTimeStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList
								.get(i).getWorkStartTime()));
			
			
			
		}
	}
	@Override
	public void dtoListChangeToDtoStrList(List<TeacherTotalInfoDto> dtoList) {
		for (int i = 0; i < dtoList.size(); ++i) {
			System.out.println("count:"+dtoList.size());
			// 出生日期
			if (dtoList.get(i).getBirthday() != null)
				dtoList.get(i).setBirthdayStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList
								.get(i).getBirthday()));
			// 从教日期
			if (dtoList.get(i).getWorkStartTime() != null)
				dtoList.get(i).setWorkStartTimeStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList
								.get(i).getWorkStartTime()));
			
			
			// 家属生日
			for (int j = 0; j < dtoList.get(i).getTeaFamilyDtoList().size(); ++j) {
				if (dtoList.get(i).getTeaFamilyDtoList().get(j).getBirthday() != null)
					dtoList.get(i).getTeaFamilyDtoList().get(j).setBirthdayStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList.get(i).getTeaFamilyDtoList().get(j).getBirthday()));			
			
			}
			
			// 教育经历开始时间
			for (int m = 0; m < dtoList.get(i).getTeaEduExpDtoList().size(); ++m) {
				if (dtoList.get(i).getTeaEduExpDtoList().get(m).getStartDate() != null)
					dtoList.get(i).getTeaEduExpDtoList().get(m).setStartDateStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList.get(i).getTeaEduExpDtoList().get(m).getStartDate()));			
			
			}	
			// 教育经历结束时间
			for (int m = 0; m < dtoList.get(i).getTeaEduExpDtoList().size(); ++m) {
				if (dtoList.get(i).getTeaEduExpDtoList().get(m).getEndDate() != null)
					dtoList.get(i).getTeaEduExpDtoList().get(m).setEndDateStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList.get(i).getTeaEduExpDtoList().get(m).getEndDate()));			
			
			}	
			
			// 简历工作开始时间
			for (int g = 0; g < dtoList.get(i).getTeaWorkExprience().size(); ++g) {
				if (dtoList.get(i).getTeaWorkExprience().get(g).getStartDate() != null)
					dtoList.get(i).getTeaWorkExprience().get(g).setStartDateStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList.get(i).getTeaWorkExprience().get(g).getStartDate()));			
			
			}			
			
			//  简历工作结束时间
			for (int k = 0; k < dtoList.get(i).getTeaWorkExprience().size(); ++k) {
				if (dtoList.get(i).getTeaWorkExprience().get(k).getEndDate() != null)
					dtoList.get(i).getTeaWorkExprience().get(k).setEndDateStr(
						new SimpleDateFormat("yyyy-MM-dd").format(dtoList.get(i).getTeaWorkExprience().get(k).getEndDate()));			
			
			}				
			
			

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public long addTeacherTotalInfoByExcel(InputStream inputStream, String format) throws BadSqlGrammarException,IllegalStateException{

		// 所属专业
		List<Major> majorList = majorService.getAllMajorInfo();
		// 职称
		List<EnumerationValue> titleTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_TITLE_TYPE);
		// 教职工类型
		List<EnumerationValue> staffTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_STAFF_TYPE);
		// 职位状态
		List<EnumerationValue> positionTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.POSITION_TYPE);
		// 性别
		List<EnumerationValue> sexTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		// 证件类型
		List<EnumerationValue> idCardTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.ID_CARD_TYPE);
		// 国籍
		List<EnumerationValue> countryList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.COUNTRY_ID);
		// 民族
		List<EnumerationValue> nationList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);
		// 政治面貌
		List<EnumerationValue> politicalFeatureTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE);
		// 婚姻状态
		List<EnumerationValue> maritalStatusList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.MARITAL_STATUS);
		// 户籍类型
		List<EnumerationValue> householdTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE);
		// 学历
		List<EnumerationValue> degreeTypeList = enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE);
		// 所属部门
		List<Department> departmentList = deptService.findAllDepartment();

		List<TeacherTotalInfoDto> dtoList = new ArrayList<TeacherTotalInfoDto>();
		List<TeacherTotalInfoDto> updList = new ArrayList<TeacherTotalInfoDto>();

		// 创建workbook
		Workbook wb = null;
		if (format.equalsIgnoreCase("xls"))
			try {
				wb = new HSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if (format.equalsIgnoreCase("xlsx")){

			try {
				wb = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		boolean flag = false; //空行,忽略
		boolean exit = false;  //工号已存在，更新
		// dtoListToDtoStrList
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		int rowIndex = 1;
		while (rows.hasNext()) {
			
			Row row = rows.next();
			System.out.println("firstCellNumber:" + row.getFirstCellNum() + ", ");
			System.out.println("lastCellNumber:" + row.getLastCellNum() + ", ");
			if (row.getRowNum() == 0) {
				continue;
			}

	//		Iterator<Cell> cells = row.cellIterator();
			// 创建一个TeacerTotalInfoDto
			TeacherTotalInfoDto dto = new TeacherTotalInfoDto();
	//		int index = 0;
			
			
			for (int index = 0; index < row.getLastCellNum(); ++index) {
				
	//		while (cells.hasNext()) {
				
				Cell cell = row.getCell(index);//cells.next();
		//		System.out.println("第" + cell.getRowIndex() + "行!");
				if (index == 0) { // 姓名

			//		cell.setCellType(Cell.CELL_TYPE_STRING);
					
			//		if (cell != null) {
						
						if (cell == null || cell.getStringCellValue() == null || cell.getStringCellValue().trim().equals("")) {
							flag = true;//为空行
							break;
						}
						String name = cell.getStringCellValue();
						System.out.println("姓名: " + name);
						dto.setName(name);
			//		}
				} else if (index == 1) { // 工号

			//		if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("工号-------------------：" + name);
						name = name.trim();
						//判断工号是否已存在
						TeacherDto tea = teaMapper.findTeacher(name);
						if (tea != null) 
							exit = true;
						System.out.println("工号:" + name);
						dto.setCode(name);
			//		}
				} else if (index == 2) { // 所属专业

					if (cell != null) {
						
						boolean find = false;
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("专业:" + name);
						for (int i = 0; i < majorList.size(); ++i) {
							if (name.trim().equals(majorList.get(i).getName())) {
								dto.setMajorId(majorList.get(i).getId());
								find = true;
								break;
							}
						}
						if (!find)
							return -1000 - rowIndex;//所属专业不存在(找不到)
					}
				} else if (index == 3) { // 担任职位

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("职位: " + name);
						dto.setNowPosition(name);
					}
				} else if (index == 4) { // 职称

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String titleType = cell.getStringCellValue();
						System.out.println("职称: " + titleType);
						for (int i = 0; i < titleTypeList.size(); ++i) {
							if (titleType.trim().equals(
									titleTypeList.get(i).getName())) {
								dto.setTitleType(titleTypeList.get(i).getId());
								break;
							}
						}
					}
				} else if (index == 5) { // 教职工类型

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("教职工类型: " + name);
						for (int i = 0; i < staffTypeList.size(); ++i) {
							if (name.trim().equals(staffTypeList.get(i).getName())) {
								dto.setStaffType(staffTypeList.get(i).getId());
								break;
							}
						}
					}
				} else if (index == 6) { // 职位状态

					if (cell != null){
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("职位状态: " + name);
						for (int i = 0; i < positionTypeList.size(); ++i) {
							if (name.trim().equals(
									positionTypeList.get(i).getName())) {
								dto.setPositionType(positionTypeList.get(i).getId());
								break;
							}
						}
					}
				} else if (index == 7) { // 参加工作日期
					
					if (cell != null) {
						
						java.util.Date date = null;
						if (cell.getDateCellValue() != null)
							date = cell.getDateCellValue();
						else
							date = new java.util.Date(0001, 1, 1);
						String name = new SimpleDateFormat("yyyy-MM-dd")
								.format(date);
						System.out.println("参加工作日期:" + name);
						dto.setWorkStartTimeStr(name);
						System.out.println("workDate:" + name);
						dto.setWorkStartTime(date);
					}
				} else if (index == 8) { // 在本校任职日期

					if (cell != null) {
						
						java.util.Date date = null;
						//		System.out.println("任职日期: " + cell.getStringCellValue());
						if (cell.getDateCellValue() != null)
							date = cell.getDateCellValue();
						else
							date = new java.util.Date(0001, 1, 1);
						String name = new SimpleDateFormat("yyyy-MM-dd")
								.format(date);
						System.out.println("本校工作日期:" + name);
						dto.setTakeOfficeTimeStr(name);
						dto.setTakeOfficeTime(date);
					}
				} else if (index == 9) { // 教职工备注
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setRemarkOfTeacher("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setRemarkOfTeacher(cell.getStringCellValue());
						}
					}
				} else if (index == 10) { // 性别

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String sex = cell.getStringCellValue();
						if (sex.trim().equals("男"))
							dto.setSexType(1001);
						else if (sex.trim().equals("女"))
							dto.setSexType(1002);
					}
				} else if (index == 11) { // 出生日期

					if (cell != null) {
						
						java.util.Date date = null;
						if (cell.getDateCellValue() != null)
							date = cell.getDateCellValue();
						else
							date = new java.util.Date(0001, 1, 1);
						String name = new SimpleDateFormat("yyyy-MM-dd")
								.format(date);
						System.out.println("chusheng日期:" + name);
						dto.setBirthdayStr(name);
						dto.setBirthday(date);
					}
				} else if (index == 12) { // 证件类型

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						for (int i = 0; i < idCardTypeList.size(); ++i) {
							if (name.trim().equals(idCardTypeList.get(i).getName())) {
								dto.setIdCardType(idCardTypeList.get(i).getId());
								break;
							}
						}
					}
				} else if (index == 13) { // 证件号码

			//		if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						dto.setIdCard(cell.getStringCellValue());
			//		}
				} else if (index == 14) { // 国籍

			//		if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						for (int i = 0; i < countryList.size(); ++i) {
							if (name.trim().equals(countryList.get(i).getName())) {
								dto.setCountryId(countryList.get(i).getId());
								break;
							}
						}
			//		}
				} else if (index == 15) { // 民族
					
			//		Cell cell = row.getCell(index);
			//		System.out.println("民族: " + cell.getStringCellValue());
			//		cell.setCellType(Cell.CELL_TYPE_STRING);
		//			if (cell != null) {
						
						if (cell == null || cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setNationType(0);
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String name = cell.getStringCellValue();
							for (int i = 0; i < nationList.size(); ++i) {
								if (name.trim().equals(nationList.get(i).getName())) {
									dto.setNationType(nationList.get(i).getId());
									break;
								}
							}
						}
			//		}
				} else if (index == 16) { // 政治面貌

			//		if ( cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						for (int i = 0; i < politicalFeatureTypeList.size(); ++i) {
							if (name.trim().equals(
									politicalFeatureTypeList.get(i).getName())) {
								dto.setPoliticalFeatureType(politicalFeatureTypeList
										.get(i).getId());
								break;
							}
						}
			//		}
				} else if (index == 17) { // 籍贯

			//		if ( cell != null ) {
						
						if (cell == null || cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setNativePlace("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setNativePlace(cell.getStringCellValue());
						}
			//		}
					
				} else if (index == 18) { // 婚姻状况

			//		if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						for (int i = 0; i < maritalStatusList.size(); ++i) {
							if (name.trim().equals(
									maritalStatusList.get(i).getName())) {
								dto.setMaritalStatus(maritalStatusList.get(i)
										.getId());
								break;
							}
						}
			//		} else {
			//			dto.setMaritalStatus(0);
			//		}
				} else if (index == 19) { // 户籍类型

			//		if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("户籍类型:" + name);
						for (int i = 0; i < householdTypeList.size(); ++i) {
							if (name.trim().equals(
									householdTypeList.get(i).getName())) {
								dto.setHouseholdType(householdTypeList.get(i)
										.getId());
								break;
							}
						}
			//		} else {
			//			dto.setHouseholdType(0);
			//		}
				} else if (index == 20) { // 学历

			//		if ( cell != null ) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						for (int i = 0; i < degreeTypeList.size(); ++i) {
							if (name.trim().equals(degreeTypeList.get(i).getName())) {
								dto.setDegreeType(degreeTypeList.get(i).getId());
								break;
							}
						}
			//		}
				} else if (index == 21) { // 家庭地址
					
					if (cell != null) {
						
						if (cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setFamilyAddress("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setFamilyAddress(cell.getStringCellValue());
						}
					}
					
				} else if (index == 22) { // 邮政编码
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell.getStringCellValue() == null || cell.getStringCellValue().trim().equals("")) {
							dto.setPostcode("");
						}
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setPostcode(cell.getStringCellValue());
						}
					}
					else {
						dto.setPostcode("");
					}
					
					
				} else if (index == 23) { // 家庭电话

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell.getStringCellValue() == null || cell.getStringCellValue().trim().equals(""))
							dto.setFamilyAddress("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setFamilyPhone(cell.getStringCellValue());
						}
					} else {
						dto.setFamilyAddress("");
					}
					
				} else if (index == 24) { // 办公电话

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setOfficePhone("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setOfficePhone(cell.getStringCellValue());
						}
					} else {
						dto.setOfficePhone("");
					}
					
					
				} else if (index == 25) { // 移动电话
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell == null || cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setMobilePhone("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String name = cell.getStringCellValue();
							System.out.println("移动电话: " + name);
							dto.setMobileOfUser(name);
							dto.setMobilePhone(name);
						}
					} else {
						dto.setMobilePhone("");
					}
					
					
				} else if (index == 26) { // 电子邮箱

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setEmail("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setEmail(cell.getStringCellValue());
						}
					} else {
						dto.setEmail("");
					}
					
				} else if (index == 27) { // 所属部门

					if (cell != null) {
						
						boolean find = false;
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						for (int i = 0; i < departmentList.size(); ++i) {
							if (name.trim().equals(departmentList.get(i).getName())) {
								dto.setDepartmentId(departmentList.get(i).getId());
								find = true;
								break;
							}
						}
						if (!find) {
							return -10000 - rowIndex;//找不到该部门
						}
					} else {
						;
					}
					
					
				} else if (index == 28) { // 详细信息备注备注

					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (cell.getStringCellValue() == null ||cell.getStringCellValue().trim().equals(""))
							dto.setRemark("");
						else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							dto.setRemark(cell.getStringCellValue());
						}
					} else {
						dto.setRemark("");
					} 
				}

		//		index++;
			}
			System.out.println(dto.toString());
			if (!flag && !exit) //不为空行且工号不存在则插入
				dtoList.add(dto);
			if (!flag && exit) //不为空行且工号尊在则更新
				updList.add(dto);
			//还原
			flag = false;
			exit = false;
			rowIndex ++;
		}
		
		this.dtoListToDtoStrList(dtoList);
		this.dtoListToDtoStrList(updList);
		System.out.println("dtoSize: " + dtoList.size() + "\nupdSize: " + updList.size());
		// 插入教师表
		int c  = 0;
		int cc  = 0;
		if (dtoList.size() > 0) {
			c = teaMapper.addTeacherByList(dtoList);
			if (c != dtoList.size()) { //插入教师失败 
				teaMapper.deleteTeacherByList(dtoList);
				return -3;
			}
		}
		// 更新教师表
		if (updList.size() > 0)
			cc = teaMapper.updateTeacherByList(updList);
		
		//得到teacherId数组
		List<Integer> teacherIdOfDto = null;
		List<Integer> teacherIdOfUpd = null;
		if (dtoList.size() > 0 && updList.size() == 0)
			teacherIdOfDto = teaMapper.getTeacherIdArrByList(dtoList);
		else if (dtoList.size() == 0 && updList.size() > 0)
			teacherIdOfUpd = teaMapper.getTeacherIdArrByList(updList);
		else if (dtoList.size() > 0 && updList.size() > 0) {
			teacherIdOfDto = teaMapper.getTeacherIdArrByList(dtoList);
			teacherIdOfUpd = teaMapper.getTeacherIdArrByList(updList);
			
		} else {
			return 0;
		}
		System.out.println("teacherIdOfDto: " + teacherIdOfDto);
		System.out.println("teacherIdOfUpd: " + teacherIdOfUpd);
		//设置teacherId
		if (dtoList.size() > 0)
			for (int i = 0; i < dtoList.size(); ++i) {
				dtoList.get(i).setTeacherId(teacherIdOfDto.get(i));
			}
		if (updList.size() > 0)
			for (int i = 0; i < updList.size(); ++i) {
				updList.get(i).setTeacherId(teacherIdOfUpd.get(i));
			}
		// 插入教师信息表
		int a = 0;
		int aa = 0;
		if (dtoList.size() > 0) {
			a = teaMapper.addTeacherInfoByExcel(dtoList);
			if (a != dtoList.size()) { //插入不成功
				teaMapper.deleteTeacherByList(dtoList);
				teaMapper.deleteTeacherInfoByList(dtoList);
				return -3;
			}
		}
		if (updList.size() > 0) 
		// 更新教师信息表
			aa = teaMapper.updateTeacherInfoByExcel(updList);;

		// 插入用户表
		int b = 0;
		int bb = 0;
		if (dtoList.size() > 0)
			b = teaMapper.addUserByExcel(dtoList);
		// 更新用户表
		if (updList.size() > 0)
			bb = teaMapper.updateUserByExcel(updList);

		// 更新教师表的userId
		if (dtoList.size() > 0) {
			System.out.println("开始更新教师表的userId: ");
			List<Integer> userId = teaMapper.getUserIdArrByList(dtoList);
			System.out.println("userId: " + userId);
			for (int i = 0; i < dtoList.size(); ++i) {
				dtoList.get(i).setUserId(userId.get(i));
			}
			teaMapper.updateUserIdByList(dtoList);
		}
		
		if (dtoList.size() > 0 && updList.size() == 0)
			return teaMapper.updateUserIdByList(dtoList);
		else if (updList.size() > 0 && dtoList.size() == 0)
			return bb + 10000;
		else if(dtoList.size() > 0 && updList.size() > 0) {
			int dtoRes = 10000 + dtoList.size();
			int updRes = 10000 + updList.size();
			System.out.println("test: " + Long.parseLong(dtoRes + "" + updRes));
			return Long.parseLong(dtoRes + "" + updRes);
		}
		else 
			return -3; // 格式错误
	}

	//
	@Override
	public TeacherTotalInfoDto searchTeacherAllInfoDtoById(int id) {
		return teaMapper.searchTeacherAllInfoByTeacherId(id);
	}

}
