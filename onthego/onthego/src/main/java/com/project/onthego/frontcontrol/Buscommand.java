package com.project.onthego.frontcontrol;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerMapping;

import com.project.onthego.controller.BusController;
import com.project.onthego.service.Frontcommand;

@Service
public class Buscommand extends Frontcommand {

	@Override
	public void process() throws ServletException, IOException {
		Class artist;
		try {
			artist = Class.forName("com.project.onthego.controller.BusController");
			String requeststr = request.getPathInfo().split("Tapin/")[1];
			String[] requestobj = requeststr.split("/");
			
		
			Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationcontext, HandlerMapping.class, true, false);
			HandlerMapping h=allRequestMappings.get("requestMappingHandlerMapping");
			System.out.println(h);
			String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
	        
			BusController buscont = applicationcontext.getBean(BusController.class);
			//beanFactory.autowireBean(buscont);
			int serviceid =Integer.parseInt(requestobj[0]);
			int stopid =Integer.parseInt(requestobj[1]);
			String cardnum =requestobj[2];
			ResponseEntity<Object> res= buscont.Bustapin(serviceid, stopid, cardnum);
			
			response.setStatus(res.getStatusCodeValue());
			response.getWriter().write(res.getBody().toString());
			
//			BusController buscont = applicationcontext.getBean(BusController.class);
//			Method method = artist.getDeclaredMethod("CreatebusserviceProvider");
//
//			
//			method.invoke(buscont,requestobj);
			
		} catch (ClassNotFoundException | SecurityException 
				| IllegalArgumentException   e) {
			e.printStackTrace();
		}

	}

}
