/**
 * 
 */
/**
 * @author Jithu
 *
 */
package com.project.onthego.DTO;

import java.util.Date;

import com.project.onthego.model.User;

public class UserDto{
	
	private int id;
	private String name;
	private String email;
	private String phoneno;
	private Date dob;
	private String password;
	
	public UserDto(User user) {
	        this.id = user.getId();
	        this.name = user.getName();
	        this.email = user.getEmail();
	        this.phoneno = user.getPhoneno();
	        this.dob = user.getDob();
	        this.password = user.getPassword();
	 }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}