package com.project.onthego.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.onthego.frontcontrol.Buscommand;
import com.project.onthego.service.Frontcommand;

@ComponentScan
@WebServlet(
        urlPatterns = "/front/*",
        loadOnStartup = 1,asyncSupported = true)
public class Frontcontroller extends HttpServlet implements ApplicationContextAware {

@Autowired
private BusController buscommand;

private static ApplicationContext applicationContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Frontcommand command;
			try {
				command = getCommand(req);
				command.init(getServletContext(), req, resp,applicationContext);
				command.process();
			} catch (Exception e) {
				e.printStackTrace();
			}
		super.doGet(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Frontcommand command;
		try {
			command = getCommand(req);
			
			command.init(getServletContext(), req, resp,applicationContext);
			command.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.doPost(req, resp);
	}

	private Frontcommand getCommand(HttpServletRequest request) throws Exception {
		try {
			return (Frontcommand) getCommandClass(request).newInstance();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private Class getCommandClass(HttpServletRequest request) throws Exception {
		Class result;
		String requeststr = request.getPathInfo();
		String[] requestobj = requeststr.split("/");
		 final String commandClassName ="com.project.onthego.frontcontrol.Buscommand";
		 try {
		 result = Class.forName(commandClassName);
		 }
		 catch (Exception e) {
				throw new Exception(e);
			}
		 return result;
		 }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
		// TODO Auto-generated method stub
		
	}
}
