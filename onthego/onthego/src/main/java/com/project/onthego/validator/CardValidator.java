package com.project.onthego.validator;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.Card;

@Component
public class CardValidator {
	
	@Value("${onthego.card.Minbalance}")
	 private float minMinbalance;
	public String Checkcardforuse(Carddto card,Boolean ischeckin)
	{
		if (card == null)
		{
			return "102";
			
		}
		if(card.getBalance() <= minMinbalance )
		{
			return "100";
		}
		if(card.isCard_Status() == false)
		{
			return "101";
		}
		
		return "0";
		
	}
}
