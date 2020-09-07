<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2020
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/student?action=create">Create a student</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Students</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>

        </tr>
        <c:forEach var="student" items="${listStudent}">

            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.address}"/></td>
<%--                <td><c:out value="${user.country}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/users?action=edit&id=${user.id}">Edit</a>--%>
<%--                    <a href="/users?action=delete&id=${user.id}">Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>