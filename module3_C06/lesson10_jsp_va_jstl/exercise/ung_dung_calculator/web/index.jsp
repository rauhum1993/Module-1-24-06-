<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/09/2020
  Time: 1:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>

  <form action="/view" method="get">
    <fieldset>
      <legend>Calculator:</legend>
      <label for="First">First operand:</label>
      <input type="text" id="First" name="first"><br><br>
      <label > Operator:</label>
      <select name="option">
        <option value="addition">addition</option>
        <option value="subtraction">subtraction</option>
        <option value="multiplication">multiplication</option>
        <option value="division">division</option>
      </select><br><br>
      <label  for="Second">Second operand:</label>
      <input type="text" id="Second" name="second"><br><br>
      <input type="submit" value="Calculate">
    </fieldset>
  </form>
  </body>
</html>
