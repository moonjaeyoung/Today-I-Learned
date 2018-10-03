<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-02
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
footer에서 전달한 메시지입니다.
<br>
<%=request.getParameter("email")%>
<br>
<%=request.getParameter("tel")%>
</body>
</html>
