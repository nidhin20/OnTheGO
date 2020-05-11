package com.project.onthego.interceptor;

import com.cloudmersive.client.invoker.auth.*;
import com.cloudmersive.client.model.VirusScanResult;
import com.project.onthego.errorlogger.Chainerrorlog;
import com.project.onthego.errorlogger.Errorlogger;
import com.project.onthego.proxy.Internet;
import com.project.onthego.proxy.ProxyInternet;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.mail.internet.ContentType;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Virusinterceptor implements HandlerInterceptor {
	public final String UPLOAD_DIR = "Data";
	@Autowired
	private Chainerrorlog chainerrorlog;

	@SuppressWarnings({ "unlikely-arg-type", "static-access" })
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String[] contenttypes = request.getContentType().split(";");
		if (Arrays.asList(contenttypes).contains(org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)) {
			int fileCt = 0;
			String uploadFilePath = request.getServletContext().getAttribute("javax.servlet.context.tempdir").toString()
					+ File.separator + UPLOAD_DIR;

			File fileSaveDir = new File(uploadFilePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}

			for (Part part : request.getParts()) {

				String fileName = "";
				String contentDisp = part.getHeader("content-disposition");
				String[] tokens = contentDisp.split(";");
				for (String token : tokens) {
					if (token.trim().startsWith("filename")) {
						fileName = token.substring(token.indexOf('=') + 2, token.length() - 1);
					}
				}

				if (!fileName.equals("")) {
					String uploadedfile = uploadFilePath + File.separator + fileName;
					part.write(uploadedfile);
					if (Boolean.FALSE.equals(fileisvirus(uploadedfile))) {
						response.sendError(response.SC_BAD_REQUEST, "File uploaded contain virus");
						return false;
					}
				}
			}
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	public Boolean fileisvirus(String uploadedfile) {

		Errorlogger log = chainerrorlog.getchainlog(); // chain of responsibility DP
		File inputFile = new File(uploadedfile);
		OkHttpClient client = new OkHttpClient();
		RequestBody body = new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart("inputFile",
				inputFile.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), inputFile))
				.build();
		Request request = new Request.Builder().url("https://api.cloudmersive.com/virus/scan/file").method("POST", body)
				.addHeader("Apikey", "49bf6ee3-976a-4f89-9389-fbf036388439").build();

		Response response;

		JSONParser parser = new JSONParser();
		try {

			Internet internet = new ProxyInternet(); // Proxy design pattern
			response = internet.connectTo(request); // Proxy design pattern
			String resultstring = response.body().string();
			JSONObject result = (JSONObject) parser.parse(resultstring);
			System.out.println(result);
			if (Boolean.FALSE.equals(result.get("CleanResult"))) {
				inputFile.delete();
				log.logmessage(Errorlogger.INFO, "Virus detected \n" + result);
				return false;
			}

		} catch (Exception e) {
			log.logmessage(Errorlogger.CODEERROR, e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
