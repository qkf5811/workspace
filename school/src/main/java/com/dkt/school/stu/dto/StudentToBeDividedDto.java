package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.Student;

public class StudentToBeDividedDto extends Student {
	private String major_field_name;
	private Integer major_field_id;
	private Integer newStu_id;
	private String newStu_name;
	private Integer is_divide_class;	
	private String is_divide_class_str;
	private String status_str;
	private String  is_free_tuition_str;
	private String class_name;
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Integer getMajor_field_id() {
		return major_field_id;
	}
	public void setMajor_field_id(Integer major_field_id) {
		this.major_field_id = major_field_id;
	}
	public String getMajor_field_name() {
		return major_field_name;
	}
	public void setMajor_field_name(String major_field_name) {
		this.major_field_name = major_field_name;
	}
	public Integer getNewStu_id() {
		return newStu_id;
	}
	public void setNewStu_id(Integer newStu_id) {
		this.newStu_id = newStu_id;
	}
	public String getNewStu_name() {
		return newStu_name;
	}
	public void setNewStu_name(String newStu_name) {
		this.newStu_name = newStu_name;
	}
	public Integer getIs_divide_class() {
		return is_divide_class;
	}
	public void setIs_divide_class(Integer is_divide_class) {
		this.is_divide_class = is_divide_class;
	}
	public String getIs_divide_class_str() {
		return is_divide_class_str;
	}
	public void setIs_divide_class_str(String is_divide_class_str) {
		this.is_divide_class_str = is_divide_class_str;
	}
	public String getStatus_str() {
		return status_str;
	}
	public void setStatus_str(String status_str) {
		this.status_str = status_str;
	}
	public String getIs_free_tuition_str() {
		return is_free_tuition_str;
	}
	public void setIs_free_tuition_str(String is_free_tuition_str) {
		this.is_free_tuition_str = is_free_tuition_str;
	}
	
	

}
