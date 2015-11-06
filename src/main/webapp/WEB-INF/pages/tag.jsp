<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Список tags</title>
</head>
<body>
<div>
    <h1>List tags</h1>
    <c:if test="${!empty tags}">
        <table>
            <tr>
                <th>tag</th>
            </tr>
            <c:forEach items="${tags}" var="tag">
                <tr>
                    <td>${tag.tagName}

                    <td>


                </tr>
            </c:forEach>
        </table>
    </c:if>


    <div class="form-group">
        <label> </label>
    </div>
</div>
</body>
</html>