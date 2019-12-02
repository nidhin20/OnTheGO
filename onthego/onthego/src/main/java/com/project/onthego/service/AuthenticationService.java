package com.project.onthego.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.UserSignInDto;
import com.project.onthego.repository.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
    private UserRepository userRepository;
	
	

	public String authenticateUser(UserSignInDto userSignInDto) {
		// TODO Auto-generated method stub
		
		int result=userRepository.findbyEmail(userSignInDto.getEmail(),userSignInDto.getPassword());
		if (result==1)
			return "Success";
		else 
			return "Invalid Credentials";
		
	}

	public User GetUserbyemail(String email)
	{
		com.project.onthego.model.User userdetails=userRepository.GetuserbyEmail(email);
		User springuser=null;
		if (userdetails !=null)
		{
			 ArrayList<GrantedAuthority> newAuthorities = new ArrayList<>();
		
			if(userdetails.getIsAdmin())
			{
				newAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
			}
			springuser=new User(userdetails.getEmail(),userdetails.getPassword(),newAuthorities);
		}
		else
		{
			throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
		}
	
		
		return springuser;
		
	}



}
