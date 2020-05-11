package com.project.onthego.errorlogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Infoerrorlog extends Errorlogger {
	@Autowired
	public Infoerrorlog() {
		this.errorlevel=Errorlogger.INFO;
	}
	
	@Override
	protected void logtherrormessage(String message) {
		Infologwriter logwrite=new Infologwriter();
		logwrite.loginformation(INFO, message);
	}

}
