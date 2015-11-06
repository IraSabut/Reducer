<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title></title>
</head>
<body>
<h1 style="color: #ff5722">Создание новой ссылки</h1>
<form:form method="post" action="/signup/addAlert" commandName="alert">
    <table border="0,8" bgcolor="#ff5722 " width="25%">
        <tr>

            <td>
                <form:label style="color:#ffffff" path="alertName">
                    Ссылка
                </form:label>
            </td>
            <td>
                <form:input cssStyle="color: #ef6c00" path="alertName" required="true"/>
            </td>
        </tr>

        <td>
            <form:input path="alertShortName" type="hidden"/>
        </td>
        <tr>
            <td>
                <form:label style="color: #ffffff" path="description">
                    Описание
                </form:label>
            </td>
            <td>
                <form:input cssStyle="color: #ef6c00" path="description" required="true"/>
            </td>
        </tr>


        <tr>
            <td>
                <form:label style="color: #ffffff" path="tagEntity.tagName">
                    Тэг
                </form:label>
            </td>
            <td>
                <form:input cssStyle="color: #ef6c00" path="tagEntity.tagName" required="true"/>
            </td>
        </tr>
        <td>
            <form:input type="hidden" path="userEntity.name"/>
        </td>

        <td>
            <form:input type="hidden" path="userEntity.password"/>
        </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Сгенерировать"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
