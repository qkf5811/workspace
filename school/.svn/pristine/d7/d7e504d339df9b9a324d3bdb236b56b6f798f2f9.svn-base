package com.dkt.school.fin.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dao.ChargeStandardCustomMapper;
import com.dkt.school.fin.dao.StudentAccountCustomMapper;
import com.dkt.school.fin.dao.StudentChargeCustomMapper;
import com.dkt.school.fin.dto.StudentAccountDto;
import com.dkt.school.fin.dto.StudentChargeDto;
import com.dkt.school.fin.dto.StudentChargeOfArrearsDto;
import com.dkt.school.fin.dto.StudentChargeToBankDto;
import com.dkt.school.fin.model.ChargeStandard;
import com.dkt.school.fin.model.StudentCharge;
import com.dkt.school.fin.service.StudentChargeService;
import com.dkt.school.sch.dao.GradeCustomMapper;
import com.dkt.school.sch.dao.MajorFieldMapper;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.GradeExample;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.model.MajorFieldExample;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dao.StudentInfoCustomMapper;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.model.StudentExample;
import com.dkt.school.system.dao.EnumerationValueCustomMapper;
import com.dkt.school.system.dao.SysConfigMapper;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.model.SysConfig;
import com.dkt.school.system.model.SysConfigExample;

/**
 * 
 * <p>Title: StudentChargeServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月1日上午9:26:01
 *
 */
@Service
public class StudentChargeServiceImpl implements StudentChargeService {

	private StudentChargeCustomMapper studentChargeCustomMapper;
	@Autowired
	private StudentChargeCustomMapper sccMapper;
	@Autowired
	private StudentCustomMapper stuMapper;

	private MajorFieldMapper majorFieldMapper;

	private SysConfigMapper sysConfigMapper;

	private StudentCustomMapper studentCustomMapper;

	private StudentInfoCustomMapper studentInfoCustomMapper;

	private GradeCustomMapper gradeCustomMapper;

	private EnumerationValueCustomMapper enumerationValueMapper;
	
	private ChargeStandardCustomMapper chargeStandardCustomMapper;
	
	@Autowired
	private StudentAccountCustomMapper studentAccountCustomMapper;

    public ChargeStandardCustomMapper getChargeStandardCustomMapper() {
		return chargeStandardCustomMapper;
	}
    @Autowired
	public void setChargeStandardCustomMapper(
			ChargeStandardCustomMapper chargeStandardCustomMapper) {
		this.chargeStandardCustomMapper = chargeStandardCustomMapper;
	}

	public EnumerationValueCustomMapper getEnumerationValueMapper() {
		return enumerationValueMapper;
	}

	@Autowired
	public void setEnumerationValueMapper(
			EnumerationValueCustomMapper enumerationValueMapper) {
		this.enumerationValueMapper = enumerationValueMapper;
	}

	public GradeCustomMapper getGradeCustomMapper() {
		return gradeCustomMapper;
	}
	@Autowired
	public void setGradeCustomMapper(GradeCustomMapper gradeCustomMapper) {
		this.gradeCustomMapper = gradeCustomMapper;
	}

	public StudentCustomMapper getStudentCustomMapper() {
		return studentCustomMapper;
	}
	@Autowired
	public void setStudentCustomMapper(StudentCustomMapper studentCustomMapper) {
		this.studentCustomMapper = studentCustomMapper;
	}

	public StudentInfoCustomMapper getStudentInfoCustomMapper() {
		return studentInfoCustomMapper;
	}
	@Autowired
	public void setStudentInfoCustomMapper(
			StudentInfoCustomMapper studentInfoCustomMapper) {
		this.studentInfoCustomMapper = studentInfoCustomMapper;
	}

	public SysConfigMapper getSysConfigMapper() {
		return sysConfigMapper;
	}
	@Autowired
	public void setSysConfigMapper(SysConfigMapper sysConfigMapper) {
		this.sysConfigMapper = sysConfigMapper;
	}

	public MajorFieldMapper getMajorFieldMapper() {
		return majorFieldMapper;
	}
	@Autowired
	public void setMajorFieldMapper(MajorFieldMapper majorFieldMapper) {
		this.majorFieldMapper = majorFieldMapper;
	}


