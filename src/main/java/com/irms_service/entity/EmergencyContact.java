package com.irms_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "emergency_contact")
public class EmergencyContact {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JsonIgnore
	private Student student;

	@Column
	private String contactNumber;

	@Column
	private String personName;
	
	@Column
	private String relationWithStudent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getRelationWithStudent() {
		return relationWithStudent;
	}

	public void setRelationWithStudent(String relationWithStudent) {
		this.relationWithStudent = relationWithStudent;
	}

	@Override
	public String toString() {
		return "EmergencyContactEntity [id=" + id + ", student=" + student + ", contactNumber=" + contactNumber
				+ ", personName=" + personName + ", relationWithStudent=" + relationWithStudent + "]";
	}
	
	

}
