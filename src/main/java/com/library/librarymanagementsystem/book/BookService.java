package com.library.librarymanagementsystem.book;

import java.util.List;

public interface BookService {

	
	 BookDto createBook (BookDto dto);
		 
	      
	 BookDto FindBookByid (Integer Id);
  
	 


	 List< BookDto> FindBookBytitle(String title);
	 
	
	List<BookDto> FindByAll ();
	
	


	BookDto UpdateByBook(Integer id, BookDto updateDto);
		
	
		void DeleteBybook(Integer id);
	
		
		
		
		List<BookDto> findbyCategory (Category category);
}
