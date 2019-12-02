package com.project.onthego.view;

import javax.validation.constraints.NotEmpty;

public class BusTypeview {
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
}
