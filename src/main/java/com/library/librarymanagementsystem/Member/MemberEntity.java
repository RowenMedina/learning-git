package com.library.librarymanagementsystem.Member;

import java.util.List;

import com.library.librarymanagementsystem.Borrowing.BorrowingEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
public class MemberEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 private String name;
	 
	      
	               
	 
	 
	 private String email;
	 
	 
	        private int quantity;
	        
	            
	     
	 @OneToMany(mappedBy = "member")
	 private List<BorrowingEntity> borrowings;
	 
	  
	 
	
}
