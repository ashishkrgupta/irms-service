package com.irms_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Person")
public class PersonEntity {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "person_id")
	private long personId;

	@ManyToOne
	@JsonIgnore
	private StudentEntity student;

	@Column
	private String relation;

	@Column
	private String firstName;

	@Column
	private String middleName;

	@Column
	private String lastName;

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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonEntity [personId=" + personId + ", student=" + student + ", relation=" + relation + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

}
