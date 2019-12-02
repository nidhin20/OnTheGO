package com.project.onthego.service;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Usersubscriptiondto;

public class Studentcard extends Cardmember {
	Studentcard(Carddto card) {
		super(card);
		setDiscount(30);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getDiscountRate(float distancetravelled) {
		Usersubscriptiondto subscription=getactiveSubscription();
		float totalfare=(float)((float)(distancetravelled/1000) * (getPriceperKM()));
		float discount=totalfare;
		float Discountrate=getDiscount();
		if (subscription.getDiscount() > 0) {
			Discountrate=subscription.getDiscount();
		}
		if(Discountrate >0)
		{
			discount=(float) (totalfare * (Discountrate/100.0));
		}
		float discountedfare= totalfare - discount;
		return discountedfare;
	}

}
