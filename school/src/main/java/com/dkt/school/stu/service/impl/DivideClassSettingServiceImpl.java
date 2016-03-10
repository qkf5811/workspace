package com.dkt.school.stu.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dao.MajorFieldMapper;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.model.MajorFieldExample;
import com.dkt.school.stu.dao.ClazzCustomMapper;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dao.StudentInfoCustomMapper;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.DivideClassDto;
import com.dkt.school.stu.dto.StudentToBeDividedDto;
import com.dkt.school.stu.model.Clazz;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.model.StudentInfo;
import com.dkt.school.stu.service.DivideClassSettingService;

@Service
public class DivideClassSettingServiceImpl implements DivideClassSettingService {

	private ClazzCustomMapper clazzCustomMapper;
	private StudentCustomMapper studentCustomMapper;
	private StudentInfoCustomMapper studentInfoCustomMapper;
	private MajorFieldMapper majorFieldMapper;
	
	
	public MajorFieldMapper getMajorFieldMapper() {
		return majorFieldMapper;
	}
	@Autowired
	public void setMajorFieldMapper(MajorFieldMapper majorFieldMapper) {
		this.majorFieldMapper = majorFieldMapper;
	}
	public StudentInfoCustomMapper getStudentInfoCustomMapper() {
		return studentInfoCustomMapper;
	}
	@Autowired
	public void setStudentInfoCustomMapper(
			StudentInfoCustomMapper studentInfoCustomMapper) {
		this.studentInfoCustomMapper = studentInfoCustomMapper;
	}
	public StudentCustomMapper getStudentCustomMapper() {
		return studentCustomMapper;
	}
	@Autowired
	public void setStudentCustomMapper(StudentCustomMapper studentCustomMapper) {
		this.studentCustomMapper = studentCustomMapper;
	}
	public ClazzCustomMapper getClazzCustomMapper() {
		return clazzCustomMapper;
	}
	@Autowired
	public void setClazzCustomMapper(ClazzCustomMapper clazzCustomMapper) {
		this.clazzCustomMapper = clazzCustomMapper;
	}
	@Override
	public List<DivideClassDto> selectTotalInfoOfDivideClass(
			PaginationCustom page) {		
		return clazzCustomMapper.selectTotalInfoOfDivideClass(page.getLimitation());
	}
	@Override
	public List<StudentToBeDividedDto> selectStudentsToDivide(
			StudentToBeDividedDto dto, PaginationCustom page) {
		return studentCustomMapper.selectStudentsToDivide(dto,page.getLimitation());
	}
	@Override
	public int selectCountOfStudentsToDivide(StudentToBeDividedDto dto) {		
		return studentCustomMapper.selectCountOfStudentsToDivide(dto);
	}
	@Override
	public int selectCountOfTotalInfoOfDivideClass() {
		return clazzCustomMapper.selectCountOfTotalInfoOfDivideClass();
	}
	
	@Override
	public int addNewStudentInAClass(Student student) {
		int id=student.getStudentInfoId();
		//更改学生基本资料表的分班状态属性为已分班
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setId(id);
		studentInfo.setIsDivideClass(2001);
		studentInfo.setStudyStatus(45002);//设置学生基本信息的就读状态为"在读"
		studentInfoCustomMapper.updateByPrimaryKeySelective(studentInfo);
		student.setStudentStatus(14001);//设置学生表的学籍状态为"在籍"

		student.setStatus(17002);//设置学生表的注册状态为"已注册"
		student.setIsFreeTuition(2002);//统一设置所有学生为不免除学费
		return studentCustomMapper.insertSelective(student);
	}
	
