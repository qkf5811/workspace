package com.dkt.school.fin.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.fin.controller.StudentAccountController;
import com.dkt.school.fin.dao.StudentAccountCustomMapper;
import com.dkt.school.fin.dto.StudentAccountDto;
import com.dkt.school.fin.service.StudentAccountService;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.tea.dto.TeacherTotalInfoDto;

@Service
public class StudentAccountServiceImpl implements StudentAccountService{
	@Autowired
	private StudentAccountCustomMapper studentAccountCustomMapper;
	
	@Autowired
	private StudentCustomMapper studentCustomMapper;

	
	//取得学生账号的数量
	@Override
	public Integer getStudentAccountCount(String finStuName, Integer finGrade,
			String finClassName, Integer finMajor, Integer finField) {
		// TODO Auto-generated method stub
		return studentAccountCustomMapper.getStudentAccountCount(finStuName,finGrade,finClassName,finMajor,finField);
	}

	//分页模糊查询学生账号
	@Override
	public List<StudentAccountDto> getStudentAccountsByPage(String finStuName,
			Integer finGrade, String finClassName, Integer finMajor,
			Integer finField, PaginationCustom page) {
		// TODO Auto-generated method stub
		return studentAccountCustomMapper.selectByLimit(finStuName,finGrade,finClassName,finMajor,finField, page.getLimitation());
	}

	//更新学生账号信息
	@Override
	public Integer updateStudentAccount(StudentAccountDto studentAccountDto) {
		// TODO Auto-generated method stub
		String account = studentAccountCustomMapper.findSameAccount(studentAccountDto.getAccount(),studentAccountDto.getStudentId());
		if(account!=null) {
			return -1;
		}
		return studentAccountCustomMapper.updateByPrimaryKey(studentAccountDto);
	}
	
	//添加学生账号记录
	@Override
	public Integer addStudentAccount(StudentAccountDto studentAccountDto) {
		
		StudentDto studentDto = studentCustomMapper.getStudentByCode(studentAccountDto.getFinStuCode());
		int result = 0;
		if (studentDto.getId() == null || "".equals(studentDto.getId())) {
			return -1;
		}
		
		studentAccountDto.setStudentId(studentDto.getId());
		// 判断记录是否存在
		StudentAccountDto saDto = studentAccountCustomMapper.findStudentAccountByStudentId(studentDto.getId());
		if (saDto == null) {
			String account = studentAccountCustomMapper.findSameAccount(studentAccountDto.getAccount(),studentAccountDto.getStudentId());
			if(account!=null) {
				return -3;
			}
			return studentAccountCustomMapper.insert(studentAccountDto);
		} else {
			result = -2;
		}
		return result;		
		
	}

	//查询学生账号
	@Override
	public List<StudentAccountDto> getStudentAccounts() {
		// TODO Auto-generated method stub
		return studentAccountCustomMapper.getStudentAccounts();
	}

	//查找所有的学生
	@Override
	public List<StudentDto> findAllStudent() {
		// TODO Auto-generated method stub
		return studentCustomMapper.findAllStudents();
	}

