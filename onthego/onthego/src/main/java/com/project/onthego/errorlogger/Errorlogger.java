package com.project.onthego.errorlogger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public abstract class Errorlogger {

	public static int INFO=0;
	public static int CODEERROR=1;
	public static int SEVEREERROR=2;
	
	protected int errorlevel;
	protected Errorlogger nexterrorlogger;
			
	public void setnexterrorlevel(Errorlogger logger) {
		this.nexterrorlogger=logger;
	}
	public void logmessage(int level,String errormessage) {
		
		 if(this.errorlevel <= level){
			 logtherrormessage(errormessage);
	      }
	      if(nexterrorlogger !=null){
	    	  nexterrorlogger.logmessage(level,errormessage);
	      }
	}
	abstract protected void logtherrormessage(String message);
}
