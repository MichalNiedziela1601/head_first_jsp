package org.webapp.beerapp.web;

import org.webapp.beerapp.model.Dog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DogServlet", urlPatterns = {"/dog"})
public class DogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = req.getServletContext();

        Dog dog = (Dog)ctx.getAttribute("dog");

        req.setAttribute("dog",dog);
        RequestDispatcher view = req.getRequestDispatcher("dog.jsp");
        view.forward(req,resp);
    }
}
