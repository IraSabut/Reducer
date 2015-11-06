<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Подробная информация о ссылке</title>
    <link rel="stylesheet" href="/signup.css">
</head>
<body>
<h1 style="color: #ff5722" align="center">Подробная информация о ссылке</h1>
<table  border="0,8" bgcolor="#fff3e0" width="90%">
  <tr>
    <th style="color:white "  bgcolor="#d84315">Ссылка</th>
    <th style="color:white "  bgcolor="#d84315">Короткая ссылка</th>
    <th style="color:white "  bgcolor="#d84315">Описание</th>
    <th style="color:white "  bgcolor="#d84315">Количество просмотров</th>
    <th style="color:white "  bgcolor="#d84315">Имя автора ссылки</th>
    <th style="color:white "  bgcolor="#d84315">Тэг</th>
    <%! private int accessCount = 0; %>
    <%= ++accessCount %>
  </tr>
  <tr>
    <td style="color: #e64a19">${alertById.alertName}</td>
    <td style="color: #e64a19">${alertById.alertShortName}</td>
    <td style="color: #e64a19">${alertById.description}</td>
    <td style="color: #e64a19">${alertById.views}</td>
    <td style="color: #e64a19">${alertById.userEntity.username}</td>
  <td><a href="<c:url value="/signup/tagByName/${alertById.tagEntity.tagName}"  />  "><label
          style="color: #e64a19">${alertById.tagEntity.tagName}</label></a>
  </td>
      <script>
   script type='text/javascript'>
  var javascriptVariable = "${alertById.views}";
  javascriptVariable+1;
  var count=0;
  function inc(aaaa) {
   javascriptVariable=javascriptVariable+1;
aaaa++;
    console.log(javascriptVariable);
  };
</script>
  </tr>

</table>


</body>
</html>
