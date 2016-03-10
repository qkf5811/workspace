package com.dkt.school.stu.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.dkt.school.stu.dto.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dao.MajorFieldCustomMapper;
import com.dkt.school.stu.dao.AdmissionScoreCustomMapper;
import com.dkt.school.stu.dao.ClazzCustomMapper;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dao.StudentInfoCustomMapper;
import com.dkt.school.stu.model.Clazz;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.model.StudentExample;
import com.dkt.school.stu.model.StudentInfo;
import com.dkt.school.stu.service.StudentInfoService;
import com.dkt.school.stu.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentCustomMapper studentMapper;
	
	@Autowired
	private StudentCustomMapper studentCustomMapper;
	
	@Autowired
	private StudentInfoCustomMapper studentInfoMapper;
	
	@Autowired
	private ClazzCustomMapper clazzMapper;
	
	@Autowired
	private StudentInfoService studentinfoService;
	
	private AdmissionScoreCustomMapper admissionScoreCustomerMapper;
	@Autowired
	public void setAdmissionScoreCustomerMapper(
			AdmissionScoreCustomMapper admissionScoreCustomerMapper) {
		this.admissionScoreCustomerMapper = admissionScoreCustomerMapper;
	}
	public AdmissionScoreCustomMapper getAdmissionScoreCustomerMapper() {
		return admissionScoreCustomerMapper;
	}
	
	private MajorFieldCustomMapper majorFieldCustomMapper;
	@Autowired
	public void setMajorFieldCustomMapper(
			MajorFieldCustomMapper majorFieldCustomMapper) {
		this.majorFieldCustomMapper = majorFieldCustomMapper;
	}
	public MajorFieldCustomMapper getMajorFieldCustomMapper() {
		return majorFieldCustomMapper;
	}
	
	private StudentInfoCustomMapper studentInfoCustomerMapper;
	@Autowired
	public void setStudentInfoCustomerMapper(
			StudentInfoCustomMapper studentInfoCustomerMapper) {
		this.studentInfoCustomerMapper = studentInfoCustomerMapper;
	}
	public StudentInfoCustomMapper getStudentInfoCustomerMapper() {
		return studentInfoCustomerMapper;
	}
	
	//根据查询条件和page查找student表
	@Override
	public List<StudentDto> searchStudentByConditionWithPage(String condition,
			Limitation limit) {

		return studentMapper.searchStudentByConditionWithPage(condition, limit);
	}

	//根据page查找student表
	@Override
	public List<StudentDto> searchStudentByPage(Limitation limit) {

		return studentMapper.searchStudentByPage(limit);
	}

	//根据查询条件和page查找student表 的记录数量
	@Override
	public int searchCountOfStudentByConditionWithPage(String condition) {

		return studentMapper.searchCountOfStudentByConditionWithPage(condition);
	}

	//根据page查找student表 的数量
	@Override
	public int searchCountOfStudentByPage() {

		return studentMapper.searchCountOfStudentByPage();
	}

	//学生注册
	@Override
	public int studentRegist(int[] ids) {
		
		return studentMapper.regist(ids);
	}

	@Override
	public void getStudentDto(List<StudentDto> list) {
		
		List<Clazz> clazz =  clazzMapper.getAllClass();
		
		for (int i = 0; i < list.size(); ++i) {
			
			for (int j = 0; j < clazz.size(); ++j) {
				if (list.get(i).getClassId() == clazz.get(j).getId()) {
					list.get(i).setClassIdStr(clazz.get(j).getName());
				}
			}
		}
	}


	@Override
	public List<StudentDto> searchStudentByThreeCondition(String className,
			String studentName, String studentCode, Limitation limit) {
		// TODO Auto-generated method stub
		return studentMapper.searchStudentByThreeCondition(className, studentName, studentCode, limit);
	}

	@Override
	public int searchStudentCountByThreeCondition(String className,
			String studentName, String studentCode) {
		// TODO Auto-generated method stub
		return studentMapper.searchStudentCountByThreeCondition(className, studentName, studentCode);
	}

	@Override
	public void getStudentInfoByExcelFile(File file) {
		
		try {
			Workbook wb = new HSSFWorkbook();
			Sheet sheet = wb.createSheet();
//			List<StudentInfo> infoList = studentInfoMapper
			List<StudentDto> stuList = studentMapper.findAllStudents();
			List<StudentInfoDto> stuInfoList = studentInfoMapper.findStudentInfoByStudent();
			getStudentDto(stuList);
			studentinfoService.toStudentInfoDtoList(stuInfoList);
			
			//表头
			Row row = sheet.createRow(0);
			row.createCell(0).setCellValue("姓名");
			row.createCell(1).setCellValue("班级");
			row.createCell(2).setCellValue("学号");
		//	row.createCell(3).setCellValue("备注");
			row.createCell(3).setCellValue("性别");
			row.createCell(4).setCellValue("出生日期");
			row.createCell(5).setCellValue("身份证号");
			row.createCell(6).setCellValue("民族");
			row.createCell(7).setCellValue("政治面貌");
			row.createCell(8).setCellValue("港澳侨胞");
			row.createCell(9).setCellValue("籍贯");
			row.createCell(10).setCellValue("户籍类型");
			row.createCell(11).setCellValue("户口所在地");
			row.createCell(12).setCellValue("家庭住址");
			row.createCell(13).setCellValue("邮政编码");
			row.createCell(14).setCellValue("家庭电话");
			row.createCell(15).setCellValue("考生类别");
			row.createCell(16).setCellValue("毕业学校");
			row.createCell(17).setCellValue("专业方向");
			row.createCell(18).setCellValue("入学总分");
			row.createCell(19).setCellValue("学习形式");
			row.createCell(20).setCellValue("入学方式");
			row.createCell(21).setCellValue("招生起点");
			row.createCell(22).setCellValue("备注");
			//导出学生表+学生基本信息表
			for (int i = 0; i < stuList.size(); ++i) {
				//导出学生表的四个字段(姓名、班级、学号、备注)
				Row tmp = sheet.createRow(i+1);
				tmp.createCell(0).setCellValue(stuList.get(i).getName());
				tmp.createCell(1).setCellValue(stuList.get(i).getClassIdStr());
				tmp.createCell(2).setCellValue(stuList.get(i).getCode());
		//		tmp.createCell(3).setCellValue(stuList.get(i).getRemark());
				//导出基本信息表
				tmp.createCell(3).setCellValue(stuInfoList.get(i).getSexTypeStr());
				tmp.createCell(4).setCellValue(stuInfoList.get(i).getBirthdayStr());
				tmp.createCell(5).setCellValue(stuInfoList.get(i).getIdCard());
				tmp.createCell(6).setCellValue(stuInfoList.get(i).getNationTypeStr());
				tmp.createCell(7).setCellValue(stuInfoList.get(i).getPoliticalFeatureTypeStr());
				tmp.createCell(8).setCellValue(stuInfoList.get(i).getIsHkMcStr());
				tmp.createCell(9).setCellValue(stuInfoList.get(i).getNativePlace());
				tmp.createCell(10).setCellValue(stuInfoList.get(i).getHouseholdTypeStr());
				tmp.createCell(11).setCellValue(stuInfoList.get(i).getHouseholdLocation());
				tmp.createCell(12).setCellValue(stuInfoList.get(i).getFamilyAddress());
				tmp.createCell(13).setCellValue(stuInfoList.get(i).getPostcode());
				tmp.createCell(14).setCellValue(stuInfoList.get(i).getFamilyPhone());
				tmp.createCell(15).setCellValue(stuInfoList.get(i).getExamineeTypeStr());
				tmp.createCell(16).setCellValue(stuInfoList.get(i).getGraduationSchool());
				tmp.createCell(17).setCellValue(stuInfoList.get(i).getMajorFieldIdStr());
				tmp.createCell(18).setCellValue(stuInfoList.get(i).getExamTotalScore());
				tmp.createCell(19).setCellValue(stuInfoList.get(i).getStudyTypeStr());
				tmp.createCell(20).setCellValue(stuInfoList.get(i).getEnterSchoolTypeStr());
				tmp.createCell(21).setCellValue(stuInfoList.get(i).getEduStageTypeStr());
				tmp.createCell(22).setCellValue(stuInfoList.get(i).getRemark());
			}
			wb.write(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	/**
	 * 导入Excel分班
	 * 作者：炳坚
	 */
	@Override
	public int toDivideClassByUploadExcel(InputStream fileInputStream,
			String format) {
		// TODO Auto-generated method stub
		Workbook book = null;
		try {
			if(format.equals("xls")){
				System.out.println("xls");
				book=new HSSFWorkbook(fileInputStream);	
			}else if(format.equals("xlsx")){
				System.out.println("xlsx");
				book=new XSSFWorkbook(fileInputStream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Book的大小为："+book.getNumberOfSheets()+"    ....................");
		
		//保存基本信息的id
		Integer stuInfoId;
		//保存班别id
		Integer classId;

		//保存已添加到新生基本信息中的id，防止出错后，再删除数据
		List<Integer> insertedStuInfoIds=new ArrayList<Integer>();
		//保存以添加到新生成绩表信息中的id,防止出错后，再删除数据
		List<Integer> insertedAdmissScoreIds=new ArrayList<Integer>();
		//保存学生信息
		List<Student> students=new ArrayList<Student>();
		
		//循环获取Sheet
		Sheet sheet;
		for(int i=0,sheetSize=book.getNumberOfSheets();i<sheetSize;i++){
			System.out.println("--------------第"+(i+1)+"张Sheet--------------");
			sheet=book.getSheetAt(i);
			System.out.println("Sheet名字为："+sheet.getSheetName()+"     ::::::::");
			String majorFieldName=sheet.getSheetName();
			
			Iterator<Row> rows=sheet.rowIterator();
			//先取第一行
			Row titleRow=rows.next();
			if(!isExcelTitleValidate(titleRow)){
				//excel第一行title行格式有错，返回-1
				return -1;
			}
			System.out.println();
			
			//接着按照字段来取每一个单元格
			while(rows.hasNext()){
				System.out.println("-------------1行-------------");
				Row row =rows.next();
				Iterator<Cell> cells=row.cellIterator();
				
				Date bornDate;
				String studentNo,ExamNum,stuName,className,sexType,idCard,nationType,politicalFeatureType,
				isHk,nativePlace,householdType,householdLocation,familyAddress,postcode,familyPhone,
				graduationSchool,studyType,enterSchoolType,eduStageType,remark,stuStatus;
				
				Integer iSexType,iNationType,iPoliticalFeatureType,iIsHk,iHouseholdType,iStudyType,
				iEnterSchoolType,iEduStageType,iStuStatus;
				
				//学号  String
				Cell cell1=cells.next(); 
				if(cell1.getCellType()==Cell.CELL_TYPE_NUMERIC){
					//数值类型，转换为String
					DecimalFormat df = new DecimalFormat("0");  
					studentNo = df.format(cell1.getNumericCellValue());
					System.out.println(studentNo);
				}else{
					//返回-2,代表数据格式有错或者无填写，删除数据库中已经插入的基本信息
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//准考证号  String
				Cell cell16=cells.next();
				if(cell16.getCellType()==Cell.CELL_TYPE_STRING){
					ExamNum=cell16.getStringCellValue();
					System.out.println(ExamNum);
					stuInfoId=admissionScoreCustomerMapper.getStudentInfoIdByExamNum(ExamNum);
				}else if(cell16.getCellType()==Cell.CELL_TYPE_NUMERIC){
					DecimalFormat df = new DecimalFormat("0");  
					ExamNum = df.format(cell16.getNumericCellValue());
					System.out.println(ExamNum);
					stuInfoId=admissionScoreCustomerMapper.getStudentInfoIdByExamNum(ExamNum);
					System.out.println("stuInfoId:  "+stuInfoId);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//姓名 String
				Cell cell2=cells.next(); 
				if(cell2.getCellType()==Cell.CELL_TYPE_STRING){
					stuName=cell2.getStringCellValue();
					System.out.println(stuName);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//班别 String
				Cell cell3=cells.next(); 
				if(cell3.getCellType()==Cell.CELL_TYPE_NUMERIC){
					//先进行格式转换
					DecimalFormat df = new DecimalFormat("0");  
					className= df.format(cell3.getNumericCellValue());
					System.out.println(className);
					ClazzDto clazz=clazzMapper.getClassByClassName(className);
					if(clazz==null){	
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -2;
					}else{
						System.out.println("Class ID为："+clazz.getId());
						classId=clazz.getId();
					}
				}else if(cell3.getCellType()==Cell.CELL_TYPE_STRING&&cell3.getStringCellValue()!=null){
					className= cell3.getStringCellValue();
					System.out.println(className==null);
					System.out.println(className.equals(""));
					System.out.println(className.equals(" "));
					System.out.println(className);
					ClazzDto clazz=clazzMapper.getClassByClassName(className);
					if(clazz==null){	
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -2;
					}else{
						System.out.println("Class ID为："+clazz.getId());
						classId=clazz.getId();
					}
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//性别，String对应数据库的int
				Cell cell4=cells.next(); 
				if(cell4.getCellType()==Cell.CELL_TYPE_STRING){
					sexType=cell4.getStringCellValue();
					if(sexType.equals("男")){
						iSexType=1001;
					}else if(sexType.equals("女")){
						iSexType=1002;
					}else{
						//填值问题错误返回-3
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(sexType+" "+iSexType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
			
				//出生日期，需要转换格式
				Cell cell5=cells.next(); 
				if(DateUtil.isCellDateFormatted(cell5)&&cell5.getDateCellValue()!=null){
					bornDate=cell5.getDateCellValue();
					System.out.println(bornDate);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//身份证号 String
				Cell cell6=cells.next(); 
				if(cell6.getCellType()==Cell.CELL_TYPE_STRING){
					idCard=cell6.getStringCellValue();
					System.out.println(idCard);
				}else if(cell6.getCellType()==Cell.CELL_TYPE_NUMERIC){
					DecimalFormat df = new DecimalFormat("0");  
					idCard= df.format(cell6.getNumericCellValue());
					System.out.println(idCard);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
			
				
				//民族 String对应数据库的int
				Cell cell7=cells.next(); 
				if(cell7.getCellType()==Cell.CELL_TYPE_STRING){
					nationType=cell7.getStringCellValue();
					if(nationType.equals("汉族")){
						iNationType=18001;
					}else if(nationType.equals("壮族")){
						iNationType=18002;
					}else if(nationType.equals("满族")){
						iNationType=18003;
					}else if(nationType.equals("回族")){
						iNationType=18004;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(nationType+" "+iNationType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//政治面貌 String对应数据的int
				Cell cell8=cells.next(); 
				if(cell8.getCellType()==Cell.CELL_TYPE_STRING){
					politicalFeatureType=cell8.getStringCellValue();
					if(politicalFeatureType.equals("共青团员")){
						iPoliticalFeatureType=6001;
					}else if(politicalFeatureType.equals("群众")){
						iPoliticalFeatureType=6002;
					}else if(politicalFeatureType.equals("共产党员")){
						iPoliticalFeatureType=6003;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(politicalFeatureType+" "+iPoliticalFeatureType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return-2;
				}
				
				//是否是港澳侨胞 String对应数据的int
				Cell cell9=cells.next(); 
				if(cell9.getCellType()==Cell.CELL_TYPE_STRING){
					isHk=cell9.getStringCellValue();
					if(isHk.equals("是")){
						iIsHk=2001;
					}else if(isHk.equals("否")){
						iIsHk=2002;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(isHk);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//籍贯  String
				Cell cell10=cells.next(); 
				if(cell10.getCellType()==Cell.CELL_TYPE_STRING){
					nativePlace=cell10.getStringCellValue();
					System.out.println(nativePlace);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}


				//户籍类型 String对应数据的int
				Cell cell11=cells.next(); 
				if(cell11.getCellType()==Cell.CELL_TYPE_STRING){
					householdType=cell11.getStringCellValue();
					if(householdType.equals("城市")){
						iHouseholdType=7001;
					}else if(householdType.equals("农村")){
						iHouseholdType=7002;
					}else if(householdType.equals("县镇非农")){
						iHouseholdType=7003;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(householdType+" "+iHouseholdType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//户口所在地 String
				Cell cell12=cells.next(); 
				if(cell12.getCellType()==Cell.CELL_TYPE_STRING){
					familyAddress=cell12.getStringCellValue();
					System.out.println(familyAddress);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//家庭住址 String
				Cell cell13=cells.next(); 
				if(cell13.getCellType()==Cell.CELL_TYPE_STRING){
					householdLocation=cell13.getStringCellValue();
					System.out.println(householdLocation);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//邮政编码 String
				Cell cell14=cells.next(); 
				if(cell14.getCellType()==Cell.CELL_TYPE_NUMERIC){
					DecimalFormat df = new DecimalFormat("0");  
					postcode= df.format(cell14.getNumericCellValue());
					System.out.println(postcode);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//家庭电话 String
				Cell cell15=cells.next(); 
				if(cell15.getCellType()==Cell.CELL_TYPE_STRING){
					//加区号  如0750-6317831
					familyPhone=cell15.getStringCellValue();
					System.out.println(familyPhone);
				}else if(cell15.getCellType()==Cell.CELL_TYPE_NUMERIC){
					//如果是不加区号
					DecimalFormat df = new DecimalFormat("0");  
					familyPhone= df.format(cell15.getNumericCellValue());
					System.out.println(familyPhone);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

//				//考生类别 int 
//				Cell cell16s=cells.next();
//				int intValue16s=(int)cell16s.getNumericCellValue();
//				System.out.println(intValue16s);

				//毕业学校 String
				Cell cell17=cells.next(); 
				if(cell17.getCellType()==Cell.CELL_TYPE_STRING){
					graduationSchool=cell17.getStringCellValue();
					System.out.println(graduationSchool);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				

				//学习形式 String对应数据库的int
				Cell cell18=cells.next(); 
				if(cell18.getCellType()==Cell.CELL_TYPE_STRING){
					studyType=cell18.getStringCellValue();
					if(studyType.equals("全日制")){
						iStudyType=9001;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(studyType+" "+iStudyType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				//入学方式 String对应数据库的int
				Cell cell19=cells.next(); 
				if(cell19.getCellType()==Cell.CELL_TYPE_STRING){
					enterSchoolType=cell19.getStringCellValue();
					if(enterSchoolType.equals("普通入学")){
						iEnterSchoolType=10001;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(enterSchoolType+" "+iEnterSchoolType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//招生起点 String对应数据库的int
				Cell cell20=cells.next();
				if(cell20.getCellType()==Cell.CELL_TYPE_STRING){
					eduStageType=cell20.getStringCellValue();
					if(eduStageType.equals("初中")){
						iEduStageType=4001;
					}else if(eduStageType.equals("高中")){
						iEduStageType=4002;
					}else{
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(eduStageType+" "+iEduStageType);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//学籍状态 String对应数据库的int
				Cell cell21=cells.next(); 
				if(cell21.getCellType()==Cell.CELL_TYPE_STRING){
					stuStatus=cell21.getStringCellValue();
					if(stuStatus.equals("未注册")){
						iStuStatus=17001;
					}else{
						//只能是未注册的
						deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
						return -3;
					}
					System.out.println(stuStatus+" "+iStuStatus);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}

				//备注 String
				Cell cell22=cells.next(); 
				if(cell22.getCellType()==Cell.CELL_TYPE_STRING){
					remark=cell22.getStringCellValue();
					System.out.println(remark);
				}else{
					deleteByIdList(insertedStuInfoIds,insertedAdmissScoreIds);
					return -2;
				}
				
				System.out.println();
				
				//没有基本信息，往studentInfos添加信息
				if(stuInfoId==null){
					StudentInfoDto studentInfo=new StudentInfoDto();
					studentInfo.setName(stuName);
					studentInfo.setSexType(iSexType);
					studentInfo.setBirthday(bornDate);
					studentInfo.setIdCard(idCard);
					studentInfo.setNationType(iNationType);
					studentInfo.setPoliticalFeatureType(iPoliticalFeatureType);
					studentInfo.setIsHkMc(iIsHk);
					studentInfo.setNativePlace(nativePlace);
					studentInfo.setHouseholdType(iHouseholdType);
					studentInfo.setHouseholdLocation(householdLocation);
					studentInfo.setFamilyAddress(familyAddress);
					studentInfo.setPostcode(postcode);
					studentInfo.setFamilyPhone(familyPhone);
					studentInfo.setGraduationSchool(graduationSchool);
					//所报专业方向id待
					Integer majorFieldId=majorFieldCustomMapper.getMajorFieldIdByName(majorFieldName);

					if(majorFieldId==null){
						//不存在该专业，返回专业名字错误信息
						return -4;
					}else{
						studentInfo.setMajorFieldId(majorFieldId);
					}
					studentInfo.setStudyType(iStudyType);
					studentInfo.setEnterSchoolType(iEnterSchoolType);
					studentInfo.setEduStageType(iEduStageType);
					studentInfo.setRemark(remark);
					//设置已分班
					studentInfo.setIsDivideClass(1);

					//插入新生基本信息  rowCount为影响的行数
					Integer rowCount=studentInfoCustomerMapper.insertStudentInfoAndGetId(studentInfo);
					stuInfoId=studentInfo.getId();
					//插入新生成绩表
					AdmissionScoreDto admissionScoreDto=new AdmissionScoreDto();
					admissionScoreDto.setExamNum(ExamNum);
					admissionScoreDto.setStudentInfoId(stuInfoId);
					admissionScoreCustomerMapper.insertAdmissionScoreAndGetId(admissionScoreDto);
					insertedStuInfoIds.add(stuInfoId);
					insertedAdmissScoreIds.add(admissionScoreDto.getId());
					
					System.out.println("影响行数为："+rowCount+",插入后的新生基本信息id为：   "+stuInfoId);
					System.out.println("insertedStuInfoIds的大小为:"+insertedStuInfoIds.size());
				}
				
				//是否有该新生的基本资料？无的话插入数据后得到id，然后也要添加到新生表中（进行分班）;有就直接添加到新生表中
				System.out.println("根据准考证号找到基本信息stuInfoId:"+stuInfoId);
				//判断学生表上是否有记录
				StudentDto dto=studentMapper.getStudentByCode(studentNo);
				if(dto!=null){
					//有记录就不添加到studentsList中
				}else{
					Student student=new Student();
					student.setCode(studentNo);
					student.setName(stuName);
					student.setClassId(classId);
					student.setStudentInfoId(stuInfoId);
					
					//根据基本信息id找基本信息，匹配excel的名字是否和已存在的名字相同
					StudentInfo info=studentInfoCustomerMapper.selectByPrimaryKey(stuInfoId);
					String exitStuName=info.getName();
					System.out.println("已有记录中的名字为："+exitStuName+",插入的记录的名字为："+stuName);
					if(!exitStuName.equals(stuName)){
						//Excel数据表中名字错误
						deleteByIdList(insertedStuInfoIds, insertedAdmissScoreIds);
						return -6;
					}
					student.setStatus(iStuStatus);
					student.setRemark(remark);
					//添加到学生信息集合中
					
					students.add(student);
					System.out.println("students的大小为:"+students.size());
				}
			}
		}
		if(students.size()!=0){
			for(Student stu:students){
				System.out.println("Code:"+stu.getCode()+",name:"+stu.getName()+",classId:"+stu.getClassId()+",StudentInfoId:"+stu.getStudentInfoId()+",Remark:"+stu.getRemark()+",Status:"+stu.getStatus());
			}
			//插入到学生表中（也就是已确定分班）
			studentMapper.insertDivideClassByExcellFile(students);
		}else{
			deleteByIdList(insertedStuInfoIds, insertedAdmissScoreIds);
			//excell表中所有的数据都已经分班
			return -5;
		}
		return 1;
	}

	@Override
	public boolean isExcelTitleValidate(Row titleRow) {
		// TODO Auto-generated method stub
		System.out.println("开始验证标题");
		Iterator<Cell> titleCells=titleRow.cellIterator();
		//判断标题行的每一个单元是否符合格式要求
		Cell cell1=titleCells.next();
		if(cell1.getStringCellValue().equals("")||!cell1.getStringCellValue().equals("学号")){
			System.out.println(cell1.getStringCellValue());
			return false;
		}
		
		Cell cell16=titleCells.next();
		if(cell16.getStringCellValue().equals("")||(!cell16.getStringCellValue().equals("准考证号"))){
			System.out.println("进来了");
			System.out.println(cell16.getStringCellValue());
			return false;
		}
		
		Cell cell2=titleCells.next();
		if(cell2.getStringCellValue().equals("")||!cell2.getStringCellValue().equals("姓名")){
			System.out.println(cell2.getStringCellValue());
			return false;
		}
		Cell cell3=titleCells.next();
		if(cell3.getStringCellValue().equals("")||!cell3.getStringCellValue().equals("班别")){
			System.out.println(cell3.getStringCellValue());
			return false;
		}
		Cell cell4=titleCells.next();
		if(cell4.getStringCellValue().equals("")||!cell4.getStringCellValue().equals("性别")){
			System.out.println(cell4.getStringCellValue());
			return false;
		}
		Cell cell5=titleCells.next();
		if(cell5.getStringCellValue().equals("")||!cell5.getStringCellValue().equals("出生日期")){
			System.out.println(cell5.getStringCellValue());
			return false;
		}
		Cell cell6=titleCells.next();
		if(cell6.getStringCellValue().equals("")||!cell6.getStringCellValue().equals("身份证号")){
			System.out.println(cell6.getStringCellValue());
			return false;
		}
		Cell cell7=titleCells.next();
		if(cell7.getStringCellValue().equals("")||!cell7.getStringCellValue().equals("民族")){
			System.out.println(cell7.getStringCellValue());
			return false;
		}
		Cell cell8=titleCells.next();
		if(cell8.getStringCellValue().equals("")||!cell8.getStringCellValue().equals("政治面貌")){
			System.out.println(cell8.getStringCellValue());
			return false;
		}
		Cell cell9=titleCells.next();
		if(cell9.getStringCellValue().equals("")||!cell9.getStringCellValue().equals("是否是港澳侨胞")){
			System.out.println(cell9.getStringCellValue());
			return false;
		}
		Cell cell10=titleCells.next();
		if(cell10.getStringCellValue().equals("")||!cell10.getStringCellValue().equals("籍贯")){
			System.out.println(cell10.getStringCellValue());
			return false;
		}
		Cell cell11=titleCells.next();
		if(cell11.getStringCellValue().equals("")||!cell11.getStringCellValue().equals("户籍类型")){
			System.out.println(cell11.getStringCellValue());
			return false;
		}
		Cell cell12=titleCells.next();
		if(cell12.getStringCellValue().equals("")||!cell12.getStringCellValue().equals("户口所在地")){
			System.out.println(cell12.getStringCellValue());
			return false;
		}
		Cell cell13=titleCells.next();
		if(cell13.getStringCellValue().equals("")||!cell13.getStringCellValue().equals("家庭住址")){
			System.out.println(cell13.getStringCellValue());
			return false;
		}
		Cell cell14=titleCells.next();
		if(cell14.getStringCellValue().equals("")||!cell14.getStringCellValue().equals("邮政编码")){
			System.out.println(cell14.getStringCellValue());
			return false;
		}
		Cell cell15=titleCells.next();
		if(cell15.getStringCellValue().equals("")||!cell15.getStringCellValue().equals("家庭电话")){
			System.out.println(cell15.getStringCellValue());
			return false;
		}
//		Cell cell16=titleCells.next();
//		if(cell16.getStringCellValue().equals("")&&!cell16.getStringCellValue().equals("考生类别")){
//			System.out.println(cell16.getStringCellValue());
//			return false;
//		}
		Cell cell17=titleCells.next();
		if(cell17.getStringCellValue().equals("")||!cell17.getStringCellValue().equals("毕业学校")){
			System.out.println(cell17.getStringCellValue());
			return false;
		}
		Cell cell18=titleCells.next();
		if(cell18.getStringCellValue().equals("")||!cell18.getStringCellValue().equals("学习形式")){
			System.out.println(cell18.getStringCellValue());
			return false;
		}
		Cell cell19=titleCells.next();
		if(cell19.getStringCellValue().equals("")||!cell19.getStringCellValue().equals("入学方式")){
			System.out.println(cell19.getStringCellValue());
			return false;
		}
		Cell cell20=titleCells.next();
		if(cell20.getStringCellValue().equals("")||!cell20.getStringCellValue().equals("招生起点")){
			System.out.println(cell20.getStringCellValue());
			return false;
		}
		Cell cell21=titleCells.next();
		if(cell21.getStringCellValue().equals("")||!cell21.getStringCellValue().equals("学籍状态")){
			System.out.println(cell21.getStringCellValue());
			return false;
		}
		Cell cell22=titleCells.next();
		if(cell22.getStringCellValue().equals("")||!cell22.getStringCellValue().equals("备注")){
			System.out.println(cell22.getStringCellValue());
			return false;
		}
		
		return true;
	}
	
	/**
	 * 当excel表导入过程中数据有错误，删除已经插入StudentInfo中的数据
	 * 作者：炳坚
	 */
	public int deleteByIdList(List<Integer> insertedStuInfoIds,List<Integer> insertedAdmissScoreIds){
		for(Integer id:insertedStuInfoIds){
			studentInfoCustomerMapper.deleteByPrimaryKey(id);
		}
		for(Integer id:insertedAdmissScoreIds){
			admissionScoreCustomerMapper.deleteByPrimaryKey(id);
		}
		return 1;
	}
    //-----------------吴俊鹏---------------------
	/**
	 * 根据班别、姓名、学号、是否免学费模糊查询，并返回查询数目
	 * @author 吴俊鹏
	 * @param studentDto
	 * @return int
	 */
	public int getStudentCount(StudentDto studentDto){
		
		return studentCustomMapper.countByNameCodeClassNameTuition(studentDto);
	}
	
	/**
	 * 根据班别、姓名、学号、是否免学费模糊分页查询
	 * @author 吴俊鹏
	 * @param studentDto
	 * @param page
	 * @return
	 */
	public List<Student> getStudentByPage(StudentDto studentDto,Pagination page){
		return studentCustomMapper.selectByLimit(studentDto, page.getLimitation());
	}
	
	/**
	 * 一键设置学费免费
	 * @author 吴俊鹏
	 * @param setFreeIds
	 * @return
	 */
	@Override
	public int setTuitionFree(int[] setFreeIds) {
		
		return studentMapper.setTuitionFree(setFreeIds);
	}
	
	/**
	 * 一键取消学费免费
	 * @author 吴俊鹏
	 * @param cancelFreeIds
	 * @return
	 */
	public int cancelTuitionFree(int[] cancelFreeIds) {

		return studentMapper.cancelTuitionFree(cancelFreeIds);
	}
	
	/**
	 * 根据模板文件路径填充免学费学生信息
	 * @param stuIds
	 * @param dir
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Override
	public int getFreeTuitionStudentExcel(Integer[] stuIds, File dir)
			throws FileNotFoundException, IOException {
		// 先清空模板然后设置
		InputStream in = new FileInputStream(dir);
		File outputFile = new File(dir.getParent() + "/免学费学生信息批量录入模板(填充).xls");
		OutputStream out = new FileOutputStream(outputFile);	
		
		Workbook wb = new HSSFWorkbook(in);

		Sheet sheet1 = wb.getSheetAt(0);
		
		for(int i =0;i<stuIds.length;i++) {
			StudentDto studentDto = studentCustomMapper.findStudentBystuId(stuIds[i]);
			// 序号
			Cell id = sheet1.createRow(i+3).createCell(0);
			id.setCellType(Cell.CELL_TYPE_NUMERIC);
			id.setCellValue(i+1);
			
			// 姓名
			Cell name = sheet1.getRow(i+3).createCell(1);
			name.setCellType(Cell.CELL_TYPE_STRING);
			name.setCellValue(studentDto.getName());	
			
			// 学号
			Cell code = sheet1.getRow(i+3).createCell(2);
			code.setCellType(Cell.CELL_TYPE_STRING);
			code.setCellValue(studentDto.getCode());
			
			//是否免学费
			Cell stuIsFreeTuition = sheet1.getRow(i+3).createCell(6);
			stuIsFreeTuition.setCellType(Cell.CELL_TYPE_STRING);
			stuIsFreeTuition.setCellValue(studentDto.getStuIsFreeTuition());
			
		}
		
		wb.write(out);
		// 关闭流
		in.close();
		out.close();
		return 1;
	}

	/**
	 * 通过excel导入免学费学生信息
	 * @param inputStream
	 * @param format
	 * @return
	 */
	@Override
	public String addFreeTuitionStudentByExcel(InputStream inputStream, String format) throws BadSqlGrammarException,IllegalStateException {
//		List<StudentDto> sadList = new ArrayList<StudentDto>();
		//错误信息
		String errorStr="";
		
		//
		String name="";
		List<StudentDto> upsadList = new ArrayList<StudentDto>();
		System.out.println("inputStream:" + inputStream);
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
		boolean exit = false;  //学生记录已存在，更新
		boolean studentHere = true; //判断学生是否存在
		boolean isFreeTuition = false; //判断是否免费，是则更新
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			Row row = rows.next();
			if (row.getRowNum() == 0||row.getRowNum() == 1||row.getRowNum() == 2) {
				continue;
			}
			//Iterator<Cell> cells = row.cellIterator();
			StudentDto studentDto = new StudentDto();
			for (int index = 0; index < row.getLastCellNum(); ++index) {
				Cell cell = row.getCell(index);
				if (index == 2) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String code = cell.getStringCellValue();
					System.out.println("学号-----无咕-----：" + code);
					code = code.trim();
					System.out.println("学号:" + code);
					StudentDto stu = studentCustomMapper.findStudent(code);
					if(stu==null) {
						studentHere=false;
						errorStr=errorStr+name+"  ";
						break;
					}else{
						if(!stu.getName().equals(name)){
							studentHere=false;
							errorStr=errorStr+name+"  ";
							break;
						}
					}
					
					exit = true;
					
					studentDto.setId(stu.getId());
				}else if (index == 1) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					 name = cell.getStringCellValue().trim();			
				}else if (index == 3) { // 是否免费
					if (cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
					}
					if ( cell.getStringCellValue() == null || cell.getStringCellValue().trim().equals("")) {
						flag = true;//为空行
						System.out.println("为空行");
						break;
					}
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String stuIsFreeTuition = cell.getStringCellValue();
					stuIsFreeTuition = stuIsFreeTuition.trim();
					if(stuIsFreeTuition.equals("是")){
						   isFreeTuition=true;
						   exit=true;
					}
					System.out.println("是否免费:" + stuIsFreeTuition);
					studentDto.setStuIsFreeTuition(stuIsFreeTuition);
				}
			}
			if (!flag && exit && isFreeTuition) {//不为空行、学号存在而且为免费则更新
				System.out.println("添加数据进队列");
				upsadList.add(studentDto);
			}
			//还原
			flag = false;
			exit = false;
			isFreeTuition=false;
			studentHere=true;
			System.out.println("进行下一次循环！");
		}
			
		System.out.println("跳出循环");
		// 更新免学费学生记录表
		int count=0;
		if (upsadList.size() >= 0){
				for (StudentDto dto : upsadList) {
					System.out.println("更新数据列表");
					if(1==studentCustomMapper.updateFreeTuitionStudent(dto)){
						count++;
					}
				}
				System.out.println(upsadList.size());
			return count+","+errorStr;
		}
		else
			return -3+""; // 格式错误
	}
		//-----------------吴俊鹏---------------------
	
	
	@Override
	public List<Student> getStudentsByClassId(int classId) {
		// TODO Auto-generated method stub
		StudentExample example = new StudentExample();
		example.createCriteria().andClassIdEqualTo(classId);
		return studentCustomMapper.selectByExample(example);
	}
}
