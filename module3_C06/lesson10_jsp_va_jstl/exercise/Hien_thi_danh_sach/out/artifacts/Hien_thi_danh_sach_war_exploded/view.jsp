<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/09/2020
  Time: 3:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customer</title>
</head>
<style>
    tr {
        height: 100px;
        text-align: center;

    }
    table {

        width: 80%;

        border-collapse: collapse;
    }

    table, tr, td ,th{
        border: 1px solid black;
    }
    img{
        width: 100px;
        height: 100px;
    }
</style>
<body>
<table>
        <tr style="text-align: center">
            <th colspan="4"> Danh sách  khách hàng</th>
        </tr>
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>

    <c:forEach var="customer" items="${list}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td style="width: 100px">
                <img src="${customer.imgCutomer}">
            </td>
        </tr>

    </c:forEach>




</table>
</body>
</html>
