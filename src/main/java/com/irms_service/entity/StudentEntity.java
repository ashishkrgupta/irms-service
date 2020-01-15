package com.irms_service.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.irms_service.model.Student;

@Entity
@Table(name="Student")
public class StudentEntity {
	
	public StudentEntity() {}
	
	public StudentEntity(Student student) {
		super();
		this.enrollmentId = student.getEnrollmentId();
		this.firstName = student.getFirstName();
		this.middleName = student.getMiddleName();
		this.lastName = student.getLastName();
		this.bloodGroup = student.getBloodGroup();
		this.gender = student.getGender();
		this.dateOfBirth = student.getDateOfBirth();
		this.nationality = student.getNationality();
		this.religion = student.getReligion();
		this.community = student.getCommunity();
		this.aadharNumber = student.getAadharNumber();
		this.languageKnown = student.getLanguageKnown();
		//this.addmissionDate = student.getAddmissionDate();
		this.leavingDate = null;
		this.addmissionStandard = student.getAddmissionStandard();
		this.emailId = student.getEmailId();
	}

	@Id
    @GeneratedValue
	private long id;
	
	@Column(name = "enrolment_id")
	private String enrollmentId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name="gender", nullable = false, length = 1)
	private String gender;
	
	@Column(name="dob")
	private LocalDateTime dateOfBirth;
	
	@Column
	private String nationality;
	
	@Column
	private String religion;
	
	@Column
	private String community;
	
	@Column(name="aadhar_number", length= 12)
	private String aadharNumber;
	
	@Column(name= "language_known")
	private String languageKnown;
	
	@Column(name="admission_date")
	@CreationTimestamp
	private LocalDateTime addmissionDate;
	
	@Column(name="leaving_date")
	private LocalDateTime leavingDate;
	
	@Column(name="addmission_standard")
	private String addmissionStandard;
	
	@Column(name="email_id")
	private String emailId;
	
	@OneToOne(mappedBy = "student")
	private AddressEntity address;

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

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
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

	public LocalDateTime getAddmissionDate() {
		return addmissionDate;
	}

	public void setAddmissionDate(LocalDateTime addmissionDate) {
		this.addmissionDate = addmissionDate;
	}

	public LocalDateTime getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(LocalDateTime leavingDate) {
		this.leavingDate = leavingDate;
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

	
	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", enrollmentId=" + enrollmentId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", bloodGroup=" + bloodGroup + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality + ", religion=" + religion
				+ ", community=" + community + ", aadharNumber=" + aadharNumber + ", languageKnown=" + languageKnown
				+ ", addmissionDate=" + addmissionDate + ", leavingDate=" + leavingDate + ", addmissionStandard="
				+ addmissionStandard + ", emailId=" + emailId + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
