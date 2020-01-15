package com.irms_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irms_service.model.Address;

@Entity
@Table(name = "Address")
public class AddressEntity {

	public AddressEntity() {
	};

	public AddressEntity(Address address) {
		super();
		this.permanentAddress = address.getPermanentAddress();
		this.currentAddress = address.getCurrentAddress();
	}

	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	private StudentEntity student;

	@Column
	private String permanentAddress;

	@Column
	private String currentAddress;

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	@Override
	public String toString() {
		return "Address [student=" + student + ", permanentAddress=" + permanentAddress + ", currentAddress="
				+ currentAddress + "]";
	}

}
