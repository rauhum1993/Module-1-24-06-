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
    <title>Product Management Application</title>
    <script src="../jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="../view">List All Product</a>
    </h2>
    <p style="color: lawngreen"><c:out value="${message}"/></p>
</center>

<div align="center">
    <form method="post">
        <h2>Edit Product</h2>
        <table border="1" cellpadding="5">

            <c:if test="${editProduct != null}">
                <input type="hidden" name="id" value="${editProduct.ID}"/>
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${editProduct.name}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="${editProduct.price}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Numbers:</th>
                <td>
                    <input type="text" name="numbers" size="45"
                           value="${editProduct.numbers}"
                    />
                </td>
            </tr>

            <tr>
                <th>Color :</th>
                <td>
                    <input type="text" name="color" size="45"
                           value="${editProduct.color}"
                    />
                </td>
            </tr>


            <tr>
                <th>Status:</th>
                <td>
                    <input type="text" name="status" size="45"
                           value="${editProduct.status}"
                    />
                </td>
            </tr>



            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="category" size="45"
                           value="${editProduct.category}"
                    />
                </td>
            </tr>


            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <a role="button" href="/view">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
