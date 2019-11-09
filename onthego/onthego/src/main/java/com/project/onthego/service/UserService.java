
package com.project.onthego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.model.Users;
import com.project.onthego.repository.UserRepository;


@Service
public class UserService {
	@Autowired
    private UserRepository repository;
	
	public List<Users> getAll(){
		return repository.findAll();
	}
		
	}
