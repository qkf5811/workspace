package com.dkt.school.stu.service.impl;

import java.util.Date;
import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.stu.model.Clazz;
import com.dkt.school.stu.model.ClazzExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.stu.dao.ClazzCustomMapper;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dao.StudentInfoCustomMapper;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.dto.StudentInfoDto;
import com.dkt.school.stu.service.ClazzService;

/**
 * ClazzService实现类，负责关于班级的业务逻辑
 */
@Service
public class ClazzServiceImpl implements ClazzService {
	
	private ClazzCustomMapper clazzCustomerMapper;
	@Autowired
	public void setClazzCustomerMapper(ClazzCustomMapper clazzCustomerMapper) {
		this.clazzCustomerMapper = clazzCustomerMapper;
	}
	public ClazzCustomMapper getClazzCustomerMapper() {
		return clazzCustomerMapper;
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
	
	private StudentCustomMapper studentCustomerMapper;
	@Autowired
	public void setStudentCustomerMapper(StudentCustomMapper studentCustomerMapper) {
		this.studentCustomerMapper = studentCustomerMapper;
	}
	public StudentCustomMapper getStudentCustomerMapper() {
		return studentCustomerMapper;
	}
	

	
	@Override
	public Integer getClassCountByMajorFieldId(Integer majorFieldId) {
		// TODO Auto-generated method stub
		return clazzCustomerMapper.getClassCountByMajorFieldId(majorFieldId);
	}
	
	@Override
	public List<ClazzDto> getClassByMajorFieldId(Integer majorFieldId) {
		// TODO Auto-generated method stub
		List<ClazzDto> clazzList=clazzCustomerMapper.getClassByMajorFieldId(majorFieldId);
		return clazzList;
	}
	
	@Override
	public Integer toDivideClass(Integer majorFieldId,Integer majorFieldStuCount, Integer classCount) {
		// TODO Auto-generated method stub
		//取得所有班别
		List<ClazzDto> clazzList=getClassByMajorFieldId(majorFieldId);
		for(ClazzDto dto:clazzList){
			System.out.println("name:"+dto.getName()+",majorFieldId:"+dto.getMajorFieldId());
		}
		//取得所有男学生
		List<StudentInfoDto> studentList=studentInfoCustomerMapper.getManStudentsByMajorFieldId(majorFieldId);
		for(StudentInfoDto sDto:studentList){
			System.out.println("name:"+sDto.getName()+",majorFieldId:"+sDto.getMajorFieldId());
		}
		System.out.println("----------------------------------男女分割线------------------------------------");
		//取得所有女学生
		List<StudentInfoDto> studentList2=studentInfoCustomerMapper.getGirlStudentsByMajorFieldId(majorFieldId);
		for(StudentInfoDto sDto:studentList2){
			System.out.println("name:"+sDto.getName()+",majorFieldId:"+sDto.getMajorFieldId());
		}
		System.out.println("专业id为："+majorFieldId+",该专业一共"+majorFieldStuCount+"人,有"+classCount+"个班");
	
		//开始进行分班
		int manCount=studentList.size();
		int grilCount=studentList2.size();
		int eachClassStudentCount=majorFieldStuCount/classCount;
		int rest=majorFieldStuCount%classCount;
		
		
		System.out.println("男生人数："+manCount+",女生人数："+grilCount+",每班人数："+eachClassStudentCount+",剩余人数："+rest);
		
		//学号设置
		String code = "";
		Date date = new Date();
	//	Integer year = (new Date().toString());
		String yearStr = date.toLocaleString().substring(0, 4);   //年份
		String majorFieldIdStr = "";
		if (majorFieldId < 10) {
			majorFieldIdStr = "0" + majorFieldId;   //专业id
		} else {
			majorFieldIdStr = majorFieldId + "";
		}
		code = yearStr + majorFieldIdStr;
		String tmpCode = code;
		
		int count=0;
		boolean type=true;
		int manTemp=0;
		int grilTemp=0;
		int codeInClass = 1;
		for(int i=0;i<majorFieldStuCount;i++){
			
			
			if(type){
				if(manTemp<manCount){
//					System.out.println("i:"+i);
//					System.out.println(studentList.get(manTemp).getName()+"是"+clazzList.get(count).getName()+"班的.");
//					System.out.println("我的男生");
					count=i%classCount;
					//插入到学生表，下面操作相同
					StudentDto dto=new StudentDto();
					StudentInfoDto studentInfoDto=studentList.get(manTemp);
					dto.setName(studentInfoDto.getName());
					dto.setStudentInfoId(studentInfoDto.getId());
		//			dto.setCode("3112002712");
					dto.setClassId(clazzList.get(count).getId());
					//设置学号
					String clazzStr = "";
					String codeInClazz = "";
					int clazz = clazzList.get(count).getId();
					if (clazz < 10) {                  //班级
						clazzStr = "0" + clazz;
					}
					if (codeInClass < 10) {                      //在班里的学号
						codeInClazz = "0" + (codeInClass);
					} else {
						codeInClazz = codeInClass + "";
					}
					code += clazzStr + codeInClazz;
					/*
					System.out.println("学号:" + code);
					System.out.println("year: " + yearStr);
					System.out.println("majorFieldId:" + majorFieldIdStr);
					System.out.println("clazz: " + clazzStr);
					System.out.println("codeInClass:" + clazzStr); */
					dto.setCode(code);     //最终的学号
					
					dto.setStatus(17001);
					dto.setRemark("我是男生"+i);
					//更新学生基本信息
					studentInfoDto.setIsDivideClass(2001);
					studentInfoCustomerMapper.updateByPrimaryKey(studentInfoDto);
					//开始插入到学生表
					int result=studentCustomerMapper.insert(dto);
					System.out.println(result);
					manTemp++;
					if(grilTemp<grilCount){
						type=false;
					}
				}else{
					type=false;
				}
			}else{
				if(grilTemp<grilCount){
//					System.out.println("i:"+i);
//					System.out.println(studentList2.get(grilTemp).getName()+"是"+clazzList.get(count).getName()+"班的.");
//					System.out.println("我的女生");	
					count=i%classCount;
					StudentDto dto=new StudentDto();
					StudentInfoDto studentInfoDto=studentList2.get(grilTemp);
					dto.setName(studentInfoDto.getName());
					dto.setStudentInfoId(studentInfoDto.getId());
				//	dto.setCode("3112002712");
					//设置学号
					String clazzStr = "";
					String codeInClazz = "";
					int clazz = clazzList.get(count).getId();
					if (clazz < 10) {                  //班级
						clazzStr = "0" + clazz;
					}
					if (codeInClass < 10) {                      //在班里的学号
						codeInClazz = "0" + (codeInClass);
					} else {
						codeInClazz = codeInClass + "";
					}
					code += clazzStr + codeInClazz;
					/*System.out.println("学号:" + code);
					System.out.println("year: " + yearStr);
					System.out.println("majorFieldId:" + majorFieldIdStr);
					System.out.println("clazz: " + clazzStr);
					System.out.println("codeInClass:" + clazzStr);*/
					dto.setCode(code);     //最终的学号
					
					dto.setClassId(clazzList.get(count).getId());
					dto.setStatus(17001);
					dto.setRemark("我是女生生"+i);
					studentInfoDto.setIsDivideClass(2001);
					studentInfoCustomerMapper.updateByPrimaryKey(studentInfoDto);
					int result=studentCustomerMapper.insert(dto);
					System.out.println(result);
					grilTemp++;
					if(manTemp<manCount){
						type=true;
					}
				}else{
					type=true;
				}
			}
			//设置完一个后
			code = tmpCode;
			codeInClass++;
			if (codeInClass > eachClassStudentCount)
				codeInClass = 1;
		}
		return 1;
	}

	public int myClassCount(Integer id) {
		return clazzCustomerMapper.myClassCount(id);
	}
	
	public List<ClazzDto> getMyClassesByPage(Integer id,Pagination page) {
		return clazzCustomerMapper.getMyClassByTeacherId(id,page.getLimitation());
	}
	
	public int getClassCount(String name, Integer gradeId, Integer majorFieldId, String teacherName) {
		return clazzCustomerMapper.countBySearch(name, gradeId, majorFieldId, teacherName);
	}

	public List<ClazzDto> getClassesByPage(String name, Integer gradeId, Integer majorFieldId, String teacherName, Pagination page) {
		return clazzCustomerMapper.selectByLimit(name,gradeId,majorFieldId,teacherName,page.getLimitation());
	}


	public int addClazz(Clazz clazz) {
		return clazzCustomerMapper.insert(clazz);
	}


	public int updateClazz(Clazz clazz) {
		return clazzCustomerMapper.updateByPrimaryKey(clazz);
	}


	public int deleteClazzById(Integer id) {
		return clazzCustomerMapper.deleteByPrimaryKey(id);
	}


	public ClazzDto findClazzByClazzId(Integer id) {

		return clazzCustomerMapper.selectClazzDtoByClazzId(id);
	}
	
	
	@Override
	public List<ClazzDto> getClassOfGradeOneByMajorFieldId(int majorFieldId) {
		return clazzCustomerMapper.getClassOfGradeOneByMajorFieldId(majorFieldId);
	}
	
	
	@Override
	public int getClassCountByteaId(int teacherId) {
		ClazzExample example= new ClazzExample();
		example.createCriteria().andTeacherIdEqualTo(teacherId);
		return clazzCustomerMapper.countByExample(example);
	}
	
	@Override
	public String getClassNameById(int classId) {
		String className="";
		className=clazzCustomerMapper.selectByPrimaryKey(classId).getName();
		return className;
	}


}
