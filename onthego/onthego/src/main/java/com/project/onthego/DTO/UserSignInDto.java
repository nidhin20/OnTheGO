package com.project.onthego.DTO;



public class UserSignInDto  {


	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		 if (email.isBlank() || email.isEmpty())
			 throw new IllegalArgumentException("Email can not be empty");
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		 if (password.isBlank() || password.isEmpty())
			 throw new IllegalArgumentException("Password can not be empty");
		this.password = password;
	}
	public UserSignInDto()
	{
	}
	public UserSignInDto(String username, String password) {
	this.setEmail(username);
	this.setPassword(password);
	}
}
