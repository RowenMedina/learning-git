package com.library.librarymanagementsystem.Member;

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



public class MemberController {
 
	
	 private MemberService service;
	 
	 
	
	  
	@PostMapping("/member")
	 public ResponseEntity<MemberDto> CreateMember (  @Valid @RequestBody   MemberDto dto) {
		
		 MemberDto save =  service.create(dto);
		 
		 
		            
		 
		 
		 return new ResponseEntity<>(save , HttpStatus.CREATED);
		 
	 } 
	
	@GetMapping("/member/{id}")
	public ResponseEntity<MemberDto> findbyid (@Valid @PathVariable ("id")Integer id) {
		
		MemberDto findbyid =  service.findbyid(id);
		
		return ResponseEntity.ok(findbyid);
		
		
		
	}
	     
	
	
	
	
	
	@PutMapping("/member/{id}")
	           public ResponseEntity<MemberDto> updateMember (  @Valid @PathVariable("id")    Integer id ,  @RequestBody    MemberDto updateDto) {
		
		
		
	
		
		
	        	   
	        	   MemberDto updateMember = service.updateMember(id, updateDto);
	        	   
	        	   
	        	   
	        	   return ResponseEntity.ok(updateMember) ;
	        	   
	           }
          
	
	@GetMapping("/Members")
	 public ResponseEntity<List<MemberDto>> findbyAll ( ) {
		
		  List<MemberDto> findbyall = service.FindByAll();
		 
		 
		 
		  return ResponseEntity.ok(findbyall);
		 
		 
	 }
	
	@DeleteMapping("/member/{id}")
	public ResponseEntity<String> deletebyId ( @PathVariable ("id") Integer id) {
		  
	
		
		
		service.DeleteMember(id);
		
		return ResponseEntity.ok("Bura na!!!");
		
		
		
		
		
		
		
		
	}
	
	
	
}
