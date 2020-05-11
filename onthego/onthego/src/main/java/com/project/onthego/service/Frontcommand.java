package com.project.onthego.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
@Service
public abstract class Frontcommand  {

	protected ApplicationContext applicationcontext;
	protected ServletContext context;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected @Autowired AutowireCapableBeanFactory beanFactory;
	abstract public void process() throws ServletException, IOException;

	protected void forward(String target) throws ServletException, IOException {
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response, ApplicationContext appContext) {
		this.context = context;
		this.request = request;
		this.response = response;
		this.applicationcontext=appContext;
	}
}
