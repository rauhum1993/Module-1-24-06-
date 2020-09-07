<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
    <script src="bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>
    <h1>List Customer</h1>
    <h2>
        <a href="/customer?action=create">Add New Customr</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">

        <tr>
            <th>ID</th>
            <th>Type ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>


        </tr>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.customerId}"/></td>
                <td><c:out value="${customer.customerTypeId}"/></td>
                <td><c:out value="${customer.customerName}"/></td>
                <td><c:out value="${customer.customerBirthday}"/></td>
                <td><c:out value="${customer.customerGender}"/></td>
                <td><c:out value="${customer.customerIdCard}"/></td>
                <td><c:out value="${customer.customerPhone}"/></td>
                <td><c:out value="${customer.customerEmail}"/></td>
                <td><c:out value="${customer.customerAddress}"/></td>

                <td>
                    <a href="/customer?action=edit&id=${customer.customerId}">Edit</a>
                    <a href="/customer?action=delete&id=${customer.customerId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>

</html>
