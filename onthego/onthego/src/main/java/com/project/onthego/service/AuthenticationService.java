package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.UserDto;
import com.project.onthego.DTO.UserSignInDto;
import com.project.onthego.DTO.UserSignUpDto;

import com.project.onthego.repository.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
    private UserRepository userRepository;
	
	

	public String authenticateUser(UserSignInDto userSignInDto) {
		// TODO Auto-generated method stub
	//	User user=new User();
		//String email=userSignInDto.getEmail();
		//String password=userSignInDto.getPassword();
		
		int result=userRepository.findbyEmail(userSignInDto.getEmail(),userSignInDto.getPassword());
		if (result==1)
			return "Success";
		else 
			return "Invalid Credentials";
		
	}

	

	

}
