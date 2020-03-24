<%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 01/02/2020
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pracownik" type="org.webapp.beerapp.domain.Employee" class="org.webapp.beerapp.domain.Employee">
<jsp:setProperty name="pracownik" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
Pracownik: <jsp:getProperty name="pracownik" property="firstName"/> <jsp:getProperty name="pracownik" property="lastName"/>
Department: ${pracownik.department}

</body>
</html>
