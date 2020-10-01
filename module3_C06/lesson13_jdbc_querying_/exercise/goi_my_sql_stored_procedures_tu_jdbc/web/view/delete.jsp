<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>Delete user</h1>
    <h2>
        <a href="/servlet">List All Users</a>
    </h2>
</center>

    <form method="post">
        <fieldset>
            <legend> Infomation of user </legend>
            <table>
                <tr>
                    <td>ID :</td>
                    <td> ${user.getId()}</td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td>${user.getEmail()}</td>
                </tr>
                <tr>
                    <td>Country :</td>
                    <td> ${user.getCountry()}</td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="delete" />
                    </td>
                    <td>
                        <a href="/servlet" >Back</a>

                    </td>

                </tr>

            </table>
        </fieldset>

    </form>

</body>
</html>
