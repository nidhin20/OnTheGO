package com.project.onthego.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public final class DataConstants {
	
	public String Applicationcommonerror = "An Error have been encountered";
		
	
	 public Map<String, String> CardErrors = new HashMap<String, String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 5333336777231482250L;

	{
		put("100","Insufficient Balance");
		put("101","Inactive Card");
		put("102","Invalid Card");
		
	}};
	  public  Map<String, String> getCardErrormap() {
	         return CardErrors;
	    }
}
