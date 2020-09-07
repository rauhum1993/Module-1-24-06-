<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 08/26/2020
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1>Result: <%=request.getParameter("username")%></h1>
    <h1>Total: <%=request.getAttribute("totalAbc")%></h1>

    <a href="index.jsp">Click to index</a>
</body>
</html>
