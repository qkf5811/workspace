package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.StudentReward;

/**
 * @author JanGin Chan
 * 2015年6月19日
 */
public class StudentRewardDto extends StudentReward{

	//学号
	private String code;
	//班别
	private Integer classId;
	//姓名
	private String name;
	//奖励类型
	private String rewardTypeStr;
	//所在班级
	private String className;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getRewardTypeStr() {
		return rewardTypeStr;
	}

	public void setRewardTypeStr(String rewardTypeStr) {
		this.rewardTypeStr = rewardTypeStr;
	}

	@Override
	public String toString() {
		return "StudentRewardDto [code=" + code + ", classId=" + classId
				+ ", name=" + name + ", rewardTypeStr=" + rewardTypeStr
				+ ", className=" + className + ", getStudentId()="
				+ getStudentId() + ", getRewardType()=" + getRewardType()
				+ ", getContent()=" + getContent() + ", getRemark()="
				+ getRemark() + "]";
	}

	
}
