<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/9/2020
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<html>
<head>
    <title>Service Management Application</title>
    <script src="../jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>

    <h1>Service Management</h1>
    <h2>
        <a href="/service">List All Service</a>
    </h2>

<p><c:out value="${notification}"/></p>
    <div align="center">
        <form method="post" action="/service">
            <input type="hidden" name="actionUser" value="create">
            <table border="1" cellpadding="5">
                <h2>Create new service</h2>
                <tr>
                    <th>Service ID:</th>
                    <td>
                        <input type="text" id="id" name="id">
                    </td>
                </tr>
                <tr>
                    <th>Service name:</th>
                    <td>
                        <input type="text" id="name" name="name">
                    </td>
                </tr>
                <tr>
                    <th>Service Area :</th>
                    <td>
                        <input type="text" id="serviceArea" name="serviceArea">
                    </td>
                </tr>
                <tr>
                    <th>Service Cost :</th>
                    <td>
                        <input type="text" id="serviceCost" name="serviceCost">
                    </td>
                </tr>
                <tr>
                    <th>Service Max People:</th>
                    <td>
                        <input type="text" id="serviceMaxPeople" name="serviceMaxPeople">
                    </td>
                </tr>
                <tr>
                    <th>Rent Type Id:</th>
                    <td>
                        <input type="text" id="rentTypeId" name="rentTypeId">
                    </td>
                </tr>
                <tr>
                    <th>Service Type Id:</th>
                    <td>
                        <input type="text" id="serviceTypeId" name="serviceTypeId">
                    </td>
                </tr>
                <tr>
                    <th>Standard Room:</th>
                    <td>
                        <input type="text" id="standardRoom" name="standardRoom">
                    </td>
                </tr>
                <tr>
                    <th>Description Orther Convenienve:</th>
                    <td>
                        <input type="text" id="descriptionOrtherConvenienve" name="descriptionOrtherConvenienve">
                    </td>
                </tr>
                <tr>
                    <th>Pool Area:</th>
                    <td>
                        <input type="text" id="poolArea" name="poolArea">
                    </td>
                </tr>
                <tr>
                    <th>Number Of Floors:</th>
                    <td>
                        <input type="text" id="numberOfFloors" name="numberOfFloors">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" role="button">
                        <a role="button" href="/service">Back</a>
                    </td>
                </tr>

    </table>
</form>
<%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
