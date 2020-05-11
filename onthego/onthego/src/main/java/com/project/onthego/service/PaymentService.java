package com.project.onthego.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.PaymentDto;
import com.project.onthego.model.Payment;
import com.project.onthego.repository.PaymentRepository;

@Service
@Configurable
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public String addPayment(PaymentDto paymentDto) {

		Payment pay = new Payment();
		String ref_id = paymentRepository.findbyrefid();
		String Ref_id;

		if (ref_id == null) {
			Ref_id = "PR" + 100;
			pay.setPay_refno(Ref_id);
			pay.setTopup(paymentDto.getTopup());
		} else {
			Ref_id = "PR" + (Integer.parseInt(ref_id.substring(2)) + 1);
			pay.setPay_refno(Ref_id);
			pay.setTopup(paymentDto.getTopup());
		}

		paymentRepository.save(pay);
		return Ref_id;
	}

	public PaymentDto getpaymentbyrefno(String refno) {
		Payment payment= paymentRepository.findpaymentbyrefid(refno);
		PaymentDto paymentdto=new PaymentDto();
		if(payment==null) {
		return null;	
		}
		BeanUtils.copyProperties(payment,paymentdto);
		
		return paymentdto;
	}
}
