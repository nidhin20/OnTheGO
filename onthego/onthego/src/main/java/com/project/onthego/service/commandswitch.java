package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class commandswitch {
	@Autowired
	private Command command_card;
	public void setcommandswitch(Command Link)
	{
		command_card=Link;
	}
	public String commandswitchservice() {
		return command_card.execute();
	}

}
