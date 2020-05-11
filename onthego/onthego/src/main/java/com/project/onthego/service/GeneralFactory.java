package com.project.onthego.service;

import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

@Component
public  class GeneralFactory extends AbstractCardfactory {
	private @Autowired AutowireCapableBeanFactory beanFactory;

	public Cardmember calculateDiscount(Carddto card) {
		Generalcard gc = new Generalcard(card);
		beanFactory.autowireBean(gc);
		return gc;
		
	}
	
	public GenReport generateReport() {
		
			return new GeneralcardPdf();
	} 

}
