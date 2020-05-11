package com.project.onthego.validator;

public class Validatecard implements Validationset {
	 int cardid;

	public Validatecard(int cardparam) {
		this.cardid=cardparam;
	}
	@Override
	public Boolean accept(ValidationSetVisitor validateSetVisitor) throws Exception {
		return validateSetVisitor.visit(this);
	}

}
