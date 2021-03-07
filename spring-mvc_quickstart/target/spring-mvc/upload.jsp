<%--
  Created by IntelliJ IDEA.
  User: 10788
  Date: 2021/3/1
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/quick22" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br>
    文件1<input type="file" name="uploadFile"><br>
    文件2<input type="file" name="uploadFile2"><br>
    <input type="submit">

</form>

</body>
</html>
