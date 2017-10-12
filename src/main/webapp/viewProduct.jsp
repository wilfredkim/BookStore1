<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/25/2017
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="adminPage.jsp"%>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="20%"> Book Name</th>
        <th width="20%">Price</th>
        <th width="20%">Author</th>
       <%-- <th width="20%">Action</th>
        <th width="20%">Action</th>
--%>
    </tr>
<c:forEach var="products" items="${viewproductlist}">
    <tr>
        <td width="20%"><c:out value="${products.product_name}"></c:out></td>
        <td width="20%"><c:out value="${products.product_price}"></c:out></td>
        <td width="20%"><c:out value="${products.product_author}"></c:out></td>
        <%--<td width="20%"><a href=""> Edit</a> </td>
        <td width="20%"><a href=""> Delete</a> </td>--%>

    </tr>
    
    
    </c:forEach>
</TABLE>
</body>
</html>
