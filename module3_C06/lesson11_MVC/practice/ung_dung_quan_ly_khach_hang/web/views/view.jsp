<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/09/2020
  Time: 8:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<p>
    <a href="/servlet">Home</a>
</p>
<p>
    <a href="/servlet?action=create"> Create new customer</a>
</p>
<p style="color: green;">
    ${message}
</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td><a href="/servlet?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/servlet?action=edit&id=${customer.getId()}">Edit</a></td>
            <td><a href="/servlet?action=delete&id=${customer.getId()}">Delete</a></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
