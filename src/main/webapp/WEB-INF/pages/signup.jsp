<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title>title</title>
  <script type='text/javascript'>
    var count=0;
    function inc(N) {
      count+=N;
      console.log(count);
    };
  </script>
  <link rel="stylesheet" href="/signup.css">
</head>
<body>

<form  method="POST" action="<c:url value="/j_spring_security_check" /> " >

<c:if test="${not empty message}"><div class="message green">${message.toString()}</div></c:if>
<c:if test="${not empty param.error}">
  <font color="red">
    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>

<tr method="POST" action="<c:url value="/j_spring_security_check" />">
  <table class="table" align="right" >
    <footer>
    <tr>
      <td style="color:#333333;" align="left">Логин</td>
      <td><input type="text" name="j_username" placeholder="username" required/></td>
      <form:errors path="name"  />
    </tr>
    <tr>
      <td style="color: #333333" align="left">Пароль</td>
      <td><input type="password" name="j_password"  required placeholder="password"/></td>
    </tr>

    <tr>
      <td align="right">Запомнить меня</td>
      <td><input type="checkbox" name="_spring_security_remember_me" /></td>
    </tr>
    <tr>
      <td align="center"><input type="submit"  class="btnLogin"  value="Войти" tabindex="4"/></td>
      <td align="center">  <input type="reset"  class="btnLogin"  value="Очистить"/>

      </td>
    </tr>
    <tr> <td align="right" class="column-header"> <a href="<c:url value="/signup/addUser"  /> " class="rLink" >
        <label class="label"  style="color: #bf360c" >Регистрация</label></a>
      </td>
      </tr>
      </footer>
  </table>

  <h1 style="color: #ff5722" align="center">Список ссылок</h1>
  <c:if test = "${!empty alerts}">
  <table border="0,8" bgcolor="#fff3e0" width="60%">
    <thead>
      <th style="color:white "  bgcolor="#d84315" >Ссылка</th>
      <th style="color:white "  bgcolor="#d84315" >Короткая ссылка</th>
      <th style="color:white "  bgcolor="#d84315" >Дополнительно</th>
    </thead>
<tbody >
    <c:forEach items = "${alerts}" var = "alert">
<tr>
        <th style="color:#ff5722 "> ${alert.alertName}</th>
       <th>   <a href="http://${alert.alertName}">
            <label  style="color: #e64a19">${alert.alertShortName}</label>   </a></th>
               <th>     <a href="<c:url value="/getAlert${alert.id}" /> "><label  style="color: #bf360c">Подробнее</label></a></th>

</td>
</tr>
    </c:forEach>

    </tbody>
  </table>
  </c:if>

</form>
</body>
</html>