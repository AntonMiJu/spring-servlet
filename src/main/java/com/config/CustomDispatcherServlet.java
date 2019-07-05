package com.config;

import com.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class CustomDispatcherServlet implements WebApplicationInitializer{
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
        dispatcherServletContext.register(AppConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet",dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
