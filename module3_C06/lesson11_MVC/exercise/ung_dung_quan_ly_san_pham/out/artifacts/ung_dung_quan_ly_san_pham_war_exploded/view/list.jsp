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
<h1>Product List</h1>
<p>
    <a href="/servlet">Home</a>
</p>
<p>
    <a href="/servlet?actionUser=create"> Create new Product</a>
</p>
<p style="color: green;font-size: 1cm">
    ${message}
</p>
<div>
    <form action="/servlet" >
        <input type="search" name="search" placeholder="search by name product" >
        <input type="submit" value="search" name="actionUser">
    </form>

</div>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/servlet?actionUser=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/servlet?actionUser=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/servlet?actionUser=delete&id=${product.getId()}">Delete</a></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
