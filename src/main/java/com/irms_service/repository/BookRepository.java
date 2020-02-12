package com.irms_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	//@Query(value= "Select bs.book_number, bs.book_id, b.book_name, b.description, b.edition, b.author_name from book b join book_Status bs on b.id = bs.book_id where bs.student_id = ?", nativeQuery=true)
	@Query(value= "Select * from test()", nativeQuery=true)
	List<Object> getBookIssuedByStudent(long student_id);

	
}
