package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusTypes  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int	Bus_Type_Id;
	private String Bus_Type_Nm;
	private int Seat_Capacity;
	private int Standing_Capacity;
	
	public String getBus_Type_Nm() {
		return Bus_Type_Nm;
	}
	public void setBus_Type_Nm(String bus_Type_Nm) {
		Bus_Type_Nm = bus_Type_Nm;
	}
	public int getSeat_Capacity() {
		return Seat_Capacity;
	}
	public void setSeat_Capacity(int seat_Capacity) {
		Seat_Capacity = seat_Capacity;
	}
	public int getStanding_Capacity() {
		return Standing_Capacity;
	}
	public void setStanding_Capacity(int standing_Capacity) {
		Standing_Capacity = standing_Capacity;
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
