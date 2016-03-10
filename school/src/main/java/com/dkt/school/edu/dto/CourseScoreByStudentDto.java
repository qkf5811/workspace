package com.dkt.school.edu.dto;

import com.dkt.school.edu.model.CourseScore;

public class CourseScoreByStudentDto extends CourseScore {

	private String studentName;
	private String studentCode;
	private String courseName;
	private String courseCode;
	private String studyYear;
	private String termName;
	private String totalScore;
	private String className;
	private String usualScore;
	private String examScore;
	public String getUsualScore() {
		return usualScore;
	}
	public void setUsualScore(String usualScore) {
		this.usualScore = usualScore;
	}
	public String getExamScore() {
		return examScore;
	}
	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getStudyYear() {
		return studyYear;
	}
	public void setStudyYear(String studyYear) {
		this.studyYear = studyYear;
	}
	
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
		
}
