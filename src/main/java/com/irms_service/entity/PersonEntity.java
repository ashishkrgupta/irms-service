package com.irms_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class PersonEntity{

	@Id
    @GeneratedValue
    @Column(name= "person_id")
	private long personId;
	
	@ManyToOne
	private StudentEntity student;
	
	@Column
	private String name;
	
	@Column 
	private String relation;
	
	@Column 
	private String contactNumber;

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", student=" + student + ", name=" + name + ", relation=" + relation
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	
	
	
}
