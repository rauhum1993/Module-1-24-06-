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
    <h1>List Contract Detail</h1>
    <h2>
        <a href="<c:url value="/contractDetail?actionUser=create"/>">Add New Contract Detail</a>
    </h2>
    <p><c:out value="${notification}"/></p>
</center>
<div align="center">
    <table id="tableStudent" border="1" class="table table-striped table-bordered" cellpadding="5" style="width: 100%">
        <thead>
        <tr>
            <th>Contract Detai lID</th>
            <th>Contract ID</th>
            <th>Attach Service ID</th>
            <th>Quantity</th>
            <th>Action</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach var="contractDetail" items="${listContractDetail}">
            <tr>
                <td><c:out value="${contractDetail.contractDetailID}"/></td>
                <td><c:out value="${contractDetail.contractID}"/></td>
                <td><c:out value="${contractDetail.attachServiceID}"/></td>
                <td><c:out value="${contractDetail.quantity}"/></td>

                <td>
                    <a href="/contractDetail?actionUser=edit&id=${contractDetail.contractDetailID}">Edit</a>
                    <a href="/contractDetail?actionUser=delete&id=${contractDetail.contractDetailID}">Delete</a>
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
