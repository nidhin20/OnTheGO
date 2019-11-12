
package com.project.onthego.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.onthego.dto.UserDto;
import com.project.onthego.dto.UserSignUpDto;
import com.project.onthego.model.User;
import com.project.onthego.repository.UserRepository;
import com.project.onthego.validation.EmailValidation;



@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	 /*@Autowired
	    private PasswordEncoder passwordEncoder;*/
	
	  public List<User> findAll() {

	        List<User> users = (List<User>) userRepository.findAll();

	        return users;
	    }

	public UserDto addUser( UserSignUpDto userSignUpDto) {
		User user = new User() ;
		//user.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
		EmailValidation e=new EmailValidation();
		if(userRepository.validbyEmail(userSignUpDto.getEmail())!=1)
		{
		int valid=e.validateEmail(userSignUpDto.getEmail());
		if(valid==1) {
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
		return null;
	}
		
	}
