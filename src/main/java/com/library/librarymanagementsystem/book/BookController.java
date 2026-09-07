package com.library.librarymanagementsystem.book;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController

public class BookController {
 
	
	private BookService service;
	
	
	@PostMapping("/book")
	 public ResponseEntity<BookDto> createBook ( @Valid @RequestBody  BookDto bookDto) {
		 
		var save = service.createBook(bookDto);
		   
		 return new ResponseEntity<>(save , HttpStatus.CREATED);
		  
		    
		 
		 
		
	 } 
	    
	@GetMapping("/{id}")
	
	   public ResponseEntity<BookDto> findById (@PathVariable("id") Integer id ) {
		   
		 var find =    service.FindBookByid(id);
		    
		   return  ResponseEntity.ok(find);
		   
	   }

	
	@GetMapping("/Title/{title}")
  public ResponseEntity<BookDto> findByTitle(@PathVariable("title") String title) {
	
		
		
		var findBytitle = service.FindBookBytitle(title);
		
		
		     
		              
		  
		
		return  ResponseEntity.ok(findBytitle);
	  
 
		      
	  
       
  
  }
	  
		@GetMapping("/Titles")
	public ResponseEntity<List<BookDto>> findAll () {
		
		var findAll = service.FindByAll();
		  
		return ResponseEntity.ok(findAll);
		 
	  
		
		
	}
	     
		 
		
		 
		@PutMapping("/{Id}")
		public ResponseEntity<BookDto> UpdateByBook ( @PathVariable ("Id")Integer id , @RequestBody BookDto updateDto) {
			 
			 var updateBybook = service.UpdateByBook(id, updateDto);
			 
			 return ResponseEntity.ok(updateBybook);
		}
   
		 @DeleteMapping("{Id}")
		 public ResponseEntity<String> DeletebyBook (@PathVariable ("Id")Integer id) {
			 
			   service.DeleteBybook(id);
			   return ResponseEntity.ok("Succsess Deleted");
			   
			   
			   
			   
			   
			   
			 
		 }

}