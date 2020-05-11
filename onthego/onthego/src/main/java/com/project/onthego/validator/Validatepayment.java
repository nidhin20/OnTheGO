package com.project.onthego.validator;



public class Validatepayment implements Validationset {
	
	  String paymentid;

	 
	 public Validatepayment(String payment) {
		this.paymentid = payment;
	}

	@Override
	public Boolean accept(ValidationSetVisitor validateSetVisitor) throws Exception {
		return validateSetVisitor.visit(this);
	}

}
