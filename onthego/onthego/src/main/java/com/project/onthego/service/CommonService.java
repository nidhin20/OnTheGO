package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.onthego.model.User;
import com.project.onthego.repository.UserRepository;
@Service
public class CommonService {
	@Autowired
	private UserRepository userRepository;

	public User Getloggedinuserdetails()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User jwtUser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
		return userRepository.GetuserbyEmail(jwtUser.getUsername());

	}
}
