package org.webapp.beerapp.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

  private ServletContext context;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.context = filterConfig.getServletContext();
    this.context.log("AuthenticationFilter initialized");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;

    String uri = req.getRequestURI();
    this.context.log("Requested Resource::"+ uri);

    HttpSession session = req.getSession(false);

    if(session != null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
      this.context.log("Unauthorized access request");
      resp.sendRedirect("LoginPage.html");
    } else {
      chain.doFilter(request,response);
    }

  }

  @Override
  public void destroy() {

  }
}
