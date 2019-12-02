package com.project.onthego.DTO;

import java.util.Date;

import com.project.onthego.model.Baseclass;

public class ServiceProviderdto  {
	private int Srvc_Prvdr_Id;
	private String Srvc_Prvdr_Nm;
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
	public String getSrvc_Prvdr_Nm() {
		return Srvc_Prvdr_Nm;
	}
	public void setSrvc_Prvdr_Nm(String srvc_Prvdr_Nm) {
		Srvc_Prvdr_Nm = srvc_Prvdr_Nm;
	}
	public int getSrvc_Prvdr_Id() {
		return Srvc_Prvdr_Id;
	}
	public void setSrvc_Prvdr_Id(int srvc_Prvdr_Id) {
		Srvc_Prvdr_Id = srvc_Prvdr_Id;
	}
}