	/**
	 * 根据模板文件路径填充学生银行账号信息
	 * @param stuIds
	 * @param dir
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Override
	public int getStudentAccountExcel(Integer[] stuIds, File dir)
			throws FileNotFoundException, IOException {
		// 先清空模板然后设置
		InputStream in = new FileInputStream(dir);
		File outputFile = new File(dir.getParent() + "/学生银行账号信息批量录入模板(填充).xls");
		OutputStream out = new FileOutputStream(outputFile);	
		
		Workbook wb = new HSSFWorkbook(in);
		
		/*CellStyle ss = wb.createCellStyle();    
		ss.setLocked(false);
		HSSFCellStyle cs = (HSSFCellStyle) wb.createCellStyle();
	    cs.setLocked(false);*/
		Sheet sheet1 = wb.getSheetAt(0);
		int tmp = 0;
		/*List<StudentDto> stuDtos = new ArrayList<StudentDto>();*/
		/*// 标题
		//行列都需要创建，这样才可以取值
		Cell name = sheet1.getRow(0).getCell(0);
		//虽然某行前3格单元格合并了，但第四个单元格的下标依然是3
		Cell m = sheet1.getRow(0).createCell(9);
		name.setCellType(Cell.CELL_TYPE_STRING);//取值的时候才需要设定
		name.setCellValue("录入");
		m.setCellValue("xuyao");*/
		for(int i =0;i<stuIds.length;i++) {
			StudentDto studentDto = studentCustomMapper.findStudentBystuId(stuIds[i]);
			// 序号
			Cell name = sheet1.createRow(i+3).createCell(0);
			/*name.setCellStyle(ss);*/
			name.setCellType(Cell.CELL_TYPE_NUMERIC);
			name.setCellValue(i+1);
			
			// 年级
			Cell grade = sheet1.getRow(i+3).createCell(1);
			/*grade.setCellStyle(ss);*/
			grade.setCellType(Cell.CELL_TYPE_STRING);
			grade.setCellValue(studentDto.getGradeName());	
			/*grade.getCellStyle().setLocked(true);*/
			// 所属专业
			Cell major = sheet1.getRow(i+3).createCell(2);
			/*major.setCellStyle(ss);*/
			major.setCellType(Cell.CELL_TYPE_STRING);
			major.setCellValue(studentDto.getMajorName());
			/*major.getCellStyle().setLocked(true);*/
			// 专业方向
			Cell field = sheet1.getRow(i+3).createCell(3);
			field.setCellType(Cell.CELL_TYPE_STRING);
			field.setCellValue(studentDto.getMajorFieldName());	
			/*field.getCellStyle().setLocked(true);*/
			// 班级
			Cell className = sheet1.getRow(i+3).createCell(4);
			
			className.setCellType(Cell.CELL_TYPE_STRING);
			className.setCellValue(studentDto.getFinClassName());	
			
			//学生姓名
			Cell stuName = sheet1.getRow(i+3).createCell(5);
			stuName.setCellType(Cell.CELL_TYPE_STRING);
			stuName.setCellValue(studentDto.getName());
			/*stuName.getCellStyle().setLocked(true);*/
			//学号
			Cell stuCode = sheet1.getRow(i+3).createCell(6);
			stuCode.setCellType(Cell.CELL_TYPE_STRING);
			stuCode.setCellValue(studentDto.getCode());
			/*stuCode.getCellStyle().setLocked(true);*/
			
			//填充第十咧
			Cell a  = sheet1.getRow(i+3).createCell(9);
			a.setCellType(Cell.CELL_TYPE_STRING);
			a.setCellValue(" ");
						
			
			
		}
		
