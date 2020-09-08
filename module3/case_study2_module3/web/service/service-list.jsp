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
    <h1>List Service</h1>
    <h2>
        <a href="<c:url value="/service?actionUser=create"/>">Add New Service</a>
    </h2>
    <p><c:out value="${notification}"/></p>
</center>
<div align="center">
    <table id="tableStudent" border="1" class="table table-striped table-bordered" cellpadding="5" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max People</th>
            <th>Rent Type Id</th>
            <th>Service Type Id</th>
            <th>Standard Room</th>
            <th>Description Orther Convenienve</th>
            <th>Pool Area</th>
            <th>Number Of Floors</th>
            <th>Action</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${listService}">
            <tr>
                <td><c:out value="${service.serviceId}"/></td>
                <td><c:out value="${service.serviceName}"/></td>
                <td><c:out value="${service.serviceArea}"/></td>
                <td><c:out value="${service.serviceCost}"/></td>
                <td><c:out value="${service.serviceMaxPeople}"/></td>
                <td><c:out value="${service.rentTypeId}"/></td>
                <td><c:out value="${service.serviceTypeId}"/></td>
                <td><c:out value="${service.standardRoom}"/></td>
                <td><c:out value="${service.descriptionOrtherConvenienve}"/></td>
                <td><c:out value="${service.poolArea}"/></td>
                <td><c:out value="${service.numberOfFloors}"/></td>

                <td>
                    <a href="/service?actionUser=edit&id=${service.serviceId}">Edit</a>
                    <a href="/service?actionUser=delete&id=${service.serviceId}">Delete</a>
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
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

</html>
