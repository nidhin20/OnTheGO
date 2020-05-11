package com.project.onthego.proxy;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public interface Internet {
	public Response connectTo(Request reg) throws Exception; 
}
