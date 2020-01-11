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
    <title>Beer Advice Result</title>
</head>
<%@include file="resources/header.html"%>
<body>

<div class="container">
    <h1>Jsp with recommendation</h1>

    <div><ul>
        <%
            List<Beer> styles = (List<Beer>)request.getAttribute("beers");
            Iterator<Beer> it = styles.iterator();
            while(it.hasNext()) {
                response.getWriter().print("<li>Try: " + it.next().getName() + "</li>");
            }
        %>
    </ul></div>

    <div>
        <%
            response.getWriter().println("Email admina: " + request.getAttribute("emailAdmina"));
        %>
    </div><br>
    <div>
        <% response.getWriter().println("Main context: " + request.getAttribute("mainContext")); %>
    </div>
</div>
</body>
</html>