	@Override
	public String getCodeByMarjorFieldIdAndClassID(int majorFieldId, int classId) {
		//设置学年编号子串
		Date date = new Date();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		String studyYearSubStr=dateStr.substring(2, 4);
		//设置班别编号子串
		String clsssSubStr;
		if (classId<10) {
			clsssSubStr="0"+classId;
		} else {
			clsssSubStr=""+classId;
		}
		//设置班内编号子串
		String innerCodeSubStr="";
		int count=studentCustomMapper.getStuCountByClassId(classId);
		if (count<10) {
			count++;
			innerCodeSubStr="0"+count;
		} else {
			count++;
			innerCodeSubStr+=count;
		}	
						
		//整合完整的学号
		String code=studyYearSubStr+clsssSubStr+innerCodeSubStr;
		return code;
	}
	
	
	@Override
	public int autoDivideClassSetting() {
		//获取全校的所有专业方向
		List<MajorField> allMajorFieldList=majorFieldMapper.selectByExample(new MajorFieldExample());
		//声明待插入数据库的所有学生的容器
		List<Student> toInsertStudentsList = new ArrayList<Student>();
		
		for (MajorField majorField : allMajorFieldList) {
			//获取专业方向ID
			int majorFieldId=majorField.getId();
			//根据专业方向ID获取相对应的一年级班级列表
			List<ClazzDto> clazzList=clazzCustomMapper.getClassOfGradeOneByMajorFieldId(majorFieldId);
			//获取班级数量
			int clazzCount=clazzList.size();
			if(clazzCount==0){
				continue;
			}
			//获取报取同一个专业方向下未分班的学生名单
			List<StudentInfo> toBeDividedStudentList=studentInfoCustomMapper.getToBeDividedStudentsByMajorFieldId(majorFieldId);
			//获取未分班的学生人数
			int toBeDividedStudentCount=toBeDividedStudentList.size();
			if(toBeDividedStudentCount==0){
				continue;
			}
			
			//获取报取同一个专业方向下已经分班的学生名单
			//List<StudentInfo> dividedStudentList=studentInfoCustomMapper.getDividedStudentsByMajorFieldId(id);
			
			/**
			 * 声明用于放置各个班级对应学生的容器,初步声明10个
			 */
			/*List<List<Student>> allStudentsList = new ArrayList<List<Student>>();
			List<Student> studentList1 = new ArrayList<Student>();
			allStudentsList.add(studentList1);
			List<Student> studentList2 = new ArrayList<Student>();
			allStudentsList.add(studentList2);
			List<Student> studentList3 = new ArrayList<Student>();
			allStudentsList.add(studentList3);
			List<Student> studentList4 = new ArrayList<Student>();
			allStudentsList.add(studentList4);
			List<Student> studentList5 = new ArrayList<Student>();
			allStudentsList.add(studentList5);
			List<Student> studentList6 = new ArrayList<Student>();
			allStudentsList.add(studentList6);
			List<Student> studentList7 = new ArrayList<Student>();
			allStudentsList.add(studentList7);
			List<Student> studentList8 = new ArrayList<Student>();
			allStudentsList.add(studentList8);
			List<Student> studentList9 = new ArrayList<Student>();
			allStudentsList.add(studentList9);
			List<Student> studentList10 = new ArrayList<Student>();
			allStudentsList.add(studentList10);*/
		
			//设置随机数变量用于学生插入到相应的班级随机选择起点
			int randomNum=0;
			Random random=new Random();
			//将同一个专业方向下未分班学生平均分配到对应的各个班级中
			for (int i=0;i<toBeDividedStudentCount;i++) {
				//得到第i个学生
				StudentInfo studentInfo = toBeDividedStudentList.get(i);
				//获取学生姓名
				String studentName=studentInfo.getName();
				//获取学生基本资料ID
				int studentInfoId=studentInfo.getId();
				//取模
				int index = i%clazzCount;
				//当index==0(即到达一个插入周期的起点)时获取[0，clazzCount]之间的随机整数
				if(clazzCount>=2&&index==0){
					randomNum=random.nextInt(clazzCount-1);
				}
				//选择要插入的对应的班级(一个插入周期中随机选择要插入的班级的起点)
				Clazz clazz=clazzList.get((index+randomNum)%clazzCount);				
				//获取班级ID
				int clazzId=clazz.getId();
				//获取学号
				String code;
				if (i<clazzCount) {
					code=getCodeByMarjorFieldIdAndClassID(majorFieldId, clazzId);
				} else {
					//由于自动插入方式获取学号时，直接调用getCodeByMarjorFieldIdAndClassID方法获取会导致学号冲突，所以只能获取插入的第一个周期的学号。从第二个周期开始需经过处理。
					String codeTemp=getCodeByMarjorFieldIdAndClassID(majorFieldId, clazzId);
					int codeNum=Integer.parseInt(codeTemp);
					codeNum=codeNum+(i/clazzCount);
					code=codeNum+"";
				}
				
				/**
				 * 设置要插入学生类的各个属性的值
				 */
				Student student=new Student();
				student.setName(studentName);
				student.setCode(code);
				student.setClassId(clazzId);
				student.setStudentInfoId(studentInfoId);
				/*student.setStatus(17001);*/
				student.setStatus(17002);//设置学生表的注册状态为"已注册"
				student.setStudentStatus(14001);//设置学生表的学籍状态为"在籍"
				student.setIsFreeTuition(2002);
				student.setRemark("由自动分班设置");
				
				//把学生暂存到toInsertStudentsList中
				toInsertStudentsList.add(student);

//				//把学生暂存在对应的List中
//				if(index<=9){
//					allStudentsList.get(index).add(student);
//				}else{
//					//其中的一个专业方向开设的班级数超过10
//					return -1;
//				}
								
			}
			
		}
		
		//把缓冲的所有学生插入到数据库中，并更改学生基本资料表的分班状态属性为已分班
		int returnCode;
		if(toInsertStudentsList.size()>0){
		    returnCode=studentCustomMapper.insertAllStudents(toInsertStudentsList);
		}else{
			returnCode=0;
		}
		
		//更改学生基本资料表的分班状态属性为已分班
		if (returnCode>0) {
			for (Student studentTemp : toInsertStudentsList) {
				int id=studentTemp.getStudentInfoId();
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setId(id);
				studentInfo.setIsDivideClass(2001);
				studentInfo.setStudyStatus(45002);//设置学生基本信息的就读状态为"在读"
				studentInfoCustomMapper.updateByPrimaryKeySelective(studentInfo);
			}
		}
				
		return returnCode;
	}


}
