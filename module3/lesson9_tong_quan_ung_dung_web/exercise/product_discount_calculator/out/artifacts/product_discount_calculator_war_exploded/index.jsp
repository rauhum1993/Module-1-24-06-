<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/8/2020
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Discount Calculation</title>

</head>
<body>
<h2>Discount Calculation</h2>
<form action="/discount" method="post">
  <label>Product Description: </label><br/>
  <input type="text" name="productDescription" placeholder="ProductDescription" value="..."/><br/>
  <label>List Price: </label><br/>
  <input type="text" name="listPrice" placeholder="ListPrice" value="0"/><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="discountPercent" placeholder="DiscountPercent" value="0"/><br/>


  <input type = "submit" id = "submit" value = "DiscountAmount"/>
</form>
</body>
</html>
