package com.project.onthego.DTO;

public class Mlpeaktime {
	private int routeid;
	private int year;
	private int month;
	private int hour;
	private int dayofweek;
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getDayofweek() {
		return dayofweek;
	}
	public void setDayofweek(int dayofweek) {
		this.dayofweek = dayofweek;
	}
	public int getNoofpass() {
		return noofpass;
	}
	public void setNoofpass(int noofpass) {
		this.noofpass = noofpass;
	}
	private int noofpass;
}
