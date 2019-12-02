package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Value;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Usersubscriptiondto;
import com.project.onthego.model.Card;

public abstract class Cardmember {
	private float Discount=0;  
	//Price is per KM
	@Value("${onthego.card.priceperkm}")
	private float PriceperKM=(float) 0.04;
	private String Cardnumber;
	private int cardid;
    public abstract float getDiscountRate(float distancetravelled);  
    
    public Usersubscriptiondto getactiveSubscription(){
    	SubscriptionService subservice= new SubscriptionService();
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
