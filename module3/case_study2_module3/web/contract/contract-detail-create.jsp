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
    <title>ContractDetail Management Application</title>
    <script src="../jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>

    <h1>ContractDetail Management</h1>
    <h2>
        <a href="/contractDetail">List All ContractDetail</a>
    </h2>

    <p ><c:out value="${notification}"/></p>
    <div align="center">
        <form method="post" action="/contractDetail">
            <input type="hidden" name="actionUser" value="create">
            <table border="1" cellpadding="5">
                <h2>Create new ContractDetail</h2>
                <tr>
                    <th>Contract Detail ID:</th>
                    <td>
                        <input type="text" id="contractDetailID" name="contractDetailID" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Contract ID:</th>
                    <td>
                        <input type="text" id="contractID" name="contractID" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Attach Service ID :</th>
                    <td>
                        <input type="text" id="attachServiceID" name="attachServiceID" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Quantity :</th>
                    <td>
                        <input type="text" id="quantity" name="quantity" size="45">
                    </td>
                </tr>


                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" role="button">
                        <a role="button" href="/contractDetail">Back</a>
                    </td>
                </tr>

            </table>
        </form>
        <%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
