<%--
  Created by IntelliJ IDEA.
  User: SeongTae Jeong
  Date: 2021-08-08
  Time: 오후 04:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Form Test</title>
</head>
<body>
<form:form modelAttribute="user">
    이름: <form:input path="name" /><br />
    이메일: <form:input path="email" /><br />
    비밀번호: <form:password path="password" /><br />
    나이: <form:input path="age" /><br />
    <br />
    <input type="submit" value="Signup"/>
</form:form>
</body>
</html>
