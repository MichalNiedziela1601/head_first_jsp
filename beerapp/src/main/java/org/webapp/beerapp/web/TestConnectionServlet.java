package org.webapp.beerapp.web;

import org.webapp.beerapp.model.Beer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestDB", urlPatterns = {"/testdb"})
public class TestConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) getServletContext().getAttribute("connection");
        List<Beer> beers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BEER");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String brewery = resultSet.getString("brewery");
                String genre = resultSet.getString("genre");
                beers.add(new Beer(id,name,brewery,genre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("beers",beers);
        RequestDispatcher view = req.getRequestDispatcher("testConnection.jsp");
        view.forward(req,resp);
    }
}
