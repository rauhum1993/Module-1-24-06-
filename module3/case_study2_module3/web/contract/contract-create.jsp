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
    <title>Contract Management Application</title>
    <script src="../jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>

    <h1>Contract Management</h1>
    <h2>
        <a href="/contract">List All Contract</a>
    </h2>

    <p ><c:out value="${notification}"/></p>
    <div align="center">
        <form method="post" action="/contract">
            <input type="hidden" name="actionUser" value="create">
            <table border="1" cellpadding="5">
                <h2>Create new Contract</h2>
                <tr>
                    <th>Contract ID:</th>
                    <td>
                        <input type="text" id="id" name="id" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Contract Start Date:</th>
                    <td>
                        <input type="text" id="contractStartDate" name="contractStartDate" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Contract End Date :</th>
                    <td>
                        <input type="text" id="contractEndDate" name="contractEndDate" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Contract Deposit :</th>
                    <td>
                        <input type="text" id="contractDeposit" name="contractDeposit" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Contrac tTotal Money:</th>
                    <td>
                        <input type="text" id="contractTotalMoney" name="contractTotalMoney" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Employee Id:</th>
                    <td>
                        <input type="text" id="employeeId" name="employeeId" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Customer ID:</th>
                    <td>
                        <input type="text" id="customerId" name="customerId" size="45">
                    </td>
                </tr>
                <tr>
                    <th>Service ID:</th>
                    <td>
                        <input type="text" id="serviceId" name="serviceId" size="45">
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" role="button">
                        <a role="button" href="/contract">Back</a>
                    </td>
                </tr>

            </table>
        </form>
        <%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
