package com.project.onthego.service;

import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;

@Component
public  class GeneralFactory extends AbstractCardfactory {

	public Cardmember calculateDiscount(Carddto card) {
		return new Generalcard(card);
		
	}
	
	public GenReport generateReport() {
		return new GeneralcardPdf();
	} 

}
