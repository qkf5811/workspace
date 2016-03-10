package com.dkt.school.fin.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dao.NewStudentPaymentCustomMapper;
import com.dkt.school.fin.dto.NewStudentPaymentOfExcelDto;
import com.dkt.school.fin.model.NewStudentPayment;
import com.dkt.school.fin.service.NewStudentPaymentService;
import com.dkt.school.stu.dao.StudentInfoCustomMapper;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;

@Service
@Transactional
public class NewStudentPaymentServiceImpl implements NewStudentPaymentService {

	@Autowired
	private NewStudentPaymentCustomMapper nspcMapper;
	
	@Autowired
	private EnumerationService enumerationService;
	
	@Autowired
	private StudentInfoCustomMapper sicMapper;
	
	@Override
	public long importNewStudentPaymentByExcel(InputStream in) {
		// TODO Auto-generated method stub
		//各种List
		//缴费方式
		List<EnumerationValue> payType = enumerationService.getEnumValueListByEnumId(EnumerationType.PAY_TYPE);
		
		Workbook wb = null;
		try {
			wb =  new HSSFWorkbook(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -4;//非Excel文件
		}
		
		List<NewStudentPaymentOfExcelDto> list = new ArrayList<NewStudentPaymentOfExcelDto>();
		List<NewStudentPaymentOfExcelDto> updList = new ArrayList<NewStudentPaymentOfExcelDto>();
		
		boolean exist = false;
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;	
		for (int i = 0; i <= sheet.getLastRowNum(); ++i) { //行循环
			
			//每行相当于一个NewStudentPaymentOfExcelDto
			NewStudentPaymentOfExcelDto dto = new NewStudentPaymentOfExcelDto();
			
	//		System.out.println("lastRowNum: " + sheet.getLastRowNum());
			row = sheet.getRow(i);
			if (row.getRowNum() == 0 ||
					row.getRowNum() == 1 ||
					row.getRowNum() == 2) {
				continue; //1,2,3行不读取
			}

			for (int j = 1; j <= row.getLastCellNum(); ++j) {//列循环
				
				cell = row.getCell(j);
				
				if (j == 1) {
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("姓名: " + name);
						dto.setName(name);
					} else {
						return -5;//格式错误
					}
				} else if (j == 2) {  //录取号
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("录取号码: " + name);
						dto.setAdmissionNumber(name);
					} else {
						
						return -5;//格式错误
					}
				} else if (j == 3) {
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("专业: " + name);
						dto.setMajorField(name);
					} else {
						return -5;//格式错误
					}
				} else if (j == 4) {
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("身份证: " + name);
						Integer id;
						try {
							 id = sicMapper.selectIdByIdCard(name);
						} catch(BindingException e) {
							e.printStackTrace();
							return -1000 - i + 2;
						} catch(MyBatisSystemException e) {
							e.printStackTrace();
					//		throw e;
							return -10000 - i + 2;
						}
						NewStudentPayment tmp = nspcMapper.selectNewStudentPaymentByStudentInfoId(id);
						if (tmp != null)
							exist = true;
						dto.setIdCard(name);
					} else {
						
						return -5;//格式错误
					}
				} else if (j == 5) {
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						float name = (float) cell.getNumericCellValue();
						System.out.println("缴费金额: " + name);
						dto.setPayMoney(name);
					} else {
						return -5;//格式错误
					}
				} else if (j == 6) {  //缴费方式
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						boolean isExist = false;
						String name = cell.getStringCellValue();
						System.out.println("汇款方式: " + name);
						for (int t = 0; t < payType.size(); ++t) {
							
							if (name.trim().equals(payType.get(t).getName())) {
								dto.setPayType(payType.get(t).getId());
								isExist = true;
								break;
							}
						}
						if (!isExist) {
							return -5;//格式错误
						}
					} else {
						
						return -5; //格式错误
					}
					
				} else if (j == 7) {
					
					if (cell != null) {
						
						String name = new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
						System.out.println("缴费日期: " + name);
						dto.setPayTime(cell.getDateCellValue());
					} else  {
						return -5;//格式错误
					}
				} else if (j == 8) {
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("单号: " + name);
						dto.setPayOrder(name);
					} else {
						return -5;//格式错误
					}
				} else if (j == 9) {
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String name = cell.getStringCellValue();
						System.out.println("备注: " + name);
						dto.setRemark(name);
					}
				}
			}
			if (!exist)
				list.add(dto);
			else 
				updList.add(dto);
			System.out.println("list.size : " + list.size() + "\nupdList.size: " + updList.size());
			//还原
			exist = false;
		}
		
		//导入前设置日期的字符串格式
		//导入前先得到对应的student_info_id
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); ++i) {
				
				list.get(i).setTimeStr(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(list.get(i).getPayTime()));
				
				try {
					int stuId = sicMapper.selectIdByIdCard(list.get(i).getIdCard());
					System.out.println("student info id: " + stuId);
					if (stuId == 0) {
						return -1000 - i - 1;//根据该身份证号找不到对应的学生信息,出错序号是i+1
					} else {
						list.get(i).setStudentInfoId(stuId);
					}
				} catch(BindingException e) {
					
					e.printStackTrace();
					return -1000 - i - 1;//根据该身份证号找不到对应的学生信息,出错序号是i+1
				}
			}
		}
		
		//更新前设置日期的字符串格式
		//更新前先得到对应的student_info_id
		if (updList.size() > 0) {
			for (int i = 0; i < updList.size(); ++i) {
						
				updList.get(i).setTimeStr(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(updList.get(i).getPayTime()));
						
				try {
					int stuId = sicMapper.selectIdByIdCard(updList.get(i).getIdCard());
					System.out.println("update student info id: " + stuId);
					if (stuId == 0) {
						return -1000 - i - 1;//根据该身份证号找不到对应的学生信息,出错序号是i+1
					} else {
						updList.get(i).setStudentInfoId(stuId);
					}
				} catch(BindingException e) {
							
					e.printStackTrace();
					return -1000 - i - 1;//根据该身份证号找不到对应的学生信息,出错序号是i+1
				}
			}
		}
		
		
		//根据 student_info_id 判断该新生缴费资料记录是否存在，存在则报错返回
