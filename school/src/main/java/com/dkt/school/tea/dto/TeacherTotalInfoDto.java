package com.dkt.school.tea.dto;

import java.util.Date;
import java.util.List;

public class TeacherTotalInfoDto extends TeacherInfoDto {

	private Integer idOfTeacher;
	
    private String nameOfTeacher;

    private String code;

    private Integer majorId;

    private String majorIdStr;
    
    private String nowPosition;

    private Integer titleType;
    
    private String titleTypeStr;

    private Integer staffType;
    
    private String staffTypeStr;
    
    private Integer positionType;
    
    private String positionTypeStr;

    private Date workStartTime;

    private String workStartTimeStr;  //str
    
    private Date takeOfficeTime;

    private String takeOfficeTimeStr;  //str
    
    
    private Integer userId;
    
    private List<TeacherFamilyDto> teaFamilyDtoList;
    
    private List<TeacherEduExperienceDto> teaEduExpDtoList;
    
    private List<TeacherWorkExperienceDto> teaWorkExprience;
    
    
  

	public List<TeacherWorkExperienceDto> getTeaWorkExprience() {
		return teaWorkExprience;
	}

	public void setTeaWorkExprience(List<TeacherWorkExperienceDto> teaWorkExprience) {
		this.teaWorkExprience = teaWorkExprience;
	}

	public List<TeacherEduExperienceDto> getTeaEduExpDtoList() {
		return teaEduExpDtoList;
	}

