package com.project.onthego.view;


public class Usersubscriptionview {
private int planid;
private String cardnumber;
private String refno;

public int getPlanid() {
	return planid;
}

public void setPlanid(int planid) {
	if (planid <=0 )
		throw new IllegalArgumentException("Plan id can not be 0");
	this.planid = planid;
}

public String getRefno() {
	return refno;
}

public void setRefno(String refno) {
	this.refno = refno;
}

public String getCardnumber() {
	return cardnumber;
}

public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}
}
