package com.dkt.school.fin.dto;

import com.dkt.school.fin.model.StudentCharge;

/**
 * 
 * <p>Title: StudentChargeDto</p>
 * <p>Description: </p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月1日上午10:05:23
 *
 */
public class StudentChargeDto extends StudentCharge {
	private String studentName;
	
	private String gradeName;
	
	private String termTypeStr;
	
	private String studentAccountName;
	
	private String studentYearStr;
	

	public String getStudentYearStr() {
		return studentYearStr;
	}

	public void setStudentYearStr(String studentYearStr) {
		this.studentYearStr = studentYearStr;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getTermTypeStr() {
		return termTypeStr;
	}

	public void setTermTypeStr(String termTypeStr) {
		this.termTypeStr = termTypeStr;
	}

	public String getStudentAccountName() {
		return studentAccountName;
	}

	public void setStudentAccountName(String studentAccountName) {
		this.studentAccountName = studentAccountName;
	}
	
    
}
