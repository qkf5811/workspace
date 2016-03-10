package com.dkt.school.stu.service.impl;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.common.util.DateUtil;
import com.dkt.school.sch.dao.MajorFieldCustomMapper;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dao.StudentInfoCustomMapper;
import com.dkt.school.stu.dto.StudentInfoDto;
import com.dkt.school.stu.dto.StudentInfoListDto;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.model.StudentExample;
import com.dkt.school.stu.model.StudentInfo;
import com.dkt.school.stu.service.StudentInfoService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoCustomMapper studentInfoCustomMapper;

	@Autowired
	private StudentCustomMapper studentCustomMapper;

	@Autowired
	private MajorFieldCustomMapper majorFieldCustomMapper;

	@Autowired
	private EnumerationService enumerationService;

	// 手工添加招生信息
	public int addStudentInfo(StudentInfo si) {
		int result = 0;
		StudentInfo info = null;
		
		if (si != null) {
			if (si.getStudentNumber() != null && !"".equals(si.getStudentNumber())) {
				// 根据学籍号判断学生是否存在
				info = studentInfoCustomMapper.findStudentInfoByStudentNumber(si.getStudentNumber());
				if (info == null) {
					if (si.getIdCard() != null && !"".equals(si.getIdCard())) {
						// 根据身份证判断学生是否存在
						info = studentInfoCustomMapper.findStudentinfoByIdCard(si.getIdCard());
						if (info != null) {
							// 身份证号已存在
							result = -3;
						}
					}
					studentInfoCustomMapper.insert(si);
					result = 1;
				} else {
					// 学籍号已存在
					result = -2;
				}
				
			} else {
				// 学籍号不能为空
				result = -1;
			}
		} else {
			// 学生信息不完整
			result = -1;
		}
		return result;
	}

	// 根据excel文件批量导入招生信息
	public long addStuInfoByExcel(InputStream in, String format) {

		List<StudentInfo> stuList = new ArrayList<StudentInfo>();
		
		List<StudentInfo> updList = new ArrayList<StudentInfo>();
		// 创建workbook
		Workbook wb = null;
		if (format.equalsIgnoreCase("xls"))
			try {
				wb = new HSSFWorkbook(in);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		else if (format.equalsIgnoreCase("xlsx")){
			try {
				wb = new XSSFWorkbook(in);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		// 民族map
		Map<Integer, String> nationMap = new HashMap<Integer, String>();
		List<EnumerationValue> nationList = enumerationService.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);
		for (int i = 0; i < nationList.size(); ++i) {
			nationMap.put(i, nationList.get(i).getName());
		}
		// 专业方向list
		List<MajorField> majorFieldList = majorFieldCustomMapper
				.getAllMajorFieldInfo();
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		
		boolean flag = false; //空行,忽略
		boolean exist = false; 
		int rowIndex = 1;
		while (rows.hasNext()) {

			Row row = rows.next();
			if (row.getRowNum() == 0)
				continue;
			// row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);

			StudentInfo stuInfo = new StudentInfo();
			stuInfo.setIsDivideClass(2002);
			stuInfo.setStudyStatus(45001);//设置学生基本信息的就读状态为"未入读"

	//		Iterator<Cell> cells = row.cellIterator();

			int index = 0;
			Cell cell = null;
	//		while (cells.hasNext()) {
		//	System.out.println("最后单元格下标:" + row.getLastCellNum());
			for (index = 0; index < row.getLastCellNum(); ++index) {

		//		System.out.println("当前下标:" + index);
				cell = row.getCell(index);
				
				if (index == 0) { // 姓名
					if (cell != null) {
						
					//	cell = cells.next();
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setName(cell.getStringCellValue());
					} else {
						flag = true;
					}
				} else if (index == 1) { // 性别
					
				//	cell = cells.next();
					if (cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int sex = 0;
						String str = cell.getStringCellValue();
						if (str.equals("男") || str.equals("男性"))
							sex = 1001;
						else if (str.equals("女") || str.equals("女性"))
							sex = 1002;
						else {
							return -3;
						}
						stuInfo.setSexType(sex);
					}
				} else if (index == 2) { // 出生日期

					cell = row.getCell(index);
					if (cell != null) {
						
						java.util.Date born = cell.getDateCellValue();
						java.sql.Date date = new java.sql.Date(born.getTime());
						stuInfo.setBirthday(date);
					} else {
						;
					}

				} else if (index == 3) { // 身份证号
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						stuInfo.setIdCard(name);
						//根据身份证号码查询学生，不存在则插入，否则更新
						StudentInfo tmp = studentInfoCustomMapper.findStudentinfoByIdCard(name);
						if (tmp != null) {
							exist = true;
						}
					}
				} else if (index == 4) { // 民族
				
					//cell = cells.next();
					cell = row.getCell(index);
					
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						for (int i = 0; i < nationList.size(); ++i) {
							if (cell.getStringCellValue().trim()
									.equals(nationMap.get(i))) {
								stuInfo.setNationType(nationList.get(i).getId());
								break;
							}
						}
					}
				} else if (index == 5) { // 政治面貌
				
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String str = cell.getStringCellValue().trim();
						int type = 0;
				//		System.out.println("政治面貌:" + str);
						if (str.equals("共青团员") || str.equals("团员")) {
							type = 6001;
						} else if (str.equals("群众") || str.equals("")) {
							type = 6002;
						} else if (str.equals("中共党员") || str.equals("党员")) {
							type = 6003;
						}
						stuInfo.setPoliticalFeatureType(type);
					} else {
				//		System.out.println("政治面貌为空!");
						return -3;//学生信息格式错误
					}
				} else if (index == 6) { // 是否是港澳侨胞
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int type = 0;
						String str = cell.getStringCellValue().trim();
						if (str.equals("是"))
							type = 2001;
						else if (str.equals("否"))
							type = 2002;
						stuInfo.setIsHkMc(type);
					}
				} else if (index == 7) {// 籍贯
			
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setNativePlace(cell.getStringCellValue());
					} else {
						stuInfo.setNativePlace("");
					}
				} else if (index == 8) { // 户籍类型
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
				
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int type = 0;
						String str = cell.getStringCellValue().trim();
						if (str.equals("城市") || str.equals("城镇"))
							type = 7001;
						else if (str.equals("农村"))
							type = 7002;
						else if (str.equals("县镇非农"))
							type = 7003;
						stuInfo.setHouseholdType(type);
					}
				} else if (index == 9) { // 户口所在地
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setHouseholdLocation(cell.getStringCellValue()
							.trim());
					} else {
						stuInfo.setHouseholdLocation("");
					}
				} else if (index == 10) {// 家庭住址
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setFamilyAddress(cell.getStringCellValue().trim());
					} else {
						stuInfo.setFamilyAddress("");
					}
				} else if (index == 11) { // 邮政编码
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setPostcode(cell.getStringCellValue().trim());
					} else {
						stuInfo.setPostcode("");
					}
				} else if (index == 12) { // 家庭电话
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setFamilyPhone(cell.getStringCellValue().trim());
					} else {
						stuInfo.setFamilyPhone("");
					}
				} else if (index == 13) { // 考生类别
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int type = 0;
						String str = cell.getStringCellValue().trim();
						if (str.equals("初中应届生"))
							type = 8001;
						else if (str.equals("初中往届生"))
							type = 8002;
						else if (str.equals("高中应届生"))
							type = 8003;
						else if (str.equals("高中往届生"))
							type = 8004;
						stuInfo.setExamineeType(type);
					} else {
						stuInfo.setExamineeType(0);
					}
				} else if (index == 14) { // 毕业学校
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setGraduationSchool(cell.getStringCellValue());
					} else {
						stuInfo.setGraduationSchool("");
					}
				} else if (index == 15) { // 所报专业方向
					
					int type = 0;
				//	cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
						
						boolean find = false;
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String str = cell.getStringCellValue().trim();
						for (int i = 0; i < majorFieldList.size(); ++i) {
							if (str.equals(majorFieldList.get(i).getName())) {
								type = majorFieldList.get(i).getId();
								find = true;
								break;
							}
						}
						if (!find)
							return -10000 - rowIndex;//所属专业方向不存在
						else
							stuInfo.setMajorFieldId(type);
					} else {
						return -3;
					}
				} else if (index == 16) {// 入学总分
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setExamTotalScore((int) Double.parseDouble(cell
								.toString()));
						// stuInfo.setExamTotalScore((int)cell.getNumericCellValue());
					} else {
						;
					}
				} else if (index == 17) {// 学习形式
					
				//	cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int type = 0;
						String str = cell.getStringCellValue().trim();
						if (str.equals("全日制"))
							type = 9001;
						stuInfo.setStudyType(type);
					} else {
						stuInfo.setStudyType(9001);
					}
				} else if (index == 18) {// 入学方式
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int type = 0;
						String str = cell.getStringCellValue().trim();
						if (str.equals("普通入学") || str.equals(""))
							type = 10001;
						stuInfo.setEnterSchoolType(type);
					} else {
						stuInfo.setEnterSchoolType(10001);
					}
				} else if (index == 19) {// 招生起点
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						int type = 0;
						String str = cell.getStringCellValue().trim();
						if (str.equals("小学"))
							type = 4001;
						else if (str.equals("初中"))
							type = 4002;
						else if (str.equals("高中"))
							type = 4003;
						stuInfo.setEduStageType(type);
					}
				} else if (index == 20) {// 备注
					
					//cell = cells.next();
					cell = row.getCell(index);
					if (cell != null) {
					
						cell.setCellType(Cell.CELL_TYPE_STRING);
						stuInfo.setRemark(cell.getStringCellValue());
					} else {
						stuInfo.setRemark("");
					}
				} else {
					break;
				}
			//	index++;
			}
			
			if (!flag) { //不为空行 
				if (!exist)
					stuList.add(stuInfo);
				else {
				//	updList.add(stuInfo);
					return -1000000 - rowIndex;//该行的学生信息已存在，请核对身份证号
				}
			} else {
				;
			}
			//还原
			flag = false;
			exist = false;
			rowIndex ++;
		}
		
		if (stuList.size() > 0 && updList.size() > 0) {
			//既插入又更新
			for (StudentInfo stuInfo: stuList) {
				studentInfoCustomMapper.insert(stuInfo);
			}
			for (StudentInfo updInfo: updList) {
				studentInfoCustomMapper.updateByPrimaryKey(updInfo);
			}
			return (10000+stuList.size())* 10000+updList.size();
		} else if (stuList.size() > 0 && updList.size() == 0) {
			//插入学生信息
			for (StudentInfo student: stuList) {
				studentInfoCustomMapper.insert(student);
			}
			return 100000 + stuList.size();
		} else if (stuList.size() == 0 && updList.size() > 0) {
			//更新学生信息
			for (StudentInfo updInfo: updList) {
				studentInfoCustomMapper.updateByPrimaryKey(updInfo);
			}
			return 10000 + updList.size();
		}
	//	return studentInfoCustomMapper.insertStuInfoByExcelFile(stuList);
		return 0;
	}

	@Override
	public int getCountOfNewStudentInfo(String studentName) {
		return studentInfoCustomMapper.getCountOfNewStudentInfo(studentName);
	}

	@Override
	public List<StudentInfoDto> getNewStudentInfo(String studentName,
			PaginationCustom page) {
		return studentInfoCustomMapper.getNewStudentInfo(studentName, page.getLimitation());
	}

	@Override
	public void getStudentInfoDtoList(List<StudentInfoDto> studentInfoList) {
		for (StudentInfoDto studentInfo : studentInfoList) {
			//出生日期
			if (studentInfo.getBirthday() != null) {
				studentInfo.setBirthdayStr(DateUtil.toDateString(studentInfo.getBirthday()));
			}
			//入学日期
			if (studentInfo.getEntranceDate() != null) {
				studentInfo.setEntranceDateStr(DateUtil.toDateString(studentInfo.getEntranceDate()));
			}
		}
	}



	/**
	 * 根据专业方向id查看该专业方向的班数
	 * 作者：炳坚
	 */
	@Override
	public Integer getStudentCountByMajorFieldId(Integer majorFieldId) {
		// TODO Auto-generated method stub
		return studentInfoCustomMapper.getStudentCountByMajorFieldId(majorFieldId);
	}
	/**
	 * 根据专业方向id查找选该专业的所有男生
	 * 作者：炳坚
	 */
	@Override
	public List<StudentInfoDto> getManStudentsByMajorFieldId(
			Integer majorFieldId) {
		// TODO Auto-generated method stub
		return studentInfoCustomMapper.getManStudentsByMajorFieldId(majorFieldId);
	}
	/**
	 * 根据专业方向id查找选该专业的所有女生
	 * 作者：炳坚
	 */
	@Override
	public List<StudentInfoDto> getGirlStudentsByMajorFieldId(
			Integer majorFieldId) {
		// TODO Auto-generated method stub
		return studentInfoCustomMapper.getGirlStudentsByMajorFieldId(majorFieldId);
	}


	@Override
	public void toStudentInfoDtoList(List<StudentInfoDto> stuInfoList) {

		//民族
		List<EnumerationValue> nationList = enumerationService.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);

		//政治面貌
		List<EnumerationValue> politicalList = enumerationService.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE);

		//户籍类型
		List<EnumerationValue> houseHoldList = enumerationService.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE);

		//考生类型
		List<EnumerationValue> examineeTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.EXAMINEE_TYPE);

		//学习形式
		List<EnumerationValue> studyTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.STUDY_TYPE);

		//入学方式
		List<EnumerationValue> enterSchoolTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.ENTER_SCHOOL_TYPE);

		//招生起点
		List<EnumerationValue> eduStageTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.EDU_STAGE_TYPE);

		//专业方向信息
		List<MajorField> majorFieldList = majorFieldCustomMapper
				.getAllMajorFieldInfo();

		//开始
		for (int i = 0; i < stuInfoList.size(); ++i) {

			//性别设置
			if (stuInfoList.get(i).getSexType() == 1001)
				stuInfoList.get(i).setSexTypeStr("男");
			else
				stuInfoList.get(i).setSexTypeStr("女");
			//民族设置
			for (int j = 0; j < nationList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getNationType();
				int tmp2 = nationList.get(j).getId();
				if ( tmp1 == tmp2) {
					stuInfoList.get(i).setNationTypeStr(nationList.get(j).getName());
					break;
				}
			}
			//政治面貌
			for (int j = 0; j < politicalList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getPoliticalFeatureType();
				int tmp2 = politicalList.get(j).getId();
				if ( tmp1 == tmp2 ) {
					stuInfoList.get(i).setPoliticalFeatureTypeStr(politicalList.get(j).getName());
					break;
				}
			}
			//港澳侨胞
			if (stuInfoList.get(i).getIsHkMc() == 2001)
				stuInfoList.get(i).setIsHkMcStr("是");
			else
				stuInfoList.get(i).setIsHkMcStr("否");

			//户籍类型
			for (int j = 0; j < houseHoldList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getHouseholdType();
				int tmp2 = houseHoldList.get(j).getId();
				if ( tmp1 ==  tmp2 ) {
					stuInfoList.get(i).setHouseholdTypeStr(houseHoldList.get(j).getName());
					break;
				}
			}
			//考生类型
			for (int j = 0; j < examineeTypeList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getExamineeType();
				int tmp2 = examineeTypeList.get(j).getId();
				if ( tmp1 == tmp2 ) {
					stuInfoList.get(i).setExamineeTypeStr(examineeTypeList.get(j).getName());
					break;
				}
			}
			//专业方向
			for (int j = 0; j < majorFieldList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getMajorFieldId();
				int tmp2 = majorFieldList.get(j).getId();
				if ( tmp1 == tmp2 ) {
					stuInfoList.get(i).setMajorFieldIdStr(majorFieldList.get(j).getName());
					break;
				}
			}
			//学习形式
			for (int j = 0; j < studyTypeList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getStudyType();
				int tmp2 = studyTypeList.get(j).getId();
				if ( tmp1 == tmp2 ) {
					stuInfoList.get(i).setStudyTypeStr(studyTypeList.get(j).getName());
					break;
				}
			}
			//入学方式
			for (int j = 0; j < enterSchoolTypeList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getEnterSchoolType();
				int tmp2 = enterSchoolTypeList.get(j).getId();
				if ( tmp1 == tmp2 ) {
					stuInfoList.get(i).setEnterSchoolTypeStr(enterSchoolTypeList.get(j).getName());
					break;
				}
			}

			//招生起点
			for (int j = 0; j < eduStageTypeList.size(); ++j) {
				int tmp1 = stuInfoList.get(i).getEduStageType();
				int tmp2 = eduStageTypeList.get(j).getId();
				if ( tmp1 == tmp2 ) {
					stuInfoList.get(i).setEduStageTypeStr(eduStageTypeList.get(j).getName());
					break;
				}
			}
			//出生日期
			stuInfoList.get(i).setBirthdayStr(new SimpleDateFormat("yyyy-MM-dd").format(stuInfoList.get(i).getBirthday()));
		}
	}


	public int getStuCount(String name,String className,Integer sexType,Integer status,Integer studentStatus){
		return studentInfoCustomMapper.countBySearch(name, className, sexType, status,studentStatus);
	}

	public List<StudentInfoListDto> getStudentsByPage(String name,String className,Integer sexType,Integer status,Integer studentStatus,Pagination page) {
		return studentInfoCustomMapper.selectByLimit(name, className, sexType, status, studentStatus, page.getLimitation());
	}

	@Override
	public StudentInfoListDto getStudentByStudentId(int id) {
		return studentInfoCustomMapper.selectByStudentId(id);
	}

	@Override
	public int updateStudentInfo(StudentInfo studentInfo) {


		if(studentInfo!=null&&studentInfo.getId()!=null){
			StudentInfo studentInfoBasic =studentInfoCustomMapper.selectByStudentId(studentInfo.getId());



			//通过反射进行对象的非空属性值赋值
				try {
					Field[] fields=studentInfo.getClass().getDeclaredFields();
					for(int i=0;i<fields.length;i++) {
						fields[i].setAccessible(true);
						Object value = fields[i].get(studentInfo);
						if(value!=null){
							fields[i].set(studentInfoBasic,value);
						}
						fields[i].setAccessible(false);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}


			//根据学生基本信息表的id查询在籍生表的数据
			StudentExample studentExample=new StudentExample();
			StudentExample.Criteria criteria=studentExample.createCriteria();
			criteria.andStudentInfoIdEqualTo(studentInfo.getId());
			Student student=studentCustomMapper.selectByExample(studentExample).get(0);
			if(studentInfoBasic.getName().equals(student.getName())==false){
				student.setName(studentInfoBasic.getName());
				//更新在籍生的数据
				studentCustomMapper.updateByPrimaryKey(student);

			}

			//更新学生基本信息
			return studentInfoCustomMapper.updateByPrimaryKey(studentInfoBasic);

		}else{
			return 0;
		}




	}

}
