package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeakTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Peak_Time_Id")
		private int id;
	
  	@Column(name="Day")
	    private String day;
  	
  	@Column(name="First_Peak_Hour")
	    private int firstpeakhour;
 
	@Column(name="Second_Peak_Hour")
    	private int secondpeakhour;
    
	@Column(name="Curr_Date")
		private Date currDate;


	public Date getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getFirstpeakhour() {
		return firstpeakhour;
	}

	public void setFirstpeakhour(int firstpeakhour) {
		this.firstpeakhour = firstpeakhour;
	}

	public int getSecondpeakhour() {
		return secondpeakhour;
	}

	public void setSecondpeakhour(int secondpeakhour) {
		this.secondpeakhour = secondpeakhour;
	}
}
