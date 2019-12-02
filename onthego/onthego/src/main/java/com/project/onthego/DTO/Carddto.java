package com.project.onthego.DTO;

import java.util.Date;

public class Carddto {
	private int Card_Id;
	private String Card_Num;
	private String Card_Category;
	private float Balance;
	private boolean Card_Status;
	public int getCard_Id() {
		return Card_Id;
	}
	public void setCard_Id(int card_Id) {
		Card_Id = card_Id;
	}
	public String getCard_Num() {
		return Card_Num;
	}
	public void setCard_Num(String card_Num) {
		Card_Num = card_Num;
	}
	public String getCard_Category() {
		return Card_Category;
	}
	public void setCard_Category(String card_Category) {
		Card_Category = card_Category;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	public boolean isCard_Status() {
		return Card_Status;
	}
	public void setCard_Status(boolean card_Status) {
		Card_Status = card_Status;
	}
	private int Created_By;
	private Date Created_Date;
	private int Updated_By;
	private Date Updated_Date;
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
