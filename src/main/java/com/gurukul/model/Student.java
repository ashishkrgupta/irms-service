package com.gurukul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
    @GeneratedValue
	int id;
	
	@Column(name="student_name")
	String studentName;
	
	@Column(name="father_name")
	String fatherName;
	
	@Column(name="gender")
	String gender;
	
	@Column(name="address")
	String address;
	
	@Column(name="is_active")
	String isActive;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", fatherName=" + fatherName + ", gender="
				+ gender + ", address=" + address + ", isActive=" + isActive + "]";
	}
	
	
}
