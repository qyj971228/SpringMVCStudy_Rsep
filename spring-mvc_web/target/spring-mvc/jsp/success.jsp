<%--
  Created by IntelliJ IDEA.
  User: 10788
  Date: 2021/2/24
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Success</h1>
    ${requestScope.name}
<%= request.getAttribute("name") %>

</body>
</html>
