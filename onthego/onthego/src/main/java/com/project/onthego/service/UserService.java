
package com.project.onthego.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.model.UserMembership;
import com.project.onthego.model.Users;
import com.project.onthego.repository.UserMembershipRepository;
import com.project.onthego.repository.UserRepository;


@Service
public class UserService {
	@Autowired
    private UserRepository userrepository;
	@Autowired
    private UserMembershipRepository usermembershiprepository;	
	public List<Users> getAll(){
		return userrepository.findAll();
	}
	public Optional<UserMembership> getAllLinkedcards(int userid){
		return usermembershiprepository.findById(userid);
	}
		
		
	}
