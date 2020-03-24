<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 26/01/2020
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show hobby</title>
</head>
<body>
<%!
    String adrEmail;
    public void jspInit() {
        ServletConfig sConfig = getServletConfig();
        adrEmail = sConfig.getInitParameter("email");
        ServletContext ctx = getServletContext();
        ctx.setAttribute("email", adrEmail);
    }

    ArrayList showFriends() {
    ArrayList<String> friends = new ArrayList<>();
    friends.add("Stefan");
    friends.add("Maciek");
    friends.add("Ola");
    return friends;
} %>
<%= application.getAttribute("mainName")%><br />
Do przyjaciół którzy mają takie samo hobby jak ty: <b><%= request.getParameter("hobby")%></b><br />
należą: <br>
<% Iterator<String> it = showFriends().iterator();
while (it.hasNext()) { %>
<%= it.next()%>

<% } %>
<br />
Mój email: <%= adrEmail %>

    </body>
</html>
