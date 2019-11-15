package com.project.onthego.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.dto.UserDto;
import com.project.onthego.dto.UserSignUpDto;
import com.project.onthego.model.User;
import com.project.onthego.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	UserService userService ;
	
	UserDto userDto;
	/*@GetMapping("/all")
	public List<User> Userlogin() {
	List<User> l1=user_service.getAll();
	return l1;
	}*/

<<<<<<< HEAD
	
=======
	@RequestMapping(path="/signup", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody @Valid UserSignUpDto userSignUpDto) {
		 UserDto userDto = userService.addUser(userSignUpDto);
         return ResponseEntity.ok().body(userDto);
		
	}
>>>>>>> bd895d9b04726694c422f4955c7769e1a60e15a4
}
