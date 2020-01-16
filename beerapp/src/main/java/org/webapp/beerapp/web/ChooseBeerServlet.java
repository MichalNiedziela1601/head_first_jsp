package org.webapp.beerapp.web;

import org.webapp.beerapp.domain.BeerDomainFacade;
import org.webapp.beerapp.domain.DomainFacade;
import org.webapp.beerapp.model.Beer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ChooseBeer.do", loadOnStartup = 1, name = "R3 Beer",
initParams = {
        @WebInitParam(name = "emailAdmina", value = "michal.niedziela@ic-consult.com")
})

public class ChooseBeerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String beerKind = req.getParameter("beerProperty");
        HttpSession session = req.getSession();
        if(session.isNew()) {
            System.out.println("This is new session");
            System.out.println("Session id: " +session.getId());
            System.out.println("Session creationTIme: " + session.getCreationTime());
            System.out.println("Session maxInactiveInterval: " + session.getMaxInactiveInterval());
        }
        session.setAttribute("beerKind",beerKind);

        req.setAttribute("emailAdmina", getServletConfig().getInitParameter("emailAdmina"));
        req.setAttribute("mainContext", getServletContext().getInitParameter("mainName"));
        req.setAttribute("contextPath",getServletContext().getContextPath());

        resp.sendRedirect("chooseBrewery.html");
    }
}
