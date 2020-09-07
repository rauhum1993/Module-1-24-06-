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
    <title>Create-New-Employee</title>
    <script src="bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../common/header.jsp"%>
<form action="/employee">
    <fieldset>
        <legend>Create New Employee</legend>
        <div>
            <label for="id">ID</label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" name="name">
        </div>

        <div>
            <label for="address">Address</label>
            <input type="text" id="address" name="address">
        </div>
        <div>
            <input type="submit" role="button">
            <a role="button" href="/employee">Back</a>
        </div>


    </fieldset>
</form>
<script src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<%@include file="../common/footer.jsp"%>
</body>
</html>
