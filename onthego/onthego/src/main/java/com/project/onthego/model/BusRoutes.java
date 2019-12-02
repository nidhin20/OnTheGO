package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity
@IdClass(BusRouteid.class)
public class BusRoutes  {
	@Id
	private int Bus_Route_Id;
	@Id
	private int Stop_Seqnce_Id;
	private int Bus_Stop_Id;
	private int Stop_Reach_Time;
	private int Distnce_to_Destn;
	private int Created_By;
	private Date Created_Date;
	private int Updated_By;
	private Date Updated_Date;
	public int getStop_Seqnce_Id() {
		return Stop_Seqnce_Id;
	}
	public void setStop_Seqnce_Id(int stop_Seqnce_Id) {
		Stop_Seqnce_Id = stop_Seqnce_Id;
	}
	public int getBus_Stop_Id() {
		return Bus_Stop_Id;
	}
	public void setBus_Stop_Id(int bus_Stop_Id) {
		Bus_Stop_Id = bus_Stop_Id;
	}
	public int getStop_Reach_Time() {
		return Stop_Reach_Time;
	}
	public void setStop_Reach_Time(int stop_Reach_Time) {
		Stop_Reach_Time = stop_Reach_Time;
	}
	public int getDistnce_to_Destn() {
		return Distnce_to_Destn;
	}
	public void setDistnce_to_Destn(int distnce_to_Destn) {
		Distnce_to_Destn = distnce_to_Destn;
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
