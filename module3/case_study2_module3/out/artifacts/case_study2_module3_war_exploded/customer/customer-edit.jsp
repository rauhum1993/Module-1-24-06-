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
        <a href="customer?action=customer">List All Customer</a>
    </h2>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${editCustomer != null}">
                <input type="hidden" name="id" value="${editCustomer.customerId}"/>
            </c:if>
            <tr>
                <th>Customer Type ID:</th>
                <td>
                    <input type="text" name="typeID" size="45"
                           value="${editCustomer.customerTypeId}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${editCustomer.customerName}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="${editCustomer.customerBirthday}"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" name="gender" size="45"
                           value="${editCustomer.customerGender}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer ID Card:</th>
                <td>
                    <input type="text" name="IDCard" size="45"
                           value="${editCustomer.customerIdCard}"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="${editCustomer.customerPhone}"
                    />
                </td>
            </tr>



            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="${editCustomer.customerEmail}"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="${ediCustomer.customerAddress}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
