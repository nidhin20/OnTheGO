package com.project.onthego.proxy;

import java.util.ArrayList;
import java.util.List;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class ProxyInternet implements Internet {
	private Internet internet = new RealInternet(); 
    private static List<String> AllowedSites; 
    static
    { 
    	AllowedSites = new ArrayList<>(); 
    	AllowedSites.add("api.cloudmersive.com"); 
    }
	@Override
	public Response connectTo(Request req) throws Exception {
		if(AllowedSites.contains(req.url().getAuthority())) 
        { 
			
			return internet.connectTo(req);
            
        } else
        {
        	throw new Exception("Access Denied"); 
        }
		 
	}

}
