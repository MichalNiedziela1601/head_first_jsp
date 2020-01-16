package org.webapp.beerapp.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "testIllegal", urlPatterns = "/TestIllegal.do", loadOnStartup = 1)
public class TestIllegal extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("/WEB-INF/ddd1.pdf");
        int read = 0;
        byte[] bytes = new byte[1024];
        System.out.println("Log: --> " + is.available());
        OutputStream os = resp.getOutputStream();
        while((read = is.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        RequestDispatcher view = req.getRequestDispatcher("wynik.jsp");
        view.forward(req,resp);
        os.close();
    }
}
