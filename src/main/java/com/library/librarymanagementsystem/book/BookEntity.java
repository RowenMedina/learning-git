package com.library.librarymanagementsystem.book;

import java.util.List;

import com.library.librarymanagementsystem.BookCategory.CategoryEntity;
import com.library.librarymanagementsystem.Borrowing.BorrowingEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity


      


public class BookEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String author;
	
	private String isbn;
	
	private boolean available;
	
	
	
	 
	@OneToMany(mappedBy = "book")
	 private List<BorrowingEntity> borrowings;
	  
	
	
	@ManyToOne
	@JoinColumn(name = "Category_Id")
	private List<CategoryEntity> categories;
	
               
	
	
	
}
