package com.project.onthego.service;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Usersubscriptiondto;

public class Generalcard extends Cardmember {

	

	Generalcard(Carddto card) {
		super(card);
		// TODO Auto-generated constructor stub
	}
	@Override
	public float getDiscountRate(float distancetravelled) {
		Usersubscriptiondto subscription=getactiveSubscription();
		float totalfare=(float)((float)(distancetravelled/1000) * (getPriceperKM()));
		float discount=totalfare;
		float Discountrate=0;
		if (subscription.getDiscount() > 0) {
			Discountrate=subscription.getDiscount();
		}
		if(Discountrate >0){
			discount=(float) (totalfare * (Discountrate/100.0));
		}
	return discount;
	}
 void Cardmember()
 {
	 setDiscount(0);
 }
}
