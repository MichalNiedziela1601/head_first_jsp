<%@ page import="org.webapp.beerapp.model.Dog" %><%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 28.10.2018
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.html"%>
    <title>Title</title>
</head>
<body>

<% Dog dog = (Dog) request.getAttribute("dog");
response.getWriter().println(dog.getName());

%>

</body>
</html>
