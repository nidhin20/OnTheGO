package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.repository.UserMembershipRepository;
@Service
public class Command_Linkdelinkcard {
	@Autowired
	private CardService cardservice;
	@Autowired
	private commandswitch command_switch;
	
	@Autowired
	private UserMembershipRepository UserMembership;
	public String Linkcard(String cardnum,int userid) {
		CardLinkservice cardlink=new CardLinkservice(cardservice,UserMembership);
		Command card=new Linkcard(cardnum,userid,cardlink,UserMembership);
		command_switch.setcommandswitch(card);
		return command_switch.commandswitchservice();
	}
	public String DeLinkcard(String cardnum,int userid) {
		CardLinkservice cardlink=new CardLinkservice(cardservice,UserMembership);
		Command card=new Delinkcard(cardnum,userid,cardlink,UserMembership);
		command_switch.setcommandswitch(card);
		return command_switch.commandswitchservice();
	}
}
