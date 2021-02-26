<%--
  Created by IntelliJ IDEA.
  User: 10788
  Date: 2021/2/26
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.12.4.min.js"></script>
    <script>

        var userlist = new Array();
        userlist.push({username:"zhangsan",age:1})
        userlist.push({username:"lisi",age:2})

        $.ajax({
            type:"post",
            url:"/user/quick15",
            data:JSON.stringify(userlist),
            contentType:"application/json;charset=utf-8"
        })

    </script>
</head>
<body>

</body>
</html>
