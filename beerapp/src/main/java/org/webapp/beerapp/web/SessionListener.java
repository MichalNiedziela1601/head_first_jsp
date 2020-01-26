package org.webapp.beerapp.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    private int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized (this) {
            count++;
        }

        System.out.println("Session created: " + se.getSession().getId());
        System.out.println("Total session: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (this) {
            count--;
        }

        System.out.println("Session destroyed: " + se.getSession().getId());
        System.out.println("Total session: " + count);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Attribute added");
        System.out.println("Session id: " + event.getSession().getId());
        System.out.println("Attribute name: " + event.getName());
        System.out.println("Attribute value: " + event.getValue().toString());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Attribute removed");
        System.out.println("Session id: " + event.getSession().getId());
        System.out.println("Attribute name: " + event.getName());
        System.out.println("Attribute value: " + event.getValue().toString());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute replaced");
        System.out.println("Session id: " + event.getSession().getId());
        System.out.println("Attribute name: " + event.getName());
        System.out.println("Attribute value: " + event.getValue().toString());
    }
}
