<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 08/26/2020
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hello World!

  <form action="/testServlet" method="post">
    <input type="text" name="username" />
    <input type="submit" value="Send name" />
  </form>

  <a href="/testServlet?username=c0505">Click to servlet</a>
  <a href="result.jsp">Click to result</a>
  </body>
</html>
