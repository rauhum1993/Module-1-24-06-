<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/09/2020
  Time: 10:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style>
    tr {
      height: 100px;
      text-align: center;

    }
    table {

      width: 80%;
      background-color: greenyellow;
      border-collapse: collapse;
    }

    table, tr, td ,th{
      border: 1px solid black;
    }
  </style>
  <body>
  <table >
    <tr style="text-align: center">
    <th colspan="4"> Danh sách  khách hàng</th>
    </tr>
    <tr>
      <th>Tên</th>
      <th>Ngày Sinh</th>
      <th>Địa chỉ</th>
      <th>Ảnh</th>
    </tr>
    <tr>
      <td>Tiến Đạt</td>
      <td>11/11/2019</td>
      <td>Hà Nội</td>
      <td>
        <img src="anh1.jpg" style="width: 100px;height: 100px;" >
      </td>
    </tr>
    <tr>
      <td>Eve</td>
      <td>Jackson</td>
      <td>94</td>
      <td><img src="anh/anh3.jpg" style="width: 100px;height: 100px;"> </td>
    </tr>
    <tr>
      <td>Eve</td>
      <td>Jackson</td>
      <td>94</td>
      <td><img src="anh/anh3.jpg" style="width: 100px;height: 100px;"> </td>
    </tr>
    <tr>
      <td>Eve</td>
      <td>Jackson</td>
      <td>94</td>
      <td><img src="anh/anh3.jpg" style="width: 100px;height: 100px;"> </td>
    </tr>
  </table>
  </body>
</html>
