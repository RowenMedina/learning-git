package com.library.librarymanagementsystem.Borrowing;

public class BorrowingMapper {

	
	
	
	public static BorrowingDto maptoDto (BorrowingEntity en) {
		return new BorrowingDto (en.getId()  , en.getBook().getId() , en.getMember().getId() , en.getStatus());
		
		
		
		
			
		}
		
	
	
}
