package com.irms_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BookStatus {

	@Id
	@GeneratedValue
	private long bookNumber;

	@ManyToOne
	private Book book;
	
	@OneToOne
	private StudentEntity student;

	@Column
	private boolean isIssued;

	public long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "BookStatus [bookNumber=" + bookNumber + ", book=" + book + ", student=" + student + ", isIssued="
				+ isIssued + "]";
	}

}
