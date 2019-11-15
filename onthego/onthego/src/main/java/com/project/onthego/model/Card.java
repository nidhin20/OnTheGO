package com.project.onthego.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card extends Baseclass{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	 
	
}
