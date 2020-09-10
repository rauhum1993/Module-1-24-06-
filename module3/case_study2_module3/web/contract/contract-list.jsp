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
    <h1>List Contract</h1>
    <h2>
        <a href="<c:url value="/contract?actionUser=create"/>">Add New Contract</a><br>
        <a href="<c:url value="/contractDetail"/>">List Contract Detail</a>
    </h2>
    <p><c:out value="${notification}"/></p>
</center>
<div align="center">
    <table id="tableStudent" border="1" class="table table-striped table-bordered" cellpadding="5" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Deposit</th>
            <th>Total Money</th>
            <th>Employee ID</th>
            <th>Customer ID</th>
            <th>Service ID</th>
            <th>Action</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach var="contractDetail" items="${listContract}">
            <tr>
                <td><c:out value="${contractDetail.contractId}"/></td>
                <td><c:out value="${contractDetail.contractStartDate}"/></td>
                <td><c:out value="${contractDetail.contractEndDate}"/></td>
                <td><c:out value="${contractDetail.contractDeposit}"/></td>
                <td><c:out value="${contractDetail.contractTotalMoney}"/></td>
                <td><c:out value="${contractDetail.employeeId}"/></td>
                <td><c:out value="${contractDetail.customerId}"/></td>
                <td><c:out value="${contractDetail.serviceId}"/></td>

                <td>
                    <a href="/contract?actionUser=edit&id=${contractDetail.contractId}">Edit</a>
                    <a href="/contract?actionUser=delete&id=${contractDetail.contractId}">Delete</a>
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
