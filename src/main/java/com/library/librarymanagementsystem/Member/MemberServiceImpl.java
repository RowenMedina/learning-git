package com.library.librarymanagementsystem.Member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class MemberServiceImpl  implements MemberService{

	
	
	
	
	
	private MemberRepository repo;
	
	
	
	
	
	
	
	@Override
	public MemberDto create(MemberDto dto) {
		
		  
		  var save = MembeMapper.mapTomember(dto);
		  
		  var  toDto =      repo.save(save);
		  
		
		
		
		
		return MembeMapper.mapTomemberDto(toDto) ;
	}


             
	




	@Override
	public MemberDto findbyid(Integer id) {
	
		
		var findbyid = repo.findById(id).orElseThrow(() ->new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Member not found " + id));
		
		  
    
				
        
		
		return MembeMapper.mapTomemberDto(findbyid);
	}







	@Override
	public MemberDto updateMember(Integer id, MemberDto dto) {
		
		var updateMember = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Member not found " + id));
		
		  updateMember.setName(dto.name());
		  updateMember.setEmail(dto.email());
		  
		  
		  
		var save =  repo.save(updateMember);
		  
		
		  
		
		return MembeMapper.mapTomemberDto(save);
	}







	@Override
	public List<MemberDto> FindByAll() {
		
		
		
		
		

		 return repo.findAll().stream().map(MembeMapper::mapTomemberDto).collect(Collectors.toList());

		
		   
		 
		 
		
	}







	@Override
	public void DeleteMember(Integer id) {
	
		    repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Member not found " + id));
		
		     repo.deleteById(id);
		     
		     
		     
		
		
	}

  





	
	
	
	
	
}
