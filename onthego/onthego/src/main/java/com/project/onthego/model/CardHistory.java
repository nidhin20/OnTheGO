package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardHistory extends Baseclass{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Card_History_Id;
private int Card_Id;
private boolean Is_Debit;
private float Amount;
private int Bus_Servce_Id;
private Date Check_In;
private Date Check_Out;
private int Check_In_BusStop;
private int Check_Out_BusStop;
private String Reference;
public int getCard_Id() {
	return Card_Id;
}
public void setCard_Id(int card_Id) {
	Card_Id = card_Id;
}
public boolean isIs_Debit() {
	return Is_Debit;
}
public void setIs_Debit(boolean is_Debit) {
	Is_Debit = is_Debit;
}
public int getBus_Servce_Id() {
	return Bus_Servce_Id;
}
public void setBus_Servce_Id(int bus_Servce_Id) {
	Bus_Servce_Id = bus_Servce_Id;
}

public String getReference() {
	return Reference;
}
public void setReference(String reference) {
	Reference = reference;
}

public Date getCheck_Out() {
	return Check_Out;
}
public void setCheck_Out(Date check_Out) {
	Check_Out = check_Out;
}
public Date getCheck_In() {
	return Check_In;
}
public void setCheck_In(Date check_In) {
	Check_In = check_In;
}
public float getAmount() {
	return Amount;
}
public void setAmount(float amount) {
	Amount = amount;
}
public int getCheck_In_BusStop() {
	return Check_In_BusStop;
}
public void setCheck_In_BusStop(int check_In_BusStop) {
	Check_In_BusStop = check_In_BusStop;
}
public int getCheck_Out_BusStop() {
	return Check_Out_BusStop;
}
public void setCheck_Out_BusStop(int check_Out_BusStop) {
	Check_Out_BusStop = check_Out_BusStop;
}
}
