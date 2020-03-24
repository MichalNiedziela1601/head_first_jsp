<%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 2/6/2020
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.html"/>
    <title>Komponent testowy</title>
</head>
<body>
<div class="container">
Request param Username: ${param.username} <br />
Request param IdEmployee: ${param.idEmployee} <br />
Request param food1: ${paramValues.food[0]} <br />
Request param food2: ${paramValues.food[1]} <br />

Request param Username: ${paramValues.username[0]}

EMail: ${initParam.adminEmail}
</div>
</body>
</html>
