package org.webapp.beerapp.web;

import org.webapp.beerapp.domain.BeerDomainFacade;
import org.webapp.beerapp.domain.DomainFacade;
import org.webapp.beerapp.model.Beer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BreweryServlet", urlPatterns = "/ChooseBrewery.do")
public class ChooseBreweryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null) {
            System.out.println("!!!!!!!!! Session was destroyed");
        }else {
            String beerKind = (String) session.getAttribute("beerKind");
            String brewery = req.getParameter("brewery");
            int par1= 6;
            session.setAttribute("par1",par1);
            session.removeAttribute("par2");
            DomainFacade facade = new BeerDomainFacade();
            List<Beer> beers = facade.beerAdvice(beerKind, brewery);
            req.setAttribute("beers",beers);
            session.invalidate();
            RequestDispatcher view = req.getRequestDispatcher("beerAdviceResult.jsp");
            view.forward(req,resp);
        }

    }
}
