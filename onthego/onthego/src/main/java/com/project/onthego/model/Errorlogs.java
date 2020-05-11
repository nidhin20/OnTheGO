package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Errorlogs {
	@Id
	private int id;
	private String Errormessage;
	private Date Createddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getErrormessage() {
		return Errormessage;
	}

	public void setErrormessage(String errormessage) {
		Errormessage = errormessage;
	}

	public Date getCreateddate() {
		return Createddate;
	}

	public void setCreateddate(Date createddate) {
		Createddate = createddate;
	}
}
