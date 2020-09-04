<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 4/9/2020
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <div class="row ">
        <div class="col-lg-8">
            <img src="logo_furama/furuma.png" class="img-fluid"/>
        </div>
        <div class="col-lg-4">
            <h1>Phan Quốc Khánh</h1>
            <h2>Lớp C0520G1</h2>
        </div>
    </div>

    <div class="row ">
        <div class="col-lg-12 ">
            <nav class="navbar navbar-expand-lg navbar-light bg-light" >
                <a class="navbar-brand" href="#">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Empolyee <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Customer</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Service
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Contract</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2 rounded-pill" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
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
</body>
<script src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>