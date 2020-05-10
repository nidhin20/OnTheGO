package com.project.onthego.service;

import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.Card;

@Component
public  class StudentFactory extends AbstractCardfactory {

	public Cardmember calculateDiscount(Carddto card) {
		return new Studentcard(card);
		
	}
	
	public GenReport generateReport() {
		return new StudentcardPdf();
	}
}
