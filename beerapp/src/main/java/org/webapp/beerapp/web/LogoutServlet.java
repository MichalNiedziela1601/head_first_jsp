package org.webapp.beerapp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    Cookie[] cookies = req.getCookies();
    if(cookies != null) {
      for(Cookie cookie : cookies) {
        if(cookie.getName().equals("JSESSIONID")) {
          System.out.println("JSESSIONID = " + cookie.getValue());
          break;
        }
      }
    }
    HttpSession session = req.getSession(false);
    System.out.println("User = " + session.getAttribute("user"));
    if(session != null) {
      session.invalidate();
    }
    resp.sendRedirect("LoginPage.html");
  }
}
