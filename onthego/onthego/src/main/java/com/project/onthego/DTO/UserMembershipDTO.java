package com.project.onthego.DTO;

import java.util.Date;

public class UserMembershipDTO {
	private int User_Id;
	private int Card_Id;
	private int Created_By;
	private Date Created_Date;
	private int Updated_By;
	private Date Updated_Date;
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public int getCard_Id() {
		return Card_Id;
	}
	public void setCard_Id(int card_Id) {
		Card_Id = card_Id;
	}

public int getCreated_By() {
	return Created_By;
}
public void setCreated_By(int created_By) {
	Created_By = created_By;
}
public Date getCreated_Date() {
	return Created_Date;
}
public void setCreated_Date(Date created_Date) {
	Created_Date = created_Date;
}
public int getUpdated_By() {
	return Updated_By;
}
public void setUpdated_By(int updated_By) {
	Updated_By = updated_By;
}
public Date getUpdated_Date() {
	return Updated_Date;
}
public void setUpdated_Date(Date updated_Date) {
	Updated_Date = updated_Date;
}
}
