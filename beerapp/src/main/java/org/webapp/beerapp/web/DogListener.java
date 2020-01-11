package org.webapp.beerapp.web;

import org.webapp.beerapp.model.Dog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DogListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String name = servletContext.getInitParameter("dog.name");
        String race = servletContext.getInitParameter("rasa");

        Dog dog = new Dog(name,race);

        servletContext.setAttribute("dog",dog);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
