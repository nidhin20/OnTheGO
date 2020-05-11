package com.project.onthego.errorlogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Chainerrorlog {

	@Autowired
	private  Severeerror severeerror;
	@Autowired
	private  Codeerrorlog codeerror;
	@Autowired
	private  Infoerrorlog infoerror;
	
	public  Errorlogger getchainlog() {
		severeerror.setnexterrorlevel(codeerror);
		codeerror.setnexterrorlevel(infoerror);
		return severeerror;
	}

}
