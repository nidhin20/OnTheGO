package com.project.onthego.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Subscriptionview {

	private int Plan_Id;
	@NotEmpty
	private String Plan_Nm;
	@NotEmpty
	private String Card_Category;
	private boolean Default_plan;
	@NotNull
	private int Sub_Period;
	@NotNull
	private float Discount_rate;
	
	public int getPlan_Id() {
		return Plan_Id;
	}
	public void setPlan_Id(int plan_Id) {
		Plan_Id = plan_Id;
	}
	public String getPlan_Nm() {
		return Plan_Nm;
	}
	public void setPlan_Nm(String plan_Nm) {
		if (plan_Nm.isEmpty())
			throw new IllegalArgumentException("Plan name can not be empty");
		Plan_Nm = plan_Nm;
	}
	public String getCard_Category() {
		return Card_Category;
	}
	public void setCard_Category(String card_Category) {
		if (!(card_Category.equals("STU") || card_Category.equals("GEN") ))
			throw new IllegalArgumentException("card category should be STU or GEN");
		Card_Category = card_Category;
	}
	public boolean isDefault_plan() {
		return Default_plan;
	}
	public void setDefault_plan(boolean default_plan) {
		Default_plan = default_plan;
	}
	public int getSub_Period() {
		return Sub_Period;
	}
	public void setSub_Period(int sub_Period) {
		Sub_Period = sub_Period;
	}
	public float getDiscount_rate() {
		return Discount_rate;
	}
	public void setDiscount_rate(float discount_rate) {
		if (discount_rate <=0)
			throw new IllegalArgumentException("Discounted rate should not be less than 0");
		Discount_rate = discount_rate;
	}

}
