package com.library.librarymanagementsystem.book;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService  {

	
	
	      
	
	 private BookRepository repo;
	 
	    
	 
	
	@Override
	public BookDto createBook(BookDto dto) {
		
		var createBook = BookMapper.maptoBook(dto);
		   var save = repo.save(createBook);
		
		   
		return BookMapper.mapToBookDto(save);


	
	
	}


          


	@Override
	public BookDto FindBookByid(Integer Id) {
		
		  BookEntity findbook = repo.findById(Id).orElseThrow(() -> new RuntimeException("Book not found: " + Id));
		            
		                            
		
		return BookMapper.mapToBookDto(findbook);
	}

      
	  
	@Override
	public List<BookDto> FindBookBytitle(String title) {
	
		
		
	
		
		  return repo.findByTitleContaining(title)
		            .stream()
		            .map(BookMapper::mapToBookDto)
		            .toList();
		 
		 
		 
		
	}

       


	@Override
	public List<BookDto> FindByAll() {
		
	
	 return repo.findAll().stream().map(BookMapper:: mapToBookDto ).collect(Collectors.toList());
	
	         
	        	
	 
	
	}

              



	@Override
	public BookDto UpdateByBook(Integer id ,BookDto updateDto) {
		
	     BookEntity update = repo.findById(id).orElseThrow(() -> new ResponseStatusException(
	                HttpStatus.NOT_FOUND,
	                "Book not found: " + id
	       
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 )
	        );
	     
	             
	      
		
	         update.setAuthor(updateDto.author());
		     update.setTitle(updateDto.title());
	         
		        
		      var save = repo.save(update);
		      
		      
		     
		     return BookMapper.mapToBookDto(save);
	}



          

	@Override
	public void DeleteBybook(Integer id) {
	
		 repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Book not found" + id));
		
		     repo.deleteById(id);
		     
		      
		    
		    
		        
		     
		   
		
	}



         

	@Override
	public List<BookDto> findbyCategory(Category category) {
	
		 
		
		
   return repo.findByCategory(category)
	            .stream()
	            .map(BookMapper::mapToBookDto)
	            .toList();

	
           
                     
	 
	        
	}
	
	
               
	    
	
  
}
