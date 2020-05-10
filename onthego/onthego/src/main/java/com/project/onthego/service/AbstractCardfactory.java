package com.project.onthego.service;

import org.springframework.stereotype.Component;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.Card;

@Component
public abstract class AbstractCardfactory {
	
  public abstract Cardmember calculateDiscount(Carddto card);
  public abstract GenReport generateReport();
  
}
