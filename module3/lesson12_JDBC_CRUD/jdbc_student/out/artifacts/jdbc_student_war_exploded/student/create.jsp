<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/9/2020
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create-New-Student</title>
</head>
<body>
<form action="/student" method="post">
    <input type="hidden" name="actionUser" value="create" />
    <fieldset>
        <legend>Create New Student</legend>
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
            <input type="submit" value="Register">
            <a role="button" href="/student">Back</a>
        </div>


    </fieldset>
</form>
</body>
</html>
