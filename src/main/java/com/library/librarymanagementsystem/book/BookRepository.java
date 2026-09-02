package com.library.librarymanagementsystem.book;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity , Integer> {

	
	Optional<BookEntity> findByTitleContaining(String title);
	
	   
	
	
	
}