	public StudentChargeCustomMapper getStudentChargeCustomMapper() {
		return studentChargeCustomMapper;
	}
	@Autowired
	public void setStudentChargeCustomMapper(
			StudentChargeCustomMapper studentChargeCustomMapper) {
		this.studentChargeCustomMapper = studentChargeCustomMapper;
	}

	@Override
	public int getStudentChargeCount(StudentChargeDto studentChargeDto) {
		return studentChargeCustomMapper.selectStudentChargeCount(studentChargeDto);
	}

	@Override
	public List<StudentChargeDto> getStudentChargeListByPage(
			StudentChargeDto studentChargeDto, PaginationCustom page) {
		return studentChargeCustomMapper.selectStudentChargeListByPage(studentChargeDto,page.getLimitation());
	}

	public int findCountOfStudentChargeOfArrears(int gradeId, int majorId, int fieldId,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return sccMapper.selectCountOfStudentChargeOfArrearsDto(gradeId, majorId, fieldId, page.getLimitation());
	}

	@Override
	public List<StudentChargeOfArrearsDto> findOfStudentChargeOfArrears(
			int gradeId, int majorId, int fieldId, PaginationCustom page) {
		// TODO Auto-generated method stub
		return sccMapper.selectStudentChargeOfArrearsDto(gradeId, majorId, fieldId, page.getLimitation());
	}

