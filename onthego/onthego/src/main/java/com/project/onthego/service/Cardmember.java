package com.project.onthego.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.BusServicesdto;
import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Mlpeaktime;
import com.project.onthego.DTO.Usersubscriptiondto;

@Service
public abstract class Cardmember {
	private float Discount=0;  
	//Price is per KM
	//@Value("${onthego.card.priceperkm}")
	private static float  PriceperKM=(float)0.04;
	//@Value("${onthego.card.priceperkmpeaktime}")
	private static float  priceperkmpeaktime=(float)0.01;
	private String Cardnumber;
	private int cardid;
	
	@Autowired
	private CardService Cardservice;
	@Autowired
	private BusService Busservice;
	@Autowired
	private Peaktimeservice Peakservice;
	@Autowired
	private SubscriptionService subservice;
	
    public abstract float getDiscountRate(float distancetravelled,int serviceid);  
    
    public float getPriceperkmpeaktime() {
		return priceperkmpeaktime;
	}

	public void setPriceperkmpeaktime(float priceperkmpeaktime) {
		this.priceperkmpeaktime = priceperkmpeaktime;
	}

	public Boolean getpeaktime(int serviceid) {
		BusServicesdto bus=Busservice.Getbusservice(serviceid);
		int noofpass=Cardservice.getcurrentusersinbus(serviceid);
		Calendar cal = Calendar.getInstance();
		
		Mlpeaktime mlp= new Mlpeaktime();
		mlp.setYear(cal.get(Calendar.YEAR));
		mlp.setDayofweek(cal.get(Calendar.DAY_OF_WEEK));
		mlp.setHour(cal.get(Calendar.HOUR));
		mlp.setMonth(cal.get(Calendar.MONTH));
		mlp.setNoofpass(noofpass);
		mlp.setRouteid(bus.getBus_Route_Id());
		return Peakservice.getpeaktimestatus(mlp);
	}
	public Usersubscriptiondto getactiveSubscription(){
    	
    	return subservice.GetsubscriptionbyCardid(cardid);
    	
    }
    Cardmember(Carddto card)
    {
		setCardnumber(card.getCard_Num());
    	setCardid(card.getCard_Id());	
    }

	public String getCardnumber() {
		return Cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		Cardnumber = cardnumber;
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}

	public float getDiscountRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getPriceperKM() {
		return PriceperKM;
	}

	public void setPriceperKM(float priceperKM) {
		PriceperKM = priceperKM;
	}
}
