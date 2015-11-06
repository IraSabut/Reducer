<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 style="color: #ff5722" align="center">Список ссылок для тэга ${alert.tagEntity.tagName}</h1>

<table border="0,8" bgcolor="#fff3e0" width="60%">
    <tr>

        <th style="color:white " bgcolor="#d84315">Ссылка</th>
        <th style="color:white " bgcolor="#d84315">Тэг</th>
        <th style="color:white " bgcolor="#d84315">Короткий адрес ссылки</th>
    </tr>

    <c:forEach items="${alertEntities}" var="alert">
        <tr>
            <th style="color:#ff5722 "> ${alert.alertName}</th>
            <th style="color:#ff5722 "> ${alert.tagEntity.tagName}</th>
            <th><a href="http://${alert.alertName}">
                <label style="color: #e64a19">${alert.alertShortName}</label> </a></th>
            <th><a href="<c:url value="/getAlert${alert.id}" /> "><label style="color: #bf360c">Подробнее</label></a>
            </th>

            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
