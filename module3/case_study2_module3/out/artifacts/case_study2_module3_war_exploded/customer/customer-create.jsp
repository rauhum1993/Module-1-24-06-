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
    <title>Customer Management Application</title>
    <script src="../jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>

    <h1>Customer Management</h1>
    <h2>
        <a href="/customer">List All Customer</a>
    </h2>


<div align="center">
    <form method="post" action="/customer">
        <input type="hidden" name="action" value="create">
        <table border="1" cellpadding="5">
           <h2>Create new customer</h2>
            <tr>
                <th>Customer ID:</th>
                <td>
                    <input type="text" id="id" name="id">
                </td>
            </tr>
            <tr>
                <th>Customer Type ID:</th>
                <td>
                    <input type="text" id="type_id" name="type_id">
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" id="name" name="name">
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="text" id="customer_birthday" name="customer_birthday">
                </td>
            </tr>

            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" id="customer_gender" name="customer_gender">
                </td>
            </tr>
            <tr>
                <th>Customer ID Card:</th>
                <td>
                    <input type="text" id="customer_id_card" name="customer_id_card">
                </td>
            </tr>

            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" id="customer_phone" name="customer_phone">
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" id="customer_email" name="customer_email">
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" id="customer_address" name="customer_address">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" role="button">
                    <a role="button" href="/customer">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
