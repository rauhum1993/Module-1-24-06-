<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/09/2020
  Time: 8:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form method="post" action="/view">
    <label>Product Description: </label><br/>
    <input type="text" name="description" placeholder="description" value="...."/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="price" value="0"/><br/>
    <label>Discount Percent:: </label><br/>
    <input type="text" name="discount" placeholder="discount" value="0"/><br/>
    <br>
    <input type = "submit" id = "submit" value = "Result"/>
  </form>

  </body>
</html>
