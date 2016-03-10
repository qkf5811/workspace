package com.dkt.school.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dao.ClazzCustomMapper;
import com.dkt.school.stu.dao.ClazzMapper;
import com.dkt.school.stu.dao.StudentChangeCustomMapper;
import com.dkt.school.stu.dao.StudentChangeMapper;
import com.dkt.school.stu.dao.StudentCustomMapper;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.service.StudentChangeService;

@Service
public class StudentChangeServiceImpl implements StudentChangeService {
	@Autowired
	private StudentChangeCustomMapper sccMapper;
//	@Autowired
//	private StudentChangeMapper scMapper;

	@Autowired
	private StudentCustomMapper studentMapper;

	@Autowired
	private ClazzCustomMapper clazzCustomMapper;

	// 取得学籍异动的数量
	@Override
	public Integer getStudentChangeCount(String name, String code) {
		// TODO Auto-generated method stub
		return sccMapper.getStudentChangeCount(name, code);
	}

	// 模糊查詢取得学籍异动
	@Override
	public List<StudentChangeDto> getStudentChangesByPage(String name,
			String code, PaginationCustom page) {
		// TODO Auto-generated method stub
		return sccMapper.selectByLimit(name, code, page.getLimitation());
	}

	// 根据学号取得学生
	@Override
	public StudentDto findStudent(String code) {
		// TODO Auto-generated method stub
		return studentMapper.findStudent(code);
	}

	// 新增学籍异动
	@Override
	public Integer addStudentChange(StudentChangeDto scDto) {
		int result = 0;
		if (scDto.getChangeType() == null || "".equals(scDto.getChangeType())
				|| scDto.getStudentId() == null
				|| "".equals(scDto.getStudentId())) {
			return -1;
		}

		// HIU add 2015-09-28，获取学籍状态
		Integer studentStatus = 0;
		if (scDto.getStudentStatus() != null && scDto.getStudentStatus() != "") {
			studentStatus = Integer.parseInt(scDto.getStudentStatus());

			if (studentStatus == 14004)// 复学时需要设置为在籍状态
				studentStatus = 14001;
		}

		// 改变学生的班别和学籍状态
		StudentDto studentDto = studentMapper.findStudent(scDto.getCode());
		studentDto.setClassId(scDto.getIntoClassId());
		studentDto.setStudentStatus(studentStatus);// HIU add 2015-09-28，设置学籍状态
		/* studentDto.setStatus(scDto.getChangeType()); */

		// studentMapper.updateByPrimaryKey(studentDto);//用updateByPrimaryKeySelective代替---HIU
		// 2015-09-28，

		studentMapper.updateByPrimaryKeySelective(studentDto);

		// 学生表中的学籍状态

		return sccMapper.insert(scDto);

	}

	// 根据id查找studentChange
	@Override
	public StudentChangeDto findStudentChangeById(Integer id) {
		// TODO Auto-generated method stub
		return sccMapper.findStudentChangeById(id);
	}

	// 更新学籍异动
	@Override
	public Integer updateStudentChange(StudentChangeDto scDto) {
		// TODO Auto-generated method stub
		return sccMapper.updateStudentChange(scDto);
	}

