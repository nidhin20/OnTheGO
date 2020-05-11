package com.project.onthego.errorlogger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.onthego.model.User;
import com.project.onthego.service.Emailnotificationservice;
import com.project.onthego.service.UserService;
@Component
public class Severeerror extends Errorlogger {

	
	@Autowired
	private Emailnotificationservice emailservice;
	@Autowired
	private UserService userservice;
	@Autowired
	public Severeerror() {
		this.errorlevel = Errorlogger.SEVEREERROR;
	}



	@Override
	protected void logtherrormessage(String message) {
		List<User> users = userservice.findAlladministrator();
		for (User u : users) {
			try {
				emailservice.notifyuserMail(u, message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
