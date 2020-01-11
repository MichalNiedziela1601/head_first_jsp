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
        DomainFacade facade = new BeerDomainFacade();
        List<Beer> beers = facade.beerAdvice(beerKind);
        req.setAttribute("beers",beers);
        req.setAttribute("emailAdmina", getServletConfig().getInitParameter("emailAdmina"));
        req.setAttribute("mainContext", getServletContext().getInitParameter("mainName"));

        RequestDispatcher view = req.getRequestDispatcher("beerAdviceResult.jsp");
        view.forward(req,resp);

    }
}
