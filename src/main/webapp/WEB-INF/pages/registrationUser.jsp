<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="/signup.css">
</head>
<body>
<h1 style="color: #ff5722">Регистрация</h1>
<form:form cssClass="box login" method="post" action="/signup/addUser" commandName="user">
    <table border="0,8" bgcolor="#ff5722 " width="20%">
        <tr>
            <td>
                <form:label style="color: #ffffff" path="name">
                    Логин
                </form:label>
            </td>
            <td>
                <form:input cssStyle="color: #ef6c00" path="name" placeholder="username" required="true"/>
            </td>
        </tr>
        <td>
            <form:label style="color: #ffffff" path="password">
                Пароль
            </form:label>
        </td>
        <td>
            <form:input cssStyle="color: #ef6c00" path="password" placeholder="password" required="true"/>
        </td>
        </tr>
        <tr>
            <td colspan="2" style="color: #ff5722"><input type="submit" value="Зарегистрироваться"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
