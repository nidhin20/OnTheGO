package com.project.onthego.validator;



public interface Validationset {
	Boolean accept(ValidationSetVisitor validateSetVisitor) throws Exception;
}
