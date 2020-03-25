package org.webapp.beerapp.web;


import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {

  private ServletContext context;
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.context = filterConfig.getServletContext();
    this.context.log("RequestLoggingFilter initialized");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    Enumeration<String> params = req.getParameterNames();
    while(params.hasMoreElements()) {
      String name = params.nextElement();
      String value = request.getParameter(name);
      this.context.log(req.getRemoteAddr() + "::RequestParam::{"+name+"="+value+"}");
    }
    Cookie[] cookies = req.getCookies();
    if(cookies != null) {
      for(Cookie cookie : cookies) {
        this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+"="+cookie.getValue()+"}");
      }
    }
    chain.doFilter(request,response);
  }

  @Override
  public void destroy() {

  }
}
