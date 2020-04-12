package com.irms_service.entity;

import org.springframework.web.multipart.MultipartFile;

public class StudentWrapper {

	public StudentWrapper() {
	}
	
	private Student student;
	
	private MultipartFile[] files;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	
}
