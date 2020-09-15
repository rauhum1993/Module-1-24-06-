<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2020
  Time: 5:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h1>
       <a href="/mat_bang">Danh Sach Mat Bang </a>
    </h1>
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
                    <a style="color: white;" href="<c:url value="/mat_bang?actionUser=create"/>">Them Moi Mat Bang</a>
                </button>

            </h2>
        </div>
        <div class="col-lg-4"></div>
        <div class="col-lg-5"  style="text-align: left">

            <form class="form-inline my-2 my-lg-0 " action="/mat_bang">
                <input class="form-control mr-sm-2 rounded-pill" type="search" name="searchMatBang" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tim kiem theo loai mat bang</button>
                <input type="hidden" name="actionUser" value="searchMatBang">
            </form><br>
            <form class="form-inline my-2 my-lg-0 " action="/mat_bang">
                <input class="form-control mr-sm-2 rounded-pill" type="search" name="searchGia" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tim kiem theo gia tri</button>
                <input type="hidden" name="actionUser" value="searchGia">
            </form><br>
            <form class="form-inline my-2 my-lg-0 " action="/mat_bang">
                <input class="form-control mr-sm-2 rounded-pill" type="search" name="searchTang" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tim kiem theo tang</button>
                <input type="hidden" name="actionUser" value="searchTang">
            </form>

        </div>



    </div>

</center>
<div align="center">
    <table id="tableStudent" border="1" class="table table-striped table-bordered" cellpadding="5" style="width: 100%">
        <thead>
        <tr>

            <th>Ma Mat Bang</th>
            <th>Trang Thai</th>
            <th>Dien Tich</th>
            <th>tang</th>
            <th>Loai Van Phong</th>
            <th>Gia Tien</th>
            <th>Ngay Bat Dau</th>
            <th >Ngay Ket Thuc</th>
            <th>Xoa</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach var="matBang" items="${danhSachMatBang}">
            <tr>
                <td ><c:out value="${matBang.maMatBang}"/></td>
                <td><c:out value="${matBang.trangThai}"/></td>
                <td><c:out value="${matBang.dienTich}"/></td>
                <td><c:out value="${matBang.tang}"/></td>
                <td><c:out value="${matBang.loaiVanPhong}"/></td>
                <td><c:out value="${matBang.giaTien}"/></td>
                <td><c:out value="${matBang.ngayBatDau}"/></td>
                <td><c:out value="${matBang.ngayKetThuc}"/></td>

                <td >
                    <button class="btn btn-primary" >
                        <a  style="color: white;" href="<c:url value="/mat_bang?actionUser=delete&maMatBang=${matBang.maMatBang}"/>">Xoa</a>
                    </button>

                </td>
<%--                <td>--%>

                    <!-- Button trigger modal -->
<%--                    <button type="button" class="btn btn-primary" data-toggle="modal" onclick="callModal1(this.id)"--%>
<%--                            id="${matBang.maMatBang}" data-target="#staticBackdrop">--%>
<%--                     Xoa--%>
<%--                    </button>--%>

                    <!-- Modal -->
<%--                    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false"--%>
<%--                         tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--                        <div class="modal-dialog">--%>
<%--                            <div class="modal-content">--%>
<%--                                <div class="modal-header">--%>
<%--                                    <h5 class="modal-title" id="staticBackdropLabel">Ban co chac muon xoa?</h5>--%>
<%--                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                        <span aria-hidden="true">&times;</span>--%>
<%--                                    </button>--%>
<%--                                </div>--%>
<%--                                <div class="modal-body">--%>
<%--                                    ...--%>
<%--                                </div>--%>
<%--                                <div class="modal-footer">--%>
<%--                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">--%>
<%--                                        Khong--%>
<%--                                    </button>--%>
<%--                                    <a role="button" href="#" id="modalDelete" class="btn btn-primary">Co</a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </td>--%>
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
        document.getElementById("modalDelete").href = "/mat_bang?actionUser=delete&id=" + id;
    }
</script>
</html>

