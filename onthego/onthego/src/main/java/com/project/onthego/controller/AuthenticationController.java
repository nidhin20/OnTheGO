package com.project.onthego.controller;

//import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.DTO.UserDto;
import com.project.onthego.DTO.UserSignInDto;
import com.project.onthego.service.AuthenticationService;



@RestController
public class AuthenticationController {

	  //@Autowired
	//    private AuthenticationManager authenticationManager;
	  
	  
	  @Autowired
	    private AuthenticationService authenticationService;
	  
	  @RequestMapping(path="/auth/user", method = RequestMethod.GET)
	    public String createAuthenticationToken(@RequestBody UserSignInDto userSignInDto)  {
		  // Authenticate the user throws exception if not able to to authenticate
		 return authenticationService.authenticateUser(userSignInDto);
	      
	  }

	/*private void authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
	        
	
	}*/
}
