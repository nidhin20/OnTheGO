package com.project.onthego.view;

public class BusRouteview {
	private int Bus_Route_Id;
	private int Bus_Stop_Id;
	private int Stop_Reach_Time;
	private int Distnce_to_Destn;
	

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
		 if (stop_Reach_Time <0)
			 throw new IllegalArgumentException("Stop reach time can not be less than 0");
		Stop_Reach_Time = stop_Reach_Time;
	}

	public int getDistnce_to_Destn() {
		return Distnce_to_Destn;
	}

	public void setDistnce_to_Destn(int distnce_to_Destn) {
		Distnce_to_Destn = distnce_to_Destn;
	}


	public int getBus_Route_Id() {
		return Bus_Route_Id;
	}

	public void setBus_Route_Id(int bus_Route_Id) {
		Bus_Route_Id = bus_Route_Id;
	}

}
