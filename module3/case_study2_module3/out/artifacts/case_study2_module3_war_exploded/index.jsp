<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 4/9/2020
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>$Title$</title>
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>

<body>
<form action="/index">
<div class="container-fluid">
    <%@include file="/common/header.jsp"%>

    <div class="row ">
        <div class="col-lg-12 ">
            <nav class="navbar navbar-expand-lg navbar-light bg-light" >
                <a class="navbar-brand" href="/index">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/employee">Empolyee <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="/customer">Customer <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="/service">Service <span class="sr-only">(current)</span></a>
                        </li>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="/contract">Contract <span class="sr-only">(current)</span></a>
                        </li>
                    </ul>

                </div>
            </nav>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-3">

            <h3>item one</h3>
            <h3>item two</h3>
            <h3>item three</h3>

        </div>
        <div class="col-lg-8 " >
            <h1>body </h1>
        </div>
    </div>
    <div class="footer row">

    </div>
</div>
</form>
</body>
<script src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>