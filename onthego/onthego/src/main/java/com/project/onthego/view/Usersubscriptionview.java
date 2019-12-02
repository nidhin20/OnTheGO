package com.project.onthego.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Usersubscriptionview {
	@NotNull
	@NotEmpty
private int planid;
private String cardnumber;

public int getPlanid() {
	return planid;
}

public void setPlanid(int planid) {
	this.planid = planid;
}

public String getCardnumber() {
	return cardnumber;
}

public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}
}
