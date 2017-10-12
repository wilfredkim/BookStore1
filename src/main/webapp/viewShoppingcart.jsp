<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/25/2017
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="customerPage.jsp"%>

<html>
<head>
    <title>View Shopping Cart</title>
</head>
<body>
<form action="buy.jsp" method="post">
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="20%"> Customer Name</th>
        <th width="20%">Book Name</th>
        <th width="20%">Price</th>
        <th width="20%">Author</th>



    </tr>
    <c:forEach var="products" items="${shoppinglist}">
        <tr>
            <td width="20%"><c:out value="${products.cust_name}"></c:out></td>
            <td width="20%"><c:out value="${products.prod_name}"></c:out></td>
            <td width="20%"><c:out value="${products.prod_price}"></c:out></td>
            <td width="20%"><c:out value="${products.prod_author}"></c:out></td>


        </tr>


    </c:forEach>
</TABLE>
    <button class="btn btn-info">Buy</button>
</form>
</body>
</html>
