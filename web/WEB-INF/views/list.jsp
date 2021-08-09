<%--
  Created by IntelliJ IDEA.
  User: SeongTae Jeong
  Date: 2021-08-09
  Time: 오전 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h1>리스트</h1>
    <table border="1">
        <tr>
            <td>아이디</td>
            <td>이메일</td>
            <td>비밀번호</td>
            <td>성명</td>
            <td>나이</td>
            <td></td>
        </tr>
        <c:forEach items="${list}" var="users">
            <tr>
                <td>${users.id}</td>
                <td>${users.email}</td>
                <td>${users.password}</td>
                <td>${users.name}</td>
                <td>${users.age}</td>
                <td>
                    <a href="/user/edit?id=${users.id}">수정</a><br />
                    <a href="/user/delete?id=${users.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
