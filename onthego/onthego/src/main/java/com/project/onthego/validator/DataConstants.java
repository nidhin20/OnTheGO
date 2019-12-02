package com.project.onthego.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public final class DataConstants {
	
	public static String Applicationcommonerror = "An Error have been encountered";
		
	
	 public static Map<String, String> CardErrors = new HashMap<String, String>(){
	{
		put("100","Insufficient Balance");
		put("101","Inactive Card");
		put("102","Invalid Card");
		put("103","Card already mapped to a user");
		put("104","You can not remove other users card");
		
	}};
	  public  Map<String, String> getCardErrormap() {
	         return CardErrors;
	    }
}