	public void setTeaEduExpDtoList(List<TeacherEduExperienceDto> teaEduExpDtoList) {
		this.teaEduExpDtoList = teaEduExpDtoList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	//教师教育经历
    private Integer educationType;

    private String educationTypeStr;
    
    public String getEducationTypeStr() {
		return educationTypeStr;
	}

	public void setEducationTypeStr(String educationTypeStr) {
		this.educationTypeStr = educationTypeStr;
	}

	private String school;

    private String major;

    private Date startDate;
    
    private Date endDate;

    private String remarkOfTeaEdu;
    
    private String startDateStr;
    private String endDateStr;
    
    public String getMajorIdStr() {
		return majorIdStr;
	}

	public void setMajorIdStr(String majorIdStr) {
		this.majorIdStr = majorIdStr;
	}

	public String getTitleTypeStr() {
		return titleTypeStr;
	}

	public void setTitleTypeStr(String titleTypeStr) {
		this.titleTypeStr = titleTypeStr;
	}

	public String getStaffTypeStr() {
		return staffTypeStr;
	}

	public void setStaffTypeStr(String staffTypeStr) {
		this.staffTypeStr = staffTypeStr;
	}

	public String getPositionTypeStr() {
		return positionTypeStr;
	}

	public void setPositionTypeStr(String positionTypeStr) {
		this.positionTypeStr = positionTypeStr;
	}

	//用户表
    private Integer idOfUser;

    private String account;

    private String password;

    private String nameOfUser;

    private Integer sexTypeOfUser;

    private Integer departmentId;
    
    private String departmentIdStr;

    public String getDepartmentIdStr() {
		return departmentIdStr;
	}

	public void setDepartmentIdStr(String departmentIdStr) {
		this.departmentIdStr = departmentIdStr;
	}

	private String mobileOfUser;

    private String phoneOfUser;

    private String emailOfUser;

    private String addressOfUser;

    private Integer isBlocked;
    
    public Integer getIdOfUser() {
		return idOfUser;
	}

	public void setIdOfUser(Integer idOfUser) {
		this.idOfUser = idOfUser;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public Integer getSexTypeOfUser() {
		return sexTypeOfUser;
	}

	public void setSexTypeOfUser(Integer sexTypeOfUser) {
		this.sexTypeOfUser = sexTypeOfUser;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getMobileOfUser() {
		return mobileOfUser;
	}

	public void setMobileOfUser(String mobileOfUser) {
		this.mobileOfUser = mobileOfUser;
	}

	public String getPhoneOfUser() {
		return phoneOfUser;
	}

	public void setPhoneOfUser(String phoneOfUser) {
		this.phoneOfUser = phoneOfUser;
	}

	public String getEmailOfUser() {
		return emailOfUser;
	}

	public void setEmailOfUser(String emailOfUser) {
		this.emailOfUser = emailOfUser;
	}

	public String getAddressOfUser() {
		return addressOfUser;
	}

	public void setAddressOfUser(String addressOfUser) {
		this.addressOfUser = addressOfUser;
	}

	public Integer getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Integer isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public Integer getEducationType() {
		return educationType;
	}

	public void setEducationType(Integer educationType) {
		this.educationType = educationType;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemarkOfTeaEdu() {
		return remarkOfTeaEdu;
	}

	public void setRemarkOfTeaEdu(String remarkOfTeaEdu) {
		this.remarkOfTeaEdu = remarkOfTeaEdu;
	}

	public String getWorkStartTimeStr() {
		return workStartTimeStr;
	}

	public void setWorkStartTimeStr(String workStartTimeStr) {
		this.workStartTimeStr = workStartTimeStr;
	}

	public String getTakeOfficeTimeStr() {
		return takeOfficeTimeStr;
	}

	public void setTakeOfficeTimeStr(String takeOfficeTimeStr) {
		this.takeOfficeTimeStr = takeOfficeTimeStr;
	}


	private String remarkOfTeacher;


	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getNameOfTeacher() {
		return nameOfTeacher;
	}

	public void setNameOfTeacher(String nameOfTeacher) {
		this.nameOfTeacher = nameOfTeacher;
	}

	public String getRemarkOfTeacher() {
		return remarkOfTeacher;
	}

	public void setRemarkOfTeacher(String remarkOfTeacher) {
		this.remarkOfTeacher = remarkOfTeacher;
	}

	public Integer getIdOfTeacher() {
		return idOfTeacher;
	}

	public void setIdOfTeacher(Integer idOfTeacher) {
		this.idOfTeacher = idOfTeacher;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getNowPosition() {
		return nowPosition;
	}

	public void setNowPosition(String nowPosition) {
		this.nowPosition = nowPosition;
	}

	public Integer getTitleType() {
		return titleType;
	}

	public void setTitleType(Integer titleType) {
		this.titleType = titleType;
	}

	public Integer getStaffType() {
		return staffType;
	}

	public void setStaffType(Integer staffType) {
		this.staffType = staffType;
	}

	public Integer getPositionType() {
		return positionType;
	}

	public void setPositionType(Integer positionType) {
		this.positionType = positionType;
	}

	public Date getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(Date workStartTime) {
		this.workStartTime = workStartTime;
	}

	public Date getTakeOfficeTime() {
		return takeOfficeTime;
	}

	public void setTakeOfficeTime(Date takeOfficeTime) {
		this.takeOfficeTime = takeOfficeTime;
	}

	public List<TeacherFamilyDto> getTeaFamilyDtoList() {
		return teaFamilyDtoList;
	}

	public void setTeaFamilyDtoList(List<TeacherFamilyDto> teaFamilyDtoList) {
		this.teaFamilyDtoList = teaFamilyDtoList;
	}

	@Override
	public String toString() {
		return "TeacherTotalInfoDto [getStartDateStr()=" + getStartDateStr()
				+ ", getEndDateStr()=" + getEndDateStr()+ ", getTeaFamilyDtoList()=" + getTeaFamilyDtoList()
				+ ", getEducationType()=" + getEducationType()
				+ ", getMajor()=" + getMajor() + ", getStartDate()="
				+ getStartDate() + ", getEndDate()=" + getEndDate()
				+ ", getRemarkOfTeaEdu()=" + getRemarkOfTeaEdu()
				+ ", getWorkStartTimeStr()=" + getWorkStartTimeStr()
				+ ", getTakeOfficeTimeStr()=" + getTakeOfficeTimeStr()
				+ ", getBirthdayStr()=" + getBirthdayStr()
				+ ", getPoliticalFeatureTypeStr()="
				+ getPoliticalFeatureTypeStr() + ", getNationTypeStr()="
				+ getNationTypeStr() + ", getSexTypeStr()=" + getSexTypeStr()
				+ ", getSchool()=" + getSchool() + ", getNameOfTeacher()="
				+ getNameOfTeacher() + ", getRemarkOfTeacher()="
				+ getRemarkOfTeacher() + ", getIdOfTeacher()="
				+ getIdOfTeacher() + ", getCode()=" + getCode()
				+ ", getMajorId()=" + getMajorId() + ", getNowPosition()="
				+ getNowPosition() + ", getTitleType()=" + getTitleType()
				+ ", getStaffType()=" + getStaffType() + ", getPositionType()="
				+ getPositionType() + ", getWorkStartTime()="
				+ getWorkStartTime() + ", getTakeOfficeTime()="
				+ getTakeOfficeTime() + ", getId()=" + getId()
				+ ", getTeacherId()=" + getTeacherId() + ", getName()="
				+ getName() + ", getSexType()=" + getSexType()
				+ ", getBirthday()=" + getBirthday() + ", getIdCardType()="
				+ getIdCardType() + ", getIdCard()=" + getIdCard()
				+ ", getCountryId()=" + getCountryId() + ", getNationType()="
				+ getNationType() + ", getPoliticalFeatureType()="
				+ getPoliticalFeatureType() + ", getNativePlace()="
				+ getNativePlace() + ", getMaritalStatus()="
				+ getMaritalStatus() + ", getHouseholdType()="
				+ getHouseholdType() + ", getDegreeType()=" + getDegreeType()
				+ ", getFamilyAddress()=" + getFamilyAddress()
				+ ", getPostcode()=" + getPostcode() + ", getFamilyPhone()="
				+ getFamilyPhone() + ", getOfficePhone()=" + getOfficePhone()
				+ ", getMobilePhone()=" + getMobilePhone() + ", getEmail()="
				+ getEmail() + ", getRemark()=" + getRemark() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}




	
}
