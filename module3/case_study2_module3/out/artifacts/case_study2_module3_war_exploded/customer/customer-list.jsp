<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">





</head>
<body>
<%@include file="../common/header.jsp" %>
<center>
    <h1>List Customer</h1>
    <h2>
        <a href="<c:url value="/customer?action=create"/>">Add New Customr</a>
    </h2>
    <p><c:out value="${notification}"/></p>
    <form class="form-inline my-2 my-lg-0 " action="/customer" >
        <input class="form-control mr-sm-2 rounded-pill" type="search" name="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search By Name</button>
        <input type="hidden" name="action" value="search">
    </form>
</center>
<div align="center">
    <table id="tableStudent" border="1" class="table table-striped table-bordered" cellpadding="5" style="width: 100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Type ID</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>ID Card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Action</th>


            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${listCustomer}">
                <tr>
                    <td><c:out value="${employee.customerId}"/></td>
                    <td><c:out value="${employee.customerTypeId}"/></td>
                    <td><c:out value="${employee.customerName}"/></td>
                    <td><c:out value="${employee.customerBirthday}"/></td>
                    <td><c:out value="${employee.customerGender}"/></td>
                    <td><c:out value="${employee.customerIdCard}"/></td>
                    <td><c:out value="${employee.customerPhone}"/></td>
                    <td><c:out value="${employee.customerEmail}"/></td>
                    <td><c:out value="${employee.customerAddress}"/></td>

                    <td>
                        <a href="<c:url value="/customer?action=edit&id=${employee.customerId}"/>" role="button" class="btn btn-outline-info my-2 my-sm-0" style="border: 1px solid ;border-radius: 5px">Edit</a>
                        <a href="<c:url value="/customer?action=delete&id=${employee.customerId}"/>" role="button" class="btn btn-outline-danger my-2 my-sm-0" style="border: 1px solid ;border-radius: 5px">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../bootstrap413/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom" :'lrtip',
            "lengthChange":false,
            "pageLength": 5
        });
    });
</script>
</html>
