<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/25/2017
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<html>
<head>
    <title>Customer Registration</title>
</head>
<body>
<form method="post" action="addCustomermapping ">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Create New Account</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name</td>
                <td><input type="text" name="custname" value="" /></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="" /></td>
            </tr>

            <tr>
                <td>PassWord</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
            <tr>
            <tr>
                <td> Confirm PassWord</td>
                <td><input type="password" name="conpass" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Already registered!! <a href="loginCustomer.jsp">Login Here</a></td>
            </tr>
             </tbody>
        </table>
    </center>
</form>
</body>
</html>
