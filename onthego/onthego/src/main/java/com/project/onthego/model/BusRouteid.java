package com.project.onthego.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class BusRouteid implements Serializable{
	private int Bus_Route_Id;
	private int Stop_Seqnce_Id;
	public int getBus_Route_Id() {
		return Bus_Route_Id;
	}
	public void setBus_Route_Id(int bus_Route_Id) {
		Bus_Route_Id = bus_Route_Id;
	}
	public int getStop_Seqnce_Id() {
		return Stop_Seqnce_Id;
	}
	public void setStop_Seqnce_Id(int stop_Seqnce_Id) {
		Stop_Seqnce_Id = stop_Seqnce_Id;
	}
	
}
