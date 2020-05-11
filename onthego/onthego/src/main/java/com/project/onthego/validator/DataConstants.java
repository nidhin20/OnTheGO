package com.project.onthego.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public  class DataConstants {
	
	public static final String APPLICATIONCOMMONERROR = "An Error have been encountered";
		
	
	 public static final Map<String, String> CardErrors = new HashMap<>();
	  public  Map<String, String> getCardErrormap() {
	         return CardErrors;
	    }
	  
	  public DataConstants() {
		  CardErrors.put("100","Insufficient Balance");
		  CardErrors.put("101","Inactive Card");
		  CardErrors.put("102","Invalid Card");
		  CardErrors.put("103","Card already mapped to a user");
		  CardErrors.put("104","You can not remove other users card");
	  }
}
