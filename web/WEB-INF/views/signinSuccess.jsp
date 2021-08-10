<%--
  Created by IntelliJ IDEA.
  User: SeongTae Jeong
  Date: 2021-08-09
  Time: 오후 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Sign-Result</title>
</head>
<body>
  Sign-in Success
    <c:set var="user" value="${SPRING_SECURITY_CONTEXT.authentication.principal}" />

현재 로그인된 유저는 ${user} 입니다. 부여된 권한은 <br/>
<c:forEach var="authority" items="${user.authorities}">
    ${authority}<br/>
</c:forEach>

<sec:authorize access="hasRole('ROLE_USER')">
    이 문장은 ROLE_USER 권한을 가진 사람에게만 보입니다.<br />
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
  이 문장은 ROLE_ADMIN 권한을 가진 사람에게만 보입니다.<br />
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
  이 문장은 ROLE_USER 혹은 ROLE_ADMIN 권한을 가진 사람에게만 보입니다.<br />
</sec:authorize>

</body>
</html>