	// 删除学籍异动
	@Override
	public Integer deleteStudentChangeById(Integer id, String code) {

		// 改变学生的班别和学籍状态
		StudentDto studentDto = studentMapper.findStudent(code);
		List<StudentChangeDto> studentChangeDtos = sccMapper
				.findStudentChangeByCode(code);
		int length = studentChangeDtos.size();
		if (length == 1) {
			// studentDto.setClassId(studentChangeDtos.get(length -
			// 1).getOutClassId()); //HIU 注释，需要判断异动状态再赋值
			/*
			 * //学籍状态为0，表示为正常 studentDto.setStatus(0);
			 */

			// hiu add
			Integer studentStatus = 0;
			studentStatus = studentChangeDtos.get(0).getChangeType();

			if (studentStatus == 14004) {// 复学时需要设置为在籍状态
				studentStatus = 14001;
				studentDto
						.setClassId(studentChangeDtos.get(0).getIntoClassId()); // 为“复学”状态时，将班id设置为转入班id
			} else if (studentStatus == 14002 || studentStatus == 14003) {
				studentDto.setClassId(studentChangeDtos.get(0).getOutClassId()); // 为“休学”或“退学”状态时，将班id设置为转出班id
			}
			studentDto.setStudentStatus(14001);// 如果异动状态表只有一条记录时（将被删除），那么学生表的学籍设为“在籍”

		}
		// 查找出来n（n>1)条记录，则删除1~(n-1)之间的任何一条记录，班级和学籍状态不会改变
		/*
		 * HIU注释，用下面的代码取替 if(length>1
		 * &&studentChangeDtos.get(length-1).getId()==id){
		 * studentDto.setClassId(
		 * studentChangeDtos.get(length-2).getIntoClassId());
		 * //studentDto.setStatus
		 * (studentChangeDtos.get(length-2).getChangeType());
		 * 
		 * //HIU add 2015-09-29，学籍状态 Integer studentStatus=0;
		 * studentStatus=studentChangeDtos.get(length-2).getChangeType();
		 * 
		 * if(studentStatus==14004)//复学时需要设置为在籍状态 studentStatus=14001;
		 * 
		 * studentDto.setStudentStatus(studentStatus); }
		 * //studentMapper.updateByPrimaryKey
		 * (studentDto);//用updateByPrimaryKeySelective代替---HIU 2015-09-28
		 */

		if (length > 1) {
			Integer studentStatus = 0;
			for (int i = 0; i < length; i++) {

				if (i == 0) {
					if (studentChangeDtos.get(i).getId() == id) {
						studentStatus = studentChangeDtos.get(i)
								.getChangeType();
						if (studentStatus == 14004) { // 理论上第一条记录不可能为这个状态，暂时保留
							studentDto.setClassId(studentChangeDtos.get(i)
									.getIntoClassId()); // 为“复学”状态时，将班id设置为转入班id
						} else if (studentStatus == 14002
								|| studentStatus == 14003) {
							studentDto.setClassId(studentChangeDtos.get(i)
									.getOutClassId()); // 为“休学”或“退学”状态时，将班id设置为转出班id

						}
						studentDto.setStudentStatus(14001);// 如果异动状态表只有一条记录时（将被删除），那么学生表的学籍设为“在籍”
					}
				} else if (studentChangeDtos.get(i).getId() == id) {

					studentStatus = studentChangeDtos.get(i - 1)
							.getChangeType();
					if (studentStatus == 14004) {// 复学时需要设置为在籍状态
						studentStatus = 14001;
						studentDto.setClassId(studentChangeDtos.get(i - 1)
								.getIntoClassId()); // 为“复学”状态时，将班id设置为转入班id
					} else if (studentStatus == 14002 || studentStatus == 14003) {
						studentDto.setClassId(studentChangeDtos.get(i - 1)
								.getOutClassId()); // 为“休学”或“退学”状态时，将班id设置为转出班id
					}

					studentDto.setStudentStatus(studentStatus);
				}
			}
		}

		studentMapper.updateByPrimaryKeySelective(studentDto);
		return sccMapper.deleteByPrimaryKey(id);
	}

	// 取得所有学生信息
	@Override
	public List<StudentDto> findAllStudents() {
		// TODO Auto-generated method stub
		return studentMapper.findAllStudents();
	}

	// 模糊查詢取得学生信息
	@Override
	public List<StudentDto> getStudentsByPage(String name, String code,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentsByLimit(name, code,
				page.getLimitation());
	}

	// 根据班级id取得班级名
	@Override
	public String getClassNameByClassId(Integer classId) {
		if (classId == null) {
			return null;
		}
		return clazzCustomMapper.selectByPrimaryKey(classId).getName();
	}

	// 根据班级名取得班级
	@Override
	public ClazzDto getClassByClassName(String className) {
		// TODO Auto-generated method stub
		return clazzCustomMapper.getClassByClassName(className);
	}

	// 根据专业方向+班级信息来查找班级
	@Override
	public ClazzDto getClassByMajorFieldClassName(String MajorFieldClass) {
		// TODO Auto-generated method stub
		return clazzCustomMapper.getClassByMajorFieldClassName(MajorFieldClass);
	}

	// 取得班级数量
	@Override
	public Integer getClassCount(String majorFieldClassName, String gradeName) {
		// TODO Auto-generated method stub
		return clazzCustomMapper.getClassCount(majorFieldClassName, gradeName);
	}

	// 分页模糊查询
	@Override
	public List<ClazzDto> getClazzsByPage(String majorFieldClassName,
			String gradeName, PaginationCustom page) {
		return clazzCustomMapper.getClazzsByPage(majorFieldClassName,
				gradeName, page.getLimitation());
	}

	// 取得学生数量
	@Override
	public Integer getStudentsCount(String name, String code) {
		// TODO Auto-generated method stub
		return studentMapper.getStudentCount(name, code);
	}

}
