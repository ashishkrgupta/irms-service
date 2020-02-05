package com.irms_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.irms_service.util.CustomDateDeserializer;


@Entity
@Table(name = "Student")
public class StudentEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String enrollmentId;

	@Column
	private String firstName;

	@Column
	private String middleName;

	@Column
	private String lastName;

	@Column
	private String bloodGroup;

	@Column
	private String gender;

	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;

	@Column
	private String nationality;

	@Column
	private String religion;

	@Column
	private String community;

	@Column
	private String aadharNumber;

	@Column
	private String languageKnown;

	@Column
	private String addmissionStandard;

	@Column
	private String emailId;

	@Column(name = "admission_date")
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date addmissionDate;

	@Column(name = "leaving_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	//@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date leavingDate;

	@OneToMany(mappedBy = "student")
	private List<AddressEntity> addressList;

	@OneToMany(mappedBy = "student")
	private List<PersonEntity> relatives;

	@OneToMany(mappedBy = "student")
	private List<DocumentEntity> documents;

	@OneToMany(mappedBy = "student")
	private List<EmergencyContactEntity> emergencyContacts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getLanguageKnown() {
		return languageKnown;
	}

	public void setLanguageKnown(String languageKnown) {
		this.languageKnown = languageKnown;
	}

	public String getAddmissionStandard() {
		return addmissionStandard;
	}

	public void setAddmissionStandard(String addmissionStandard) {
		this.addmissionStandard = addmissionStandard;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getAddmissionDate() {
		return addmissionDate;
	}

	public void setAddmissionDate(Date addmissionDate) {
		this.addmissionDate = addmissionDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public List<AddressEntity> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressEntity> addressList) {
		this.addressList = addressList;
	}

	public List<PersonEntity> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<PersonEntity> relatives) {
		this.relatives = relatives;
	}

	public List<DocumentEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentEntity> documents) {
		this.documents = documents;
	}

	public List<EmergencyContactEntity> getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContactEntity> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", enrollmentId=" + enrollmentId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", bloodGroup=" + bloodGroup + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality + ", religion=" + religion
				+ ", community=" + community + ", aadharNumber=" + aadharNumber + ", languageKnown=" + languageKnown
				+ ", addmissionStandard=" + addmissionStandard + ", emailId=" + emailId + ", addmissionDate="
				+ addmissionDate + ", leavingDate=" + leavingDate + ", addressList=" + addressList + ", relatives="
				+ relatives + ", documents=" + documents + ", emergencyContacts=" + emergencyContacts + "]";
	}
	
	

}
