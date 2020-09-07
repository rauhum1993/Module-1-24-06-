<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2020
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create-New-Customer</title>
    <script src="bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<form action="/customer" method="post">
    <input type="hidden" name="action" value="create">
    <fieldset>
        <legend>Create New Customer</legend>
        <div>
            <label for="id">ID</label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label for="type_id">Type ID</label>
            <input type="text" id="type_id" name="type_id">
        </div>
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <label for="customer_birthday">Birthday</label>
            <input type="text" id="customer_birthday" name="customer_birthday">
        </div>

        <div>
            <label for="customer_gender">Gender</label>
            <input type="customer_gender" id="customer_gender" name="customer_gender">
        </div>
        <div>
            <label for="customer_id_card">Id Card</label>
            <input type="text" id="customer_id_card" name="customer_id_card">
        </div>
        <div>
                <label for="customer_phone">Phone</label>
            <input type="text" id="customer_phone" name="customer_phone">
        </div>
        <div>
            <label for="customer_email">Email</label>
            <input type="text" id="customer_email" name="customer_email">
        </div>
        <div>
            <label for="customer_address">Address</label>
            <input type="text" id="customer_address" name="customer_address">
        </div>
        <div>
            <input type="submit" value="Save" role="button">
            <a role="button" href="/customer">Back</a>
        </div>


    </fieldset>
</form>
<%@include file="../common/footer.jsp"%>
</body>
<script src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
