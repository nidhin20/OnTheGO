package com.project.onthego.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.onthego.DTO.Mlpeaktime;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
@Service
public class Peaktimeservice {
	@Value("${onthego.peaktimeurl}")
	private  String  Peakurl;
	
	public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
	
	public Boolean getpeaktimestatus(Mlpeaktime mlpeak) {
		URL urlForGetRequest;
		Boolean ispeaktime=false;
		try {
			ObjectMapper mapper = new ObjectMapper();
		      String jsonString = mapper.writeValueAsString(mlpeak);
		
			OkHttpClient client = new OkHttpClient();
			 RequestBody body = RequestBody.create(JSON,jsonString); 
			  Request request = new Request.Builder()
			      .url(Peakurl)
			      .post(body)
			      .build();
			  Response response = client.newCall(request).execute(); //Calling Pycharm API to get peak time predictions
		   String result=response.body().string().trim();
			if(result.equals("1")) {
				ispeaktime=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ispeaktime;
		
	}
}
