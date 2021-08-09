<%--
  Created by IntelliJ IDEA.
  User: SeongTae Jeong
  Date: 2021-08-09
  Time: 오후 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Signin</title>
</head>
<body>
    <form action="j_spring_security_check" enctype="application/x-www-form-urlencoded" method="post">
        <input type="text" placeholder="email" name="username" />
        <input type="password" placeholder="password" name="password" />
        <input type="submit" value="Signin" />
    </form>
</body>
</html>
