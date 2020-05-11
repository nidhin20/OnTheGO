package com.project.onthego.service;

import org.springframework.stereotype.Service;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Usersubscriptiondto;

public class Generalcard extends Cardmember {

	Generalcard(Carddto card) {
		super(card);
	}

	@Override
	public float getDiscountRate(float distancetravelled, int serviceid) {
		Usersubscriptiondto subscription = getactiveSubscription();
		float totalfare = (float) ((float) (distancetravelled / 1000) * (getPriceperKM()));
		float discount = totalfare;
		float Discountrate = 0;
		float peakprice = 0;
		if(Boolean.TRUE.equals(getpeaktime(serviceid))) {
			peakprice=(float)((float)(distancetravelled/1000) * getPriceperkmpeaktime());
		}
		if (subscription.getDiscount() > 0) {
			Discountrate = subscription.getDiscount();
		}
		if (Discountrate > 0) {
			discount = (float) (totalfare * (Discountrate / 100.0));
		}
		return discount + peakprice;
	}

	void Cardmember() {
		setDiscount(0);
	}
}
