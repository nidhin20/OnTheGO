package com.project.onthego.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Payment_Id")
	private int pay_id;

	@Column(name="Paymnt_Reference_Nbr")
    private String pay_refno;
	
	@Column(name="Top_Up_Amt")
	private int topup;

	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}

	public String getPay_refno() {
		return pay_refno;
	}

	public void setPay_refno(String pay_refno) {
		this.pay_refno = pay_refno;
	}

	public int getTopup() {
		return topup;
	}

	public void setTopup(int topup) {
		this.topup = topup;
	}
	
}
