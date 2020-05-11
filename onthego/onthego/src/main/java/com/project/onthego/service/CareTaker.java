package com.project.onthego.service;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	 private List<Memento> listofmemento = new ArrayList<>();

	   public void add(Memento state){
		   listofmemento.add(state);
	   }

	   public Memento get(int index){
	      return listofmemento.get(index);
	   }
}
