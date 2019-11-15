
package com.project.onthego.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.onthego.model.UserMembership;
import com.project.onthego.repository.UserMembershipRepository;

import com.project.onthego.DTO.UserDto;
import com.project.onthego.DTO.UserSignUpDto;
import com.project.onthego.model.User;
import com.project.onthego.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private UserMembershipRepository usermembershiprepository;	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	public Optional<UserMembership> getAllLinkedcards(int userid){
		return usermembershiprepository.findById(userid);
	}
    
	
	 /*@Autowired
	    private PasswordEncoder passwordEncoder;*/
	
	  public List<User> findAll() {

	        List<User> users = (List<User>) userRepository.findAll();

	        return users;
	    }

	public UserDto addUser( UserSignUpDto userSignUpDto) {
		User user = new User() ;
		//user.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
		user.setPassword(userSignUpDto.getPassword());
        user.setName(userSignUpDto.getName());
        user.setDob(userSignUpDto.getDob());
        user.setEmail(userSignUpDto.getEmail());
        user.setPhoneno(userSignUpDto.getPhoneno());
		
        User userSaved = userRepository.save(user);

        
        UserDto userDto = new UserDto(userSaved);
       

        return userDto;
	}
		
		
	}
