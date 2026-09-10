package com.library.librarymanagementsystem.BookCategory;




public class CategoryMapper {
 
	
	
	  
	
	      public CategoryDto maptoDto (CategoryEntity entity) {
			return new CategoryDto (entity.getId() , entity.getCategories() , entity.getDiscreption() );
	    	
			
			
			
	      }
	 
}


