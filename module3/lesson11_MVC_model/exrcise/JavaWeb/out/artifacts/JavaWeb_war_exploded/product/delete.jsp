<%--
  Created by IntelliJ IDEA.
  User: Phan Quốc Khánh
  Date: 30/08/2020
  Time: 7:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h2>Are you sure you want to remove "${requestScope["products"].name}" it from the list ?</h2>
    <table>
        <tr>
            <th></th>
            <th>Information:</th>
        </tr>
        <tr>
            <td>ID-Product:</td>
            <td>${requestScope["products"].id}</td>
        </tr>
        <tr>
            <td>Name-Product:</td>
            <td>${requestScope["products"].name}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${requestScope["products"].price}</td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>${requestScope["products"].description}</td>
        </tr>
        <tr>
            <td>Producer:</td>
            <td>${requestScope["products"].producer}</td>
        </tr>
    </table>
    <div>
        <input type="submit" role="button" value="delete">
        <a role="button" href="/product">Back</a>
    </div>
</form>
</body>
</html>

