package com.project.onthego.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.PaymentDto;
import com.project.onthego.model.UserSubscription;
import com.project.onthego.service.CardService;
import com.project.onthego.service.PaymentService;
@Component
public class ValidationEngine implements ValidationSetVisitor {
	@Autowired
	public PaymentService paymentservice;
	@Autowired
	public CardService Cardservice; 
	@Autowired
	public CardValidator cardValidator;
	@Override
	public Boolean visit(Validatecard validateCard) throws Exception {

		Carddto card = Cardservice.getCarddetailsbycardID(validateCard.cardid);
		Boolean result = cardValidator.isValidcard(card);
		return true;
	}

	@Override
	public Boolean visit(Validatepayment vpayment) throws Exception {
		PaymentDto payment = paymentservice.getpaymentbyrefno(vpayment.paymentid);
		try {
			if(payment !=null) {
				return true;
			}else {
				throw new Exception("Can not find a valid payment");
			}
		} catch (Exception e) {
			throw e; 
		}
		
	}

	

}
