<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/25/2017
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="customerPage.jsp" %>
<html>
<head>
    <title> view Catalogue</title>
</head>
<body>
<form action="shoppingmapping" method="post">

    <div class ="container">
        Check to Add to Cart
        <c:forEach var="catalog" items="${viewcataloglist}">
        <div class ="panel" >
           Name: <c:out value="${catalog.product_name}"></c:out>
         Price:   <c:out value="${catalog.product_price}"></c:out>
            <input type="checkbox" name="chB" value ="${catalog.product_name}" >

        </div>
        <br>

        </c:forEach>

        <button class="btn btn-info">Add to Chart</button>

</form>
</div>
</body>
</html>
