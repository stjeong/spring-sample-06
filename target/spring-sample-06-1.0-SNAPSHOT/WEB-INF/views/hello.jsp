<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="org.springframework.core.SpringVersion" %>
<html>
<head>
    <title></title>
</head>
<body>
SpringVersion: <% out.println(SpringVersion.getVersion()); %> <br />
Hello, ${var1}
</body>
</html>