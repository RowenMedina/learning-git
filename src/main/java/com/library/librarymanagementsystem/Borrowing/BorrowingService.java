package com.library.librarymanagementsystem.Borrowing;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.library.librarymanagementsystem.Member.MemberEntity;
import com.library.librarymanagementsystem.Member.MemberRepository;
import com.library.librarymanagementsystem.book.BookEntity;
import com.library.librarymanagementsystem.book.BookMapper;
import com.library.librarymanagementsystem.book.BookRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor
public class BorrowingService {
  
	      final private BookRepository bookrepo;
	      final private MemberRepository memberrepo;
	      final private BorrowingRepository borrowingrepo;
	      
	      
	      
	      
	      
	      @Transactional
	      public BorrowingDto save (BorrowingDto dto) {
		
	    	  
	    	  
	    	MemberEntity member =   memberrepo.findById(dto.memberId()).orElseThrow(() -> new ResponseStatusException(
		                HttpStatus.NOT_FOUND,
		                "Book not found: " ) );
	    			 
	    
	    	   
	    	  BookEntity book = bookrepo.findById(dto.bookId()).orElseThrow(() -> new ResponseStatusException(
		                HttpStatus.NOT_FOUND,
		                "Book not found: " ) );
	    	 
	    	  
	    	   
	    	                
	    	  
	    	  
	    	  
	    	  if (!book.isAvailable()) {
	    		   
	    		  
	    		  throw new ResponseStatusException(
	    		            HttpStatus.CONFLICT,
	    		            "Book is already borrowed"
	    		        );
	    		    
	    		  
	    		  
	    		  
	    		  
	    	  }
	    	  
	    	   book.setAvailable(false);
	    	
	    	   bookrepo.save(book);
	    	
	    	  
	    	  
	    	   
	    	   member.setQuantity(member.getQuantity() + 1);
	    	       
	    	 
	    	   memberrepo.save(member);
	    	   
	    	      
	    	         
	    	   
	    	
	    	  
	    	       BorrowingEntity borr = new   BorrowingEntity();
	    	       
	    	         borr.setMember(member);
	    	  borr.setBook(book);
	    	  
	    	  
	    	    
	    	  
	    	   
	    	   
	    	   borr.setBorrowDate(LocalDate.now());
	    	 
	    	  
	    	  borr.setStatus(BorrowingStatus.BORROWED);
	    	    BorrowingEntity saved = borrowingrepo.save(borr);
	    	    
	    	    
	    	    
	    	    
	    	    
	    	  
	    	return BorrowingMapper.maptoDto(saved);
	    	
	    	
	          
	    	        
	    	  
	    	  
	    	  
	    	  
	      }
	   
	       
	 
	      @Transactional
	      public BorrowingDto returnthebook (Integer  id) {
		
	    	  
	    	        
	    	
	    		    BorrowingEntity borrowing = borrowingrepo.findById(id)
	    		            .orElseThrow(() -> new ResponseStatusException(
	    		                    HttpStatus.NOT_FOUND,
	    		                    "Borrowing not found"
	    		            ));

	    		    if (borrowing.getStatus() == BorrowingStatus.RETURNED) {
	    		        throw new ResponseStatusException(
	    		                HttpStatus.CONFLICT,
	    		                "Book is already returned"
	    		        );
	    		    }

	    		    
	    		    
	    		   
	    		    
	    		    
	    		    
	    		    
	    		    borrowing.setStatus(BorrowingStatus.RETURNED);
	    		    borrowing.setReturnDate(LocalDate.now());

	    		    
	    		    MemberEntity member =  borrowing.getMember();
	    		    
	    		    
	    		    member.setQuantity(member.getQuantity() - 1);
	    		    
	    		    
	    		   
	    		    
	    		    
	    		      memberrepo.save(member);
	    		      
	    		      
	    		      
	    		      
	    		        
	    		     
	    		      
	    		    
	    		    
	    		    BookEntity book = borrowing.getBook();
	    		    book.setAvailable(true);
	    		    bookrepo.save(book);

	    		    BorrowingEntity saved = borrowingrepo.save(borrowing);

	    		    return BorrowingMapper.maptoDto(saved);
	    	
	    		    
	    		   
	      
	      
	      }
	    	  
	        
	                   public List <BorrowingDto> getAllborrowing () {
	                	   
	                	   
	                	
	                	   
	                	
	                	//return repo.findAll().stream().map(BookMapper:: mapToBookDto ).collect(Collectors.toList());	   
	                	   
	                	   return  borrowingrepo.findAll().stream().map(BorrowingMapper:: maptoDto ).collect(Collectors.toList());
	                	   
	                	   
	                	   
	                	   
	                   }
	               
	    
	      
	        
	             
	      
	      }
	      
	
	
	 

