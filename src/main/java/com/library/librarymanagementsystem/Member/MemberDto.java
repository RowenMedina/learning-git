package com.library.librarymanagementsystem.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MemberDto(
		
		Integer id ,

		 @NotBlank(message = "The name is required")
  
String name ,

         

@NotBlank(message = "Email is required")
@Email(message = "Invalid email")
 
		
		
      

String email
		
		
          

		
		
		) {

}
