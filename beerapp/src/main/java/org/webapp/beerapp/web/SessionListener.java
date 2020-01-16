package org.webapp.beerapp.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
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
}
