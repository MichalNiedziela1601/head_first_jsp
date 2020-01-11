<%@ page import="java.util.List" %>
<%@ page import="org.webapp.beerapp.model.Beer" %><%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 29.10.2018
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="resources/header.html"%>
<body>
List of beers
<% List<Beer> beers = (List<Beer>) request.getAttribute("beers");
for(Beer b : beers) {
    response.getWriter().println("name: " + b.getName());
}

%>
</body>
</html>
