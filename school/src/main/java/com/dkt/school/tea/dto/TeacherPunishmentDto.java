package com.dkt.school.tea.dto;

import com.dkt.school.tea.model.TeacherPunishment;

public class TeacherPunishmentDto extends TeacherPunishment {

		//学年
		private String schoolYear;
		//教师编号
		private String code;
		//教师姓名
		private String name;
		//担任职务
		private String nowPosition;
		//学期
		private String schoolTermTypeStr;
		//处罚日期
		private String punishDateStr;
		//处罚类型
		private String punishmentTypeStr;
		
		
		public String getSchoolYear() {
			return schoolYear;
		}
		public void setSchoolYear(String schoolYear) {
			this.schoolYear = schoolYear;
		}
		public String getSchoolTermTypeStr() {
			return schoolTermTypeStr;
		}
		public void setSchoolTermTypeStr(String schoolTermTypeStr) {
			this.schoolTermTypeStr = schoolTermTypeStr;
		}
		public String getPunishDateStr() {
			return punishDateStr;
		}
		public void setPunishDateStr(String punishDateStr) {
			this.punishDateStr = punishDateStr;
		}
		public String getNowPosition() {
			return nowPosition;
		}
		public void setNowPosition(String nowPosition) {
			this.nowPosition = nowPosition;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getPunishmentTypeStr() {
			return punishmentTypeStr;
		}
		public void setPunishmentTypeStr(String punishmentTypeStr) {
			this.punishmentTypeStr = punishmentTypeStr;
		}
		@Override
		public String toString() {
			return "TeacherPunishmentDto [schoolYear" + schoolYear +",code=" + code + ", name=" + name
					+ ", nowPosition=" + nowPosition + ", schoolTermTypeStr="
					+ schoolTermTypeStr + ", punishDateStr=" + punishDateStr
					+ ", punishmentTypeStr=" + punishmentTypeStr + "]";
		}
		
}
