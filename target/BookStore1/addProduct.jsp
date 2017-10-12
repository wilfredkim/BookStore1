<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/24/2017
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="adminPage.jsp"%>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<form method="post" action="addProductt">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Register New Book</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name of the Product</td>
                <td><input type="text" name="prodname" value="" /></td>
            </tr>

            <tr>
                <td>Price</td>
                <td><input type="number" name="price" value="" /></td>
            </tr>

            <tr>
                <td>Author</td>
                <td><input type="text" name="author" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add  Book" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
