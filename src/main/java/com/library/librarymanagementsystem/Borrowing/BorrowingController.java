package com.library.librarymanagementsystem.Borrowing;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor

public class BorrowingController {

	    
	    private BorrowingService service;
	    
	    @PostMapping()
	     public ResponseEntity<BorrowingDto> saved  ( @RequestBody  BorrowingDto dto) {
			
	    	   var savedbyborrowing = service.save(dto);
	    	   
	    	   
	    	 
	    	 
	    	 return new ResponseEntity<>(savedbyborrowing , HttpStatus.CREATED);
	    	 
	     }
	
	    @GetMapping("/{id}/return")
	 public ResponseEntity<BorrowingDto> returnthebook ( @PathVariable("id") Integer id) {
	
	    	
	    	 
	    	
	    	
		 
		 
		  var returnbybook =      service.returnthebook(id);
		 
		 
		 
		  
		 return ResponseEntity.ok( returnbybook);
		 
	 }
	 
	
	
	
	
	
	
}
