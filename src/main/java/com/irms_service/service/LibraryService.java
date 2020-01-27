package com.irms_service.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.entity.Book;
import com.irms_service.repository.BookRepository;
import com.irms_service.repository.BookStatusRepository;
import com.irms_service.repository.StudentRepository;

@Service
@Transactional
public class LibraryService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookStatusRepository bookStatusRepository;
	
	public  List<Book> getAllBooksInformation() {
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookInfoById(long id) {
		return bookRepository.findById(id);
	}
	
	/*public void getBookIssuedByStudent(long student_id){
		return bookStatusRepository.findByStudentId(student_id)
	}*/
}
