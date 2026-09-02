package com.library.librarymanagementsystem.book;

import jakarta.validation.constraints.NotBlank;

public record BookDto( Integer id ,

		 @NotBlank(message = "Title is required")
   
String title ,

          
 
   @NotBlank (message = "author is required")
String author , 
 
     


 String isbn ,
 
 
  

 boolean available ) {


	
	
	
             
	
	
}
