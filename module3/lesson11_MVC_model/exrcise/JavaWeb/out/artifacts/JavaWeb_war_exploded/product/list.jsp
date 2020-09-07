<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2020
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<div>
    <a href="/product?action=create" role="button">Create New Product</a><br>
</div>
<div>
    <form action="/products ">
        <input type="text" placeholder="Search" name="search">
        <input type="submit" value="search" name="action">
    </form>
</div>
<table>
    <tr>
        <th>ID-Product</th>
        <th>Name-Product</th>
        <th>Price</th>
        <th>Detail</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="products" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="/product?action=view&id=${product.id}">Detail</a></td>
            <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
            <td><a href="/product?action=update&id=${product.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
