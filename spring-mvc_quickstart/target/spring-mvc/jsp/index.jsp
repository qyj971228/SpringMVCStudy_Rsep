<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
${requestScope.name}
<%= request.getAttribute("name")%>
</body>
</html>
