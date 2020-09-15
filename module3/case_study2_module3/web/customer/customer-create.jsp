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
                <span class="msg-invalid" style="color: red">&nbsp;(*)&nbsp;Must fill in the correct format </span><br>
            </tr>
            <tr>
                <th>Customer ID:</th>
                <td>
                    <input type="text" id="id" name="id" size="50">
<%--                    <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>--%>
<%--                    <span class="msg-invalid" style="color: #b1dfbb">&nbsp;format KH-XXXX .X is number </span><br>--%>
<%--                    <span class="msg-invalid" style="color: red">${messageID}</span>--%>
                </td>
            </tr>
            <tr>
                <th>Customer Type ID:</th>
                <td>
                    <input type="text" id="type_id" name="type_id" size="50">
                    <span class="msg-invalid" style="color: red" >&nbsp;(*)</span><br>
                    <span class="msg-invalid" style="color: red">${messageTypeID}</span>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" id="name" name="name" size="50">
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" id="customer_birthday" name="customer_birthday" size="50">
                    <span class="msg-invalid" style="color: red" >&nbsp;(*)</span><br>
                    <span class="msg-invalid" style="color: red">${messageBirthday}</span>
                </td>
            </tr>

            <tr>
                <th>Customer Gender:</th>
                <td>

                   <select name="customer_gender" id="customer_gender" >
                       <option value="0">Male</option>
                       <option value="1">FeMale</option>

                   </select>
                </td>
            </tr>
            <tr>
                <th>Customer ID Card:</th>
                <td>
                    <input type="text" id="customer_id_card" name="customer_id_card" size="50">
                    <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                    <span class="msg-invalid" style="color: red">${messageIDCard}</span>
                </td>
            </tr>

            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" id="customer_phone" name="customer_phone" size="50">
                    <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                    <span class="msg-invalid" style="color: red">${messagePhone}</span>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" id="customer_email" name="customer_email" size="50">
                    <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                    <span class="msg-invalid" style="color: red">${messageEmail}</span>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" id="customer_address" name="customer_address" size="50">
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
