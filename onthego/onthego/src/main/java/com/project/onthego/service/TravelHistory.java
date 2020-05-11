package com.project.onthego.service;

import java.util.Date;

public class TravelHistory implements TravelHistoryInterface {
 
	private Date Created_Date;
	private int Bus_Route_Id;
	private Date Bus_Start_Time;
	private String Startstop;
	private String Endstop;
	private float Amount;
	private int Is_Debit;
	public Date getCreated_Date() {
		return Created_Date;
	}
	public void setCreated_Date(Date created_Date) {
		Created_Date = created_Date;
	}
	public int getBus_Route_Id() {
		return Bus_Route_Id;
	}
	public void setBus_Route_Id(int bus_Route_Id) {
		Bus_Route_Id = bus_Route_Id;
	}
	public Date getBus_Start_Time() {
		return Bus_Start_Time;
	}
	public void setBus_Start_Time(Date bus_Start_Time) {
		Bus_Start_Time = bus_Start_Time;
	}
	public String getStartstop() {
		return Startstop;
	}
	public void setStartstop(String startstop) {
		Startstop = startstop;
	}
	public String getEndstop() {
		return Endstop;
	}
	public void setEndstop(String endstop) {
		Endstop = endstop;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public int getIs_Debit() {
		return Is_Debit;
	}
	public void setIs_Debit(int is_Debit) {
		Is_Debit = is_Debit;
	}
	
}
