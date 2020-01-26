package org.webapp.beerapp.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestCookie", urlPatterns = "/TestCookie.do")
public class TestCookie extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("username");
        Cookie cookie = new Cookie("username", name);
        cookie.setMaxAge(20*60);
        resp.addCookie(cookie);

        req.getRequestDispatcher("cookieresult.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        for(int i =0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("username")) {
                String username = cookie.getValue();
                out.println("Hello, " + username);
                break;
            }
        }
    }
}
