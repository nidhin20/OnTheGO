
package com.project.onthego.validator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.onthego.repository.UserRepository;

@Component
public class EmailValidation{

		@Autowired
	    private UserRepository userRepository;
		public int validateEmail(String email)
		{
			
			
			if(email.matches("^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$") && !email.isEmpty())
			 return 1;
			else return 0;
			
			
			
			
		}
		
		
	}
