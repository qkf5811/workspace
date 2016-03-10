package com.dkt.school.edu.dto;

import com.dkt.school.edu.model.Course;

public class CourseCountDto {
	private int int0;
	private int int1;
	private int int2;
	private int int3;
	private int int4;
	
	private double double0;
	private double double1;
	private double double2;
	private double double3;
	private double double4;
	
	private int sum;
	private double sumScore;
	private double avg;
	public int getInt0() {
		return int0;
	}
	public void setInt0(int int0) {
		this.int0 = int0;
	}
	public int getInt1() {
		return int1;
	}
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	public int getInt2() {
		return int2;
	}
	public void setInt2(int int2) {
		this.int2 = int2;
	}
	public int getInt3() {
		return int3;
	}
	public void setInt3(int int3) {
		this.int3 = int3;
	}
	public int getInt4() {
		return int4;
	}
	public void setInt4(int int4) {
		this.int4 = int4;
	}
	public double getDouble0() {
		return Math.round(double0 * 10000) * 0.01d;
	}
	public void setDouble0(double double0) {
		this.double0 = double0;
	}
	public double getDouble1() {
		return Math.round(double1 * 10000) * 0.01d;
	}
	public void setDouble1(double double1) {
		this.double1 = double1;
	}
	public double getDouble2() {
		return Math.round(double2 * 10000) * 0.01d;
	}
	public void setDouble2(double double2) {
		this.double2 = double2;
	}
	public double getDouble3() {
		return Math.round(double3 * 10000) * 0.01d;
	}
	public void setDouble3(double double3) {
		this.double3 = double3;
	}
	public double getDouble4() {
		return Math.round(double4 * 10000) * 0.01d;
	}
	public void setDouble4(double double4) {
		this.double4 = double4;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getSumScore() {
		return sumScore;
	}
	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}
	
	
}
