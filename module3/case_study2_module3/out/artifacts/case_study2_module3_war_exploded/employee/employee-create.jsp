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
    <title>Employee Management Application</title>
    <script src="../jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<center>

    <h1>Employee Management</h1>
    <h2>
        <a href="/employee">List All Employee</a>
    </h2>


    <div align="center">
        <form method="post" action="/employee">
            <input type="hidden" name="actionUser" value="create">
            <table border="1" cellpadding="5">
                <h2>Create new Employee</h2>
                <tr>
                    <th>Employee ID:</th>
                    <td>
                        <input type="text" id="id" name="id">
                        <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: #b1dfbb">&nbsp;format KH-XXXX (X is number 0-9) </span><br>
                        <span class="msg-invalid" style="color: red">${messageID}</span>
                    </td>
                </tr>
                <tr>
                    <th>Employee Name:</th>
                    <td>
                        <input type="text" id="name" name="name">
                        <span class="msg-invalid" style="color: red" >&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: red">${messageName}</span>
                    </td>
                </tr>
                <tr>
                    <th>Employee Birthday:</th>
                    <td>
                        <input type="date" id="birthday" name="birthday">
                        <span class="msg-invalid" style="color: red" >&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: red">${messageBirthday}</span>
                    </td>
                </tr>

                <tr>
                    <th>Employee salary:</th>
                    <td>
                        <input type="text" id="salary" name="salary">
                        <span class="msg-invalid" style="color: red" >&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: red">${messageSalary}</span>
                    </td>
                </tr>
                <tr>
                    <th>Employee ID Card:</th>
                    <td>
                        <input type="text" id="id_card" name="id_card">
                        <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: red">${messageIDCard}</span>
                    </td>
                </tr>

                <tr>
                    <th>Customer Phone:</th>
                    <td>
                        <input type="text" id="phone" name="phone">
                        <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: red">${messagePhone}</span>
                    </td>
                </tr>
                <tr>
                    <th>Employee Email:</th>
                    <td>
                        <input type="text" id="email" name="email">
                        <span class="msg-invalid" style="color: red">&nbsp;(*)</span><br>
                        <span class="msg-invalid" style="color: red">${messageEmail}</span>
                    </td>
                </tr>
                <tr>
                    <th>Employee Address:</th>
                    <td>
                        <input type="text" id="employeeAddress" name="employeeAddress">
                    </td>
                </tr>

                <tr>
                    <th>Employee Position ID:</th>
                    <td>
                        <input type="text" id="positionID" name="positionID">
                    </td>
                </tr>
                <tr>
                    <th>Employee EducationDegree ID:</th>
                    <td>
                        <input type="text" id="educationDegreeID" name="educationDegreeID">
                    </td>
                </tr>
                <tr>
                    <th>Employee Division ID:</th>
                    <td>
                        <input type="text" id="divisionID" name="divisionID">
                    </td>
                </tr>
                <tr>
                    <th>Employee Username:</th>
                    <td>
                        <input type="text" id="username" name="username">
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" role="button">
                        <a role="button" href="/employee">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%@include file="../common/footer.jsp"%>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
