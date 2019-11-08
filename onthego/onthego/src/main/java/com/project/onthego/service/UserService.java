
package com.project.onthego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.model.Users;
import com.project.onthego.repository.UserRepository;


@RestController
@RequestMapping(value="/onthego/user")
//@Service
public class UserService {
	@Autowired
    private UserRepository repository;
	
	@GetMapping(value="/all")
	public List<Users> getAll(){
		return repository.findAll();
	}
		
	}
