package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SubscriptionPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Plan_Id;
	private String Plan_Nm;
	private String Card_Category;
	private boolean Default_plan;
	private int Sub_Period;
	private float Discount_rate;
	private boolean Is_Subs_Active;
	private int Created_By;
	private Date Created_Date;
	private int Updated_By;
	private Date Updated_Date;
	public int getPlan_Id() {
		return Plan_Id;
	}
	public void setPlan_Id(int plan_Id) {
		Plan_Id = plan_Id;
	}
	public String getCard_Category() {
		return Card_Category;
	}
	public void setCard_Category(String card_Category) {
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
		Discount_rate = discount_rate;
	}
	public boolean isIs_Subs_Active() {
		return Is_Subs_Active;
	}
	public void setIs_Subs_Active(boolean is_Subs_Active) {
		Is_Subs_Active = is_Subs_Active;
	}
	public int getCreated_By() {
		return Created_By;
	}
	public void setCreated_By(int created_By) {
		Created_By = created_By;
	}
	public Date getCreated_Date() {
		return Created_Date;
	}
	public void setCreated_Date(Date created_Date) {
		Created_Date = created_Date;
	}
	public int getUpdated_By() {
		return Updated_By;
	}
	public void setUpdated_By(int updated_By) {
		Updated_By = updated_By;
	}
	public Date getUpdated_Date() {
		return Updated_Date;
	}
	public void setUpdated_Date(Date updated_Date) {
		Updated_Date = updated_Date;
	}
	public String getPlan_Nm() {
		return Plan_Nm;
	}
	public void setPlan_Nm(String plan_Nm) {
		Plan_Nm = plan_Nm;
	}
}