		wb.write(out);
		// 关闭流
		in.close();
		out.close();
		return 1;
	}

	/**
	 * 通过excel导入学生账号信息
	 * @param inputStream
	 * @param format
	 * @return
	 */
	@Override
	public long addStudentAccountByExcel(InputStream inputStream, String format) throws BadSqlGrammarException,IllegalStateException {
		List<StudentAccountDto> sadList = new ArrayList<StudentAccountDto>();
		List<StudentAccountDto> upsadList = new ArrayList<StudentAccountDto>();
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
		boolean exit = false;  //学生账号记录已存在，更新
		boolean studentHere = true; //判断学生是否存在
		boolean trueAccount = false; //判断账号是否符合16或19位数字
		boolean sameAccount = false; //判断账号是否已有
		boolean exitCode = true;
		boolean exitName = true;
		boolean exitAccount = true;
		List<String> accountStr = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			Row row = rows.next();
			
			if (row.getRowNum() == 0||row.getRowNum() == 1) {
				continue;
			}
			
			
			Iterator<Cell> cells = row.cellIterator();
			StudentAccountDto studentAccountDto = new StudentAccountDto();
			if(row.getRowNum() == 2)  {
				for(int i=6;i<row.getLastCellNum();++i){
					Cell cell = row.getCell(i);
					if (i == 6) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String code = cell.getStringCellValue();
						code = code.trim();
						if(!code.equals("学号")) {
							exitCode = false;
							System.out.println("xuehao");
						}
						
						
											
					} else if (i == 7) { // 学生户名
							
	
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						name = name.trim();
						if(!name.equals("银行户名")) {
							exitName = false;
							System.out.println("yinhanghuming");
						}
											
					
							
					}else if (i == 8) { // 学生账号
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String account = cell.getStringCellValue();
						account = account.trim();
						if(!account.equals("银行账号")) {
							exitAccount = false;
							System.out.println("yinhangzhnaghao");
						}
					}
				}
				continue;
			}
			
			for (int index = 6; index < row.getLastCellNum(); ++index) {
				Cell cell = row.getCell(index);
				if (index == 6) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String code = cell.getStringCellValue();
					System.out.println("学号-------------------：" + code);
					code = code.trim();
					StudentDto stu = studentCustomMapper.findStudent(code);
					if(stu==null) {
						studentHere=false;
						System.out.println("studentHere:false");
						break;
						
					}else{
						StudentAccountDto so = studentAccountCustomMapper.findStudentAccountByStudentId(stu.getId());
						if (so != null) 
							exit = true;
						
						System.out.println("工号:" + code);
						studentAccountDto.setStudentId(stu.getId());
					}
					
				} else if (index == 7) { // 学生户名
						
						if (cell != null) {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							
							if (cell.getStringCellValue() == null || cell.getStringCellValue().trim().equals("")) {
								
								flag = true;//为空行
								break;
							}
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String name = cell.getStringCellValue();
							name = name.trim();
							studentAccountDto.setName(name);
						} else {
							flag = true;
						}
						
						
				}else if (index == 8) { // 学生账号
					if (cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if ( cell.getStringCellValue() == null || cell.getStringCellValue().trim().equals("")) {
							
							flag = true;//为空行
						
						} else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String account = cell.getStringCellValue();
							account = account.trim();
							
							//自己不可以插入除本人账号相同外的已有相同账号
							if(studentAccountCustomMapper.findSameAccount(account,studentAccountDto.getStudentId())!=null){
								sameAccount=true;
							}
							accountStr.add(account);
							if (!"".equals(account)) {
								 char num[] = account.toCharArray();//把字符串转换为字符数组
								 for (int i = 0; i < num.length; i++) {
									 if (Character.isDigit(num[i])) {
										 if(account.length()==16 ||account.length()==19) 
											 trueAccount=true;
									 }
								}
							}
							
							studentAccountDto.setAccount(account);
						}
						
					} else {
						flag = true;
					}
						
						
				}
			}
			
		
			if (!flag && !exit) //不为空行且工号不存在则插入
				sadList.add(studentAccountDto);
			if (!flag && exit) //不为空行且工号尊在则更新
				upsadList.add(studentAccountDto);
			//还原
			flag = false;
			exit = false;
			
		}
		if(exitCode==false && exitName == false && exitAccount == false ) {
			return -5;
		}
		//学生不存在
		if(studentHere==false) {
			System.out.println("result:-6");
			return -6;
		}
		
		
		if(sameAccount==true) {
			return -8;
		}
		
		//判断插入的excel记录中是否存在账号重复的问题
		for(int i = 0; i<accountStr.size()-1;i++) {
			for(int j = i+1;j<accountStr.size();j++) {
				if(accountStr.get(i).equals(accountStr.get(j))) {
					return -9;
				}
			}
		}
		
		if(trueAccount==false) {
			return -7;
		}
		
		// 插入学生账号
		int c  = 0;
		int cc  = 0;
		if (sadList.size() > 0) {
			c = studentAccountCustomMapper.addStudentAccountByList(sadList);
			if (c != sadList.size()) { //插入学生账号失败 
				studentAccountCustomMapper.deleteStudentAccountByList(sadList);
				return -3;
			}
		}
		// 更新学生账号表
		if (upsadList.size() > 0)
			cc = studentAccountCustomMapper.updateStudentAccountrByList(upsadList);
		
				
		if (sadList.size() > 0 && upsadList.size() == 0)
			return c;
		else if (upsadList.size() > 0 && sadList.size() == 0)
			return cc + 10000;
		else if(sadList.size() > 0 && upsadList.size() > 0) {
			int dtoRes = 10000 + sadList.size();
			int updRes = 10000 + upsadList.size();
			System.out.println("test: " + Long.parseLong(dtoRes + "" + updRes));
			return Long.parseLong(dtoRes + "" + updRes);
		}
		else 
			return -3; // 格式错误
	}

	//取得所有未录入的学生的id
	@Override
	public List<Integer> getStudentIdsByNotSettingStudentAccount() {
		// TODO Auto-generated method stub
		return studentAccountCustomMapper.getStudentIdsByNotSettingStudentAccount();
	}

}
