package com.library.librarymanagementsystem.book;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity , Integer> {

	
	List<BookEntity> findByTitleContaining(String title);
	
	   
	 List<BookEntity> findByCategory (Category category);
	 
	       
	  
	
	
}
