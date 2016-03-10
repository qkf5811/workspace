package com.dkt.school.tea.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dao.TeacherWorkExperienceCustomMapper;
import com.dkt.school.tea.dao.TeacherWorkExperienceMapper;
import com.dkt.school.tea.dto.TeacherWorkExperienceDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.model.TeacherWorkExperience;
import com.dkt.school.tea.service.TeacherResumeService;

@Service
public class TeacherResumeServiceImpl implements TeacherResumeService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TeacherWorkExperienceCustomMapper cMapper;
	
	@Autowired
	private TeacherWorkExperienceMapper mapper;

	@Override
	public List<TeacherWorkExperienceDto> getTeacherWorkList(String code,String name,Limitation limit) {
		return cMapper.getTeacherWorkList(code,name,limit);
	}

	@Override
	public Integer getTeacherWorkCount(String code,String name) {
		return cMapper.getTeacherWorkCount(code,name);
	}

	@Override
	public int deleteTeaWorkItem(Integer id) {
		return cMapper.deleteWorkItemById(id);
	}

	@Override
	public TeacherWorkExperienceDto getTeacherWorkExperienceById(Integer id) {
		return cMapper.getTeacherWorkExperienceById(id);
	}

	@Override
	public int updateResumeItem(TeacherWorkExperience record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int addSingleResumeInfo(TeacherWorkExperience record) {
		System.out.println(record.getTransferCause());
		return mapper.insertSelective(record);
	}

	@Override
	public int getTeahcerCount(String name,String code) {
		return cMapper.getTeacherCount(name, code);
	}

	@Override
	public List<Teacher> getAllTeacher(String name,String code,Limitation limit) {
		List<Teacher> list = cMapper.getAllTeacher(name,code,limit);
		if (list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	@Override
	public int importTeaResumeByXLS(InputStream inputStream, String ext) {
		List<TeacherWorkExperience> list = new ArrayList<TeacherWorkExperience>();
		try{
			Workbook wb = null;
			if (ext.equalsIgnoreCase("xls")){
				wb = new HSSFWorkbook(inputStream);
			} else if (ext.equalsIgnoreCase("xlsx")){
				wb = new XSSFWorkbook(inputStream);
			}
			//获得第一张excel表
			Sheet sheet = wb.getSheetAt(0);
			//Iterator<Row> rowIter = sheet.rowIterator();
			for (int i = 0;i < sheet.getLastRowNum();i++){
				Row row = sheet.getRow(i);
			
			//while (rowIter.hasNext()){
			//	Row row = rowIter.next();
				//处理完一行生成一个对象(一个row映射一个TeacherWorkExperience)
				TeacherWorkExperience twe = new TeacherWorkExperience();
				System.out.println("第一列:"+row.getFirstCellNum());
				System.out.println("最末列:"+row.getLastCellNum());
				if (row.getRowNum() == 0){
					//第一行表头不做处理
					continue;
				}
				//Iterator<Cell> cellIter = row.cellIterator();
				Cell cell = null;
				/*
				while (cellIter.hasNext() && 			//
						cellIter.next().getColumnIndex() < row.getLastCellNum()){
						*/
				cell = row.getCell(0);		//取第一个单元格  code,再根据code获取teacherId
				System.out.println(cell == null);
				logger.info("----code:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					int teacherId;
					if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()){	
						teacherId = getTeacherIdByCode(String.valueOf((int)cell.getNumericCellValue()));
						logger.info("-----------------------教师编号："+teacherId+"-----------------------");
					} else {
						teacherId = getTeacherIdByCode(cell.getStringCellValue());
					}
					//logger.info("--------编号："+cell.getStringCellValue()+"----------教师ID："+teacherId+"-------------------");
					twe.setTeacherId(teacherId);
				}
				cell = row.getCell(1);		//取第二个单元格  workPlace
				logger.info("----workPlace:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					twe.setWorkPlace(cell.getStringCellValue());
				}
				cell = row.getCell(2);		//取第三个单元格  position
				logger.info("----position:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					twe.setPosition(cell.getStringCellValue());
				}
				cell = row.getCell(3);		//取第四个单元格  startDate
				logger.info("----startDate:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					//twe.setStartDate(new Date(cell.getNumericCellValue()));
					java.util.Date temp = cell.getDateCellValue();
					java.sql.Date startDate = new java.sql.Date(temp.getTime());
					System.out.println("开始日期：=="+startDate);
					twe.setStartDate(startDate);
				} 
				cell =  row.getCell(4);		//取第五个单元格  endDate
				logger.info("----endDate:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					java.util.Date temp = cell.getDateCellValue();
					java.sql.Date endDate = new java.sql.Date(temp.getTime());
					System.out.println("结束日期：=="+endDate);
					twe.setEndDate(endDate);
				}
				cell =  row.getCell(5);		//取第六个单元格  transferCause
				logger.info("----transferCause:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					twe.setTransferCause(cell.getStringCellValue());
				}
				cell =  row.getCell(6);		//取第七个单元格  remark
				logger.info("----remark:"+cell.getColumnIndex()+"-----");
				if (cell != null){
					twe.setRemark(cell.getStringCellValue());
				}
				list.add(twe);
			
			logger.info("-----------list的大小------------"+list.size()+"");
			}
		} catch(NullPointerException npe){
			npe.printStackTrace();
			return -2;
		}catch (IllegalStateException e){
			e.printStackTrace();
			//内部数据错误
			return -2;
		} catch (BindingException bex){
			bex.printStackTrace();
			return -2;
		} catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return cMapper.insertTeaWorkExperienceByXLS(list);
	}

	@Override
	public int getTeacherIdByCode(String code) {
		return cMapper.getTeacherIdByCode(code);
	}

	@Override
	public void downloadTeaResumeExcel(InputStream in,File file) {
		FileOutputStream out = null;
		try {
			Workbook wb = new HSSFWorkbook(in);
			Sheet sheet1 = wb.createSheet();
			//设置表头
			Row row = sheet1.getRow(0);
			row.createCell(0).setCellValue("教师编号");
			row.createCell(1).setCellValue("所属单位");
			row.createCell(2).setCellValue("职位");
			row.createCell(3).setCellValue("开始时间");
			row.createCell(4).setCellValue("结束时间");
			row.createCell(5).setCellValue("调动原因");
			row.createCell(6).setCellValue("备注信息");
			
			out = new FileOutputStream(file);
			wb.write(out);
			out.close();
		}  catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("文件不存在!!!");
		} finally{
			try{
				if (out != null){
					out.close();
				} 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Integer getSingleWorkExperienceCount(Integer id) {
		
		return cMapper.getSingleWorkExperienceCount(id);
	}

	@Override
	public List<TeacherWorkExperienceDto> getSingleWorkExperienceById(Integer id) {
		return cMapper.getSingleWorkExperienceById(id);
	}
	
}
