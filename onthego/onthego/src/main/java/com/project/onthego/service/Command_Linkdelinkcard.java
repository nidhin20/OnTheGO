package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.repository.UserMembershipRepository;
@Service
public class Command_Linkdelinkcard {
	@Autowired
	private CardService cardservice;
	private Command command_link;
	@Autowired
	private UserMembershipRepository UserMembership;
	public String Linkcard(String cardnum,int userid) {
		CardLinkservice cardlink=new CardLinkservice(cardservice,UserMembership);
		command_link=new Linkcard(cardnum,userid,cardlink,UserMembership);
		return command_link.execute();
	}
	public String DeLinkcard(String cardnum,int userid) {
		CardLinkservice cardlink=new CardLinkservice(cardservice,UserMembership);
		command_link=new Delinkcard(cardnum,userid,cardlink,UserMembership);
		return command_link.execute();
	}
}
