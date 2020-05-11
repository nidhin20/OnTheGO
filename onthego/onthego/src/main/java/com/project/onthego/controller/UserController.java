package com.project.onthego.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.DTO.UserDto;
import com.project.onthego.DTO.UserSignUpDto;
import com.project.onthego.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	UserService userService ;
	
	UserDto userDto;

	@RequestMapping(path="/signup", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody @Valid UserSignUpDto userSignUpDto) {
		 UserDto userDto = userService.addUser(userSignUpDto);
		 if(userDto==null)
		 {
			 return ResponseEntity.ok().body("Invalid Email/User already exist");
		 }
         return ResponseEntity.ok().body("Successfully Registered");
		
	}
}
