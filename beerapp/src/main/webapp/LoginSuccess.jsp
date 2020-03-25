<%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 3/24/2020
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    String user = (String) session.getAttribute("user");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
      for(Cookie cookie : cookies) {
        if(cookie.getName().equals("user")) userName = cookie.getValue();
        if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
      }
    }

%>
<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
<br>
<a href="CheckoutPage.jsp">Checkout Page</a>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>
