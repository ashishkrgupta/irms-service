package com.irms_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String bookName;
	
	@Column
	private String authorName;
	
	@Column
	private String description;
	
	@Column
	private String edition;
	
	@Column
	private int numberOfBooks;
	
	@Column
	private int availableBooks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public int getAvailableBooks() {
		return availableBooks;
	}

	public void setAvailableBooks(int availableBooks) {
		this.availableBooks = availableBooks;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", description="
				+ description + ", edition=" + edition + ", numberOfBooks=" + numberOfBooks + ", availableBooks="
				+ availableBooks + "]";
	}
	
	
	
	
	
	

}
