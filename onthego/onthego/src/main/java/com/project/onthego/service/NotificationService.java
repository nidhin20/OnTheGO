package com.project.onthego.service;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {

	List<Observer> obs_list;
	List<CheckSubscription> newsubscription;
	
	
	public NotificationService() {
		
		obs_list = new ArrayList<Observer>();
		newsubscription=new ArrayList<CheckSubscription>();
	}


	@Override
	public void Attach(Observer o) {
		
		obs_list.add(o);
		
	}



	@Override
	public void Notify() throws Exception {
		
		try {
			for(int i=0;i<obs_list.size();i++)
			{
				obs_list.get(i).Update(this);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addSubscriptionlist(CheckSubscription cs) throws Exception {
		newsubscription.add(cs);
		Notify();
		
	}
	

	
	public List<CheckSubscription> getlist()
	{
		return newsubscription;
	}
}
