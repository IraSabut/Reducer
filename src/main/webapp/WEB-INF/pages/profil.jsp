<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show user</title>
    <link rel="stylesheet" href="/signup.css">
</head>
<body>
<h1 style="color: #ff5722">

    Hi <sec:authentication property="principal.username"/>

</h1>
<c:url var="profil" value="profil"/>

<form:form>

    <table border="0,8" bgcolor="#fff3e0" width="80%">
        <tr>

            <th style="color:white " bgcolor="#d84315">Ссылка</th>
            <th style="color:white " bgcolor="#d84315">Короткая ссылка</th>
            <th style="color:white " bgcolor="#d84315">Описание</th>
            <th style="color:white " bgcolor="#d84315">Количество просмотров</th>
            <th style="color:white " bgcolor="#d84315">Тэг</th>
        </tr>

        <c:forEach items="${alertUserEntities}" var="alert">
            <tr>
                <th style="color:#ff5722 "> ${alert.alertName}</th>
                <th style="color:#ff5722 "> ${alert.alertShortName}</th>
                <th style="color:#ff5722 "> ${alert.description}</th>
                <th style="color:#ff5722 "> ${alert.views}</th>
                <th style="color:#ff5722 "> ${alert.tagEntity.tagName}</th>
            </tr>
        </c:forEach>
    </table>

    <a href="<c:url value="/signup/addAlert" /> ">
        <label style="color: #ff5722">Сгенерировать корокую ссылку</label>
    </a>


    </body>
    </html>
</form:form>



