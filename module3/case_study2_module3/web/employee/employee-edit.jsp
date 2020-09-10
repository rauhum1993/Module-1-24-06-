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
        <a href="../employee">List All Employee</a>
    </h2>
</center>

<div align="center">
    <form method="post">
        <h2>Edit Employee</h2>
        <table border="1" cellpadding="5">

            <c:if test="${editEmployee != null}">
                <input type="hidden" name="id" value="${editEmployee.employeeId}"/>
            </c:if>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${editEmployee.employeeName}"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="${editEmployee.employeeBirthday}"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="salary" size="45"
                           value="${editEmployee.employeeSalary}"
                    />
                </td>
            </tr>

            <tr>
                <th>Employee Id Card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="${editEmployee.employeeIdCard}"
                    />
                </td>
            </tr>


            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="${editEmployee.employeePhone}"
                    />
                </td>
            </tr>



            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="${editEmployee.employeeEmail}"
                    />
                </td>
            </tr>

            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="${editEmployee.employeeAddress}"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee positionID:</th>
                <td>
                    <input type="text" name="positionID" size="45"
                           value="${editEmployee.positionID}"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Education Degree ID:</th>
                <td>
                    <input type="text" name="educationDegreeID" size="45"
                           value="${editEmployee.educationDegreeID}"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Division ID:</th>
                <td>
                    <input type="text" name="divisionID" size="45"
                           value="${editEmployee.divisionID}"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee username:</th>
                <td>
                    <input type="text" name="username" size="45"
                           value="${editEmployee.username}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
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
