package com.project.onthego.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.Card;

@Component
public class CardValidator {

	@Value("${onthego.card.Minbalance}")
	private float minMinbalance = (float) 0.04;

	public String checkcardforuse(Carddto card) {
		if (card == null) {
			return "102";

		}
		if (card.getBalance() <= minMinbalance) {
			return "100";
		}
		if (!card.isCard_Status()) {
			return "101";
		}

		return "0";

	}

	public Boolean isValidcard(Carddto card) throws Exception {
		if (card == null) {
			throw new Exception("System does not have given card details");
		}
		if (!card.isCard_Status()) {
			throw new Exception("Card is inactive");
		}
		return true;
	}
}
