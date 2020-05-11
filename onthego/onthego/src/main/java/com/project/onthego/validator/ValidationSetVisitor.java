package com.project.onthego.validator;

import org.springframework.stereotype.Component;

@Component
public interface ValidationSetVisitor {
	Boolean visit(Validatecard validateCard) throws Exception;
	Boolean visit(Validatepayment vpayment) throws Exception;
}
