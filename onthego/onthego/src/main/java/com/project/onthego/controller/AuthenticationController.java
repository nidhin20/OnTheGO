package com.project.onthego.controller;

import javax.validation.Valid;

//import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.DTO.UserSignInDto;
import com.project.onthego.security.JwtUtil;
import com.project.onthego.service.AuthenticationService;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userdetailsservice;
	@Autowired
	private JwtUtil Jwttokenutil;

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UserSignInDto userSignInDto) throws Exception {
		// Authenticate the user throws exception if not able to to authenticate
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userSignInDto.getEmail(), userSignInDto.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Incorrect username and password");
		}
		final UserDetails userDetails = userdetailsservice.loadUserByUsername(userSignInDto.getEmail());
		final String jwt = Jwttokenutil.GenerateToken(userDetails);
		return ResponseEntity.ok(jwt);
	}
}