//		for (int i = 0; i < list.size(); ++i) {
//			
//			List<NewStudentPaymentOfExcelDto> tmp = nspcMapper.selectNewStudentPaymentsByStudentInfoId(list);
//			
//			if (tmp.size() > 0) {
//				
//				System.out.println(tmp.get(0).getIdCard());
//				System.out.println(Long.parseLong(tmp.get(0).getIdCard()));
//				return Long.parseLong(tmp.get(0).getIdCard());
//			}
//			
//		}
		//批量导入
		long result = 0;
		if (list.size() > 0) {
			result = nspcMapper.insertNewStudentPaymentByExcel(list);
			if (result != list.size()) {
				//删除（手动回滚）
				nspcMapper.deleteNewStudentPaymentsBystuId(list);
				result = 0;//sql出错
			} else {
				//没有出错则更新录取号到stu_student_info表(批量更新)
				sicMapper.updateAdmissionByNewStudentPaymentOfExcelDto(list);
				result = 10000 + result;  //返回插入的结果
			}
		}
		//批量更新
		long update = 0;
		if (updList.size() > 0) {
			update = nspcMapper.updateByList(updList);
		}
		
		if (list.size() > 0 && updList.size() > 0)
			result = Long.parseLong(result + "" + 1000 + update);
		else if (list.size() > 0)
			;
		else if (updList.size() > 0)
			result = 100000 + update;
		return result;//nspcMapper.insertNewStudentPaymentByExcel();
	}

	@Override
	public int findNewStudentPaymentCountByPage(String name, String admissionNumber, String idCard,
			int fieldId, PaginationCustom page) {
		// TODO Auto-generated method stub
		return nspcMapper.selectNewStudentPaymentCountByPage(name, admissionNumber, idCard, fieldId, page.getLimitation());
	}

	@Override
	public List<NewStudentPaymentOfExcelDto> findNewStudentPaymentByPage(
			String name, String admissionNumber, String idCard, int fieldId, PaginationCustom page) {
		// TODO Auto-generated method stub
		return nspcMapper.selectNewStudentPaymentByPage(name, admissionNumber, idCard, fieldId, page.getLimitation());
	}

}
