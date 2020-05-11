package com.project.onthego.service;

import java.util.Date;

public interface TravelHistoryInterface {

	public Date getCreated_Date();
	public int getBus_Route_Id();
	public Date getBus_Start_Time();
	public String getStartstop();
	public String getEndstop();
	public float getAmount();
	public int getIs_Debit();
	
	public void setIs_Debit(int is_Debit) ;
	public void setAmount(float amount);
	public void setEndstop(String endstop);
	public void setStartstop(String startstop);
	public void setBus_Start_Time(Date bus_Start_Time);
	public void setBus_Route_Id(int bus_Route_Id);
	public void setCreated_Date(Date created_Date);
	
}
