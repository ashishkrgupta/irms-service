package com.irms_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irms_service.entity.Book;
import com.irms_service.entity.StudentEntity;
import com.irms_service.service.LibraryService;
import com.irms_service.service.StudentService;

@RestController
@RequestMapping("library")
public class LibraryController {

	@Autowired
	LibraryService service;

	@GetMapping(value = "/books")
	public List<Book> getAllBooksInformation() {
		return service.getAllBooksInformation();
	}
	
	@GetMapping(value = "/bookInfo/{id}")
	public Optional<Book> getBookInfoById(@PathVariable("id") long id) {
		return service.getBookInfoById(id);
	}
	
	@GetMapping(value = "/bookIssuedBy/{id}")
	public List<Object> getBookIssuedByStudent(@PathVariable("id") long student_id) {
		return service.getBookIssuedByStudent(student_id);
	}
}
