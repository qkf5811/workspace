package com.dkt.school.edu.dto;

import com.dkt.school.edu.model.Course;

public class CourseDto  extends Course{

		private String majorStr;
		public String getMajorStr() {
			return majorStr;
		}

		public void setMajorStr(String majorStr) {
			this.majorStr = majorStr;
		}
}