	@Override
	public int getArreasInfoExcel(int gradeId, int majorId, int fieldId, File dir) {
		// TODO Auto-generated method stub

		//所有欠费信息
		List<StudentChargeOfArrearsDto> scList = this.findOfStudentChargeOfArrears(gradeId, majorId, fieldId, new PaginationCustom());
		//去除重复学号的欠费信息(分第一第二学期)
		List<StudentChargeOfArrearsDto> tmpList = new ArrayList<StudentChargeOfArrearsDto>();

		//得到tmpList
		boolean flag = false;
		for (int i = 0; i < scList.size(); ++i) {
			if (tmpList.size() == 0) {
				tmpList.add(scList.get(i));
			} else {
				for (int j = 0; j < tmpList.size(); ++j) {
					if (tmpList.get(j).getCode().equals(scList.get(i).getCode()))
						flag = true;
				}
				if (!flag) {
					tmpList.add(scList.get(i));
				} else {
					flag = false;
				}
			}
		}
		System.out.println("欠费List size: " + scList.size());

		// 各种枚举

		// 先清空模板然后设置
		try {
			InputStream in = new FileInputStream(dir);
			File outputFile = new File(dir.getParent() + "/学生欠费信息(填充).xls");
			OutputStream out = new FileOutputStream(outputFile);

			Workbook wb = new HSSFWorkbook(in);
			// System.out.println("读取excel测试: " +
			// wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
			Sheet sheet1 = wb.getSheetAt(0);
			int tmp = 0;

			//序号
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.createRow(2+i).createCell(0);
				cell.setCellValue(i+1);
			}
			//班级
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(1);
				cell.setCellValue(tmpList.get(i).getClassStr());
			}
			//学号
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(2);
				cell.setCellValue(tmpList.get(i).getCode());
			}
			//姓名
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(3);
				cell.setCellValue(tmpList.get(i).getName());
			}
			//是否免费入学
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(4);
				StudentDto dto = stuMapper.findStudent(scList.get(i).getCode());
				if (dto.getIsFreeTuition() == null || dto.getIsFreeTuition() == 0)
					cell.setCellValue("否");
				else 
					cell.setCellValue("是");
			}
			//身份证号码
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(5);
				cell.setCellValue(tmpList.get(i).getIdCard());
			}
			//银行账号
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(6);
				cell.setCellValue(tmpList.get(i).getAccount());
			}

			//		//第一学期欠费
			//		float arrears1 = 0;
			//		for (int i = 0; i < tmpList.size(); ++i) {
			//			
			//			Cell cell = sheet1.getRow(2+i).createCell(7);
			//			arrears1 = tmpList.get(i).getTotalFee() - tmpList.get(i).getPaidTotalFee();
			//			cell.setCellValue(arrears1);
			//		}
			//		//第二学期欠费
			//		float arrears2 = 0;
			//		for (int i = 0; i < tmpList.size(); ++i) {
			//					
			//			Cell cell = sheet1.getRow(2+i).createCell(8);
			//			arrears2 = tmpList.get(i).getTotalFee() - tmpList.get(i).getPaidTotalFee();
			//			cell.setCellValue(arrears2);
			//		}
			//		//合计
			//		for (int i = 0; i < tmpList.size(); ++i) {
			//			
			//			Cell cell = sheet1.getRow(2+i).createCell(9);
			//			cell.setCellValue(arrears1 + arrears2);
			//		}
			//欠费与合计
			for (int i = 0; i < tmpList.size(); ++i) {

				float arrears1 = 0;
				float arrears2 = 0;
				if (tmpList.get(i).getTermType() == EnumerationType.SCHOOL_TERM_TYPE + 1) { //第一学期

					arrears1 = tmpList.get(i).getTotalFee()-tmpList.get(i).getPaidTotalFee();
					sheet1.getRow(2+i).createCell(7).setCellValue(arrears1);
					//设置第二学期欠费
					for (int j = 0; j < scList.size(); ++j) {

						if (tmpList.get(i).getCode().equals(scList.get(j).getCode()) &&
								tmpList.get(i).getTermType() != scList.get(j).getTermType()) {

							arrears2 = scList.get(j).getTotalFee() - scList.get(j).getPaidTotalFee();
							sheet1.getRow(2+i).createCell(8).setCellValue(arrears2);
							break;
						}
					}
				} else {  //临时List 是第二学期

					arrears2 = tmpList.get(i).getTotalFee()-tmpList.get(i).getPaidTotalFee();
					sheet1.getRow(2+i).createCell(8).setCellValue(arrears2);
					//设置第一学期欠费
					for (int j = 0; j < scList.size(); ++j) {

						if (tmpList.get(i).getCode().equals(scList.get(j).getCode()) &&
								tmpList.get(i).getTermType() != scList.get(j).getTermType()) {

							arrears1 = scList.get(j).getTotalFee() - scList.get(j).getPaidTotalFee();
							sheet1.getRow(2+i).createCell(7).setCellValue(arrears1);
							break;
						}
					}
				}
				//合计
				sheet1.getRow(2+i).createCell(9).setCellValue(arrears1 + arrears2);
			}
			//非税扣费备注
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(11);
				cell.setCellValue(tmpList.get(i).getDeductRemark());
			}
			//备注
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(12);
				cell.setCellValue(tmpList.get(i).getRemark());
			}

			//上缴学费
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(14);
				cell.setCellValue(tmpList.get(i).getPaidTuitionFee());
			}
			//上缴住宿费
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(15);
				cell.setCellValue(tmpList.get(i).getPaidRoomFee());
			}
			//上缴书费
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(16);
				cell.setCellValue(tmpList.get(i).getPaidBookFee());
			}
			//上缴时间
			for (int i = 0; i < tmpList.size(); ++i) {

				Cell cell = sheet1.getRow(2+i).createCell(17);
				if (tmpList.get(i).getTermType() == EnumerationType.SCHOOL_TERM_TYPE+1) {//第一学期

					cell.setCellValue(tmpList.get(i).getPayTime());
				} else {

					boolean have = false;
					for (int j = 0; j < scList.size(); ++j) {

						if (tmpList.get(i).getCode().equals(scList.get(j).getCode()) &&
								tmpList.get(i).getTermType() != scList.get(j).getTermType()) {

							cell.setCellValue(scList.get(i).getPayTime());
							have = true;
						}
					}

					if(!have) {
						cell.setCellValue(tmpList.get(i).getPayTime());
					}
				}

			}
			//备注

			wb.write(out);
			// 关闭流
			in.close();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return 1;
	}




	//计算应扣学费
	@Override
	public String toCountAllStudentsCharge() {
		//获取全校的所有专业方向
		List<MajorField> allMajorFieldList=majorFieldMapper.selectByExample(new MajorFieldExample());
		
		//声明待插入数据库的所有学生收费情况的容器
		List<StudentCharge> toInsertStudentChargeList = new ArrayList<>();
		//定义已被计算扣费信息的学生人数
		int insertCount = 0;
		int updateCount = 0;
		
		//获取年级列表
		List<Grade> gradeList= gradeCustomMapper.selectByExample(new GradeExample());
		
		//获取学期类型
		List<EnumerationValue> termTypeList = 
				enumerationValueMapper.selectByEnumerationId(EnumerationType.SCHOOL_TERM_TYPE);
		
		//获得当前学年的Id
		String studyYearId="";
		List<SysConfig> sysConfigList=sysConfigMapper.selectByExample(new SysConfigExample());
		for (SysConfig sysConfig : sysConfigList) {
			System.out.println(sysConfig.getCode());
			if(sysConfig.getCode().equals("study_year")){
				studyYearId+=sysConfig.getValue();
				break;
			}
		}
		System.out.println("studyYearId:"+studyYearId);

		//根据学期类型、年级、专业方向对所有学生计算应扣学费
		for (EnumerationValue enumerationValue : termTypeList) {
			//获取学期类型Id
			int termType=enumerationValue.getId();
			for (Grade grade : gradeList) {
				//获取年级Id
				int gradeId=grade.getId();
				for (MajorField majorField : allMajorFieldList) {
					//获取专业方向ID
					int majorFieldId=majorField.getId();
					/**
					 * 根据学期类型、专业方向ID、年级ID获取收费标准
					 */
					List<ChargeStandard> chargeStandardList=chargeStandardCustomMapper.selectChargeStandardByMultiC(gradeId,termType,majorFieldId);
					if(chargeStandardList.size()==0)
						continue;
					float tuitionFee=0f;
					float boyRoomFee=0f;
					float girlRoomFee=0f;
					float bookFee=0f;
					if(chargeStandardList.size()==1){
						//获取学费tuition_fee
						tuitionFee=chargeStandardList.get(0).getTuitionFee();
						//System.out.println(tuitionFee);
						//获取女生住宿费room_fee_girl
						girlRoomFee=chargeStandardList.get(0).getRoomFeeGirl();
						//获取男生住宿费room_fee_boy
						boyRoomFee=chargeStandardList.get(0).getRoomFeeBoy();
						//获取书本资料费book_fee
						bookFee=chargeStandardList.get(0).getBookFee();
						//System.out.println(bookFee);
					}
					
					
					//根据专业方向ID、年级ID获取符合条件的学生列表
					List<Student> studenList = studentCustomMapper.selectStudentByMultiCondition(gradeId,majorFieldId);
//					for (Student student : studenList) {
//						System.out.println(student.getId()+"  "+ student.getName());
//					}
					/**
					 * 设置学生扣费信息
					 */
					for (Student student : studenList) {
						//获取学生Id
						int studentId=student.getId();
						//System.out.println(studentId);
						//获取学生是否免费(默认不免费)
						int isFreeTuition=2002;
						if(student.getIsFreeTuition()!=null)
						    isFreeTuition=student.getIsFreeTuition();
						//根据学生Id获取学生性别
						String sexType=studentInfoCustomMapper.getSexTypeByStudentId(studentId);
						if(sexType==null){
							continue;
						}
						//System.out.println(sexType);
						
						StudentCharge studentCharge = new StudentCharge();
						//设置学生帐号id
						int accountId;
						StudentAccountDto studentAccountDto = studentAccountCustomMapper.findStudentAccountByStudentId(studentId);
						//System.out.println(studentAccountDto.getId());
						if(studentAccountDto==null){
							continue;//没有学生账号则不为该同学计算扣费信息
						}else{
							accountId = studentAccountDto.getId();
						}
						studentCharge.setAccountId(accountId);
						
						//设置所属年级id
						studentCharge.setGradeId(gradeId);
						//设置学年ID
						studentCharge.setStudyYear(Integer.parseInt(studyYearId));
						//设置学期类型
						studentCharge.setTermType(termType);
						//设置学生id
						studentCharge.setStudentId(studentId);
						
						//设置应扣书费
						studentCharge.setBookFee(bookFee);
						
						//当该学生免学费时（默认免3年的学费，如果只免新生的学费，则要加条件控制）
						if (isFreeTuition==2001) {
							//设置应扣学费
							studentCharge.setTuitionFee(0f);
							//当性别为男时
							if (sexType.equals("男")) {
								//设置应扣住宿费
								studentCharge.setRoomFee(boyRoomFee);								
								//设置应扣金额合计
								studentCharge.setTotalFee(bookFee+boyRoomFee);
							} else {//当性别为女时
								//设置应扣住宿费
								studentCharge.setRoomFee(girlRoomFee);								
								//设置应扣金额合计
								studentCharge.setTotalFee(bookFee+girlRoomFee);
							}	
													
						} else {							
							//设置应扣学费
							studentCharge.setTuitionFee(tuitionFee);							
							//当性别为男时
							if (sexType.equals("男")) {
								//设置应扣住宿费
								studentCharge.setRoomFee(boyRoomFee);								
								//设置应扣金额合计
								studentCharge.setTotalFee(tuitionFee+bookFee+boyRoomFee);
							} else {//当性别为女时
								//设置应扣住宿费
								studentCharge.setRoomFee(girlRoomFee);								
								//设置应扣金额合计
								studentCharge.setTotalFee(tuitionFee+bookFee+girlRoomFee);
							}														

						}
						
						//把其中一条学生扣费信息暂存到toInsertStudentChargeList
						toInsertStudentChargeList.add(studentCharge);
						
						
						
						
					}

				}
			}
		}

		
		//把所有学生扣费信息插入数据库
//		int insertReturnCode ;
//		for (StudentCharge studentCharge : toInsertStudentChargeList) {
//			//System.out.println("把生扣费信息插入数据库,StudentId："+studentCharge.getStudentId());
//			insertReturnCode = studentChargeCustomMapper.insertAllStudentCharge(studentCharge);
//			//insertReturnCode的值为1代表数据库没有重复的记录，为一名未计算过扣费信息的学生计算扣费
//			if(insertReturnCode==1){
//				insertCount++;
//			}
//			if(insertReturnCode==0){			
//				//更新数据之前检查是否该条记录需要更新
//				if(1==studentChargeCustomMapper.selectStudentChargeCountBeModi(studentCharge)){
//					studentChargeCustomMapper.updateStudentChargeByMultiCon(studentCharge);
//					updateCount++;
//				}
//				
//				
//			}
//						
//		}
//		System.out.println(insertCount+","+updateCount);
		
		//更新数据之前检查是否该条记录需要更新
		for (StudentCharge studentCharge : toInsertStudentChargeList) {
			if(1==studentChargeCustomMapper.selectStudentChargeCountBeModi(studentCharge)){
				studentChargeCustomMapper.updateStudentChargeByMultiCon(studentCharge);
				updateCount++;
			}else{
				if(1==studentChargeCustomMapper.insertAllStudentCharge(studentCharge)){
					insertCount++;
				}
			}
		}
		
		return insertCount+","+updateCount;
	}
	
	public void exportStuChargeInfo(HttpServletResponse response,
			Integer studyYearId, Integer termTypeId, Integer gradeId) {

		HSSFWorkbook hssfWorkbook = null;
		String filePath = null;
		String basepath = this.getClass().getResource("/").toString();
		basepath = basepath.substring(6, basepath.length() - 8);
		basepath = basepath + "files/批扣模版文件.xls";
		basepath = URLDecoder.decode(basepath);

		InputStream is = null;
      
		try {
			is = new FileInputStream(basepath);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

		addDataToExcel(hssfSheet, studyYearId, termTypeId, gradeId);

		String dirPath="";
		try {
			int i = basepath.lastIndexOf("/") + 1;

			if (i > 0) {
			   dirPath= basepath.substring(0,i);
			}							
			filePath = dirPath + "批扣文件.xls";
			OutputStream out = new FileOutputStream(filePath);
			hssfWorkbook.write(out);
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// 下载Excel
		File file = new File(filePath);

		String filename = "";
		int index = filePath.lastIndexOf("/") + 1;

		if (index > 0) {
			filename = filePath.substring(index);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/msexcel");

		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] bytes = new byte[1024];
			while ((in.read(bytes) != -1)) {
				out.write(bytes, 0, bytes.length);
			}
			in.close();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (file.exists()){
				file.delete();
			}
		}
	}

	public void addDataToExcel(HSSFSheet sheet, Integer studyYearId,
			Integer termTypeId, Integer gradeId) {
		// 所有欠费信息
		List<StudentChargeToBankDto> strChargeList = studentChargeCustomMapper
				.selectStudentChargeListByExport(studyYearId, termTypeId,
						gradeId);

		int beginRow = 6;
		HSSFRow row = sheet.getRow(beginRow);

		HSSFCell paidname_cell = null;
		HSSFCell account_cell = null;
		HSSFCell accountName_cell = null;
		HSSFCell tuition_cell = null;
		HSSFCell tuitionTotal_cell = null;
		HSSFCell room_cell = null;
		HSSFCell roomTotal_cell = null;
		HSSFCell sumMoney_cell = null;

		// 记录第一行数据的单元格样式，用来设置二行起的单元格格式
		CellStyle paidname_cell_style = null;
		CellStyle account_cell_style = null;
		CellStyle accountName_cell_style = null;
		CellStyle tuition_cell_style = null;
		CellStyle tuitionTotal_cell_style = null;
		CellStyle room_cell_style = null;
		CellStyle roomTotal_cell_style = null;
		CellStyle sumMoney_cell_style = null;

		float sumMoney = 0;
		float needPaidTuition = 0;
		float needPaidRoom = 0;

		for (int index = 0; index < strChargeList.size(); ++index) {

			sumMoney = 0;
			needPaidTuition = 0;
			needPaidRoom = 0;

			row = sheet.getRow(beginRow + index);

			if (index == 0) {
				paidname_cell = row.getCell(0);
				account_cell = row.getCell(1);
				accountName_cell = row.getCell(2);
				tuition_cell = row.getCell(3);

				tuitionTotal_cell = row.getCell(4);
				room_cell = row.getCell(5);
				roomTotal_cell = row.getCell(6);
				sumMoney_cell = row.getCell(9);

				paidname_cell_style = paidname_cell.getCellStyle();
				account_cell_style = account_cell.getCellStyle();
				accountName_cell_style = accountName_cell.getCellStyle();
				tuition_cell_style = tuition_cell.getCellStyle();

				tuitionTotal_cell_style = tuitionTotal_cell.getCellStyle();
				room_cell_style = room_cell.getCellStyle();
				roomTotal_cell_style = roomTotal_cell.getCellStyle();
				sumMoney_cell_style = sumMoney_cell.getCellStyle();

			} else {

				paidname_cell = row.createCell(0);
				paidname_cell.setCellStyle(paidname_cell_style);

				account_cell = row.createCell(1);
				account_cell.setCellStyle(account_cell_style);

				accountName_cell = row.createCell(2);
				accountName_cell.setCellStyle(accountName_cell_style);

				tuition_cell = row.createCell(3);
				tuition_cell.setCellStyle(tuition_cell_style);

				tuitionTotal_cell = row.createCell(4);
				tuitionTotal_cell.setCellStyle(tuitionTotal_cell_style);

				room_cell = row.createCell(5);
				room_cell.setCellStyle(room_cell_style);

				roomTotal_cell = row.createCell(6);
				roomTotal_cell.setCellStyle(roomTotal_cell_style);

				sumMoney_cell = row.createCell(9);
				sumMoney_cell.setCellStyle(sumMoney_cell_style);

			}

			paidname_cell.setCellValue(strChargeList.get(index)
					.getStudentName());
			account_cell.setCellValue(strChargeList.get(index)
					.getStudentAccount());
			accountName_cell.setCellValue(strChargeList.get(index)
					.getAccountName());

			needPaidTuition = strChargeList.get(index).getTuitionFee()
					- strChargeList.get(index).getPaidTuitionFee();
			if (needPaidTuition < 0) {// 防止倒贴钱
				needPaidTuition = 0;
			}

			if (needPaidTuition > 0) {
				tuition_cell.setCellValue(needPaidTuition);
				tuitionTotal_cell.setCellValue(1);
			} else {
				tuition_cell.setCellValue(0);
				tuitionTotal_cell.setCellValue(0);
			}

			needPaidRoom = strChargeList.get(index).getRoomFee()
					- strChargeList.get(index).getPaidRoomFee();
			if (needPaidRoom < 0) {
				needPaidRoom = 0;
			}
			if (needPaidRoom > 0) {
				room_cell.setCellValue(needPaidRoom);
				roomTotal_cell.setCellValue(1);
			} else {
				room_cell.setCellValue(0);
				roomTotal_cell.setCellValue(0);
			}

			sumMoney = needPaidTuition + needPaidRoom;
			sumMoney_cell.setCellValue(sumMoney);

		}

	}

	@Override
	public Integer getCurrentStudyYear() {
		
		return studentChargeCustomMapper.getCurrentStudyYear();
	}

}
