package com.project.onthego.view;


public class Usersubscriptionview {
private int planid;
private String cardnumber;

public int getPlanid() {
	return planid;
}

public void setPlanid(int planid) {
	if (planid <=0 )
		throw new IllegalArgumentException("Plan id can not be 0");
	this.planid = planid;
}

public String getCardnumber() {
	return cardnumber;
}

public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}
}
