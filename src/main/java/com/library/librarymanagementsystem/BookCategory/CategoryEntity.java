package com.library.librarymanagementsystem.BookCategory;



import java.util.List;
import java.util.Locale.Category;

import com.library.librarymanagementsystem.book.BookEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity




public class CategoryEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	  private String categories;
	  
	  
	  
	  private String discreption;
	  
	  @Enumerated(EnumType.STRING)
	  private Category category;
	  
	
	  @OneToMany(mappedBy = "category")
	    private List<BookEntity> books;
	
	
	   
	
}
