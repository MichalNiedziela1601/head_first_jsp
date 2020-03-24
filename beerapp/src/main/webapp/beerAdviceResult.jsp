<%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 13/10/18
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="org.webapp.beerapp.model.Beer" %>
<html>
<head>
    <%@include file="header.html" %>
    <title>Beer Advice Result</title>
</head>

<body>

<div class="container">
    <h1><% response.getWriter().println("<div class=\"container\">Jsp with recommendation");%></h1>

    <div><ul>
        <% try {
            List<Beer> styles = (List<Beer>) request.getAttribute("beers");
            Iterator<Beer> it = styles.iterator();
            while (it.hasNext()) {
                response.getWriter().print("<li>Try: " + it.next().getName() + "</li>");
            }
            response.getWriter().println("</div>");

        } catch (NoSuchElementException e) {
            response.getWriter().println(e.getMessage());
        }
        %>
    </ul></div>
    <div>
        <% response.getWriter().println("Main context: " + request.getAttribute("mainContext")); %>
    </div>
    <br />
    <div><% response.getWriter().println(request.getAttribute("contextPath")); %></div>
</div>
<div class="footer">
    <p><h4><% response.getWriter().print(request.getAttribute("emailAdmina")); %></h4></p>
</div>
</body>
</html>
