package com.project.onthego.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;



public class RealInternet implements Internet {

	@Override
	public Response connectTo(Request req) throws Exception {
		Proxy webProxy 
		  = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("54.213.107.123", 3128));
		
		OkHttpClient client = new OkHttpClient();
		client.setProxy(webProxy);
		return client.newCall(req).execute();
	}

}
