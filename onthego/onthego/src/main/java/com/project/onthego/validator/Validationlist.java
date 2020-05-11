package com.project.onthego.validator;

import java.util.ArrayList;
import java.util.List;

public class Validationlist{

	List<Validationset> vallist;

	public Validationlist() {
		this.vallist = new ArrayList<>();
	}

	public void addvisitor(Validationset valset) {
		this.vallist.add(valset);
	}

	
	public Boolean validate(ValidationSetVisitor validateSetVisitor) throws Exception {

		for (Validationset itemlist : vallist) {
			itemlist.accept(validateSetVisitor);
		}
		return true;
	}

}
