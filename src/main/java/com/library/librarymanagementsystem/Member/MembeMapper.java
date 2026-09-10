package com.library.librarymanagementsystem.Member;

import java.util.ArrayList;

public class MembeMapper {

	
	
	   public static MemberDto mapTomemberDto (MemberEntity member) {
		 
		   
		   
		   
		   
		   
		   
		   return new MemberDto(member.getId() , member.getName() , member.getEmail());
		   
	   }
	    public static MemberEntity mapTomember (MemberDto dto) {
			return new  MemberEntity(dto.id() , dto.name() , dto.email() , 0 ,new ArrayList<>() );
	    	
			
		
	 
			
			
	    
	    }
	
	
	
	
}
