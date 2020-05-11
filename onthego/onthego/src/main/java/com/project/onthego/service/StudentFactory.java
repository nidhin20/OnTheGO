package com.project.onthego.service;

import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

@Component
public  class StudentFactory extends AbstractCardfactory {

private @Autowired AutowireCapableBeanFactory beanFactory;

	public Cardmember calculateDiscount(Carddto card) {
		Studentcard st = new Studentcard(card);
			beanFactory.autowireBean(st);
			return st;
		
	}
	
	public GenReport generateReport() {
		return new StudentcardPdf();
	}
}
