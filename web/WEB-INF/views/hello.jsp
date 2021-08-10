<%@ page contentType="text/html;charset=UTF-8"
         import="org.springframework.core.SpringVersion" %>
<html>
<head>
    <title></title>
</head>
<body>
SpringVersion: <% System.out.println(SpringVersion.getVersion()); %> <br />
Hello, ${var1}


</body>
</html>