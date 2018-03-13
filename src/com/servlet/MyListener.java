package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by asouqi on 3/5/18.
 */

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext=servletContextEvent.getServletContext();
        servletContext.setAttribute("number",new AtomicInteger());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext=httpSessionEvent.getSession().getServletContext();
        AtomicInteger n=(AtomicInteger)servletContext.getAttribute("number");
        System.out.println("Number>>>>>>"+n.incrementAndGet());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext=httpSessionEvent.getSession().getServletContext();
        AtomicInteger n=(AtomicInteger)servletContext.getAttribute("number");
        System.out.println("Number------"+n.decrementAndGet());
    }
}
