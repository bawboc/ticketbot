package com.ticketbot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;

/**
 * <h1>JSF Initialization</h1>
 * <p>
 * Sets up Prime Faces
 * </p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public class FacesInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("primefaces.THEME", "bootstrap");
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
	}

}
