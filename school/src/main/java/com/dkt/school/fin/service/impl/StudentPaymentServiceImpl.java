package com.dkt.school.fin.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dao.StudentPaymentCustomMapper;
import com.dkt.school.fin.dto.StudentPaymentDto;
import com.dkt.school.fin.service.StudentPaymentService;

@Service
public class StudentPaymentServiceImpl implements StudentPaymentService {

	private static Logger logger 
		= LoggerFactory.getLogger(StudentPaymentServiceImpl.class);
	@Autowired
	private StudentPaymentCustomMapper cMapper;
	
	@Override
	public List<StudentPaymentDto> getStudentPaymentList(String stuPayName,
			String stuPayCode, Limitation limit) {
		List<StudentPaymentDto> list = cMapper.getStuPayList(stuPayName, stuPayCode, limit);
		if (list != null && list.size() > 0){
			for (StudentPaymentDto dto : list){
				switch(dto.getPayType()){
					case 39001:
						dto.setPayTypeStr("现金");
						break;
					case 39002:
						dto.setPayTypeStr("POS");
						break;
					case 39003:
						dto.setPayTypeStr("汇款");
						break;
					default : 
						break;
				}
			}
		}
		return list;
	}

	@Override
	public Integer getStudentPaymentCount(String stuPayName, String stuPayCode) {
		
		return cMapper.getStuPayCount(stuPayName, stuPayCode);
	}

	
	@Override
	public List<StudentPaymentDto> exportStuPayList(String param) {
		List<String> list = Arrays.asList(param);
		List<StudentPaymentDto> stuList = cMapper.exportStuPayList(list);
		return stuList;
	}
	
	
	
	/**
	 * 导入扣费excel文件清单(参考扣费清单文件)
	 * @param inputStream 
	 * @param ext 
	 * @return
	 */
	@Override
	public Integer uploadStuPayInfoExcel(InputStream inputStream, String ext) {
		Integer result = null;					//插入结果
		List<StudentPaymentDto> list = new ArrayList<StudentPaymentDto>();
		Workbook wb = null;
		try{
			if (ext.equalsIgnoreCase("xls")){
				wb = new HSSFWorkbook(inputStream);
			} else if (ext.equalsIgnoreCase("xlsx")){
				wb = new XSSFWorkbook(inputStream);
			}else {
				//文件格式错误
				return -1;
			}
			
			//continue to write code here
			//获得第一张表
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIter = sheet.rowIterator();
			while (rowIter.hasNext()){
				//根据扣费清单的模板,从excel文件的第六行开始读取数据
				if (rowIter.next().getRowNum() < 5)
					continue;
				Row row = rowIter.next();
				System.out.println("-----行号："+row.getRowNum());
				StudentPaymentDto sp = new StudentPaymentDto();
				Iterator<Cell> cellIter = row.cellIterator();
				while (cellIter.hasNext()){
					Cell cell = cellIter.next();
					if (cell.getColumnIndex() == 0){ 		//缴费人姓名
						sp.setStuPayName(cell.getStringCellValue());
					}
					if (cell.getColumnIndex() == 1){		//缴费人账号
						sp.setStuPayAccount(cell.getStringCellValue());
					} 
					if (cell.getColumnIndex() == 2){		//缴费人户主姓名
						sp.setStuAccountName(cell.getStringCellValue());
					}
					if (cell.getColumnIndex() == 3){		//收费项目一学费
						sp.setTuitionFee(Float.valueOf(cell.getNumericCellValue()+""));
					}
					if (cell.getColumnIndex() == 5){		//收费项目二住宿费
						sp.setRoomFee(Float.valueOf(cell.getNumericCellValue()+""));
					}
					if (cell.getColumnIndex() == 9){		//总共金额
						sp.setPayMoney(Float.valueOf(cell.getNumericCellValue()+""));
					}
					if (cell.getColumnIndex() == 10){		//备注
						sp.setRemark(cell.getNumericCellValue()+"");
					}
				}
				list.add(sp);
			}
			result = cMapper.insertStuPayList(list);
			cMapper.insertStuChargeList(list);
		}catch (IllegalStateException e){
			//内部数据错误
			return -2;
		} catch (BindingException bex){
			return -2;
		} catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		//返回插入了多少条记录
		return result;
	}
	

	/**
	 * 导出到excel表(需求变更，已作废)
	 */
	@Override
	public void export2Excel(List<StudentPaymentDto> list, File file) {
		try{
			OutputStream out = new FileOutputStream(file);
			Workbook wb = new HSSFWorkbook();
			//获得第一张表
			Sheet sheet = wb.getSheetAt(0);
			int index = 8;
			//从第九行开始插入数据
			for (StudentPaymentDto dto : list){
				Row row = sheet.getRow(index);
				//插入缴费人姓名
				Cell cell0 = row.getCell(0);
				cell0.setCellType(Cell.CELL_TYPE_STRING);
				cell0.setCellValue(dto.getStuPayName());
				//插入缴费账号
				Cell cell1 = row.getCell(1);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				cell1.setCellValue(dto.getStuPayAccount());
				//插入户主姓名
				Cell cell2 = row.getCell(2);
				cell2.setCellType(Cell.CELL_TYPE_STRING);
				cell2.setCellValue(dto.getStuAccountName());
				//插入还未交的学费额
				Cell cell3 = row.getCell(3);
				cell3.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell3.setCellValue(dto.getTuitionFee() - dto.getPaidTuitionFee());
				//数量固定1
				Cell cell4 = row.getCell(4);
				cell4.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell4.setCellValue(1);
				//插入还未交的住宿费
				Cell cell5 = row.getCell(5);
				cell5.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell5.setCellValue(dto.getRoomFee() - dto.getPaidRoomFee());
				//数量固定1
				Cell cell6 = row.getCell(6);
				cell6.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell6.setCellValue(1);
				//小计
				Cell cell9 = row.getCell(9);
				cell9.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell9.setCellValue((dto.getTuitionFee() + dto.getRoomFee())
						   - (dto.getPaidTuitionFee()+dto.getRoomFee()));
				++index;
			}
			wb.write(out);
			out.close();
				
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
