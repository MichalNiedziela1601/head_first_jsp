<%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 3/25/2020
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    String userName = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
      for(Cookie cookie : cookies) {
        if(cookie.getName().equals("user")) userName = cookie.getValue();
      }
    }
%>
<h3>Hi <%=userName%>, do the checkout</h3>
<br />
<form method="post" action="LogoutServlet">
    <input type="submit" value="Logout" />
</form>
</body>
</html>
