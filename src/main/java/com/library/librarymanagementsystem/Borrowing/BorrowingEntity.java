package com.library.librarymanagementsystem.Borrowing;

import java.time.LocalDate;

import com.library.librarymanagementsystem.Member.MemberEntity;
import com.library.librarymanagementsystem.book.BookEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BorrowingEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 

	
	
	private LocalDate borrowDate = LocalDate.now();
	private LocalDate returnDate;
	
	
	   
           @Enumerated(EnumType.STRING)
	private BorrowingStatus status;
	
           
	          
	@ManyToOne
	@JoinColumn(name = "member_id")
	private MemberEntity member;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private BookEntity book;
	    
	
	
	
	          
	
}
