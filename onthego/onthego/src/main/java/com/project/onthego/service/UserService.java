
package com.project.onthego.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.project.onthego.model.UserMembership;
import com.project.onthego.model.Users;
import com.project.onthego.repository.UserMembershipRepository;
=======
import com.project.onthego.dto.UserDto;
import com.project.onthego.dto.UserSignUpDto;
import com.project.onthego.model.User;
>>>>>>> bd895d9b04726694c422f4955c7769e1a60e15a4
import com.project.onthego.repository.UserRepository;



@Service
public class UserService {
	@Autowired
<<<<<<< HEAD
    private UserRepository userrepository;
	@Autowired
    private UserMembershipRepository usermembershiprepository;	
	public List<Users> getAll(){
		return userrepository.findAll();
	}
	public Optional<UserMembership> getAllLinkedcards(int userid){
		return usermembershiprepository.findById(userid);
=======
    private UserRepository userRepository;
	
	 /*@Autowired
	    private PasswordEncoder passwordEncoder;*/
	
	  public List<User> findAll() {

	        List<User> users = (List<User>) userRepository.findAll();

	        return users;
	    }

	public UserDto addUser( UserSignUpDto userSignUpDto) {
		User user = new User() ;
		//user.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
		user.setPassword(userSignUpDto.getPassword());
        user.setName(userSignUpDto.getName());
        user.setDob(userSignUpDto.getDob());
        user.setEmail(userSignUpDto.getEmail());
        user.setPhoneno(userSignUpDto.getPhoneno());
		
        User userSaved = userRepository.save(user);

        
        UserDto userDto = new UserDto(userSaved);
       

        return userDto;
>>>>>>> bd895d9b04726694c422f4955c7769e1a60e15a4
	}
		
		
	}
