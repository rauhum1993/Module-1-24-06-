<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2020
  Time: 5:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<%@include file="../common/header.jsp" %>
<center>
    <h1>List Product</h1>
    <h3>
        <p style="color: lawngreen"><c:out value="${notification1}"/></p>
        <p style="color: red"><c:out value="${notification2} "/></p>
        <p style="color: yellow"><c:out value="${notification3} "/></p>
        <p style="color: rebeccapurple"><c:out value="${notification4} "/></p>
    </h3>
    <div class="row">
        <div class="col-lg-3" style="text-align: right;">
            <h2>
                <button class="btn btn-primary" >
                    <a style="color: white;" href="<c:url value="/view?actionUser=create"/>">Add New Product</a>
                </button>

            </h2>
        </div>
        <div class="col-lg-5"></div>
        <div class="col-lg-4"  style="text-align: left">

            <form class="form-inline my-2 my-lg-0 " action="/view">
                <input class="form-control mr-sm-2 rounded-pill" type="search" name="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search By Name</button>
                <input type="hidden" name="actionUser" value="search">
            </form>
        </div>



    </div>

</center>
<div align="center">
    <table id="tableStudent" border="1" class="table table-striped table-bordered" cellpadding="5" style="width: 100%">
        <thead>
        <tr>

            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Numbers</th>
            <th>Color</th>
            <th>Status</th>
            <th>Category</th>
            <th >Edit</th>
            <th>Delete</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.ID}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.numbers}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.status}"/></td>
                <td><c:out value="${product.category}"/></td>

                <td >
                    <button class="btn btn-primary" >
                        <a  style="color: white;" href="<c:url value="/view?actionUser=edit&id=${product.ID}"/>">Edit</a>
                    </button>

                </td>
                <td>

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" onclick="callModal1(this.id)"
                            id="${product.ID}" data-target="#staticBackdrop">
                        Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Do you want to delete?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    ...
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                        Close
                                    </button>
                                    <a role="button" href="#" id="modalDelete" class="btn btn-primary">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
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
<script>
    function callModal1(id) {
        document.getElementById("modalDelete").href = "/view?actionUser=delete&id=" + id;
    }
</script>
</html>

