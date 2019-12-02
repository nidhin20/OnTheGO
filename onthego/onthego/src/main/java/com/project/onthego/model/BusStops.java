package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class BusStops {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Bus_Stop_Id;
	private String Bus_Stop_Nm;
	private int Created_By;
	private Date Created_Date;
	private int Updated_By;
	private Date Updated_Date;

	public int getBus_Stop_Id() {
		return Bus_Stop_Id;
	}

	public void setBus_Stop_Id(int bus_Stop_Id) {
		Bus_Stop_Id = bus_Stop_Id;
	}

	public String getBus_Stop_Nm() {
		return Bus_Stop_Nm;
	}

	public void setBus_Stop_Nm(String bus_Stop_Nm) {
		Bus_Stop_Nm = bus_Stop_Nm;
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
