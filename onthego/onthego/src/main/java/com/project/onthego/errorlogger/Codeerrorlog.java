package com.project.onthego.errorlogger;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.onthego.model.Errorlogs;
import com.project.onthego.service.Errorlogsservice;

@Component
public class Codeerrorlog extends Errorlogger {
	@Autowired
	private Errorlogsservice errorlogservice;

	@Autowired
	public Codeerrorlog() {
		this.errorlevel=Errorlogger.CODEERROR;
	}
	
	@Override
	protected void logtherrormessage(String message) {
		
		Errorlogs errorlog=new Errorlogs();
		errorlog.setErrormessage(message);
		Date CurrentDate = new Date();
		errorlog.setCreateddate(CurrentDate);
		errorlogservice.inserterrorlog(errorlog);
		
	}

}
