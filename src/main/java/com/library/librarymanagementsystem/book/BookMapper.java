package com.library.librarymanagementsystem.book;

import java.util.ArrayList;



public class BookMapper {
 
	
	
	
	 public static BookDto mapToBookDto (BookEntity entity) {
		 
		 
		 
		 return new BookDto(entity.getId() , entity.getTitle() , entity.getAuthor() , entity.getIsbn() , entity.isAvailable() , entity.getCategory() );
		 
		         
		             
		            
		 
	
	 }

	 public static BookEntity maptoBook(BookDto bookDto) {
		    return BookEntity.builder()
		            .id(bookDto.id())
		            .title(bookDto.title())
		            .author(bookDto.author())
		            .isbn(bookDto.isbn())
		            .available(bookDto.available())
		            .borrowings(new ArrayList<>())
		            .category(bookDto.category())
		            
		  
		            .build();
	
	 }
}
