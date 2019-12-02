package com.project.onthego.service;

import org.springframework.stereotype.Service;

import com.project.onthego.repository.UserMembershipRepository;
@Service
public class Linkcard implements Command {
	private String Cardnum;
	private int userid;
	private CardLinkservice CardLinkservice;
	private UserMembershipRepository UserMembershipRepo;
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return CardLinkservice.Linkcardtouser(Cardnum,userid);

	}
	public Linkcard() {
		
	}
	public Linkcard(String Cardno,int user,CardLinkservice card,UserMembershipRepository UserMembership) {
		setCardnum(Cardno);
		setUserid(user);
		CardLinkservice=card;
		setUserMembershipRepo(UserMembership);
		
	}
	public String getCardnum() {
		return Cardnum;
	}
	public void setCardnum(String cardnum) {
		Cardnum = cardnum;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public UserMembershipRepository getUserMembershipRepo() {
		return UserMembershipRepo;
	}
	public void setUserMembershipRepo(UserMembershipRepository userMembershipRepo) {
		UserMembershipRepo = userMembershipRepo;
	}
	

}
