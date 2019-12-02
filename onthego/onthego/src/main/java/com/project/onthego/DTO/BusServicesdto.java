package com.project.onthego.DTO;

import java.util.Date;

public class BusServicesdto {
	private int Bus_Srvc_Id;
	private int Bus_Route_Id;
	private int Bus_Type_Id;
	private int Servc_Prvdr_Id;
	private Date Bus_Start_Time;
	private int Created_By;
	private Date Created_Date;
	private int Updated_By;
	private Date Updated_Date;
	public int getBus_Srvc_Id() {
		return Bus_Srvc_Id;
	}
	public void setBus_Srvc_Id(int bus_Srvc_Id) {
		Bus_Srvc_Id = bus_Srvc_Id;
	}
	public int getBus_Route_Id() {
		return Bus_Route_Id;
	}
	public void setBus_Route_Id(int bus_Route_Id) {
		Bus_Route_Id = bus_Route_Id;
	}
	public int getBus_Type_Id() {
		return Bus_Type_Id;
	}
	public void setBus_Type_Id(int bus_Type_Id) {
		Bus_Type_Id = bus_Type_Id;
	}
	public int getServc_Prvdr_Id() {
		return Servc_Prvdr_Id;
	}
	public void setServc_Prvdr_Id(int servc_Prvdr_Id) {
		Servc_Prvdr_Id = servc_Prvdr_Id;
	}
	public Date getBus_Start_Time() {
		return Bus_Start_Time;
	}
	public void setBus_Start_Time(Date bus_Start_Time) {
		Bus_Start_Time = bus_Start_Time;
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
