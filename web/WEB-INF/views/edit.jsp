<%--
  Created by IntelliJ IDEA.
  User: SeongTae Jeong
  Date: 2021-08-10
  Time: 오전 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="user">
  <form:hidden path="id" />
  name: <form:input path="name" /><br />
  email: <form:input path="email" /><br />
  password: <form:password path="password" showPassword="true" /><br />
  age: <form:input path="age" /><br />
  <input type="submit" value="Edit" />
</form:form>

</body>
</html>
