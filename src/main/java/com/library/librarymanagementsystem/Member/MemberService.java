package com.library.librarymanagementsystem.Member;

import java.util.List;

import com.library.librarymanagementsystem.book.BookDto;

public interface MemberService {
     
	
	
	   MemberDto create (MemberDto dto);
	 
	   
	       
	   
	       MemberDto updateMember (Integer id , MemberDto dto);
	       
	       
	       
	       
	       
	       
	       List<MemberDto> FindByAll ();
	       
	       void DeleteMember (Integer id);


		   MemberDto findbyid(Integer id);
	       
	   
}
